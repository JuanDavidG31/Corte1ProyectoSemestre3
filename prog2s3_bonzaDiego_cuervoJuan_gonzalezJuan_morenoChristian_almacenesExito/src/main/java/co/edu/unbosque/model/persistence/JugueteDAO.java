package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
/**
 * Clase de acceso a datos (DAO) para la gestión de juguetes.
 * Implementa las operaciones CRUD sobre una lista de juguetes.
 */
public class JugueteDAO implements CRUDOperation<JugueteDTO, Juguete> {

	private ArrayList<Juguete> listaJuguete;
	private final String FILE_NAME = "juguete.csv";
	private final String SERIAL_NAME = "juguete.dat";
	/**
	 * Constructor que inicializa la lista de juguetes y lee los datos serializados.
	 */
	public JugueteDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}
	/**
	 * Establece una nueva lista de juguetes.
	 * @param listaJuguete Lista de juguetes a asignar.
	 */
	public void setListaJuguete(ArrayList<Juguete> listaJuguete) {
		this.listaJuguete = listaJuguete;
	}
	/**
	 * Obtiene una lista de juguetes con una cantidad específica.
	 * @param size Número de juguetes a obtener.
	 * @return Una lista de juguetes aleatorios si size es mayor que la cantidad existente,
	 *         o una sublista con los primeros "size" elementos.
	 */
	public ArrayList<Juguete> getListaJuguete(int size) {

		if (size > listaJuguete.size()) {
			Random rand = new Random();

			ArrayList<Juguete> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaJuguete.size());
				randomList.add(listaJuguete.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaJuguete.subList(0, size));
		}

	}
	/**
	 * Clona una cantidad específica de juguetes, asignando nuevos códigos a cada uno.
	 * @param size Cantidad de juguetes a clonar.
	 * @return Lista de juguetes clonados con nuevos códigos.
	 */
	public ArrayList<Juguete> getClonedJuguete(int size) {
		ArrayList<Juguete> results = new ArrayList<>();
		ArrayList<Juguete> originals = getListaJuguete(size);
		for (Juguete original : originals) {
			results.add((original));
		}

		for (Juguete product : results) {
			product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}
	/**
	 * Elimina un juguete según su posición en la lista.
	 * @param positionToDelete Índice del juguete a eliminar.
	 */
	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaJuguete.size()) {
			return;
		} else {
			listaJuguete.remove(positionToDelete);
			return;
		}

	}
	/**
	 * Muestra todos los juguetes en la lista.
	 * @return Cadena de texto con la información de todos los juguetes o mensaje de lista vacía.
	 */
	@Override
	public String showAll() {
		String rta = "";
		if (listaJuguete.isEmpty()) {
			return "No hay Juguetes en la lista";
		} else {
			for (Juguete Juguete : listaJuguete) {
				rta += Juguete;
			}
			return rta;
		}
	}
	/**
	 * Obtiene todos los juguetes en formato DTO.
	 * @return Lista de objetos JugueteDTO.
	 */
	@Override
	public ArrayList<JugueteDTO> getAll() {
		return DataMapper.listaJugueteToListaJugueteDTO(listaJuguete);

	}
	/**
	 * Agrega un nuevo juguete a la lista.
	 * @param newData Objeto JugueteDTO con la información del nuevo juguete.
	 * @return true si se agrega correctamente.
	 */
	@Override
	public boolean add(JugueteDTO newData) {

		listaJuguete.add(DataMapper.JugueteDTOToJuguete(newData));
		writeFile();
		writeSerialized();
		return true;

	}
	/**
	 * Elimina un juguete según un objeto JugueteDTO.
	 * @param toDelete Objeto JugueteDTO a eliminar.
	 * @return true si se elimina correctamente, false si no se encuentra.
	 */
	@Override
	public boolean delete(JugueteDTO toDelete) {
		Juguete found = find2(DataMapper.JugueteDTOToJuguete(toDelete));
		if (found != null) {
			listaJuguete.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Actualiza un juguete en la lista reemplazando el antiguo con el nuevo.
	 * 
	 * @param previous El juguete existente que se desea actualizar.
	 * @param newData  Los nuevos datos del juguete.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	@Override
	public boolean update(JugueteDTO previous, JugueteDTO newData) {
		Juguete found = find2(DataMapper.JugueteDTOToJuguete(previous));
		if (found != null) {
			listaJuguete.remove(found);
			listaJuguete.add(DataMapper.JugueteDTOToJuguete(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Escribe la lista de juguetes en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Juguete m : listaJuguete) {
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
	 * Lee los datos del archivo CSV y los almacena en la lista de juguetes.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaJuguete = new ArrayList<>();
		} else {
			listaJuguete = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Juguete tempo = new Juguete();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaJuguete.add(tempo);
			}
		}

	}
	/**
	 * Serializa y guarda la lista de juguetes en un archivo binario.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaJuguete);
	}
	/**
	 * Carga los juguetes desde un archivo serializado.
	 */
	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaJuguete = new ArrayList<>();
		} else {
			listaJuguete = (ArrayList<Juguete>) content;
		}
	}
	/**
	 * Busca un juguete en la lista basado en su ID.
	 * 
	 * @param toFind El juguete a buscar.
	 * @return El juguete encontrado o null si no existe.
	 */
	@Override
	public Juguete find(Juguete toFind) {
		Juguete found = null;
		if (!listaJuguete.isEmpty()) {
			for (Juguete Juguete : listaJuguete) {
				if (Juguete.getId() == toFind.getId()) {
					found = Juguete;
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
	 * Busca un juguete en la lista basado en su código.
	 * 
	 * @param toFind El juguete a buscar.
	 * @return El juguete encontrado o null si no existe.
	 */
	@Override
	public Juguete find2(Juguete toFind) {
	Juguete found = null;
		if (!listaJuguete.isEmpty()) {
			for (Juguete Juguete : listaJuguete) {
				if (Juguete.getCode().equals(toFind.getCode())) {
					found = Juguete;
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
