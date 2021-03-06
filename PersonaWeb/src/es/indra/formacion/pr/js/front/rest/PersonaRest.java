package es.indra.formacion.pr.js.front.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.formacion.pr.js.front.wrapper.ResponseWrapper;
import es.indra.formacion.pr.js.model.Persona;
import es.indra.formacion.pr.js.service.IPersonaService;

@Controller
public class PersonaRest {
	@Autowired
	IPersonaService personaService;
	
	@RequestMapping(
			value={"/personas", "/personas/"}, 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody ResponseWrapper<List<Persona>> obtenerTodos() {
		ResponseWrapper<List<Persona>> responseWrapper = new ResponseWrapper<List<Persona>>();
		responseWrapper.setData(personaService.obtenerPersonas());
		return responseWrapper;
	}
	
}