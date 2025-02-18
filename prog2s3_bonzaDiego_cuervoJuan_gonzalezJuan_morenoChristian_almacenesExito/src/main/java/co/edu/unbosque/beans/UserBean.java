package co.edu.unbosque.beans;

import java.io.IOException;
import java.util.ArrayList;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("UserBean")
@RequestScoped

public class UserBean {

	private String id;
	private String contrasegna;
	private String contrasegna2;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;
	private UsuarioDAO uDao;
	private ArrayList<UsuarioDTO> Usuario;

	public UserBean() {
		uDao = new UsuarioDAO();
		Usuario = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getContrasegna2() {
		return contrasegna2;
	}

	public void setContrasegna2(String contrasegna2) {
		this.contrasegna2 = contrasegna2;
	}

	public void crear() {
		Usuario = uDao.getAll();

		if (Usuario.isEmpty()) {
			uDao.add(new UsuarioDTO(id, contrasegna, nombre, apellido, correo, cargo));
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Usuario creado exitosamente"));
			PrimeFaces.current().executeScript("alert('Usuario creado exitosamente');");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		} else {
			for (UsuarioDTO u : Usuario) {
				String tId = u.getId().toString();

				if (tId.equals(id)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Advertencia", "El usuario con ese ID ya existe"));
					PrimeFaces.current().executeScript("alert('El usuario con ese ID ya existe');");
					return;
				} else {
					continue;

				}
			}

			uDao.add(new UsuarioDTO(id, contrasegna, nombre, apellido, correo, cargo));
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Usuario creado exitosamente"));
			PrimeFaces.current().executeScript("alert('Usuario creado exitosamente');");
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
	}
}
