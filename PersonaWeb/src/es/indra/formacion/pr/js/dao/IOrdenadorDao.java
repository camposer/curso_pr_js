package es.indra.formacion.pr.js.dao;

import java.util.List;

import es.indra.formacion.pr.js.model.Ordenador;

public interface IOrdenadorDao extends IDao<Ordenador, Integer> {
	public List<Ordenador> obtenerTodosOrdenadosPorSerial();
}
