package co.edu.unbosque.model;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int number;
    private final String imagePath;

    public Order(int number, String imagePath) {
        this.number = number;
        this.imagePath = imagePath;
    }

    public int getNumber() {
        return number;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return number == order.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

}
