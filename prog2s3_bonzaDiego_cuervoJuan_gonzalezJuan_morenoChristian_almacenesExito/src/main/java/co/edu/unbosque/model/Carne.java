package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Representa un producto de tipo Carne.
 */
public class Carne implements Serializable {
	
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
     * Constructor vacio.
     */
	public Carne() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros.
     * 
     * @param id Identificador único del producto.
     * @param code Código del producto.
     * @param name Nombre del producto.
     * @param description Descripción del producto.
     * @param image URL de la imagen del producto.
     * @param price Precio del producto.
     * @param category Categoría del producto.
     * @param quantity Cantidad disponible en stock.
     * @param inventoryStatus Estado del inventario.
     * @param rating Calificación del producto.
     * @param orders Lista de órdenes asociadas al producto.
     */
	public Carne(int id, String code, String name, String description, String image, double price, String category,
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
	 * @return El ID del producto.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el ID del producto.
	 * @param id El nuevo ID del producto.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtiene el código del producto.
	 * @return El código del producto.
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Establece el código del producto.
	 * @param code El nuevo código del producto.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Obtiene el nombre del producto.
	 * @return El nombre del producto.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Establece el nombre del producto.
	 * @param name El nuevo nombre del producto.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Obtiene la descripción del producto.
	 * @return La descripción del producto.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Establece la descripción del producto.
	 * @param description La nueva descripción del producto.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Obtiene la URL de la imagen del producto.
	 * @return La URL de la imagen del producto.
	 */
	public String getImage() {
		return image;
	}
	/**
	 * Establece la URL de la imagen del producto.
	 * @param image La nueva URL de la imagen del producto.
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Obtiene el precio del producto.
	 * @return El precio del producto.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Establece el precio del producto.
	 * @param price El nuevo precio del producto.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Obtiene la categoría del producto.
	 * @return La categoría del producto.
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Establece la categoría del producto.
	 * @param category La nueva categoría del producto.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * Obtiene la cantidad disponible en inventario.
	 * @return La cantidad del producto en inventario.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Establece la cantidad disponible en inventario.
	 * @param quantity La nueva cantidad del producto en inventario.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Obtiene el estado del inventario del producto.
	 * @return El estado del inventario del producto.
	 */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
	 * Establece el estado del inventario del producto.
	 * @param inventoryStatus El nuevo estado del inventario del producto.
	 */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
	 * Obtiene la calificación del producto.
	 * @return La calificación del producto.
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Establece la calificación del producto.
	 * @param rating La nueva calificación del producto.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Obtiene la lista de órdenes asociadas al producto.
	 * @return La lista de órdenes del producto.
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
	 * Establece la lista de órdenes asociadas al producto.
	 * @param orders La nueva lista de órdenes del producto.
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	/**
     * Compara este objeto con otro para verificar si son iguales.
     * 
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
     * Genera un código hash basado en el código del producto.
     * 
     * @return Valor del código hash.
     */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	/**
     * Devuelve una representación en cadena del objeto.
     * 
     * @return Cadena con los valores de los atributos del objeto.
     */
	@Override
	public String toString() {
		return "Carne [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", image="
				+ image + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ ", inventoryStatus=" + inventoryStatus + ", rating=" + rating + ", orders=" + orders + "]";
	}

}
