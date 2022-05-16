package ing.edu.co.eci.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping( "/v1/pregunta")
public class PreguntasController {

	private ArrayList<String> adultoPregunta = new ArrayList<String>();
	
	private ArrayList<String> jovenPregunta = new ArrayList<String>();
	
	
	@PostMapping(path = "/guardarPregunta", consumes = "application/json", produces="application/json")
	public boolean guardarPregunta( @RequestBody PreguntaDto preguntaDto) {
		return agregarPregunta(preguntaDto);
	}
	
	@GetMapping(path="/todas")
	public ArrayList<String> todasLasPreguntas( @RequestParam String tipo  ){
		ArrayList<String> answ = jovenPregunta;
		if(tipo.equals("adulto")) {
			answ = adultoPregunta;
		}
		return answ;
	}
	
	private synchronized boolean agregarPregunta( PreguntaDto preguntaDto ) {
		boolean answ = false;;
		
		if( preguntaDto.getTipo().equals("adulto") ) {
			answ = adultoPregunta.add( preguntaDto.getPregunta() );
		}else {
			answ = jovenPregunta.add(preguntaDto.getPregunta());
		}
		return answ;
	}
	
}
