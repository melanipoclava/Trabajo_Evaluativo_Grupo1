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


import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.service.IUsuarioService;


@Controller
public class UsuarioController {
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	ICandidatoService candidatoService;
	//CandidatoInterfaceImp candidatoService;
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	IUsuarioService usuarioService;

	
	@GetMapping("/nuevoUsuario")
	public String getFormUsuario(Model model){
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "usuario";
	}
	@PostMapping("/usuario/guardado")
	public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuar){
		usuarioService.guardarUsuario(usuar);
		ModelAndView mav=new ModelAndView("votacion");
		mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidatos());
		mav.addObject("usuario", usuar);
		return mav;
	}
	
	@GetMapping("/gracias/{codigo}")
	public ModelAndView getMensaje(@PathVariable(value="codigo")int codigo) {
			candidatoService.agregarVoto(codigo);
			ModelAndView mav = new ModelAndView("gracias");
			return mav;
	}
	
	@GetMapping("/listaVotos")
	public String getTablaVotantes(Model model){
		model.addAttribute("usuarios", usuarioService.getListaUsuario().getListaUsuario());
		return "tablaVotacion";
	}
}
