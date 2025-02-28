package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Clase que representa un objeto Carne en forma de DTO (Data Transfer Object).
 * Contiene información sobre el producto, incluyendo su identificación, nombre, 
 * descripción, imagen, precio, categoría, cantidad disponible, estado de inventario, 
 * calificación y lista de órdenes asociadas.
 */
public class CarneDTO {
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
	private ArrayList<Order> orders;
	 /**
     * Constructor vacío de la clase CarneDTO.
     */
	public CarneDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros para inicializar un objeto CarneDTO.
     * 
     * @param id               Identificador único del producto.
     * @param code             Código del producto.
     * @param name             Nombre del producto.
     * @param description      Descripción del producto.
     * @param image            URL de la imagen del producto.
     * @param price            Precio del producto.
     * @param category         Categoría a la que pertenece el producto.
     * @param quantity         Cantidad disponible en inventario.
     * @param inventoryStatus  Estado del inventario del producto.
     * @param rating           Calificación del producto.
     * @param orders           Lista de órdenes asociadas al producto.
     */
	public CarneDTO(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<Order> orders) {
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
		this.orders = orders;
	}
	 /**
     * Obtiene el ID del producto.
     * @return ID del producto.
     */
	public int getId() {
		return id;
	}
	/**
     * Establece el ID del producto.
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
     * Obtiene la URL de la imagen del producto.
     * @return URL de la imagen del producto.
     */
	public String getImage() {
		return image;
	}
	/**
     * Establece la URL de la imagen del producto.
     * @param image Nueva URL de la imagen del producto.
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
     * Obtiene la cantidad de unidades del producto en inventario.
     * @return Cantidad en inventario.
     */
	public int getQuantity() {
		return quantity;
	}
	/**
     * Establece la cantidad de unidades del producto en inventario.
     * @param quantity Nueva cantidad en inventario.
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
     * Obtiene el estado del inventario del producto.
     * @return Estado del inventario.
     */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
     * Establece el estado del inventario del producto.
     * @param inventoryStatus Nuevo estado del inventario.
     */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
     * Obtiene la calificación del producto.
     * @return Calificación del producto.
     */
	public int getRating() {
		return rating;
	}
	/**
     * Establece la calificación del producto.
     * @param rating Nueva calificación del producto.
     */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
     * Obtiene la lista de órdenes asociadas al producto.
     * @return Lista de órdenes.
     */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
     * Establece la lista de órdenes asociadas al producto.
     * @param orders Nueva lista de órdenes.
     */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	/**
     * Compara si dos objetos CarneDTO son iguales basándose en su código.
     * @param obj Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Carne other = (Carne) obj;
		if (code == null) {
			return other.getCode() == null;
		} else {
			return code.equals(other.getCode());
		}
	}
	/**
     * Genera un código hash para el objeto CarneDTO basado en su código.
     * @return Valor hash del objeto.
     */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	 /**
     * Genera una representación en cadena del objeto CarneDTO.
     * @return Representación en cadena del objeto.
     */
	@Override
	public String toString() {
		return "Carne [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", image="
				+ image + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ ", inventoryStatus=" + inventoryStatus + ", rating=" + rating + ", orders=" + orders + "]";
	}
}
