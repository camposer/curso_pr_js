package es.indra.formacion.pr.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.indra.formacion.pr.spring.dao.IOrdenadorDao;
import es.indra.formacion.pr.spring.dao.IPersonaDao;
import es.indra.formacion.pr.spring.dao.OrdenadorDao;
import es.indra.formacion.pr.spring.dao.PersonaDao;
import es.indra.formacion.pr.spring.service.IOrdenadorService;
import es.indra.formacion.pr.spring.service.IPersonaService;
import es.indra.formacion.pr.spring.service.OrdenadorService;
import es.indra.formacion.pr.spring.service.PersonaService;

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
