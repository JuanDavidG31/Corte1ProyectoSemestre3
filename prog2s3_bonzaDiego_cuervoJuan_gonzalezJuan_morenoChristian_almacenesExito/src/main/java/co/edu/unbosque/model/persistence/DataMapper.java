package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;

public class DataMapper {

	public static Usuario UsuarioDTOToUsuario(UsuarioDTO dto) {
		Usuario entity;
		entity = new Usuario(dto.getNombreUsuario(), dto.getContrasegna());
		return entity;
	}

	public static UsuarioDTO UsuarioToUsuarioDTO(Usuario entity) {
		UsuarioDTO dto;
		dto = new UsuarioDTO(entity.getNombreUsuario(), entity.getContrasegna());
		return dto;
	}

	public static ArrayList<UsuarioDTO> listaUsuarioToListaUsuarioDTO(ArrayList<Usuario> entityList) {
		ArrayList<UsuarioDTO> dtoList = new ArrayList<>();
		for (Usuario m : entityList) {
			dtoList.add(new UsuarioDTO(m.getNombreUsuario(), m.getContrasegna()));
		}
		return dtoList;
	}

	public static ArrayList<Usuario> listaUsuarioDTOToListaUsuario(ArrayList<UsuarioDTO> dtoList) {
		ArrayList<Usuario> entityList = new ArrayList<>();
		for (UsuarioDTO d : dtoList) {
			entityList.add(new Usuario(d.getNombreUsuario(), d.getContrasegna()));
		}
		return entityList;
	}

}
