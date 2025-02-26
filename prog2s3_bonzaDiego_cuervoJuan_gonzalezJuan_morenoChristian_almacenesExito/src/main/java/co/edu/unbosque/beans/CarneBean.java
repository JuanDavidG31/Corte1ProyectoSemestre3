package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.CarneDTO;

import co.edu.unbosque.model.InventoryStatus;

import co.edu.unbosque.model.persistence.CarneDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("CarneBean")
@SessionScoped
public class CarneBean implements Serializable {

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

	private ArrayList<CarneDTO> carne;
	private ArrayList<CarneDTO> carne2;
	private CarneDTO carneDTO;
	private CarneDAO carneDao;

	public CarneBean() {
		carne = new ArrayList<>();
		carneDao = new CarneDAO();
		carne2 = new ArrayList<CarneDTO>();

	}

	@PostConstruct
	public void init() {
		System.out.println("Iniciando CarneBean...");

		carne = carneDao.getAll();

		if (carne == null) {
			System.out.println("ERROR: carneDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + carne.size());
			for (CarneDTO c : carne) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}

	public CarneBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<CarneDTO> carne, CarneDAO carneDao) {
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
		this.carne = carne;
		this.carneDao = carneDao;
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

	public ArrayList<CarneDTO> getCarne() {
		return carne;
	}

	public void setCarne(ArrayList<CarneDTO> carne) {
		this.carne = carne;
	}

	public CarneDAO getCarneDao() {
		return carneDao;
	}

	public void setCarneDao(CarneDAO carneDao) {
		this.carneDao = carneDao;
	}

	public ArrayList<CarneDTO> getCarne2() {
		return carne2;
	}

	public void setCarne2(ArrayList<CarneDTO> carne2) {
		this.carne2 = carne2;
	}

	public CarneDTO getCarneDTO() {
		return carneDTO;
	}

	public void setCarneDTO(CarneDTO carneDTO) {
		this.carneDTO = carneDTO;
	}

	public void guardar() {
		CarneDTO nuevoProducto = new CarneDTO(id, code, name, description, image, price, category, quantity,
				inventoryStatus, rating, null);
		carneDao.add(nuevoProducto);
		carne = carneDao.getAll();
	}

	public void openNew() {
		carneDTO = new CarneDTO();
	}

	public void eliminar() {
		ArrayList<CarneDTO> ca = carneDao.getAll();

		for (CarneDTO carneDTO : ca) {

			int tNumDoc = carneDTO.getId();
			System.out.println(tNumDoc);
			if (tNumDoc == id) {
				carneDao.delete(new CarneDTO(id, code, name, description, image, price, category, quantity,
						inventoryStatus, rating, null));
			}
		}

	}

}
