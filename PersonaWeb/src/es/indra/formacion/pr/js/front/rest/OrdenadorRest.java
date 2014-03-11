package es.indra.formacion.pr.js.front.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.formacion.pr.js.front.wrapper.ResponseWrapper;
import es.indra.formacion.pr.js.model.Ordenador;
import es.indra.formacion.pr.js.service.IOrdenadorService;

@Controller
public class OrdenadorRest {
	@Autowired
	IOrdenadorService ordenadorService;
	
	@RequestMapping(
			value={"/ordenadores", "/ordenadores/"}, 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody ResponseWrapper<List<Ordenador>> obtenerTodos() {
		ResponseWrapper<List<Ordenador>> responseWrapper = new ResponseWrapper<List<Ordenador>>();
		responseWrapper.setData(ordenadorService.obtenerOrdenadores());
		
		return responseWrapper;
	}
	
	@RequestMapping(
			value="/ordenadores/{id}", 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody ResponseWrapper<Ordenador> obtener(@PathVariable Integer id) {
		ResponseWrapper<Ordenador> responseWrapper = new ResponseWrapper<Ordenador>();
		responseWrapper.setData(ordenadorService.obtenerOrdenador(id));
		
		return responseWrapper;
	}	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(
			value="/ordenadores/{id}*", 
			method=RequestMethod.PUT,
			consumes="application/json"
		)
	public @ResponseBody ResponseWrapper modificar(
			@PathVariable Integer id, 
			@RequestBody Ordenador ordenador) {
		
		// TODO: Agregar manejo de errores como en el agregar
		ordenador.setId(id);
		ordenadorService.modificarOrdenador(ordenador);
		
		return new ResponseWrapper();
	}	

	@SuppressWarnings("rawtypes")
	@RequestMapping(
			value="/ordenadores/{id}", 
			method=RequestMethod.DELETE
		)
	public @ResponseBody ResponseWrapper eliminar(
			@PathVariable Integer id) {
		
		// TODO: Agregar manejo de errores como en el agregar
		
		ordenadorService.eliminarOrdenador(id);
		
		return new ResponseWrapper();
	}	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(
			value={"/ordenadores", "/ordenadores/"}, 
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json"
		)
	public @ResponseBody ResponseWrapper agregar(@RequestBody Ordenador ordenador) {
		ResponseWrapper responseWrapper = new ResponseWrapper<List<Ordenador>>();
		
		// FIXME: Averiguar como meter clave de messages
		/***** Validaciones *****/
		List<String> errores = new ArrayList<String>();
		
		if (ordenador.getNombre() == null || 
				ordenador.getNombre().trim().equals(""))
			errores.add("Nombre inválido"); 
			
		if (ordenador.getSerial() == null || 
			ordenador.getSerial().trim().equals("") ||
			ordenador.getSerial().trim().length() < 7)
			errores.add("Serial inválido"); 
		
		if (ordenador.getPersona() == null || 
			ordenador.getPersona().getId() == null)
			errores.add("Persona id requerido"); 

		/******* Ejecución *******/
		if (errores.size() > 0) {
			responseWrapper.setSuccess(false);
			responseWrapper.setErrores(errores);
		} else {
			try {
				ordenadorService.agregarOrdenador(ordenador);
				responseWrapper.setSuccess(true);
			} catch (Exception e) {
				responseWrapper.setSuccess(false);
				errores.add(e.getMessage());
			}
		}
		
		return responseWrapper;
	}	

}