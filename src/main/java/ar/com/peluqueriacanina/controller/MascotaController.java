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

import ar.com.peluqueriacanina.model.Cliente;
import ar.com.peluqueriacanina.model.Mascota;
import ar.com.peluqueriacanina.service.ClienteService;
import ar.com.peluqueriacanina.service.MascotaService;

@RequestMapping ("/mascota")
@RestController
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Mascota> addMascota(@RequestBody Mascota mascota) {
        try {
            Cliente cliente = clienteService.findById(mascota.getCliente().getId());
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            mascota.setCliente(cliente);
            Mascota nuevaMascota = mascotaService.save(mascota);
            return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam int mascotaId){
		
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

	@GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Mascota mascota = mascotaService.findById(id);
            response.put("data", mascota);
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
            List<Mascota> mascotas = mascotaService.findAll();
            response.put("data", mascotas);
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Mascota mascota) {
        Map<String, Object> response = new HashMap<>();
        try {
            Mascota updatedMascota = mascotaService.update(mascota);
            response.put("data", updatedMascota);
            response.put("msj", "ok");
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	
	
	
	
	
	

}
