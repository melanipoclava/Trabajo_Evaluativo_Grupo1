package ar.edu.unju.fi.listas;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Candidato;
//creacion de lista
@Component
public class ListaCandidatos {
	private ArrayList<Candidato> listaCandidatos;
	
	public ListaCandidatos() {
		listaCandidatos=new ArrayList<Candidato>();
		listaCandidatos.add(new Candidato(000,"Ninguno","---","---"));
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the listaCandidatos
	 */
	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}

	/**
	 * @param listaCandidatos the listaCandidatos to set
	 */
	public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
	
	
}
