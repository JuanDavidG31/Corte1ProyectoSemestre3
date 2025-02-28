package co.edu.unbosque.beans;

import java.io.IOException;
import java.util.ArrayList;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;

import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
/**
 * Clase UserBean que actúa como un Managed Bean en un entorno JSF.
 * Se encarga de manejar la lógica de presentación y comunicación entre la capa 
 * de negocio (UserDAO) y la vista, permitiendo la gestión de usuarios.
 */
@Named("UserBean")
@ApplicationScoped
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
	/**
     * Obtiene el ID del usuario.
     * 
     * @return ID del usuario
     */
	public String getId() {
		return id;
	}
	/**
     * Establece el ID del usuario.
     * 
     * @param id Nuevo ID del usuario
     */
	public void setId(String id) {
		this.id = id;
	}
	/**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario
     */
	public String getContrasegna() {
		return contrasegna;
	}
	/**
     * Establece la contraseña del usuario.
     * 
     * @param contrasegna Nueva contraseña del usuario
     */
	public void setContrasegna(String contrasegna) {
		this.contrasegna = contrasegna;
	}
	/**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Establece el nombre del usuario.
     * 
     * @param nombre Nuevo nombre del usuario
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
     * Obtiene el apellido del usuario.
     * 
     * @return Apellido del usuario
     */
	public String getApellido() {
		return apellido;
	}
	/**
     * Establece el apellido del usuario.
     * 
     * @param apellido Nuevo apellido del usuario
     */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	 /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return Correo electrónico del usuario
     */
	public String getCorreo() {
		return correo;
	}
	/**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo Nuevo correo electrónico del usuario
     */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
     * Obtiene el cargo del usuario.
     * 
     * @return Cargo del usuario
     */
	public String getCargo() {
		return cargo;
	}
	 /**
     * Establece el cargo del usuario.
     * 
     * @param cargo Nuevo cargo del usuario
     */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
     * Obtiene la segunda contraseña ingresada del usuario (para confirmación).
     * 
     * @return Segunda contraseña ingresada
     */
	public String getContrasegna2() {
		return contrasegna2;
	}
	/**
     * Establece la segunda contraseña ingresada del usuario (para confirmación).
     * 
     * @param contrasegna2 Nueva segunda contraseña ingresada
     */
	public void setContrasegna2(String contrasegna2) {
		this.contrasegna2 = contrasegna2;
	}
	/**
     * Crea un nuevo usuario si no existe previamente.
     * Verifica si el usuario con el ID proporcionado ya existe antes de crearlo.
     */
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
	/**
     * Inicia sesión verificando las credenciales del usuario.
     * Si las credenciales son correctas, redirige al menú principal.
     */
	public void iniciarSesion() {
		Usuario = uDao.getAll();
		for (UsuarioDTO u : Usuario) {
			String tId = u.getId().toString();
			String tContrasegna = u.getContrasegna().toString();
			if (tId.equals(id) && tContrasegna.equals(contrasegna)) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);

				try {

					FacesContext.getCurrentInstance().getExternalContext().redirect("menu.xhtml");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			} else {
				continue;
			}
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "ID o contraseña incorrectos."));
	}
	/**
     * Permite al usuario recordar su contraseña redirigiéndolo a la página de recuperación.
     */
	public void recordarContrasegna() {

		Usuario = uDao.getAll();
		for (UsuarioDTO u : Usuario) {
			String tId = u.getId().toString();
			if (tId.equals(id)) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("newPassword.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				continue;
			}

		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "ID incorrecto."));
	}
	/**
     * Cambia la contraseña del usuario si el ID es válido.
     * Actualiza la base de datos con la nueva contraseña y redirige a la página de inicio.
     */
	public void cambiarContrasegna() {

		ArrayList<UsuarioDTO> u = uDao.getAll();
		for (UsuarioDTO usuarioDTO : u) {

			String tId = usuarioDTO.getId().toString();
			if (tId.equals(id)) {
				if (uDao.update(new UsuarioDTO(id, null, null, null, null, null),
						new UsuarioDTO(id, contrasegna, usuarioDTO.getNombre().toString(),
								usuarioDTO.getApellido().toString(), usuarioDTO.getCorreo().toString(),
								usuarioDTO.getCargo().toString()))) {
					try {
						FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("No se pudo actualizar");
				}
				break;
			} else {
				continue;
			}
		}
	}
}
