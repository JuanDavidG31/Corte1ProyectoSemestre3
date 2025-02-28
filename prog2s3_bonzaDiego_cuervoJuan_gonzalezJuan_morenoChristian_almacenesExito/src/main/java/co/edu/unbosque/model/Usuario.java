package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Representa un usuario con sus datos básicos.
 * Implementa la interfaz Serializable para permitir la serialización del objeto.
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String contrasegna;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;
	/**
     * Constructor vacio de la clase Usuario.
     */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor de la clase Usuario con parámetros.
     * 
     * @param id          Identificador único del usuario.
     * @param contrasegna Contraseña del usuario.
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param cargo       Cargo o rol del usuario.
     */
	public Usuario(String id, String contrasegna, String nombre, String apellido, String correo, String cargo) {
		super();
		this.id = id;
		this.contrasegna = contrasegna;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.cargo = cargo;
	}
	/**
	 * Obtiene el ID del usuario.
	 * 
	 * @return El ID del usuario.
	 */
	public String getId() {
		return id;
	}
	/**
	 * Establece el ID del usuario.
	 * 
	 * @param id Nuevo ID del usuario.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return La contraseña del usuario.
	 */
	public String getContrasegna() {
		return contrasegna;
	}
	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param contrasegna Nueva contraseña del usuario.
	 */
	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}
	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre Nuevo nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el apellido del usuario.
	 * 
	 * @return El apellido del usuario.
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Establece el apellido del usuario.
	 * 
	 * @param apellido Nuevo apellido del usuario.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Obtiene el correo electrónico del usuario.
	 * 
	 * @return El correo electrónico del usuario.
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Establece el correo electrónico del usuario.
	 * 
	 * @param correo Nuevo correo electrónico del usuario.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Obtiene el cargo del usuario.
	 * 
	 * @return El cargo del usuario.
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * Establece el cargo del usuario.
	 * 
	 * @param cargo Nuevo cargo del usuario.
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * Devuelve una representación en cadena del objeto Usuario.
	 * 
	 * @return Una cadena con la información del usuario.
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", contrasegna=" + contrasegna + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", cargo=" + cargo + "]";
	}

}