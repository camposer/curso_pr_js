package es.indra.formacion.pr.persistence.model;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * The persistent class for the ORDENADOR database table.
 * 
 */
@Entity
@Table(name="ORDENADOR")
@NamedQueries({
		@NamedQuery(name="Ordenador.findAll", query="SELECT o FROM Ordenador o"),
		/*@NamedQuery(name="Ordenador.findAllOrderedBySerial", query="SELECT o, p FROM Ordenador o, Persona p WHERE p.id = o.persona.id ORDER BY o.serial ASC"),*/
		@NamedQuery(name="Ordenador.findAllOrderedBySerial", query="SELECT o FROM Ordenador o JOIN o.persona p ORDER BY o.serial ASC"),
		/*@NamedQuery(name="Ordenador.findAllOrderedBySerial", query="SELECT o.nombre, o.serial, p.nombre, p.apellido, p.fechaNacimiento, p.altura FROM Ordenador o JOIN o.persona p ORDER BY o.serial ASC"),*/
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ordenador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(nullable=false, length=50)
	private String serial;
	
	@Transient
	private Integer personaId;
	
	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PERSONA_ID", nullable=false)
	private Persona persona;

	public Ordenador() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", nombre=" + nombre + ", serial="
				+ serial + ", personaId=" + personaId +"]";
	}

	
}