package co.edu.unbosque.model;
/**
 * Enumeración que representa el estado del inventario de un producto.
 */
public enum InventoryStatus {

	/** Producto disponible en stock. */
	INSTOCK("En Stock"), 
	/** Producto agotado. */
	OUTOFSTOCK("Agotado"), 
	/** Producto con bajo stock. */
	LOWSTOCK("Stock bajo");

	private String text;
	 /**
     * Constructor de InventoryStatus.
     * 
     * @param text Descripción del estado del inventario.
     */
	InventoryStatus(String text) {
		this.text = text;
	}
	/**
     * Obtiene la descripción del estado del inventario.
     * 
     * @return Texto descriptivo del estado.
     */
	public String getText() {
		return text;
	}
}
