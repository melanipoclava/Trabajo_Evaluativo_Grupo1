package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaCandidatos;
import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;

@Controller
public class CandidatoController {
	
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	ICandidatoService candidatoService;
	//ListaCandidatos listaCandidatos = new ListaCandidatos();

	//devuelve la vista del formulario de candidato
	@GetMapping("/NuevoCan")
	public String getCandidatoform(Model model) {
		model.addAttribute("candidato", candidatoService.getCandidato());
		return "candidato";
	}


	// devolucion de redireccion al inicio luego de registrar un nuevo candidato.
	@PostMapping("/candidato/guardar")
	public ModelAndView guardarCandidato(@ModelAttribute("candidato") Candidato nuevoCandidato) {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidatos",candidatoService.getListaCandidatos().getListaCandidatos());
		candidatoService.guardarCandidato(nuevoCandidato);
		
		// mostramos la lista con todos los cursos.
		return mav;
	}

	@GetMapping("/Modificacion")
	public ModelAndView getListaCandidatos() {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidatos",candidatoService.getListaCandidatos().getListaCandidatos());
		
		return mav;
	}
	
	//respuesta a la solicitud modificar candidato
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCand(@PathVariable(value="codigo")int codigo) {
		ModelAndView mav = new ModelAndView("editar_candidato");
		Candidato candidato = candidatoService.buscarCandidato(codigo);
		mav.addObject("candidato", candidato);
		// mostramos la lista con todos los cursos.
		return mav;
	}
	//modificar un elemento de la lista de candidatos
	@PostMapping("/modificar")
	public ModelAndView guardarCandidatoEditar(@ModelAttribute("candidato") Candidato candidatoMod) {
		//busco el objeto seleccionado para modificar en la lista de candidato
		ModelAndView mav = new ModelAndView("lista_candidatos");
		candidatoService.modificarCandidato(candidatoMod);
		mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidatos());
		return mav;
		
	}
	//respuesta a la solicitud eliminar candidato
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCand(@PathVariable(value="codigo")int codigo,Model model) {
		ModelAndView mav =new ModelAndView("lista_candidatos");
		candidatoService.eliminarCandidato(codigo);
		mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidatos());
		// mostramos la lista con todos los cursos.
		return mav;
	}
	
	//devuelve la vista del formulario de candidato
	@GetMapping("/listaVotacion")
	public String getTablaVot(Model model) {
		model.addAttribute("candidatos", candidatoService.getListaCandidatos().getListaCandidatos());

		return "lista_Votos";
	}
}
