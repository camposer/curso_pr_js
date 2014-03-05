package es.indra.formacion.pr.spring.front.form;

import java.util.Date;

public class PersonaForm {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Double altura;
	private String ordenadorNombre;
	private String ordenadorSerial;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getOrdenadorNombre() {
		return ordenadorNombre;
	}
	public void setOrdenadorNombre(String ordenadorNombre) {
		this.ordenadorNombre = ordenadorNombre;
	}
	public String getOrdenadorSerial() {
		return ordenadorSerial;
	}
	public void setOrdenadorSerial(String ordenadorSerial) {
		this.ordenadorSerial = ordenadorSerial;
	}
}
