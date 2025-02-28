package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.RopaDAO;
import co.edu.unbosque.model.persistence.RopaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("RopaBean")
@SessionScoped
/**
 * Clase RopaBean que actúa como un Managed Bean en un entorno JSF.
 * Se encarga de manejar la lógica de presentación y comunicación entre la capa 
 * de negocio (RopaDAO) y la vista, permitiendo la gestión de ropa.
 */
public class RopaBean implements Serializable {

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

	private ArrayList<RopaDTO> ropa;
	private ArrayList<RopaDTO> ropa2;
	private RopaDTO ropaDTO;
	private RopaDAO ropaDao;
	/**
     * Constructor por defecto de RopaBean.
     * Inicializa la lista de ropa y el DAO.
     */
	public RopaBean() {
		ropa = new ArrayList<>();
		ropaDao = new RopaDAO();
		ropa2 = new ArrayList<RopaDTO>();

	}
	/**
     * Método de inicialización post-construcción.
     * Carga la lista de ropa desde la base de datos.
     */
	@PostConstruct
	public void init() {
		System.out.println("Iniciando RopaBean...");

		ropa = ropaDao.getAll();

		if (ropa == null) {
			System.out.println("ERROR: RopaDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + ropa.size());
			for (RopaDTO c : ropa) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}
	/**
     * Constructor sobrecargado de RopaBean.
     *
     * @param id              ID de la prenda
     * @param code            Código de la prenda
     * @param name            Nombre de la prenda
     * @param description     Descripción de la prenda
     * @param image           URL de la imagen de la prenda
     * @param price           Precio de la prenda
     * @param category        Categoría de la prenda
     * @param quantity        Cantidad disponible
     * @param inventoryStatus Estado del inventario
     * @param rating          Calificación de la prenda
     * @param ropa            Lista de prendas
     * @param ropaDao         DAO para acceder a la base de datos
     */
	public RopaBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<RopaDTO> ropa, RopaDAO ropaDao) {
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
		this.ropa = ropa;
		this.ropaDao = ropaDao;
	}
	/**
     * Obtiene el ID de la prenda.
     * @return ID de la prenda.
     */
	public int getId() {
		return id;
	}
	/**
     * Establece el ID de la prenda.
     * @param id Nuevo ID.
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * Obtiene el código de la prenda.
     * @return Código de la prenda.
     */
	public String getCode() {
		return code;
	}
	/**
     * Establece el código de la prenda.
     * @param code Nuevo código.
     */
	public void setCode(String code) {
		this.code = code;
	}
	/**
     * Obtiene el nombre de la prenda.
     * @return Nombre de la prenda.
     */
	public String getName() {
		return name;
	}
	/**
     * Establece el nombre de la prenda.
     * @param name Nuevo nombre.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Obtiene la descripción de la prenda.
     * @return Descripción de la prenda.
     */
	public String getDescription() {
		return description;
	}
	/**
     * Establece la descripción de la prenda.
     * @param description Nueva descripción.
     */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
     * Obtiene la URL de la imagen de la prenda.
     * @return URL de la imagen.
     */
	public String getImage() {
		return image;
	}
	/**
     * Establece la URL de la imagen de la prenda.
     * @param image Nueva URL de la imagen.
     */
	public void setImage(String image) {
		this.image = image;
	}
	/**
     * Obtiene el precio de la prenda.
     * @return Precio de la prenda.
     */
	public double getPrice() {
		return price;
	}
	/**
     * Establece el precio de la prenda.
     * @param price Nuevo precio.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Obtiene la categoría del producto.
	 * @return la categoría del producto.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Establece la categoría del producto.
	 * @param category la categoría a asignar.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * Obtiene la cantidad del producto.
	 * @return la cantidad del producto.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Establece la cantidad del producto.
	 * @param quantity la cantidad a asignar.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Obtiene el estado del inventario.
	 * @return el estado del inventario.
	 */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
	 * Establece el estado del inventario.
	 * @param inventoryStatus el estado del inventario a asignar.
	 */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
	 * Obtiene la calificación del producto.
	 * @return la calificación del producto.
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Establece la calificación del producto.
	 * @param rating la calificación a asignar.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Obtiene la lista de productos de ropa.
	 * @return la lista de productos de ropa.
	 */
	public ArrayList<RopaDTO> getRopa() {
		return ropa;
	}
	/**
	 * Establece la lista de productos de ropa.
	 * @param ropa la lista de productos a asignar.
	 */
	public void setRopa(ArrayList<RopaDTO> ropa) {
		this.ropa = ropa;
	}
	/**
	 * Obtiene el DAO de Ropa.
	 * @return el objeto RopaDAO.
	 */
	public RopaDAO getRopaDao() {
		return ropaDao;
	}
	/**
	 * Establece el DAO de Ropa.
	 * @param ropaDao el DAO de Ropa a asignar.
	 */
	public void setRopaDao(RopaDAO ropaDao) {
		this.ropaDao = ropaDao;
	}
	/**
	 * Obtiene la segunda lista de productos de ropa.
	 * @return la segunda lista de productos de ropa.
	 */
	public ArrayList<RopaDTO> getRopa2() {
		return ropa2;
	}
	/**
	 * Establece la segunda lista de productos de ropa.
	 * @param ropa2 la segunda lista de productos a asignar.
	 */
	public void setRopa2(ArrayList<RopaDTO> ropa2) {
		this.ropa2 = ropa2;
	}
	/**
	 * Obtiene el objeto de transferencia de datos de ropa.
	 * @return el objeto RopaDTO.
	 */
	public RopaDTO getRopaDTO() {
		return ropaDTO;
	}
	/**
	 * Establece el objeto de transferencia de datos de ropa.
	 * @param ropaDTO el objeto RopaDTO a asignar.
	 */
	public void setRopaDTO(RopaDTO ropaDTO) {
		this.ropaDTO = ropaDTO;
	}
	/**
	 * Guarda un nuevo producto de ropa en la base de datos.
	 */
	public void guardar() {
		RopaDTO nuevoProducto = new RopaDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		ropaDao.add(nuevoProducto);
		ropa = ropaDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	/**
	 * Crea un nuevo objeto RopaDTO vacío.
	 */

	public void actualizar() {

		if (ropaDTO != null) {
			RopaDTO ropaActualizada = new RopaDTO(id, ropaDTO.getCode(), name, description, image, price, category,
					quantity, iStatus(quantity), rating, null);
			if (ropaDao.update(ropaDTO, ropaActualizada)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			ropa = ropaDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}


	public void openNew() {
		ropaDTO = new RopaDTO();
	}
	/**
	 * Elimina un producto de ropa de la base de datos.
	 */
	public void eliminar() {
		if (ropaDTO != null) {

			ropaDao.delete(ropaDTO);

			ropa.removeIf(c -> c.getId() == ropaDTO.getId());
			ropa = ropaDao.getAll();

			ropaDTO = null;
		}
	}

	/**
	 * Genera un código único para el producto.
	 * @return un código único de 8 caracteres.
	 */


	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}

	/**
	 * Determina el estado del inventario según la cantidad disponible.
	 * @param cant cantidad del producto en inventario.
	 * @return el estado del inventario correspondiente.
	 */


	public void mostrar() {
		this.name = ropaDTO.getName();
		this.description = ropaDTO.getDescription();
		this.category = ropaDTO.getCategory();
		this.price = ropaDTO.getPrice();
		this.quantity = ropaDTO.getQuantity();
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