package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Representa una orden con un número único y una imagen asociada.
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int number;
    private final String imagePath;
    /**
     * Crea una nueva orden con un número y una ruta de imagen.
     * 
     * @param number Número único de la orden.
     * @param imagePath Ruta de la imagen asociada a la orden.
     */
    public Order(int number, String imagePath) {
        this.number = number;
        this.imagePath = imagePath;
    }
    /**
     * Obtiene el número de la orden.
     * 
     * @return Número de la orden.
     */
    public int getNumber() {
        return number;
    }
    /**
     * Obtiene la ruta de la imagen asociada a la orden.
     * 
     * @return Ruta de la imagen.
     */
    public String getImagePath() {
        return imagePath;
    }
    /**
     * Compara si dos órdenes son iguales basándose en su número único.
     * 
     * @param o Objeto a comparar.
     * @return {@code true} si los números de orden son iguales, de lo contrario {@code false}.
     */
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
    /**
     * Devuelve el código hash de la orden basado en su número.
     * 
     * @return Código hash de la orden.
     */
    @Override
    public int hashCode() {
        return number;
    }

}
