package co.edu.unbosque.model;

public enum InventoryStatus {

	INSTOCK("En Stock"), OUTOFSTOCK("Agotado"), LOWSTOCK("Stock bajo");

	private String text;

	InventoryStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
