package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;
/**
 * Representa un producto en el sistema.
 */
public class Product implements Serializable {

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
    private List<Order> orders;
    /**
     * Constructor vacío de la clase Product.
     */
    public Product() {
    }
    /**
     * Constructor con parámetros para inicializar un producto.
     * 
     * @param id               Identificador único del producto.
     * @param code             Código único del producto.
     * @param name             Nombre del producto.
     * @param description      Descripción del producto.
     * @param image            URL o ruta de la imagen del producto.
     * @param price            Precio del producto.
     * @param category         Categoría del producto.
     * @param quantity         Cantidad disponible del producto.
     * @param inventoryStatus  Estado del inventario del producto.
     * @param rating           Calificación del producto.
     */
    public Product(int id, String code, String name, String description, String image, double price, String category, int quantity,
            InventoryStatus inventoryStatus, int rating) {
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
    }
    /**
     * Crea una copia del objeto Product.
     * 
     * @return Una nueva instancia de Product con los mismos valores.
     */
    @Override
    public Product clone() {
        return new Product(getId(), getCode(), getName(), getDescription(), getImage(), getPrice(), getCategory(), getQuantity(),
                getInventoryStatus(), getRating());
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
     * Obtiene el código único del producto.
     * @return Código del producto.
     */
    public String getCode() {
        return code;
    }
    /**
     * Establece el código único del producto.
     * @param code Código a asignar.
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
     * Obtiene la URL o ruta de la imagen del producto.
     * @return Imagen del producto.
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
     * Establece la cantidad del producto.
     * @param quantity Nueva cantidad del producto.
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
     * Obtiene la lista de órdenes asociadas con el producto.
     * @return Lista de órdenes.
     */
    public List<Order> getOrders() {
        return this.orders;
    }
    /**
     * Establece la lista de órdenes asociadas con el producto.
     * @param orders Nueva lista de órdenes.
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    /**
     * Genera un código hash basado en el código del producto.
     * @return Valor hash del producto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }
    /**
     * Compara dos productos basándose en su código.
     * @param obj El objeto a comparar.
     * @return true si los productos son iguales, false en caso contrario.
     */
    @Override
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
        Product other = (Product) obj;
        if (code == null) {
            return other.code == null;
        }
        else {
            return code.equals(other.code);
        }
    }

	
}
