package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase que representa una prenda de ropa en el sistema.
 * Implementa Serializable para permitir la serialización del objeto.
 */
public class Ropa implements Serializable {

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
	 * Constructor vacio de Ropa.
	 */
	public Ropa() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor con parámetros para inicializar un objeto Ropa.
	 *
	 * @param id              Identificador único de la prenda.
	 * @param code            Código de la prenda.
	 * @param name            Nombre de la prenda.
	 * @param description     Descripción de la prenda.
	 * @param image           URL o nombre del archivo de imagen de la prenda.
	 * @param price           Precio de la prenda.
	 * @param category        Categoría de la prenda.
	 * @param quantity        Cantidad disponible en inventario.
	 * @param inventoryStatus Estado del inventario de la prenda.
	 * @param rating          Calificación de la prenda.
	 * @param orders          Lista de órdenes asociadas a la prenda.
	 */
	public Ropa(int id, String code, String name, String description, String image, double price, String category,
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
	 * Obtiene el identificador único de la prenda.
	 *
	 * @return Identificador de la prenda.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el identificador único de la prenda.
	 *
	 * @param id Identificador de la prenda.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene el código de la prenda.
	 *
	 * @return Código de la prenda.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Establece el código de la prenda.
	 *
	 * @param code Código de la prenda.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Obtiene el nombre de la prenda.
	 *
	 * @return Nombre de la prenda.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Establece el nombre de la prenda.
	 *
	 * @param name Nombre de la prenda.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Obtiene la descripción de la prenda.
	 *
	 * @return Descripción de la prenda.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Establece la descripción de la prenda.
	 *
	 * @param description Descripción de la prenda.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Obtiene la URL o el nombre del archivo de imagen de la prenda.
	 *
	 * @return Imagen de la prenda.
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Establece la URL o el nombre del archivo de imagen de la prenda.
	 *
	 * @param image Imagen de la prenda.
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Obtiene el precio de la prenda.
	 *
	 * @return Precio de la prenda.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Establece el precio de la prenda.
	 *
	 * @param price Precio de la prenda.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Obtiene la categoría de la prenda.
	 *
	 * @return Categoría de la prenda.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Establece la categoría de la prenda.
	 *
	 * @param category Categoría de la prenda.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * Obtiene la cantidad disponible en inventario.
	 * @return Cantidad en inventario.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Establece la cantidad en inventario.
	 * @param quantity Nueva cantidad en inventario.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Obtiene el estado del inventario.
	 * @return Estado del inventario.
	 */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
	 * Establece el estado del inventario.
	 * @param inventoryStatus Nuevo estado del inventario.
	 */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
	 * Obtiene la calificación de la prenda.
	 * @return Calificación de la prenda.
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Establece la calificación de la prenda.
	 * @param rating Nueva calificación de la prenda.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Obtiene la lista de órdenes asociadas a la prenda.
	 * @return Lista de órdenes.
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
	 * Establece la lista de órdenes asociadas a la prenda.
	 * @param orders Nueva lista de órdenes.
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	/**
	 * Compara esta prenda con otro objeto para determinar si son iguales.
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
		Ropa other = (Ropa) obj;
		if (code == null) {
			return other.getCode() == null;
		} else {
			return code.equals(other.getCode());
		}
	}
	/**
	 * Genera el código hash para la prenda basado en su código.
	 * @return Código hash de la prenda.
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	/**
	 * Representación en cadena de la prenda.
	 * @return Cadena que representa la prenda.
	 */
	@Override
	public String toString() {
		return "Ropa [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", image="
				+ image + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ ", inventoryStatus=" + inventoryStatus + ", rating=" + rating + ", orders=" + orders + "]";
	}

}

