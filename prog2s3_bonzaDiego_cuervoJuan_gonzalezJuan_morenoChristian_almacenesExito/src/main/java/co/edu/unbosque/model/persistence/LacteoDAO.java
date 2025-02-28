package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Lacteo;
import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
/**
 * Clase LacteoDAO que implementa las operaciones CRUD para la entidad Lacteo.
 */
public class LacteoDAO implements CRUDOperation<LacteoDTO, Lacteo> {

	private ArrayList<Lacteo> listaLacteo;
	private final String FILE_NAME = "lacteo.csv";
	private final String SERIAL_NAME = "lacteo.dat";
	/**
     * Constructor de la clase LacteoDAO. Inicializa la lista de lácteos cargando los datos serializados.
     */
	public LacteoDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}
	/**
     * Establece la lista de lácteos.
     * @param listaLacteo Lista de objetos Lacteo.
     */
	public void setListaLacteo(ArrayList<Lacteo> listaLacteo) {
		this.listaLacteo = listaLacteo;
	}
	/**
     * Obtiene una lista de lácteos con un tamaño especificado.
     * @param size Cantidad de elementos a obtener.
     * @return Lista de objetos Lacteo.
     */
	public ArrayList<Lacteo> getListaLacteo(int size) {

		if (size > listaLacteo.size()) {
			Random rand = new Random();

			ArrayList<Lacteo> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaLacteo.size());
				randomList.add(listaLacteo.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaLacteo.subList(0, size));
		}

	}
	/**
     * Obtiene una lista clonada de lácteos con códigos únicos.
     * @param size Cantidad de elementos a obtener.
     * @return Lista clonada de objetos Lacteo.
     */
	public ArrayList<Lacteo> getClonedLacteo(int size) {
		ArrayList<Lacteo> results = new ArrayList<>();
		ArrayList<Lacteo> originals = getListaLacteo(size);
		for (Lacteo original : originals) {
			results.add((original));
		}

		for (Lacteo product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}
	/**
     * Elimina un elemento de la lista en una posición específica.
     * @param positionToDelete Índice del elemento a eliminar.
     */
	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaLacteo.size()) {
			return;
		} else {
			listaLacteo.remove(positionToDelete);
			return;
		}

	}
	/**
     * Muestra todos los elementos de la lista en formato de texto.
     * @return Cadena con la representación de todos los elementos.
     */
	@Override
	public String showAll() {
		String rta = "";
		if (listaLacteo.isEmpty()) {
			return "No hay Lacteos en la lista";
		} else {
			for (Lacteo Lacteo : listaLacteo) {
				rta += Lacteo;
			}
			return rta;
		}
	}
	 /**
     * Obtiene todos los elementos de la lista en formato DTO.
     * @return Lista de objetos LacteoDTO.
     */
	@Override
	public ArrayList<LacteoDTO> getAll() {
		return DataMapper.listaLacteoToListaLacteoDTO(listaLacteo);

	}
	/**
     * Agrega un nuevo lácteo a la lista.
     * @param newData Datos del nuevo lácteo.
     * @return true si la operación fue exitosa.
     */
	@Override
	public boolean add(LacteoDTO newData) {

		listaLacteo.add(DataMapper.LacteoDTOToLacteo(newData));
		writeFile();
		writeSerialized();
		return true;

	}
	/**
     * Elimina un lácteo específico de la lista.
     * @param toDelete Objeto LacteoDTO a eliminar.
     * @return true si el elemento fue eliminado exitosamente, false en caso contrario.
     */
	@Override
	public boolean delete(LacteoDTO toDelete) {
		Lacteo found = find2(DataMapper.LacteoDTOToLacteo(toDelete));
		if (found != null) {
			listaLacteo.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Actualiza un objeto Lacteo en la lista.
	 * 
	 * @param previous El objeto LacteoDTO que se desea actualizar.
	 * @param newData  Los nuevos datos a actualizar.
	 * @return true si se actualiza correctamente, false en caso contrario.
	 */
	@Override
	public boolean update(LacteoDTO previous, LacteoDTO newData) {
		Lacteo found = find2(DataMapper.LacteoDTOToLacteo(previous));
		if (found != null) {
			listaLacteo.remove(found);
			listaLacteo.add(DataMapper.LacteoDTOToLacteo(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Escribe la lista de productos lácteos en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Lacteo m : listaLacteo) {
			content += m.getId() + ";";
			content += m.getCode() + ";";
			content += m.getName() + ";";
			content += m.getDescription() + ";";
			content += m.getImage() + ";";
			content += m.getPrice() + ";";
			content += m.getCategory() + ";";
			content += m.getQuantity() + ";";
			content += m.getInventoryStatus() + ";";
			content += m.getRating() + ";";
			content += m.getOrders() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}
	/**
	 * Lee los datos del archivo CSV y los carga en la lista de lácteos.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaLacteo = new ArrayList<>();
		} else {
			listaLacteo = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Lacteo tempo = new Lacteo();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaLacteo.add(tempo);
			}
		}

	}
	/**
	 * Serializa y guarda la lista de lácteos en un archivo.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaLacteo);
	}
	/**
	 * Lee los datos serializados y los carga en la lista de lácteos.
	 */
	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaLacteo = new ArrayList<>();
		} else {
			listaLacteo = (ArrayList<Lacteo>) content;
		}
	}
	/**
	 * Busca un objeto Lacteo en la lista por su ID.
	 * 
	 * @param toFind El objeto Lacteo que se desea encontrar.
	 * @return El objeto encontrado o null si no se encuentra.
	 */
	@Override
	public Lacteo find(Lacteo toFind) {
		Lacteo found = null;
		if (!listaLacteo.isEmpty()) {
			for (Lacteo Lacteo : listaLacteo) {
				if (Lacteo.getId() == toFind.getId()) {
					found = Lacteo;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}
	/**
	 * Busca un objeto Lacteo en la lista por su código.
	 * 
	 * @param toFind El objeto Lacteo que se desea encontrar.
	 * @return El objeto encontrado o null si no se encuentra.
	 */
	@Override
	public Lacteo find2(Lacteo toFind) {
		Lacteo found = null;
		if (!listaLacteo.isEmpty()) {
			for (Lacteo Lacteo : listaLacteo) {
				if (Lacteo.getCode().equals(toFind.getCode())) {
					found = Lacteo;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}
}
