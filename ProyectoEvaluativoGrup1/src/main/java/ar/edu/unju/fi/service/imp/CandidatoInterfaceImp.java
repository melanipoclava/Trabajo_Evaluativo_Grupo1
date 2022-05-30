package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaCandidatos;
import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
@Service("CandidatoServiceImpList")
public class CandidatoInterfaceImp implements ICandidatoService {
	
	@Autowired
	ListaCandidatos listaCandidatos;
	@Override
	public Candidato getCandidato() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		return listaCandidatos.getListaCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		for(Candidato tcand : listaCandidatos.getListaCandidatos()) {
			 if(tcand.getCodigo() == candidato.getCodigo()) {
				tcand.setNombre(candidato.getNombre());
				tcand.setGenero(candidato.getGenero());
				tcand.setDescripcion(candidato.getDescripcion());
			}	 
		}
		}


	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		int k=0;
		int i=0;
		for(Candidato t: listaCandidatos.getListaCandidatos()) {
			if(t.getCodigo()==codigo) {
				i=k;
			}
			k++;
		}
		listaCandidatos.getListaCandidatos().remove(i);
	}

	@Override
	public ListaCandidatos getListaCandidatos() {
		// TODO Auto-generated method stub
		return listaCandidatos;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		Optional<Candidato> candidato=listaCandidatos.getListaCandidatos().stream().filter(a -> a.getCodigo()==codigo).findFirst();
		return candidato.get();
	}
	@Override
	public void agregarVoto(int codigo){
		for(Candidato tcand : listaCandidatos.getListaCandidatos()) {
			 if(tcand.getCodigo() == codigo) {
					tcand.setVotos(tcand.getVotos()+1);;
			 }	 
		}
	}

}
