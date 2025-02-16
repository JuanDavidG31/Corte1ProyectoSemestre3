package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO implements CRUDOperation<UsuarioDTO, Usuario> {

	ArrayList<Usuario> listaUsuario;
	private final String FILE_NAME = "usuario.csv";
	private final String SERIAL_NAME = "usuario.dat";

	public UsuarioDAO() {
		FileHandler.checkFolder();
		readSerizalized();
	}

	@Override
	public void delete(int positionToDelete) {
		// TODO Auto-generated method stub

	}

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

	@Override
	public ArrayList<UsuarioDTO> getAll() {
		return DataMapper.listaUsuarioToListaUsuarioDTO(listaUsuario);

	}

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

	@Override
	public boolean update(UsuarioDTO previous, UsuarioDTO newData) {
		Usuario found = find2(DataMapper.UsuarioDTOToUsuario(previous));
		if (found != null) {
			listaUsuario.remove(found);
			listaUsuario.add(DataMapper.UsuarioDTOToUsuario(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

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
				int id = Integer.parseInt(cols[0]);
				tempo.setId(id);
				tempo.setContrasegna(cols[1]);
				tempo.setNombre(cols[2]);
				tempo.setApellido(cols[3]);
				tempo.setCorreo(cols[4]);
				tempo.setCargo(cols[5]);
				listaUsuario.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaUsuario);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaUsuario = new ArrayList<>();
		} else {
			listaUsuario = (ArrayList<Usuario>) content;
		}
	}

	@Override
	public Usuario find(Usuario toFind) {
		Usuario found = null;
		if (!listaUsuario.isEmpty()) {
			for (Usuario Usuario : listaUsuario) {
				if (Usuario.getId() == toFind.getId()) {
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

	@Override
	public Usuario find2(Usuario toFind) {
		// TODO Auto-generated method stub
		return null;
	}

}
