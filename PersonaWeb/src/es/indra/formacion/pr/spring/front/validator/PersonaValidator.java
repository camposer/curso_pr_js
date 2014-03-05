package es.indra.formacion.pr.spring.front.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.indra.formacion.pr.spring.front.form.OrdenadorForm;
import es.indra.formacion.pr.spring.front.form.PersonaForm;

@Component
public class PersonaValidator implements Validator {
	@Autowired
	OrdenadorValidator ordenadorValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return PersonaForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PersonaForm personaForm = (PersonaForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "persona.error.nombreVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "persona.error.apellidoVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", "persona.error.fechaNacimientoVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "altura", "persona.error.alturaVacio");
		
		if (personaForm.getAltura() != null && 
				personaForm.getAltura() <= 0)
			errors.rejectValue("altura", "persona.error.alturaMayoQue0");

		// Validando datos de Ordenador
		/*
		OrdenadorForm ordenadorForm = new OrdenadorForm();
		ordenadorForm.setNombre(personaForm.getOrdenadorNombre());
		ordenadorForm.setSerial(personaForm.getOrdenadorSerial());
		ordenadorValidator.validate(ordenadorForm, errors);
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ordenadorNombre", "ordenador.error.nombreVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ordenadorSerial", "ordenador.error.serialVacio");

		if (personaForm.getOrdenadorSerial() != null &&
				personaForm.getOrdenadorSerial().trim().length() <= 7)
			errors.rejectValue("ordenadorSerial", "ordenador.error.serialMenorQue7");
		
		
	}

}
