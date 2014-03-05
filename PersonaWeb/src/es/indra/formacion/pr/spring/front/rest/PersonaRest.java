package es.indra.formacion.pr.spring.front.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.formacion.pr.persistence.model.Persona;
import es.indra.formacion.pr.spring.service.IPersonaService;

@Controller
public class PersonaRest {
	@Autowired
	IPersonaService personaService;
	
	@RequestMapping(
			value={"/personas", "/personas/"}, 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody List<Persona> obtenerTodos() {
		return personaService.obtenerPersonas();
	}
	
}