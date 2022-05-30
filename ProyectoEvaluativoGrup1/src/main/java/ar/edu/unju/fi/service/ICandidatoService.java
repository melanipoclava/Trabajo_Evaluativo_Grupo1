package ar.edu.unju.fi.service;

import ar.edu.unju.fi.listas.ListaCandidatos;
import ar.edu.unju.fi.model.Candidato;

public interface ICandidatoService {
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidatos getListaCandidatos();
	public Candidato buscarCandidato(int codigo);
	public void agregarVoto(int codigo);
}
