package ar.edu.unju.fi.listas;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.model.Usuario;
//Creacion de lista de Usuario
@Component
public class ListaUsuarios {
	ArrayList<Usuario> listaUsuario = new ArrayList<>();

	public ListaUsuarios() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the listaUsuario
	 */
	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	/**
	 * @param listaUsuario the listaUsuario to set
	 */
	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
}
