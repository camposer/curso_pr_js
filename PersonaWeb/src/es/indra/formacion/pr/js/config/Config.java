package es.indra.formacion.pr.js.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.indra.formacion.pr.js.dao.IOrdenadorDao;
import es.indra.formacion.pr.js.dao.IPersonaDao;
import es.indra.formacion.pr.js.dao.OrdenadorDao;
import es.indra.formacion.pr.js.dao.PersonaDao;
import es.indra.formacion.pr.js.service.IOrdenadorService;
import es.indra.formacion.pr.js.service.IPersonaService;
import es.indra.formacion.pr.js.service.OrdenadorService;
import es.indra.formacion.pr.js.service.PersonaService;

/**
 * La clase debe tener la anotación \@Configuration
 */
@Configuration
public class Config {
	@Bean
	public IOrdenadorService ordenadorService() {
		return new OrdenadorService();
	}

	@Bean
	public IPersonaService personaService() {
		return new PersonaService();
	}

	@Bean
	public IPersonaDao personaDao() {
		return new PersonaDao();
	}

	@Bean
	public IOrdenadorDao ordenadorDao() {
		return new OrdenadorDao();
	}

}
