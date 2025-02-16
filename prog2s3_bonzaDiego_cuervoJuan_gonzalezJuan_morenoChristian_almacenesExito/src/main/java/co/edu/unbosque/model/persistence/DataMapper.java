package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;

public class DataMapper {

	public static Usuario UsuarioDTOToUsuario(UsuarioDTO dto) {
		Usuario entity;
		entity = new Usuario(dto.getId(), dto.getContrasegna(), dto.getNombre(), dto.getApellido(), dto.getCorreo(),
				dto.getCargo());
		return entity;
	}

	public static UsuarioDTO UsuarioToUsuarioDTO(Usuario entity) {
		UsuarioDTO dto;
		dto = new UsuarioDTO(entity.getId(), entity.getContrasegna(), entity.getNombre(), entity.getApellido(),
				entity.getCorreo(), entity.getCargo());
		return dto;
	}

	public static ArrayList<UsuarioDTO> listaUsuarioToListaUsuarioDTO(ArrayList<Usuario> entityList) {
		ArrayList<UsuarioDTO> dtoList = new ArrayList<>();
		for (Usuario m : entityList) {
			dtoList.add(new UsuarioDTO(m.getId(), m.getContrasegna(), m.getNombre(), m.getApellido(), m.getCorreo(),
					m.getCargo()));
		}
		return dtoList;
	}

	public static ArrayList<Usuario> listaUsuarioDTOToListaUsuario(ArrayList<UsuarioDTO> dtoList) {
		ArrayList<Usuario> entityList = new ArrayList<>();
		for (UsuarioDTO d : dtoList) {
			entityList.add(new Usuario(d.getId(), d.getContrasegna(), d.getNombre(), d.getApellido(), d.getCorreo(),
					d.getCargo()));
		}
		return entityList;
	}

}
