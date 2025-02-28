package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Data Transfer Object (DTO) para la entidad Juguete.
 * Se utiliza para transferir datos entre capas sin exponer la entidad original.
 */
public class JugueteDTO {
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
     * Constructor vacío de JugueteDTO.
     */
	public JugueteDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con parámetros.
     *
     * @param id Identificador único del juguete.
     * @param code Código único del juguete.
     * @param name Nombre del juguete.
     * @param description Descripción del juguete.
     * @param image URL de la imagen del juguete.
     * @param price Precio del juguete.
     * @param category Categoría del juguete.
     * @param quantity Cantidad en inventario.
     * @param inventoryStatus Estado del inventario.
     * @param rating Calificación del juguete.
     * @param orders Lista de órdenes asociadas.
     */
	public JugueteDTO(int id, String code, String name, String description, String image, double price, String category,
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
     * @return el ID del juguete.
     */
	public int getId() {
		return id;
	}
	/**
     * Establece el ID del juguete.
     * @param id el ID a establecer.
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * Obtiene el código del juguete.
     * @return el código del juguete.
     */
	public String getCode() {
		return code;
	}
	/**
     * Establece el código del juguete.
     * @param code el código a establecer.
     */
	public void setCode(String code) {
		this.code = code;
	}
	/**
     * Obtiene el nombre del juguete.
     * @return el nombre del juguete.
     */
	public String getName() {
		return name;
	}
	/**
     * Establece el nombre del juguete.
     * @param name el nombre a establecer.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Obtiene la descripción del juguete.
     * @return la descripción del juguete.
     */
	public String getDescription() {
		return description;
	}
    /**
     * Establece la descripción del juguete.
     * @param description la descripción a establecer.
     */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
     * Obtiene la imagen del juguete.
     * @return la imagen del juguete.
     */
	public String getImage() {
		return image;
	}
	/**
     * Establece la imagen del juguete.
     * @param image la imagen a establecer.
     */
	public void setImage(String image) {
		this.image = image;
	}
	/**
     * Obtiene el precio del juguete.
     * @return el precio del juguete.
     */
	public double getPrice() {
		return price;
	}
	/**
     * Establece el precio del juguete.
     * @param price el precio a establecer.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
     * Obtiene la categoría del juguete.
     * @return la categoría del juguete.
     */
	public String getCategory() {
		return category;
	}
	/**
     * Establece la categoría del juguete.
     * @param category la categoría a establecer.
     */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
     * Obtiene la cantidad disponible del juguete.
     * @return la cantidad disponible.
     */
	public int getQuantity() {
		return quantity;
	}
	/**
     * Establece la cantidad disponible del juguete.
     * @param quantity la cantidad a establecer.
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
     * Obtiene el estado de inventario del juguete.
     * @return el estado de inventario.
     */
	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}
	/**
     * Establece el estado de inventario del juguete.
     * @param inventoryStatus el estado de inventario a establecer.
     */
	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	/**
     * Obtiene la calificación del juguete.
     * @return la calificación del juguete.
     */
	public int getRating() {
		return rating;
	}
	/**
     * Establece la calificación del juguete.
     * @param rating la calificación a establecer.
     */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
     * Obtiene la lista de pedidos asociados al juguete.
     * @return la lista de pedidos.
     */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
     * Establece la lista de pedidos asociados al juguete.
     * @param orders la lista de pedidos a establecer.
     */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	/**
     * Compara dos objetos JugueteDTO basándose en su código.
     * @param obj Objeto a comparar.
     * @return true si los códigos son iguales, false en caso contrario.
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
     * Calcula el código hash basado en el código del juguete.
     * @return el valor hash del objeto.
     */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	/**
     * Devuelve una representación en cadena del objeto JugueteDTO.
     * @return Cadena con los valores del objeto.
     */
	@Override
	public String toString() {
		return "Juguete [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", image="
				+ image + ", price=" + price + ", category=" + category + ", quantity=" + quantity
				+ ", inventoryStatus=" + inventoryStatus + ", rating=" + rating + ", orders=" + orders + "]";
	}
}
