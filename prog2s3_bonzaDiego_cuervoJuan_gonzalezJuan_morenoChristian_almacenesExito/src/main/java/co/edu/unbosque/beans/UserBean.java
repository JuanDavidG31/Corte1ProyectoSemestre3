package co.edu.unbosque.beans;

import java.util.ArrayList;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;

import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named("UserBean")
@RequestScoped

public class UserBean {

	private int id;
	private String contrasegna;
	private String contrasegna2;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;
	private UsuarioDAO uDao;

	public UserBean() {
		uDao = new UsuarioDAO();
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

	public String getContrasegna2() {
		return contrasegna2;
	}

	public void setContrasegna2(String contrasegna2) {
		this.contrasegna2 = contrasegna2;
	}

	public void crear() {

		

	}

	public void mostrar() {
		ArrayList<UsuarioDTO> u = uDao.getAll();
		for (UsuarioDTO usuarioDTO : u) {
			System.out.println(usuarioDTO);
		}
	}

}
