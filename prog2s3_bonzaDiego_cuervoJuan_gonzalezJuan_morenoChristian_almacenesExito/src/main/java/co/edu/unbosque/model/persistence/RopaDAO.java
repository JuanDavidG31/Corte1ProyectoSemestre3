package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Ropa;
import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
/**
 * Clase que implementa las operaciones CRUD para la entidad Ropa.
 */
public class RopaDAO implements CRUDOperation<RopaDTO, Ropa> {

	private ArrayList<Ropa> listaRopa;
	private final String FILE_NAME = "ropa.csv";
	private final String SERIAL_NAME = "ropa.dat";
	/**
     * Constructor de la clase RopaDAO.
     * Inicializa la lista de ropa y carga los datos serializados si existen.
     */
	public RopaDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}
	/**
     * Establece la lista de ropa.
     * @param listaRopa Lista de objetos Ropa.
     */
	public void setListaRopa(ArrayList<Ropa> listaRopa) {
		this.listaRopa = listaRopa;
	}
	/**
     * Obtiene una lista de ropa con un tamaño específico.
     * Si el tamaño es mayor a la cantidad de elementos disponibles, 
     * se devuelven elementos aleatorios.
     * 
     * @param size Cantidad de elementos deseados.
     * @return Lista de objetos Ropa.
     */
	public ArrayList<Ropa> getListaRopa(int size) {

		if (size > listaRopa.size()) {
			Random rand = new Random();

			ArrayList<Ropa> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaRopa.size());
				randomList.add(listaRopa.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaRopa.subList(0, size));
		}

	}
	/**
     * Obtiene una lista clonada de ropa con un tamaño específico.
     * Cada elemento clonado recibe un nuevo código único.
     * 
     * @param size Cantidad de elementos deseados.
     * @return Lista clonada de objetos Ropa.
     */
	public ArrayList<Ropa> getClonedRopa(int size) {
		ArrayList<Ropa> results = new ArrayList<>();
		ArrayList<Ropa> originals = getListaRopa(size);
		for (Ropa original : originals) {
			results.add((original));
		}

		for (Ropa product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}
	/**
     * Elimina un elemento de la lista de ropa según su posición.
     * 
     * @param positionToDelete Índice del elemento a eliminar.
     */
	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaRopa.size()) {
			return;
		} else {
			listaRopa.remove(positionToDelete);
			return;
		}

	}
	/**
     * Muestra todos los elementos de la lista de ropa.
     * 
     * @return Una cadena con la información de todas las prendas de ropa.
     */
	@Override
	public String showAll() {
		String rta = "";
		if (listaRopa.isEmpty()) {
			return "No hay Ropas en la lista";
		} else {
			for (Ropa Ropa : listaRopa) {
				rta += Ropa;
			}
			return rta;
		}
	}
	/**
     * Obtiene la lista de ropa en formato DTO.
     * 
     * @return Lista de objetos RopaDTO.
     */
	@Override
	public ArrayList<RopaDTO> getAll() {
		return DataMapper.listaRopaToListaRopaDTO(listaRopa);

	}
	/**
     * Agrega una nueva prenda de ropa a la lista.
     * 
     * @param newData Objeto RopaDTO con los datos de la nueva prenda.
     * @return true si se agregó correctamente.
     */
	@Override
	public boolean add(RopaDTO newData) {

		listaRopa.add(DataMapper.RopaDTOToRopa(newData));
		writeFile();
		writeSerialized();
		return true;

	}
	/**
     * Elimina una prenda de ropa de la lista.
     * 
     * @param toDelete Objeto RopaDTO que representa la prenda a eliminar.
     * @return true si se eliminó correctamente, false si no se encontró.
     */
	@Override
	public boolean delete(RopaDTO toDelete) {
		Ropa found = find2(DataMapper.RopaDTOToRopa(toDelete));
		if (found != null) {
			listaRopa.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
     * Actualiza una prenda de ropa en la lista.
     * 
     * @param previous Objeto RopaDTO con los datos anteriores.
     * @param newData Objeto RopaDTO con los nuevos datos.
     * @return true si se actualizó correctamente, false si no se encontró.
     */
	@Override
	public boolean update(RopaDTO previous, RopaDTO newData) {
		Ropa found = find2(DataMapper.RopaDTOToRopa(previous));
		if (found != null) {
			listaRopa.remove(found);
			listaRopa.add(DataMapper.RopaDTOToRopa(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Escribe la lista de ropa en un archivo CSV.
	 * Cada atributo de la ropa se separa por punto y coma (;).
	 */
	public void writeFile() {
		String content = "";
		for (Ropa m : listaRopa) {
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
	 * Lee la lista de ropa desde un archivo CSV y la almacena en la lista.
	 * Si el archivo está vacío o no existe, se inicializa una lista vacía.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaRopa = new ArrayList<>();
		} else {
			listaRopa = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Ropa tempo = new Ropa();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaRopa.add(tempo);
			}
		}

	}
	/**
	 * Serializa y guarda la lista de ropa en un archivo binario.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaRopa);
	}
	/**
	 * Lee la lista de ropa desde un archivo serializado.
	 * Si el archivo no existe, se inicializa una lista vacía.
	 */
	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaRopa = new ArrayList<>();
		} else {
			listaRopa = (ArrayList<Ropa>) content;
		}
	}
	/**
	 * Busca un objeto Ropa en la lista por su ID.
	 * 
	 * @param toFind Objeto Ropa con el ID a buscar.
	 * @return El objeto Ropa encontrado, o null si no se encuentra.
	 */
	@Override
	public Ropa find(Ropa toFind) {
		Ropa found = null;
		if (!listaRopa.isEmpty()) {
			for (Ropa Ropa : listaRopa) {
				if (Ropa.getId() == toFind.getId()) {
					found = Ropa;
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
	 * Busca un objeto Ropa en la lista por su código.
	 * 
	 * @param toFind Objeto Ropa con el código a buscar.
	 * @return El objeto Ropa encontrado, o null si no se encuentra.
	 */
	@Override
	public Ropa find2(Ropa toFind) {
		Ropa found = null;
		if (!listaRopa.isEmpty()) {
			for (Ropa Ropa : listaRopa) {
				if (Ropa.getCode().equals(toFind.getCode())) {
					found = Ropa;
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
