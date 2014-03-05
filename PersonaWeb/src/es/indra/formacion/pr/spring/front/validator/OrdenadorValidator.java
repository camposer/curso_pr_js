package es.indra.formacion.pr.spring.front.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.indra.formacion.pr.spring.front.form.OrdenadorForm;

@Component
public class OrdenadorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrdenadorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrdenadorForm ordenadorForm = (OrdenadorForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "ordenador.error.nombreVacio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "serial", "ordenador.error.serialVacio");

		if (ordenadorForm.getSerial() != null &&
				ordenadorForm.getSerial().trim().length() <= 7)
			errors.rejectValue("serial", "ordenador.error.serialMenorQue7");
	}

}
