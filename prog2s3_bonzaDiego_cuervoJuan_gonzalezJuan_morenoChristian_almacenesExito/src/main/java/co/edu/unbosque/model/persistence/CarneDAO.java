package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.CarneDTO;
/**
 * Clase que maneja las operaciones CRUD para los objetos de tipo Carne.
 */
public class CarneDAO implements CRUDOperation<CarneDTO, Carne> {

	private ArrayList<Carne> listaCarne;
	private final String FILE_NAME = "carne.csv";
	private final String SERIAL_NAME = "carne.dat";
	/**
     * Constructor que inicializa la lista de carnes cargando los datos serializados.
     */
	public CarneDAO() {
		FileHandler.checkFolder();
		readSerizalized();

	}
	/**
     * Establece la lista de carnes.
     * @param listaCarne Lista de objetos Carne.
     */
	public void setListaCarne(ArrayList<Carne> listaCarne) {
		this.listaCarne = listaCarne;
	}
	/**
     * Obtiene una lista de carnes con el tamaño especificado.
     * Si el tamaño solicitado es mayor al disponible, selecciona aleatoriamente elementos.
     * 
     * @param size Tamaño de la lista deseada.
     * @return Lista de carnes con la cantidad solicitada o la totalidad si es menor.
     */
	public ArrayList<Carne> getListaCarne(int size) {

		if (size > listaCarne.size()) {
			Random rand = new Random();

			ArrayList<Carne> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCarne.size());
				randomList.add(listaCarne.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCarne.subList(0, size));
		}

	}
	/**
     * Elimina un elemento de la lista según su posición.
     * @param positionToDelete Índice del elemento a eliminar.
     */
	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaCarne.size()) {
			return;
		} else {
			listaCarne.remove(positionToDelete);
			return;
		}

	}
	/**
     * Muestra todos los elementos de la lista de carnes.
     * @return Cadena con la representación de todas las carnes o un mensaje si la lista está vacía.
     */
	@Override
	public String showAll() {
		String rta = "";
		if (listaCarne.isEmpty()) {
			return "No hay Carnes en la lista";
		} else {
			for (Carne Carne : listaCarne) {
				rta += Carne;
			}
			return rta;
		}
	}
	/**
     * Obtiene una lista de todas las carnes en formato DTO.
     * @return Lista de objetos CarneDTO.
     */
	@Override
	public ArrayList<CarneDTO> getAll() {
		return DataMapper.listaCarneToListaCarneDTO(listaCarne);

	}

	@Override
	public boolean add(CarneDTO newData) {

		listaCarne.add(DataMapper.CarneDTOToCarne(newData));
		writeFile();
		writeSerialized();
		return true;

	}
	 /**
     * Agrega un nuevo objeto Carne a la lista y lo guarda en archivo.
     * @param newData Objeto CarneDTO a agregar.
     * @return true si la operación fue exitosa.
     */
	@Override
	public boolean delete(CarneDTO toDelete) {
		Carne carneToRemove = find2(DataMapper.CarneDTOToCarne(toDelete));
		if (carneToRemove != null) {
			listaCarne.remove(carneToRemove);
			writeFile();
			writeSerialized();
			return true;
		}
		return false;
	}
	/**
     * Elimina un objeto Carne de la lista basado en su coincidencia con otro objeto.
     * @param toDelete Objeto CarneDTO a eliminar.
     * @return true si la eliminación fue exitosa, false si no se encontró.
     */
	@Override
	public boolean update(CarneDTO previous, CarneDTO newData) {
		Carne found = find2(DataMapper.CarneDTOToCarne(previous));
		if (found != null) {
			listaCarne.remove(found);
			listaCarne.add(DataMapper.CarneDTOToCarne(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Escribe los datos de la lista de carnes en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Carne m : listaCarne) {
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
	 * Lee los datos desde un archivo CSV y los carga en la lista de carnes.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaCarne = new ArrayList<>();
		} else {
			listaCarne = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Carne tempo = new Carne();
				tempo.setId(Integer.parseInt(cols[0]));
				tempo.setCode(cols[1]);
				tempo.setName(cols[2]);
				tempo.setDescription(cols[3]);
				tempo.setImage(cols[4]);
				tempo.setPrice(Integer.parseInt(cols[5]));
				tempo.setCategory(cols[6]);
				tempo.setQuantity(Integer.parseInt(cols[7]));
				tempo.setRating(Integer.parseInt(cols[9]));
				listaCarne.add(tempo);
			}
		}

	}
	/**
	 * Escribe los datos de la lista de carnes en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaCarne);
	}
	/**
	 * Lee los datos desde un archivo serializado y los carga en la lista de carnes.
	 */
	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaCarne = new ArrayList<>();
		} else {
			listaCarne = (ArrayList<Carne>) content;
		}
	}
	/**
	 * Busca una carne en la lista por ID.
	 * 
	 * @param toFind Objeto Carne con el ID a buscar.
	 * @return Carne encontrada o null si no existe.
	 */
	@Override
	public Carne find(Carne toFind) {
		Carne found = null;
		if (!listaCarne.isEmpty()) {
			for (Carne Carne : listaCarne) {
				if (Carne.getId() == toFind.getId()) {
					found = Carne;
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
	 * Busca una carne en la lista por código.
	 * 
	 * @param toFind Objeto Carne con el código a buscar.
	 * @return Carne encontrada o null si no existe.
	 */
	@Override
	public Carne find2(Carne toFind) {
		Carne found = null;
		if (!listaCarne.isEmpty()) {
			for (Carne Carne : listaCarne) {
				if (Carne.getCode().equals(toFind.getCode())) {
					found = Carne;
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
