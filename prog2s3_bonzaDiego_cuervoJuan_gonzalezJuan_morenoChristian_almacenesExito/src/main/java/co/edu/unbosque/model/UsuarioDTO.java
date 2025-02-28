package co.edu.unbosque.model;
/**
 * Clase DTO (Data Transfer Object) para representar un usuario.
 * Se utiliza para transferir datos entre capas sin exponer la entidad original.
 */
public class UsuarioDTO {

	private String id;
	private String contrasegna;
	private String nombre;
	private String apellido;
	private String correo;
	private String cargo;
	/**
     * Constructor vacio la clase UsuarioDTO.
     */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor de la clase UsuarioDTO con parámetros.
     * 
     * @param id          Identificador único del usuario.
     * @param contrasegna Contraseña del usuario.
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param correo      Correo electrónico del usuario.
     * @param cargo       Cargo o rol del usuario dentro de la organización.
     */
	public UsuarioDTO(String id, String contrasegna, String nombre, String apellido, String correo, String cargo) {
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
     * Devuelve una representación en cadena del objeto UsuarioDTO.
     * 
     * @return Una cadena con la información del usuario.
     */
	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", contrasegna=" + contrasegna + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", cargo=" + cargo + "]";
	}

}
