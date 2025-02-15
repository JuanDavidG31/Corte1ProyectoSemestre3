package co.edu.unbosque.model;

public class UsuarioDTO {

	private String nombreUsuario;
	private String contrasegna;

	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String nombreUsuario, String contrasegna) {
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
		return "UsuarioDTO [nombreUsuario=" + nombreUsuario + ", contrasegna=" + contrasegna + "]";
	}

}
