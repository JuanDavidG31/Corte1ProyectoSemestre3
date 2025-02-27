package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.CarneDTO;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("JugueteBean")
@SessionScoped

public class JugueteBean implements Serializable {

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

	private ArrayList<JugueteDTO> juguete;
	private ArrayList<JugueteDTO> juguete2;
	private JugueteDTO jugueteDTO;
	private JugueteDAO jugueteDao;

	public JugueteBean() {
		juguete = new ArrayList<>();
		jugueteDao = new JugueteDAO();
		juguete2 = new ArrayList<JugueteDTO>();

	}

	@PostConstruct
	public void init() {
		System.out.println("Iniciando JugueteBean...");

		juguete = jugueteDao.getAll();

		if (juguete == null) {
			System.out.println("ERROR: JugueteDao.getAll() devolvió null.");
		} else {
			System.out.println("Datos cargados: " + juguete.size());
			for (JugueteDTO c : juguete) {
				System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
			}
		}
	}

	public JugueteBean(int id, String code, String name, String description, String image, double price, String category,
			int quantity, InventoryStatus inventoryStatus, int rating, ArrayList<JugueteDTO> juguete, JugueteDAO jugueteDao) {
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
		this.juguete = juguete;
		this.jugueteDao = jugueteDao;
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

	public ArrayList<JugueteDTO> getJuguete() {
		return juguete;
	}

	public void setJuguete(ArrayList<JugueteDTO> juguete) {
		this.juguete = juguete;
	}

	public JugueteDAO getJugueteDao() {
		return jugueteDao;
	}

	public void setJugueteDao(JugueteDAO jugueteDao) {
		this.jugueteDao = jugueteDao;
	}

	public ArrayList<JugueteDTO> getJuguete2() {
		return juguete2;
	}

	public void setJuguete2(ArrayList<JugueteDTO> juguete2) {
		this.juguete2 = juguete2;
	}

	public JugueteDTO getJugueteDTO() {
		return jugueteDTO;
	}

	public void setJugueteDTO(JugueteDTO jugueteDTO) {
		this.jugueteDTO = jugueteDTO;
	}

	public void guardar() {
		JugueteDTO nuevoProducto = new JugueteDTO(id, createCode(), name, description, image, price, category, quantity,
				iStatus(quantity), rating, null);
		jugueteDao.add(nuevoProducto);
		juguete = jugueteDao.getAll();
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public void actualizar() {

		
		if (jugueteDTO != null) {
			JugueteDTO jugueteActualizada = new JugueteDTO(id, jugueteDTO.getCode(), name,
					description, image, price, category,
					quantity, iStatus(quantity), rating, null);
			if (jugueteDao.update(jugueteDTO, jugueteActualizada)) {
				System.out.println("si");
			} else {
				System.out.println("no");
			}

			juguete = jugueteDao.getAll();
		}
		this.name = "";
		this.description = "";
		this.category = "";
		this.price = 0;
		this.quantity = 0;
	}

	public void openNew() {
		jugueteDTO = new JugueteDTO();
	}

	public void eliminar() {
		if (jugueteDTO != null) {

			jugueteDao.delete(jugueteDTO);

			juguete.removeIf(c -> c.getId() == jugueteDTO.getId());
			juguete = jugueteDao.getAll();

			jugueteDTO = null;
		}
	}
	
	public String createCode() {

		String i = UUID.randomUUID().toString().replace("-", "").substring(0, 8);

		return i;
	}
	public void mostrar() {
		this.name = jugueteDTO.getName();
		this.description = jugueteDTO.getDescription();
		this.category = jugueteDTO.getCategory();
		this.price = jugueteDTO.getPrice();
		this.quantity = jugueteDTO.getQuantity();
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
