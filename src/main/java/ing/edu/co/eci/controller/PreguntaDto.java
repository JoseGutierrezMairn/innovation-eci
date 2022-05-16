package ing.edu.co.eci.controller;

public class PreguntaDto {
	
	private String pregunta;
	private String tipo;

	
	public PreguntaDto() {	}

	public PreguntaDto(String pregunta, String tipo) {
		this.pregunta = pregunta;
		this.tipo = tipo;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
