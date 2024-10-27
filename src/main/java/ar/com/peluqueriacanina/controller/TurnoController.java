package ar.com.peluqueriacanina.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ar.com.peluqueriacanina.model.Mascota;
import ar.com.peluqueriacanina.model.Turno;
import ar.com.peluqueriacanina.service.MascotaService;
import ar.com.peluqueriacanina.service.TurnoService;

@RequestMapping  ("/turno")
@RestController
public class TurnoController {
	
	@Autowired
	private TurnoService turnoService;
	@Autowired
	private MascotaService mascotaService;
	
	@PostMapping
	public ResponseEntity<Turno> addTurno(@RequestBody Turno turno){
		 try {
	            Mascota mascota = mascotaService.findById(turno.getMascota().getMascotaId());
	            if (mascota == null) {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	            turno.setMascota(mascota);
	            Turno nuevoTurno = turnoService.save(turno);
	            return new ResponseEntity<>(nuevoTurno, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam int turnoId){
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
	
	@GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Turno turno = turnoService.findById(id);
            response.put("data", turno);
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Turno> turnos = turnoService.findAll();
            response.put("data", turnos);
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Turno turno) {
        Map<String, Object> response = new HashMap<>();
        try {
            Turno updatedTurno = turnoService.update(turno);
            response.put("data", updatedTurno);
            response.put("msj", "ok");
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	
	
	
	
	
	


}
