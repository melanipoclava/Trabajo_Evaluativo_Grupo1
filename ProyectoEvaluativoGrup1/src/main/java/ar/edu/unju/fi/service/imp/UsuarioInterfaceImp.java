package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.listas.ListaUsuarios;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
@Service("UsuarioServiceImpList")
public class UsuarioInterfaceImp implements IUsuarioService {
	@Autowired
	ListaUsuarios listaUsuario;
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return listaUsuario.getListaUsuario().add(usuario);
	}

	@Override
	public ListaUsuarios getListaUsuario() {
		// TODO Auto-generated method stub
		return listaUsuario;
	}
	

}
