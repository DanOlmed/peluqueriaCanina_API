package ar.com.peluqueriacanina.controller;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ar.com.peluqueriacanina.model.Turno;
import ar.com.peluqueriacanina.service.TurnoService;

@RequestMapping  ("/turno")
@RestController
public class TurnoController {
	
	@Autowired
	private TurnoService turnoService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody Turno turno){
		Map<String, Object> response = new HashMap<String, Object>(); 
		try {
			Turno sTurno = turnoService.save(turno);
			response.put("data", sTurno);
			response.put("msj","ok");
			
		}catch(Exception e) {
			response.put("error", e.toString());
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam Long turnoId){
		Map<String, Object> response = new HashMap<String,Object>();
		
		try {
			Boolean resultado = turnoService.delete(turnoId);
			response.put("data", resultado);
			
		}catch(Exception e) {
			response.put("error", e.toString());
			return new ResponseEntity<Map<String, Object>>(response,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
