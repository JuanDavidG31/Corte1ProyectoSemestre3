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
/**
 * Clase utilitaria para mapear entre entidades y DTOs.
 */
public class DataMapper {
	 /**
     * Convierte un {@link UsuarioDTO} en un {@link Usuario}.
     *
     * @param dto El objeto DTO a convertir.
     * @return Un objeto {@link Usuario} con los datos del DTO.
     */
	public static Usuario UsuarioDTOToUsuario(UsuarioDTO dto) {
		Usuario entity;
		entity = new Usuario(dto.getId(), dto.getContrasegna(), dto.getNombre(), dto.getApellido(), dto.getCorreo(),
				dto.getCargo());
		return entity;
	}
	/**
     * Convierte un {@link Usuario} en un {@link UsuarioDTO}.
     *
     * @param entity El objeto entidad a convertir.
     * @return Un objeto {@link UsuarioDTO} con los datos de la entidad.
     */
	public static UsuarioDTO UsuarioToUsuarioDTO(Usuario entity) {
		UsuarioDTO dto;
		dto = new UsuarioDTO(entity.getId(), entity.getContrasegna(), entity.getNombre(), entity.getApellido(),
				entity.getCorreo(), entity.getCargo());
		return dto;
	}
	/**
     * Convierte una lista de entidades {@link Usuario} en una lista de {@link UsuarioDTO}.
     *
     * @param entityList Lista de entidades a convertir.
     * @return Lista de objetos {@link UsuarioDTO}.
     */
	public static ArrayList<UsuarioDTO> listaUsuarioToListaUsuarioDTO(ArrayList<Usuario> entityList) {
		ArrayList<UsuarioDTO> dtoList = new ArrayList<>();
		for (Usuario m : entityList) {
			dtoList.add(new UsuarioDTO(m.getId(), m.getContrasegna(), m.getNombre(), m.getApellido(), m.getCorreo(),
					m.getCargo()));
		}
		return dtoList;
	}
	/**
     * Convierte una lista de {@link UsuarioDTO} en una lista de entidades {@link Usuario}.
     *
     * @param dtoList Lista de DTOs a convertir.
     * @return Lista de objetos {@link Usuario}.
     */
	public static ArrayList<Usuario> listaUsuarioDTOToListaUsuario(ArrayList<UsuarioDTO> dtoList) {
		ArrayList<Usuario> entityList = new ArrayList<>();
		for (UsuarioDTO d : dtoList) {
			entityList.add(new Usuario(d.getId(), d.getContrasegna(), d.getNombre(), d.getApellido(), d.getCorreo(),
					d.getCargo()));
		}
		return entityList;
	}
	/**
     * Convierte un {@link CarneDTO} en un {@link Carne}.
     *
     * @param dto El objeto DTO a convertir.
     * @return Un objeto {@link Carne} con los datos del DTO.
     */
	public static Carne CarneDTOToCarne(CarneDTO dto) {
		Carne entity;
		entity = new Carne(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}
	/**
     * Convierte un {@link Carne} en un {@link CarneDTO}.
     *
     * @param entity El objeto entidad a convertir.
     * @return Un objeto {@link CarneDTO} con los datos de la entidad.
     */
	public static CarneDTO CarneToCarneDTO(Carne entity) {
		CarneDTO dto;
		dto = new CarneDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}
	/**
     * Convierte una lista de entidades {@link Carne} en una lista de {@link CarneDTO}.
     *
     * @param entityList Lista de entidades a convertir.
     * @return Lista de objetos {@link CarneDTO}.
     */
	public static ArrayList<CarneDTO> listaCarneToListaCarneDTO(ArrayList<Carne> entityList) {
		ArrayList<CarneDTO> dtoList = new ArrayList<>();
		for (Carne m : entityList) {
			dtoList.add(new CarneDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}
	 /**
     * Convierte una lista de {@link CarneDTO} en una lista de entidades {@link Carne}.
     *
     * @param dtoList Lista de DTOs a convertir.
     * @return Lista de objetos {@link Carne}.
     */
	public static ArrayList<Carne> listaCarneDTOToListaCarne(ArrayList<CarneDTO> dtoList) {
		ArrayList<Carne> entityList = new ArrayList<>();
		for (CarneDTO d : dtoList) {
			entityList.add(new Carne(d.getId(), d.getCode(), d.getName(), d.getDescription(), d.getImage(),
					d.getPrice(), d.getCategory(), d.getQuantity(), d.getInventoryStatus(), d.getRating(),
					d.getOrders()));
		}
		return entityList;
	}
	
	 /**
     * Convierte un {@link JugueteDTO} en un {@link Juguete}.
     *
     * @param dto El objeto DTO a convertir.
     * @return Un objeto {@link Juguete} con los datos del DTO.
     */
	
	public static Juguete JugueteDTOToJuguete(JugueteDTO dto) {
		Juguete entity;
		entity = new Juguete(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}
	 /**
     * Convierte un {@link Juguete} en un {@link JugueteDTO}.
     *
     * @param entity El objeto entidad a convertir.
     * @return Un objeto {@link JugueteDTO}.
     */
	public static JugueteDTO JugueteToJugueteDTO(Juguete entity) {
		JugueteDTO dto;
		dto = new JugueteDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}
	 /**
     * Convierte una lista de entidades {@link Juguete} en una lista de {@link JugueteDTO}.
     *
     * @param entityList Lista de entidades a convertir.
     * @return Lista de objetos {@link JugueteDTO}.
     */
	public static ArrayList<JugueteDTO> listaJugueteToListaJugueteDTO(ArrayList<Juguete> entityList) {
		ArrayList<JugueteDTO> dtoList = new ArrayList<>();
		for (Juguete m : entityList) {
			dtoList.add(new JugueteDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}
	/**
     * Convierte una lista de {@link JugueteDTO} en una lista de entidades {@link Juguete}.
     *
     * @param dtoList Lista de DTOs a convertir.
     * @return Lista de objetos {@link Juguete}.
     */
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
	/**
     * Convierte un {@link RopaDTO} en un {@link Ropa}.
     *
     * @param dto El objeto DTO a convertir.
     * @return Un objeto {@link Ropa}.
     */
	public static Ropa RopaDTOToRopa(RopaDTO dto) {
		Ropa entity;
		entity = new Ropa(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}
	/**
     * Convierte un {@link Ropa} en un {@link RopaDTO}.
     *
     * @param entity El objeto entidad a convertir.
     * @return Un objeto {@link RopaDTO}.
     */
	public static RopaDTO RopaToRopaDTO(Ropa entity) {
		RopaDTO dto;
		dto = new RopaDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}
	/**
     * Convierte una lista de entidades {@link Ropa} en una lista de {@link RopaDTO}.
     *
     * @param entityList Lista de entidades a convertir.
     * @return Lista de objetos {@link RopaDTO}.
     */
	public static ArrayList<RopaDTO> listaRopaToListaRopaDTO(ArrayList<Ropa> entityList) {
		ArrayList<RopaDTO> dtoList = new ArrayList<>();
		for (Ropa m : entityList) {
			dtoList.add(new RopaDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}
	 /**
     * Convierte una lista de {@link RopaDTO} en una lista de entidades {@link Ropa}.
     *
     * @param dtoList Lista de DTOs a convertir.
     * @return Lista de objetos {@link Ropa}.
     */
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
	/**
     * Convierte un {@link LacteoDTO} en un {@link Lacteo}.
     *
     * @param dto El objeto DTO a convertir.
     * @return Un objeto {@link Lacteo}.
     */
	public static Lacteo LacteoDTOToLacteo(LacteoDTO dto) {
		Lacteo entity;
		entity = new Lacteo(dto.getId(), dto.getCode(), dto.getName(), dto.getDescription(), dto.getImage(),
				dto.getPrice(), dto.getCategory(), dto.getQuantity(), dto.getInventoryStatus(), dto.getRating(),
				dto.getOrders());
		return entity;
	}
	 /**
     * Convierte un {@link Lacteo} en un {@link LacteoDTO}.
     *
     * @param entity El objeto entidad a convertir.
     * @return Un objeto {@link LacteoDTO}.
     */
	public static LacteoDTO LacteoToLacteoDTO(Lacteo entity) {
		LacteoDTO dto;
		dto = new LacteoDTO(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImage(),
				entity.getPrice(), entity.getCategory(), entity.getQuantity(), entity.getInventoryStatus(), entity.getRating(),
				entity.getOrders());
		return dto;
	}
	/**
     * Convierte una lista de entidades {@link Lacteo} en una lista de {@link LacteoDTO}.
     *
     * @param entityList Lista de entidades a convertir.
     * @return Lista de objetos {@link LacteoDTO}.
     */
	public static ArrayList<LacteoDTO> listaLacteoToListaLacteoDTO(ArrayList<Lacteo> entityList) {
		ArrayList<LacteoDTO> dtoList = new ArrayList<>();
		for (Lacteo m : entityList) {
			dtoList.add(new LacteoDTO(m.getId(), m.getCode(), m.getName(), m.getDescription(), m.getImage(),
					m.getPrice(), m.getCategory(), m.getQuantity(), m.getInventoryStatus(), m.getRating(),
					m.getOrders()));
		}
		return dtoList;
	}
	/**
     * Convierte una lista de {@link LacteoDTO} en una lista de entidades {@link Lacteo}.
     *
     * @param dtoList Lista de DTOs a convertir.
     * @return Lista de objetos {@link Lacteo}.
     */
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
