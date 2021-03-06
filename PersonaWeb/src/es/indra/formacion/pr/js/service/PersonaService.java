package es.indra.formacion.pr.js.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.pr.js.dao.IOrdenadorDao;
import es.indra.formacion.pr.js.dao.IPersonaDao;
import es.indra.formacion.pr.js.model.Ordenador;
import es.indra.formacion.pr.js.model.Persona;


@Transactional
public class PersonaService implements IPersonaService {
	@Autowired
	private IPersonaDao personaDao;
	@Autowired
	private IOrdenadorDao ordenadorDao;

	@Override
	public void agregarPersona(Persona p) {
		// Operaciones con persona
		personaDao.agregar(p);

		// Operaciones con ordenadores
		if (p.getOrdenadores() != null) for (Ordenador o : p.getOrdenadores()) {
				o.setPersona(p); // Ya fue persistido!!!
				ordenadorDao.agregar(o);
		}
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}

}
