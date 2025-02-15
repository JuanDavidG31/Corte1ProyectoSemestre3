package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<D, E> {
	

	public void delete(int positionToDelete);
	
	public String showAll(); 

	public ArrayList<D> getAll(); 

	public boolean add(D newData);  

	public E find(E toFind); 

	public E find2(E toFind); 

	public boolean update(D previous, D newData); 
	
	public boolean delete(D toDelete); 
}
