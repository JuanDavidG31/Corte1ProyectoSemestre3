package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO implements CRUDOperation<UsuarioDTO, UsuarioDTO> {

	ArrayList<UsuarioDTO> listaUsuario;

	public UsuarioDAO() {
		listaUsuario = new ArrayList<>();
	}

	@Override
	public void crear(UsuarioDTO nuevoDato) {
		listaUsuario.add(nuevoDato);

	}

	@Override
	public void eliminar(UsuarioDTO nuevoDato) {
		if (listaUsuario.remove(nuevoDato)) {
			return;
		} else {
			return;
		}

	}

	@Override
	public void eliminar(int posicionE) {
		if (posicionE < 0 || posicionE >= listaUsuario.size()) {
			return;
		} else {
			listaUsuario.remove(posicionE);
			return;
		}

	}

	@Override
	public void actualizar(int posicionA, UsuarioDTO nuevoDato) {
		if (posicionA < 0 || posicionA >= listaUsuario.size()) {
			return;
		} else {
			listaUsuario.set(posicionA, nuevoDato);
			return;
		}
	}

	@Override
	public ArrayList<UsuarioDTO> buscarTodo() {
		return listaUsuario;
	}

	@Override
	public UsuarioDTO buscarUno(int posicionB) {

		return listaUsuario.get(posicionB);
	}

}
