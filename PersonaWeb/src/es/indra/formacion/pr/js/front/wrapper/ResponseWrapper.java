package es.indra.formacion.pr.js.front.wrapper;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseWrapper<T> implements Serializable {
	private static final long serialVersionUID = 1244637866215590927L;

	private Boolean success = true;
	private List<String> errores;
	private T data;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public List<String> getErrores() {
		return errores;
	}
	public void setErrores(List<String> errores) {
		this.errores = errores;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
