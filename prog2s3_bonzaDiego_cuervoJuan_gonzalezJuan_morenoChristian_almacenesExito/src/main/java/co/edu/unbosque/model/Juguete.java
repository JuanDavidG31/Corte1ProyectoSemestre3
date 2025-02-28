package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase que representa un juguete dentro del sistema.
 * Implementa la interfaz Serializable para permitir la serialización del objeto.
 */
public class Juguete implements Serializable {

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
	private ArrayList<Order> orders;
	/**
     * Constructor vacío de la clase Juguete.
     */
	public Juguete() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros para inicializar un objeto Juguete.
     *
     * @param id               Identificador único del juguete.
     * @param code             Código único del juguete.
     * @param name             Nombre del juguete.
     * @param description      Descripción del juguete.
     * @param image            URL de la imagen del juguete.
     * @param price            Precio del juguete.
     * @param category         Categoría a la que pertenece el juguete.
     * @param quantity         Cantidad disponible en el inventario.
     * @param inventoryStatus  Estado del inventario del juguete.
     * @param rating           Calificación del juguete.
     * @param orders           Lista de órdenes asociadas al juguete.
     */
	public Juguete(int id, String code, String name, String description, String image, double price, String category,
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
     * Obtiene el ID del juguete.
     * @return ID del juguete.
     */
	public int getId() {
		return id;
	}
	/**
     * Establece el ID del juguete.
     * @param id Nuevo ID del juguete.
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
     * @return URL de la imagen del juguete.
     */
	public String getImage() {
		return image;
	}
	/**
     * Establece la URL de la imagen del juguete.
     * @param image Nueva URL de la imagen del juguete.
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
     * Obtiene la cantidad de unidades del juguete en inventario.
     * @return Cantidad en inventario.
     */
	public int getQuantity() {
		return quantity;
	}
	/**
     * Establece la cantidad de unidades del juguete en inventario.
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
     * Obtiene la lista de órdenes asociadas al juguete.
     * @return Lista de órdenes.
     */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
     * Establece la lista de órdenes asociadas al juguete.
     * @param orders Nueva lista de órdenes.
     */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	/**
     * Compara si dos objetos Juguete son iguales basándose en su código.
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
		Juguete other = (Juguete) obj;
		if (code == null) {
			return other.getCode() == null;
		} else {
			return code.equals(other.getCode());
		}
	}
	/**
     * Genera un código hash para el objeto Juguete basado en su código.
     * @return Valor hash del objeto.
     */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	/**
     * Genera una representación en cadena del objeto Juguete.
     * @return Representación en cadena del objeto.
     */
	@Override
	public String toString() {
		return "Juguete [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", image="
				+ image + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ ", inventoryStatus=" + inventoryStatus + ", rating=" + rating + ", orders=" + orders + "]";
	}

}