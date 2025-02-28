package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.LacteoDAO;
import co.edu.unbosque.model.persistence.LacteoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("LacteoBean")
@SessionScoped
/**
 * Clase que gestiona la información y operaciones relacionadas con productos lácteos.
 * Implementa Serializable para permitir su uso en sesiones.
 */
public class LacteoBean implements Serializable {

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

	private ArrayList<LacteoDTO> lacteo;
	private ArrayList<LacteoDTO> lacteo2;
	private LacteoDTO lacteoDTO;
	private LacteoDAO lacteoDao;
	/**
     * Constructor por defecto de LacteoBean.
     * Inicializa listas y DAO.
     */
	public LacteoBean() {
		lacteo = new ArrayList<>();
		lacteoDao = new LacteoDAO();
		lacteo2 = new ArrayList<LacteoDTO>();

	}
	/**
     * Método de inicialización llamado después de la construcción del bean.
     * Carga la lista de productos lácteos desde la base de datos.
     */
	@PostConstruct
	public void init() {
		System.out.println("Iniciando LacteoBean...");

		lacteo = lacteoDao.getAll();

		if (lacteo == null) {
			System.out.println("ERROR: LacteoDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + lacteo.size());
			for (LacteoDTO c : lacteo) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}
	/**
     * Constructor con parámetros para inicializar un objeto LacteoBean.
     * @param id Identificador del producto lácteo.
     * @param code Código del producto.
     * @param name Nombre del producto.
     * @param description Descripción del producto.
     * @param image URL de la imagen del producto.
     * @param price Precio del producto.
     * @param category Categoría del producto.
     * @param quantity Cantidad disponible del producto.
     * @param inventoryStatus Estado del inventario del producto.
     * @param rating Calificación del producto.
     * @param lacteo Lista de productos lácteos.
     * @param lacteoDao DAO para la gestión de productos lácteos.
     */
	public LacteoBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<LacteoDTO> lacteo,
			LacteoDAO lacteoDao) {
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
		this.lacteo = lacteo;
		this.lacteoDao = lacteoDao;
	}
	/**
     * Obtiene el ID del producto lácteo.
     * @return ID del producto.
     */
	public int getId() {
		return id;
	}
	/**
     * Establece el ID del producto lácteo.
     * @param id Nuevo ID del producto.
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * Obtiene el código del producto.
     * @return Código del producto.
     */
	public String getCode() {
		return code;
	}
	/**
     * Establece el código del producto.
     * @param code Nuevo código del producto.
     */
	public void setCode(String code) {
		this.code = code;
	}
	/**
     * Obtiene el nombre del producto.
     * @return Nombre del producto.
     */
	public String getName() {
		return name;
	}
	/**
     * Establece el nombre del producto.
     * @param name Nuevo nombre del producto.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Obtiene la descripción del producto.
     * @return Descripción del producto.
     */
	public String getDescription() {
		return description;
	}
	/**
     * Establece la descripción del producto.
     * @param description Nueva descripción del producto.
     */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
     * Obtiene la imagen del producto.
     * @return URL de la imagen del producto.
     */
	public String getImage() {
		return image;
	}
	/**
     * Establece la imagen del producto.
     * @param image Nueva imagen del producto.
     */
	public void setImage(String image) {
		this.image = image;
	}
	/**
     * Obtiene el precio del producto.
     * @return Precio del producto.
     */
	public double getPrice() {
		return price;
	}
	/**
     * Establece el precio del producto.
     * @param price Nuevo precio del producto.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
     * Obtiene la categoría del producto.
     * @return Categoría del producto.
     */
	public String getCategory() {
		return category;
	}
	/**
     * Establece la categoría del producto.
     * @param category Nueva categoría del producto.
     */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
     * Obtiene la cantidad disponible del producto.
     * @return Cantidad del producto.
     */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Establece la cantidad de productos lácteos.
	 * 
	 * @param quantity Cantidad de productos.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Obtiene el estado del inventario.
	 * 
	 * @return Estado del inventario.
	 */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
	 * Establece el estado del inventario.
	 * 
	 * @param inventoryStatus Estado del inventario.
	 */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
	 * Obtiene la calificación del producto.
	 * 
	 * @return Calificación del producto.
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Establece la calificación del producto.
	 * 
	 * @param rating Calificación del producto.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Obtiene la lista de productos lácteos.
	 * 
	 * @return Lista de productos lácteos.
	 */
	public ArrayList<LacteoDTO> getLacteo() {
		return lacteo;
	}
	/**
	 * Establece la lista de productos lácteos.
	 * 
	 * @param lacteo Lista de productos lácteos.
	 */
	public void setLacteo(ArrayList<LacteoDTO> lacteo) {
		this.lacteo = lacteo;
	}
	/**
	 * Obtiene el DAO de productos lácteos.
	 * 
	 * @return DAO de productos lácteos.
	 */
	public LacteoDAO getLacteoDao() {
		return lacteoDao;
	}
	/**
	 * Establece el DAO de productos lácteos.
	 * 
	 * @param lacteoDao DAO de productos lácteos.
	 */
	public void setLacteoDao(LacteoDAO lacteoDao) {
		this.lacteoDao = lacteoDao;
	}
	/**
	 * Obtiene la segunda lista de productos lácteos.
	 * 
	 * @return Segunda lista de productos lácteos.
	 */
	public ArrayList<LacteoDTO> getLacteo2() {
		return lacteo2;
	}
	/**
	 * Establece la segunda lista de productos lácteos.
	 * 
	 * @param lacteo2 Segunda lista de productos lácteos.
	 */
	public void setLacteo2(ArrayList<LacteoDTO> lacteo2) {
		this.lacteo2 = lacteo2;
	}
	/**
	 * Obtiene el objeto LacteoDTO actual.
	 * 
	 * @return Objeto LacteoDTO.
	 */
	public LacteoDTO getLacteoDTO() {
		return lacteoDTO;
	}

	public void setLacteoDTO(LacteoDTO lacteoDTO) {
		this.lacteoDTO = lacteoDTO;
	}
	/**
	 * Guarda un nuevo producto lácteo en la base de datos.
	 */
	public void guardar() {
		LacteoDTO nuevoProducto = new LacteoDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		lacteoDao.add(nuevoProducto);
		lacteo = lacteoDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	/**
	 * Inicializa un nuevo objeto LacteoDTO.
	 */


	public void actualizar() {

		if (lacteoDTO != null) {
			LacteoDTO lacteoActualizado = new LacteoDTO(id, lacteoDTO.getCode(), name, description, image, price,
					category, quantity, iStatus(quantity), rating, null);
			if (lacteoDao.update(lacteoDTO, lacteoActualizado)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			lacteo = lacteoDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}


	public void openNew() {
		lacteoDTO = new LacteoDTO();
	}
	/**
	 * Elimina un producto lácteo de la base de datos.
	 */
	public void eliminar() {
		if (lacteoDTO != null) {

			lacteoDao.delete(lacteoDTO);

			lacteo.removeIf(c -> c.getId() == lacteoDTO.getId());
			lacteo = lacteoDao.getAll();

			lacteoDTO = null;
		}
	}

	/**
	 * Genera un código único para un producto lácteo.
	 * 
	 * @return Código generado aleatoriamente.
	 */



	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}

	/**
	 * Determina el estado del inventario basado en la cantidad disponible.
	 * 
	 * @param cant Cantidad de productos en stock.
	 * @return Estado del inventario correspondiente.
	 */


	public void mostrar() {
		this.name = lacteoDTO.getName();
		this.description = lacteoDTO.getDescription();
		this.category = lacteoDTO.getCategory();
		this.price = lacteoDTO.getPrice();
		this.quantity = lacteoDTO.getQuantity();
	}


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
