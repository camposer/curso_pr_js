package es.indra.formacion.pr.spring.front.editor;

import java.beans.PropertyEditorSupport;

@SuppressWarnings("rawtypes")
public class NumeroEditor extends PropertyEditorSupport {
	protected Class clase;
	
	public NumeroEditor(Class clazz) {
		clase = clazz;
	}
	
	/**
	 * Traduce lo que viene del request (que es un String)
	 * al tipo de dato correspondiente
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Object resultado = null;

		try {
			if (clase.equals(Short.class))
				resultado = Short.parseShort(text);
			else if (clase.equals(Integer.class))
				resultado = Integer.parseInt(text);
			else if (clase.equals(Long.class))
				resultado = Long.parseLong(text);
			else if (clase.equals(Float.class))
				resultado = Float.parseFloat(text);
			else if (clase.equals(Double.class))
				resultado = Double.parseDouble(text);
		} catch (NumberFormatException e) {}
		 
		setValue(resultado);
	}
	
	/**
	 * Traduce del objeto a un string para posible enviar en
	 * algún momento al navegador 
	 */
	@Override
	public String getAsText() {
		if (getValue() != null) 
			return getValue().toString();
		else 
			return "";
	}
}
