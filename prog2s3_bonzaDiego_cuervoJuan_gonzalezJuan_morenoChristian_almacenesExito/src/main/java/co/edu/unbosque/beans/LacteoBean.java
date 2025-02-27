package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.LacteoDAO;
import co.edu.unbosque.model.persistence.LacteoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("LacteoBean")
@SessionScoped

public class LacteoBean implements Serializable {

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

	private ArrayList<LacteoDTO> lacteo;
	private ArrayList<LacteoDTO> lacteo2;
	private LacteoDTO lacteoDTO;
	private LacteoDAO lacteoDao;

	public LacteoBean() {
		lacteo = new ArrayList<>();
		lacteoDao = new LacteoDAO();
		lacteo2 = new ArrayList<LacteoDTO>();

	}

	@PostConstruct
	public void init() {
		System.out.println("Iniciando LacteoBean...");

		lacteo = lacteoDao.getAll();

		if (lacteo == null) {
			System.out.println("ERROR: LacteoDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + lacteo.size());
			for (LacteoDTO c : lacteo) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}

	public LacteoBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<LacteoDTO> lacteo,
			LacteoDAO lacteoDao) {
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
		this.lacteo = lacteo;
		this.lacteoDao = lacteoDao;
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

	public ArrayList<LacteoDTO> getLacteo() {
		return lacteo;
	}

	public void setLacteo(ArrayList<LacteoDTO> lacteo) {
		this.lacteo = lacteo;
	}

	public LacteoDAO getLacteoDao() {
		return lacteoDao;
	}

	public void setLacteoDao(LacteoDAO lacteoDao) {
		this.lacteoDao = lacteoDao;
	}

	public ArrayList<LacteoDTO> getLacteo2() {
		return lacteo2;
	}

	public void setLacteo2(ArrayList<LacteoDTO> lacteo2) {
		this.lacteo2 = lacteo2;
	}

	public LacteoDTO getLacteoDTO() {
		return lacteoDTO;
	}

	public void setLacteoDTO(LacteoDTO lacteoDTO) {
		this.lacteoDTO = lacteoDTO;
	}

	public void guardar() {
		LacteoDTO nuevoProducto = new LacteoDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		lacteoDao.add(nuevoProducto);
		lacteo = lacteoDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	public void actualizar() {

		if (lacteoDTO != null) {
			LacteoDTO lacteoActualizado = new LacteoDTO(id, lacteoDTO.getCode(), name, description, image, price,
					category, quantity, iStatus(quantity), rating, null);
			if (lacteoDao.update(lacteoDTO, lacteoActualizado)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			lacteo = lacteoDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	public void openNew() {
		lacteoDTO = new LacteoDTO();
	}

	public void eliminar() {
		if (lacteoDTO != null) {

			lacteoDao.delete(lacteoDTO);

			lacteo.removeIf(c -> c.getId() == lacteoDTO.getId());
			lacteo = lacteoDao.getAll();

			lacteoDTO = null;
		}
	}

	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}

	public void mostrar() {
		this.name = lacteoDTO.getName();
		this.description = lacteoDTO.getDescription();
		this.category = lacteoDTO.getCategory();
		this.price = lacteoDTO.getPrice();
		this.quantity = lacteoDTO.getQuantity();
	}

	public InventoryStatus iStatus(int cant) {

		if (cant <= 0) {
			return InventoryStatus.OUTOFSTOCK;
		} else if (cant >= 1 && cant <= 10) {
			return InventoryStatus.LOWSTOCK;
		} else if (cant > 10) {

			return InventoryStatus.INSTOCK;
		}
		return null;

	}

}
