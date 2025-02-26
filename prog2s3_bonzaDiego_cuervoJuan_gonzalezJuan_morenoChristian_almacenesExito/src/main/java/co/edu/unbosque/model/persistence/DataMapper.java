package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Carne;
import co.edu.unbosque.model.CarneDTO;
import co.edu.unbosque.model.Juguete;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.Lacteo;
import co.edu.unbosque.model.LacteoDTO;
import co.edu.unbosque.model.Ropa;
import co.edu.unbosque.model.RopaDTO;
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
	
	//////////////////
	
	public static Juguete JugueteDTOToJuguete(JugueteDTO dto) {
		Juguete entity;
		entity = new Juguete(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}

	public static JugueteDTO JugueteToJugueteDTO(Juguete entity) {
		JugueteDTO dto;
		dto = new JugueteDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}

	public static ArrayList<JugueteDTO> listaJugueteToListaJugueteDTO(ArrayList<Juguete> entityList) {
		ArrayList<JugueteDTO> dtoList = new ArrayList<>();
		for (Juguete m : entityList) {
			dtoList.add(new JugueteDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}

	public static ArrayList<Juguete> listaJugueteDTOToListaJuguete(ArrayList<JugueteDTO> dtoList) {
		ArrayList<Juguete> entityList = new ArrayList<>();
		for (JugueteDTO d : dtoList) {
			entityList.add(new Juguete(d.getId(), d.getCode(), d.getName(), d.getDescription(), d.getImage(),
					d.getPrice(), d.getCategory(), d.getQuantity(), d.getInventoryStatus(), d.getRating(),
					d.getOrders()));
		}
		return entityList;
	}
	
	//////////////////
	
	public static Ropa RopaDTOToRopa(RopaDTO dto) {
		Ropa entity;
		entity = new Ropa(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}

	public static RopaDTO RopaToRopaDTO(Ropa entity) {
		RopaDTO dto;
		dto = new RopaDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}

	public static ArrayList<RopaDTO> listaRopaToListaRopaDTO(ArrayList<Ropa> entityList) {
		ArrayList<RopaDTO> dtoList = new ArrayList<>();
		for (Ropa m : entityList) {
			dtoList.add(new RopaDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}

	public static ArrayList<Ropa> listaRopaDTOToListaRopa(ArrayList<RopaDTO> dtoList) {
		ArrayList<Ropa> entityList = new ArrayList<>();
		for (RopaDTO d : dtoList) {
			entityList.add(new Ropa(d.getId(), d.getCode(), d.getName(), d.getDescription(), d.getImage(),
					d.getPrice(), d.getCategory(), d.getQuantity(), d.getInventoryStatus(), d.getRating(),
					d.getOrders()));
		}
		return entityList;
	}
	
	/////////////////
	
	public static Lacteo LacteoDTOToLacteo(LacteoDTO dto) {
		Lacteo entity;
		entity = new Lacteo(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}

	public static LacteoDTO LacteoToLacteoDTO(Lacteo entity) {
		LacteoDTO dto;
		dto = new LacteoDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}

	public static ArrayList<LacteoDTO> listaLacteoToListaLacteoDTO(ArrayList<Lacteo> entityList) {
		ArrayList<LacteoDTO> dtoList = new ArrayList<>();
		for (Lacteo m : entityList) {
			dtoList.add(new LacteoDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}

	public static ArrayList<Lacteo> listaLacteoDTOToListaLacteo(ArrayList<LacteoDTO> dtoList) {
		ArrayList<Lacteo> entityList = new ArrayList<>();
		for (LacteoDTO d : dtoList) {
			entityList.add(new Lacteo(d.getId(), d.getCode(), d.getName(), d.getDescription(), d.getImage(),
					d.getPrice(), d.getCategory(), d.getQuantity(), d.getInventoryStatus(), d.getRating(),
					d.getOrders()));
		}
		return entityList;
	}

}
