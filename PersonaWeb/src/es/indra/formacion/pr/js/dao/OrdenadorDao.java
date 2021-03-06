package es.indra.formacion.pr.js.dao;

import java.util.List;

import es.indra.formacion.pr.js.model.Ordenador;

public class OrdenadorDao extends BaseDao<Ordenador, Integer> implements IOrdenadorDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Ordenador> obtenerTodosOrdenadosPorSerial() {
		return em.createNamedQuery("Ordenador.findAllOrderedBySerial").getResultList();
	}
}
