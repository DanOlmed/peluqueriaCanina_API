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

import ar.com.peluqueriacanina.model.Mascota;
import ar.com.peluqueriacanina.service.MascotaService;

@RequestMapping ("/mascota")
@RestController
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody Mascota mascota){
		
		Map<String,Object> response = new HashMap<String,Object>();
		
		try {
			Mascota sMascota = mascotaService.save(mascota);
			response.put("data", sMascota);
			response.put("msj","ok");
		} catch (Exception e) {
			response.put("error", e.toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam Long mascotaId){
		
		Map<String, Object> response = new HashMap<String,Object>();
		
		try {
			Boolean resultado = mascotaService.delete(mascotaId);
			response.put("data", resultado);
			
		} catch(Exception e) {
			response.put("error", e.toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	

}
