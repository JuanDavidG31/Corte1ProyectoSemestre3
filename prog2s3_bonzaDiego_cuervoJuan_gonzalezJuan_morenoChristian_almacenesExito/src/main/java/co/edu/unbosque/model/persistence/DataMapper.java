package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.CarneDTO;
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

	public static Carne CarneDTOToCarne(CarneDTO dto) {
		Carne entity;
		entity = new Carne(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}

	public static CarneDTO CarneToCarneDTO(Carne entity) {
		CarneDTO dto;
		dto = new CarneDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}

	public static ArrayList<CarneDTO> listaCarneToListaCarneDTO(ArrayList<Carne> entityList) {
		ArrayList<CarneDTO> dtoList = new ArrayList<>();
		for (Carne m : entityList) {
			dtoList.add(new CarneDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}

	public static ArrayList<Carne> listaCarneDTOToListaCarne(ArrayList<CarneDTO> dtoList) {
		ArrayList<Carne> entityList = new ArrayList<>();
		for (CarneDTO d : dtoList) {
			entityList.add(new Carne(d.getId(), d.getCode(), d.getName(), d.getDescription(), d.getImage(),
					d.getPrice(), d.getCategory(), d.getQuantity(), d.getInventoryStatus(), d.getRating(),
					d.getOrders()));
		}
		return entityList;
	}

}
