package ar.edu.unju.fi.service;


import ar.edu.unju.fi.listas.ListaUsuarios;

import ar.edu.unju.fi.model.Usuario;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public ListaUsuarios getListaUsuario();

}
