package es.indra.formacion.pr.spring.service;

import java.util.List;

import es.indra.formacion.pr.persistence.model.Ordenador;

public interface IOrdenadorService {
	public void agregarOrdenador(Ordenador o);
	public void modificarOrdenador(Ordenador o);
	public void eliminarOrdenador(Integer id);
	public Ordenador obtenerOrdenador(Integer id);
	public List<Ordenador> obtenerOrdenadores();
	public List<Ordenador> obtenerOrdenadoresOrdenadosPorSerial();
}
