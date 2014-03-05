package es.indra.formacion.pr.spring.dao;

import java.util.List;

import es.indra.formacion.pr.persistence.model.Ordenador;

public interface IOrdenadorDao extends IDao<Ordenador, Integer> {
	public List<Ordenador> obtenerTodosOrdenadosPorSerial();
}
