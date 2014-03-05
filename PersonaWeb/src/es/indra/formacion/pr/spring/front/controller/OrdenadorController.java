package es.indra.formacion.pr.spring.front.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.persistence.model.Persona;
import es.indra.formacion.pr.spring.front.editor.NumeroEditor;
import es.indra.formacion.pr.spring.front.form.OrdenadorForm;
import es.indra.formacion.pr.spring.front.validator.OrdenadorValidator;
import es.indra.formacion.pr.spring.service.IOrdenadorService;
import es.indra.formacion.pr.spring.service.IPersonaService;

@Controller
@RequestMapping("/ordenador/*")
public class OrdenadorController {
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IOrdenadorService ordenadorService;
	@Autowired
	private OrdenadorValidator ordenadorValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new NumeroEditor(Integer.class));
		binder.setValidator(ordenadorValidator);
	}
	
	@ModelAttribute("personas")
	public List<Persona> personas() {
		return personaService.obtenerPersonas();
	}
	
	@ModelAttribute("ordenadores")
	public List<Ordenador> ordenadores() {
		return ordenadorService.obtenerOrdenadores();
	}

	@ModelAttribute("ordenadorForm")
	public OrdenadorForm ordenadorForm() {
		return new OrdenadorForm();
	}

	@RequestMapping(value={"principal", ""})
	public String principal(Model model) {
		// Reemplazado por el método de arriba (ModelAttribute)
		//model.addAttribute("personas", personaService.obtenerPersonas());
		//model.addAttribute("ordenadores", ordenadorService.obtenerOrdenadores());
		//model.addAttribute("ordenadorForm", ordenadorForm);
		
		return "forward:/jsp/ordenador/principal.jsp";
	}
	
	
	@RequestMapping("agregar")
	public String agregar(
			@ModelAttribute("ordenadorForm") @Valid OrdenadorForm ordenadorForm,
			BindingResult binding) {
		
		if (!binding.hasErrors()) {
			Persona p = new Persona();
			p.setId(ordenadorForm.getPersonaId());
			
			Ordenador o = new Ordenador();
			o.setNombre(ordenadorForm.getNombre());
			o.setSerial(ordenadorForm.getSerial());
			o.setPersona(p);
			
			ordenadorService.agregarOrdenador(o);

			return "redirect:principal.do";
		} 

		return "forward:/jsp/ordenador/principal.jsp";
	}
	
}
