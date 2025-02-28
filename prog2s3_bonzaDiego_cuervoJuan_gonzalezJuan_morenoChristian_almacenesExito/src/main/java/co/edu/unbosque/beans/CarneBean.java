package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CarneDTO;

import co.edu.unbosque.model.InventoryStatus;

import co.edu.unbosque.model.persistence.CarneDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("CarneBean")
@SessionScoped
/**
 * Clase CarneBean que actúa como un Managed Bean en un entorno JSF.
 * Se encarga de manejar la lógica de presentación y comunicación entre la capa 
 * de negocio (CarneDAO) y la vista, permitiendo la gestión de productos cárnicos.
 */
public class CarneBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String code;
	private String name;
	private String description;
	private String image;
	private double price;
	private String category;
	private int quantity;
	private InventoryStatus inventoryStatus;
	private int rating;

	private ArrayList<CarneDTO> carne;
	private ArrayList<CarneDTO> carne2;
	private CarneDTO carneDTO;
	private CarneDAO carneDao;

	/**
	 * Constructor por defecto de CarneBean.
	 * Inicializa las listas y la instancia del DAO.
	 */
	public CarneBean() {
		carne = new ArrayList<>();
		carneDao = new CarneDAO();
		carne2 = new ArrayList<CarneDTO>();

	}

	/**
	 * Método de inicialización llamado después de la construcción del bean.
	 * Carga la lista de carnes desde la base de datos.
	 */
	@PostConstruct
	public void init() {
		
		
		
		System.out.println("Iniciando CarneBean...");

		carne = carneDao.getAll();

		if (carne == null) {
			System.out.println("ERROR");
		} else {

			for (CarneDTO c : carne) {
				System.out.println("Code: " + c.getCode() + ", Nombre: " + c.getName());
			}
		}
	}

	/**
	 * Constructor con parámetros para CarneBean.
	 *
	 * @param id Identificador único
	 * @param code Código de la carne
	 * @param name Nombre de la carne
	 * @param description Descripción de la carne
	 * @param image Imagen de la carne
	 * @param price Precio de la carne
	 * @param category Categoría de la carne
	 * @param quantity Cantidad disponible
	 * @param inventoryStatus Estado del inventario
	 * @param rating Calificación
	 * @param carne Lista de carnes
	 * @param carneDao Objeto DAO para acceso a datos
	 */
	public CarneBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<CarneDTO> carne, CarneDAO carneDao) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.inventoryStatus = inventoryStatus;
		this.rating = rating;
		this.carne = carne;
		this.carneDao = carneDao;
	}

	/**
	 * Obtiene el ID de la carne.
	 *
	 * @return ID de la carne
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el ID de la carne.
	 *
	 * @param id Nuevo ID de la carne
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Obtiene el código de la carne. */
	public String getCode() {
		return code;
	}
	/** Establece el código de la carne. */
	public void setCode(String code) {
		this.code = code;
	}
	/** Obtiene el nombre de la carne. */
	public String getName() {
		return name;
	}
	/** Establece el nombre de la carne. */
	public void setName(String name) {
		this.name = name;
	}
	/** Obtiene la descripción de la carne. */
	public String getDescription() {
		return description;
	}
	/** Establece la descripción de la carne. */
	public void setDescription(String description) {
		this.description = description;
	}
	/** Obtiene la imagen de la carne. */
	public String getImage() {
		return image;
	}
	/** Establece la imagen de la carne. */
	public void setImage(String image) {
		this.image = image;
	}
	/** Obtiene el precio de la carne. */
	public double getPrice() {
		return price;
	}
	/** Establece el precio de la carne. */
	public void setPrice(double price) {
		this.price = price;
	}
	/** Obtiene la categoría de la carne. */
	public String getCategory() {
		return category;
	}
	/** Establece la categoría de la carne. */
	public void setCategory(String category) {
		this.category = category;
	}
	/** Obtiene la cantidad disponible en inventario. */
	public int getQuantity() {
		return quantity;
	}
	/** Establece la cantidad disponible en inventario. */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/** Obtiene el estado del inventario. */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/** Establece el estado del inventario. */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/** Obtiene la calificación de la carne. */
	public int getRating() {
		return rating;
	}
	/** Establece la calificación de la carne. */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/** Obtiene la lista de carnes. */
	public ArrayList<CarneDTO> getCarne() {
		return carne;
	}
	/** Establece la lista de carnes. */
	public void setCarne(ArrayList<CarneDTO> carne) {
		this.carne = carne;
	}
	/** Obtiene el objeto DAO de carne. */
	public CarneDAO getCarneDao() {
		return carneDao;
	}
	/** Establece el objeto DAO de carne. */
	public void setCarneDao(CarneDAO carneDao) {
		this.carneDao = carneDao;
	}
	/** Obtiene la segunda lista de carnes. */
	public ArrayList<CarneDTO> getCarne2() {
		return carne2;
	}
	/** Establece la segunda lista de carnes. */
	public void setCarne2(ArrayList<CarneDTO> carne2) {
		this.carne2 = carne2;
	}
	/** Obtiene el objeto CarneDTO. */
	public CarneDTO getCarneDTO() {
		return carneDTO;
	}
	/** Establece el objeto CarneDTO. */
	public void setCarneDTO(CarneDTO carneDTO) {
		this.carneDTO = carneDTO;
	}
	/** Guarda un nuevo objeto CarneDTO en la base de datos. */
	public void guardar() {

		CarneDTO nuevoProducto = new CarneDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		carneDao.add(nuevoProducto);
		carne = carneDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}
	/** Inicializa un nuevo objeto CarneDTO. */
	public void openNew() {
		carneDTO = new CarneDTO();
	}

	public void eliminar() {
		if (carneDTO != null) {

			carneDao.delete(carneDTO);

			carne.removeIf(c -> c.getId() == carneDTO.getId());
			carne = carneDao.getAll();

			carneDTO = null;
		}
	}

	/** Actualiza la carne del inventario */

	
	public void mostrar() {
		this.name = carneDTO.getName();
		this.description = carneDTO.getDescription();
		this.category = carneDTO.getCategory();
		this.price = carneDTO.getPrice();
		this.quantity = carneDTO.getQuantity();
	}


	public void actualizar() {

	
		if (carneDTO != null) {
			CarneDTO carneActualizada = new CarneDTO(id, carneDTO.getCode(), name,
					description, image, price, category,
					quantity, iStatus(quantity), rating, null);
			if (carneDao.update(carneDTO, carneActualizada)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			carne = carneDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	/** Crea un nuevo código único para la carne. */
	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}
	/** Determina el estado del inventario según la cantidad. */
	public InventoryStatus iStatus(int cant) {

		if (cant <= 0) {
			return InventoryStatus.OUTOFSTOCK;
		} else if (cant >= 1 && cant <= 10) {
			return InventoryStatus.LOWSTOCK;
		} else if (cant > 10) {

			return InventoryStatus.INSTOCK;
		}
		return null;

	}

}