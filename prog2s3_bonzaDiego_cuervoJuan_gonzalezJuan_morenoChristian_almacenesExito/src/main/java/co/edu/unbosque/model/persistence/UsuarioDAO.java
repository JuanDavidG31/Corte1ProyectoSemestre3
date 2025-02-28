package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;
/**
 * Clase que implementa las operaciones CRUD para la entidad Usuario.
 * Gestiona la lectura y escritura de usuarios en archivos CSV y serializados.
 */
public class UsuarioDAO implements CRUDOperation<UsuarioDTO, Usuario> {

	ArrayList<Usuario> listaUsuario;
	private final String FILE_NAME = "usuario.csv";
	private final String SERIAL_NAME = "usuario.dat";
	/**
	 * Constructor que inicializa la lista de usuarios y carga los datos serializados.
	 */
	public UsuarioDAO() {
		FileHandler.checkFolder();
		readSerizalized();
	}
	/**
	 * Elimina un usuario en la posición especificada de la lista.
	 * @param positionToDelete Índice del usuario a eliminar.
	 */
	@Override
	public void delete(int positionToDelete) {
		if (positionToDelete < 0 || positionToDelete >= listaUsuario.size()) {
			return;
		} else {
			listaUsuario.remove(positionToDelete);
			return;
		}

	}
	/**
	 * Muestra todos los usuarios almacenados.
	 * @return Cadena con la representación de todos los usuarios.
	 */
	@Override
	public String showAll() {
		String rta = "";
		if (listaUsuario.isEmpty()) {
			return "No hay Usuarios en la lista";
		} else {
			for (Usuario Usuario : listaUsuario) {
				rta += Usuario;
			}
			return rta;
		}
	}
	/**
	 * Obtiene todos los usuarios almacenados y los devuelve en una lista de DTOs.
	 * @return Lista de objetos UsuarioDTO.
	 */
	@Override
	public ArrayList<UsuarioDTO> getAll() {
		return DataMapper.listaUsuarioToListaUsuarioDTO(listaUsuario);

	}
	/**
	 * Agrega un nuevo usuario si no existe previamente.
	 * @param newData UsuarioDTO con los datos del usuario a agregar.
	 * @return true si el usuario se agregó con éxito, false si ya existía.
	 */
	@Override
	public boolean add(UsuarioDTO newData) {
		if (find(DataMapper.UsuarioDTOToUsuario(newData)) == null) {
			listaUsuario.add(DataMapper.UsuarioDTOToUsuario(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}
	/**
	 * Elimina un usuario de la lista.
	 * @param toDelete UsuarioDTO que representa al usuario a eliminar.
	 * @return true si el usuario se eliminó, false si no se encontró.
	 */
	@Override
	public boolean delete(UsuarioDTO toDelete) {
		Usuario found = find2(DataMapper.UsuarioDTOToUsuario(toDelete));
		if (found != null) {
			listaUsuario.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Actualiza los datos de un usuario.
	 * @param previous UsuarioDTO con los datos anteriores.
	 * @param newData UsuarioDTO con los nuevos datos.
	 * @return true si el usuario fue actualizado, false si no se encontró.
	 */
	@Override
	public boolean update(UsuarioDTO previous, UsuarioDTO newData) {
		Usuario found = find(DataMapper.UsuarioDTOToUsuario(previous));
		if (found != null) {
			System.out.println("si");
			listaUsuario.remove(found);
			listaUsuario.add(DataMapper.UsuarioDTOToUsuario(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Escribe la lista de usuarios en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Usuario m : listaUsuario) {
			content += m.getId() + ";";
			content += m.getContrasegna() + ";";
			content += m.getNombre() + ";";
			content += m.getApellido() + ";";
			content += m.getCorreo() + ";";
			content += m.getCargo() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}
	/**
	 * Lee los usuarios almacenados en un archivo CSV.
	 */
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			listaUsuario = new ArrayList<>();
		} else {
			listaUsuario = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Usuario tempo = new Usuario();
				tempo.setId(cols[0]);
				tempo.setContrasegna(cols[1]);
				tempo.setNombre(cols[2]);
				tempo.setApellido(cols[3]);
				tempo.setCorreo(cols[4]);
				tempo.setCargo(cols[5]);
				listaUsuario.add(tempo);
			}
		}

	}
	/**
	 * Guarda la lista de usuarios en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaUsuario);
	}
	/**
	 * Carga la lista de usuarios desde un archivo serializado.
	 */
	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaUsuario = new ArrayList<>();
		} else {
			listaUsuario = (ArrayList<Usuario>) content;
		}
	}
	/**
	 * Busca un usuario en la lista por su ID.
	 * @param toFind Usuario a buscar.
	 * @return El usuario encontrado o null si no existe.
	 */
	@Override
	public Usuario find(Usuario toFind) {
		Usuario found = null;
		if (!listaUsuario.isEmpty()) {
			for (Usuario Usuario : listaUsuario) {
				if (Usuario.getId().equals(toFind.getId())) {
					found = Usuario;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}
	/**
	 * Busca un usuario en la lista por otro criterio (implementación pendiente).
	 * @param toFind Usuario a buscar.
	 * @return null (por implementar).
	 */
	@Override
	public Usuario find2(Usuario toFind) {
		// TODO Auto-generated method stub
		return null;
	}

}
