package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.RopaDAO;
import co.edu.unbosque.model.persistence.RopaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("RopaBean")
@RequestScoped

public class RopaBean implements Serializable {

	/**
	 * 
	 */
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

	private ArrayList<RopaDTO> ropa;
	private ArrayList<RopaDTO> ropa2;
	private RopaDTO ropaDTO;
	private RopaDAO ropaDao;

	public RopaBean() {
		ropa = new ArrayList<>();
		ropaDao = new RopaDAO();
		ropa2 = new ArrayList<RopaDTO>();

	}

	@PostConstruct
	public void init() {
		System.out.println("Iniciando RopaBean...");

		ropa = ropaDao.getAll();

		if (ropa == null) {
			System.out.println("ERROR: RopaDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + ropa.size());
			for (RopaDTO c : ropa) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}

	public RopaBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<RopaDTO> ropa, RopaDAO ropaDao) {
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
		this.ropa = ropa;
		this.ropaDao = ropaDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ArrayList<RopaDTO> getRopa() {
		return ropa;
	}

	public void setRopa(ArrayList<RopaDTO> ropa) {
		this.ropa = ropa;
	}

	public RopaDAO getRopaDao() {
		return ropaDao;
	}

	public void setRopaDao(RopaDAO ropaDao) {
		this.ropaDao = ropaDao;
	}

	public ArrayList<RopaDTO> getRopa2() {
		return ropa2;
	}

	public void setRopa2(ArrayList<RopaDTO> ropa2) {
		this.ropa2 = ropa2;
	}

	public RopaDTO getRopaDTO() {
		return ropaDTO;
	}

	public void setRopaDTO(RopaDTO ropaDTO) {
		this.ropaDTO = ropaDTO;
	}

	public void guardar() {
		RopaDTO nuevoProducto = new RopaDTO(id, code, name, description, image, price, category, quantity,
				inventoryStatus, rating, null);
		ropaDao.add(nuevoProducto);
		ropa = ropaDao.getAll();
	}

	public void openNew() {
		ropaDTO = new RopaDTO();
	}

	public void eliminar() {
		ArrayList<RopaDTO> ca = ropaDao.getAll();

		for (RopaDTO ropaDTO : ca) {

			int tNumDoc = ropaDTO.getId();
			System.out.println(tNumDoc);
			if (tNumDoc == id) {
				ropaDao.delete(new RopaDTO(id, code, name, description, image, price, category, quantity,
						inventoryStatus, rating, null));
			}
		}

	}

}