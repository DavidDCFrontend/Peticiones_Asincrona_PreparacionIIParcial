package es.dsw.models;

public class Resultado {
	
	private Alumno alumno;
	private String municipio;
	private boolean error;
	private String msgError;
	
	public Resultado(Alumno alumno, String municipio, boolean error, String msgError) {
		super();
		this.alumno = alumno;
		this.municipio = municipio;
		this.error = error;
		this.msgError = msgError;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
}
