package es.indra.formacion.pr.spring.front.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.indra.formacion.pr.persistence.model.Ordenador;
import es.indra.formacion.pr.spring.service.IOrdenadorService;

@Controller
public class OrdenadorRest {
	@Autowired
	IOrdenadorService ordenadorService;
	
	@RequestMapping(
			value={"/ordenadores", "/ordenadores/"}, 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody List<Ordenador> obtenerTodos() {
		return ordenadorService.obtenerOrdenadores();
	}
	
	@RequestMapping(
			value="/ordenadores/{id}", 
			method=RequestMethod.GET,
			produces="application/json"
		)
	public @ResponseBody Ordenador obtener(@PathVariable Integer id) {
		return ordenadorService.obtenerOrdenador(id);
	}	
	
	@RequestMapping(
			value="/ordenadores/{id}", 
			method=RequestMethod.PUT,
			consumes="application/json"
		)
	public @ResponseBody void modificar(@PathVariable Integer id, Ordenador ordenador) {
		ordenador.setId(id);
		ordenadorService.modificarOrdenador(ordenador);
	}	

	@RequestMapping(
			value={"/ordenadores", "/ordenadores/"}, 
			method=RequestMethod.POST,
			consumes="application/json"
		)
	public @ResponseBody void agregar(Ordenador ordenador) {
		System.out.println(ordenador);
		ordenadorService.agregarOrdenador(ordenador);
	}	

}