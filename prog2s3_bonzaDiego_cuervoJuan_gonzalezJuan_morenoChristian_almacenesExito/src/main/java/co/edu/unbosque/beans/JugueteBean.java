package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.CarneDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("JugueteBean")
@SessionScoped
/**
 * Clase JugueteBean que actúa como un Managed Bean en un entorno JSF.
 * Se encarga de manejar la lógica de presentación y comunicación entre la capa 
 * de negocio (JugueteDAO) y la vista, permitiendo la gestión de productos de entretenimiento.
 */
public class JugueteBean implements Serializable {

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

	private ArrayList<JugueteDTO> juguete;
	private ArrayList<JugueteDTO> juguete2;
	private JugueteDTO jugueteDTO;
	private JugueteDAO jugueteDao;
	/**
	 * Constructor por defecto de JugueteBean.
	 * Inicializa las listas de juguetes y la instancia de JugueteDAO.
	 */

	public JugueteBean() {
		juguete = new ArrayList<>();
		jugueteDao = new JugueteDAO();
		juguete2 = new ArrayList<JugueteDTO>();

	}
	/**
	 * Método de inicialización llamado después de la construcción del bean.
	 * Carga la lista de juguetes desde el DAO y muestra información de la carga en la consola.
	 */
	@PostConstruct
	public void init() {
		System.out.println("Iniciando JugueteBean...");

		juguete = jugueteDao.getAll();

		if (juguete == null) {
			System.out.println("ERROR: JugueteDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + juguete.size());
			for (JugueteDTO c : juguete) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}
	/**
	 * Constructor con parámetros para inicializar un JugueteBean con datos específicos.
	 *
	 * @param id Identificador del juguete.
	 * @param code Código único del juguete.
	 * @param name Nombre del juguete.
	 * @param description Descripción del juguete.
	 * @param image URL de la imagen del juguete.
	 * @param price Precio del juguete.
	 * @param category Categoría del juguete.
	 * @param quantity Cantidad disponible en inventario.
	 * @param inventoryStatus Estado del inventario del juguete.
	 * @param rating Calificación del juguete.
	 * @param juguete Lista de juguetes DTO.
	 * @param jugueteDao Instancia del DAO para la gestión de juguetes.
	 */
	public JugueteBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<JugueteDTO> juguete, JugueteDAO jugueteDao) {
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
		this.juguete = juguete;
		this.jugueteDao = jugueteDao;
	}
	/**
	 * Obtiene el identificador del juguete.
	 * @return id del juguete.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el identificador del juguete.
	 * @param id Nuevo id del juguete.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene el código del juguete.
	 * @return Código del juguete.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Establece el código del juguete.
	 * @param code Nuevo código del juguete.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Obtiene el nombre del juguete.
	 * @return Nombre del juguete.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Establece el nombre del juguete.
	 * @param name Nuevo nombre del juguete.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Obtiene la descripción del juguete.
	 * @return Descripción del juguete.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Establece la descripción del juguete.
	 * @param description Nueva descripción del juguete.
	 */

	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Obtiene la URL de la imagen del juguete.
	 * @return URL de la imagen.
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Establece la URL de la imagen del juguete.
	 * @param image Nueva URL de la imagen.
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Obtiene el precio del juguete.
	 * @return Precio del juguete.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Establece el precio del juguete.
	 * @param price Nuevo precio del juguete.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Obtiene la categoría del juguete.
	 * @return Categoría del juguete.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Establece la categoría del juguete.
	 * @param category Nueva categoría del juguete.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * Obtiene la cantidad disponible del juguete en el inventario.
	 * @return Cantidad en inventario.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Establece la cantidad disponible del juguete en el inventario.
	 * @param quantity Nueva cantidad en inventario.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Obtiene el estado del inventario del juguete.
	 * @return Estado del inventario.
	 */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
	 * Establece el estado del inventario del juguete.
	 * @param inventoryStatus Nuevo estado del inventario.
	 */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
	 * Obtiene la calificación del juguete.
	 * @return Calificación del juguete.
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Establece la calificación del juguete.
	 * @param rating Nueva calificación del juguete.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Obtiene la lista de juguetes.
	 * @return Lista de juguetes DTO.
	 */
	public ArrayList<JugueteDTO> getJuguete() {
		return juguete;
	}
	/**
	 * Establece la lista de juguetes.
	 * @param juguete Nueva lista de juguetes DTO.
	 */
	public void setJuguete(ArrayList<JugueteDTO> juguete) {
		this.juguete = juguete;
	}
	/**
	 * Obtiene la instancia del DAO de juguetes.
	 * @return Instancia de JugueteDAO.
	 */
	public JugueteDAO getJugueteDao() {
		return jugueteDao;
	}
	/**
	 * Establece la instancia del DAO de juguetes.
	 * @param jugueteDao Nueva instancia de JugueteDAO.
	 */
	public void setJugueteDao(JugueteDAO jugueteDao) {
		this.jugueteDao = jugueteDao;
	}
	/**
	 * Obtiene la segunda lista de juguetes DTO.
	 * @return Segunda lista de juguetes DTO.
	 */
	public ArrayList<JugueteDTO> getJuguete2() {
		return juguete2;
	}
	/**
	 * Establece la segunda lista de juguetes DTO.
	 * @param juguete2 Nueva segunda lista de juguetes DTO.
	 */
	public void setJuguete2(ArrayList<JugueteDTO> juguete2) {
		this.juguete2 = juguete2;
	}
	/**
	 * Obtiene el juguete DTO actual.
	 * @return JugueteDTO actual.
	 */
	public JugueteDTO getJugueteDTO() {
		return jugueteDTO;
	}
	/**
	 * Establece el juguete DTO actual.
	 * @param jugueteDTO Nuevo JugueteDTO actual.
	 */
	public void setJugueteDTO(JugueteDTO jugueteDTO) {
		this.jugueteDTO = jugueteDTO;
	}

	public void guardar() {
		JugueteDTO nuevoProducto = new JugueteDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		jugueteDao.add(nuevoProducto);
		juguete = jugueteDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public void actualizar() {

		
		if (jugueteDTO != null) {
			JugueteDTO jugueteActualizada = new JugueteDTO(id, jugueteDTO.getCode(), name,
					description, image, price, category,
					quantity, iStatus(quantity), rating, null);
			if (jugueteDao.update(jugueteDTO, jugueteActualizada)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			juguete = jugueteDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	public void openNew() {
		jugueteDTO = new JugueteDTO();
	}

	public void eliminar() {
		if (jugueteDTO != null) {

			jugueteDao.delete(jugueteDTO);

			juguete.removeIf(c -> c.getId() == jugueteDTO.getId());
			juguete = jugueteDao.getAll();

			jugueteDTO = null;
		}
	}
	
	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}
	public void mostrar() {
		this.name = jugueteDTO.getName();
		this.description = jugueteDTO.getDescription();
		this.category = jugueteDTO.getCategory();
		this.price = jugueteDTO.getPrice();
		this.quantity = jugueteDTO.getQuantity();
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
