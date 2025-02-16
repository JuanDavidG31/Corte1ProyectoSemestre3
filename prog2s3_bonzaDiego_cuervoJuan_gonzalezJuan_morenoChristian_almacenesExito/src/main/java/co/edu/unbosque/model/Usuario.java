package co.edu.unbosque.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String contrasegna;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String contrasegna, String nombre, String apellido, String correo, String cargo) {
		super();
		this.id = id;
		this.contrasegna = contrasegna;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", contrasegna=" + contrasegna + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", cargo=" + cargo + "]";
	}

}