package co.edu.unbosque.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contrasegna;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombreUsuario, String contrasegna) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasegna = contrasegna;
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

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrasegna=" + contrasegna + "]";
	}

}