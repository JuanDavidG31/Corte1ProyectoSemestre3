package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * 
 * @param <D> Tipo de dato de la entidad a manipular.
 * @param <E> Tipo de dato utilizado para búsquedas.
 */
public interface CRUDOperation<D, E> {
	
	 /**
     * Elimina un elemento en la posición especificada.
     * 
     * @param positionToDelete Índice del elemento a eliminar.
     */
	public void delete(int positionToDelete);
	/**
     * Muestra todos los elementos en una representación de cadena.
     * 
     * @return Cadena con la información de todos los elementos.
     */
	public String showAll(); 
	/**
     * Obtiene una lista con todos los elementos almacenados.
     * 
     * @return Lista de todos los elementos.
     */
	public ArrayList<D> getAll(); 
	/**
     * Agrega un nuevo elemento a la colección.
     * 
     * @param newData Elemento a agregar.
     * @return {@code true} si la operación fue exitosa, de lo contrario {@code false}.
     */
	public boolean add(D newData);  
	/**
     * Busca un elemento en la colección.
     * 
     * @param toFind Elemento a buscar.
     * @return Elemento encontrado o {@code null} si no se encuentra.
     */
	public E find(E toFind); 
	/**
     * Busca un elemento en la colección utilizando otro criterio.
     * 
     * @param toFind Elemento a buscar.
     * @return Elemento encontrado o {@code null} si no se encuentra.
     */
	public E find2(E toFind); 
	/**
     * Actualiza un elemento en la colección.
     * 
     * @param previous Elemento a reemplazar.
     * @param newData Nuevo elemento.
     * @return {@code true} si la actualización fue exitosa, de lo contrario {@code false}.
     */
	public boolean update(D previous, D newData); 
	 /**
     * Elimina un elemento de la colección.
     * 
     * @param toDelete Elemento a eliminar.
     * @return {@code true} si la eliminación fue exitosa, de lo contrario {@code false}.
     */
	public boolean delete(D toDelete); 
}
