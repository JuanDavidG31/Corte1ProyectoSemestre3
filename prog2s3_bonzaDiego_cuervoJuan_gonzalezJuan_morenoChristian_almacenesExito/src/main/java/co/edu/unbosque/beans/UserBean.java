package co.edu.unbosque.beans;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;

import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named("UserBean")
@RequestScoped

public class UserBean {

	private String nombreUsuario;
	private String contrasegna;
	private UsuarioDAO uDao;

	public UserBean() {
		uDao = new UsuarioDAO();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasegna() {
		return contrasegna;
	}

	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}

	public void eliminar() {

		this.nombreUsuario = "";
		this.contrasegna = "";
	}

	public void guardar() {
		uDao.add(new UsuarioDTO(nombreUsuario, contrasegna));
		
	}

}
