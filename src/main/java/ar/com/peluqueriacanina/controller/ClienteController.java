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
import ar.com.peluqueriacanina.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
		

	@Autowired
	private ClienteService  clienteService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody  Cliente cliente ){
		Map<String, Object> response = new HashMap<String, Object>(); 
		try {
			Cliente sCliente  =  clienteService.save(cliente);
			response.put("data", sCliente);
			response.put("msj", "ok");
		
		} catch (Exception e) {
			response.put("error", e.toString());
			 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		} 
		 
		 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		 
	 } 	
	
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestParam int clienteId ) {

		Map<String, Object> response = new HashMap<String, Object>(); 
		try {
			
		   Boolean resultado = 	clienteService.delete(clienteId);
			response.put("data", resultado);	
			response.put("msj", "Cliente borrado exitosamente");
			
		} catch (Exception e) {response.put("error", e.toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente cliente = clienteService.findById(id);
            response.put("data", cliente);
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
            List<Cliente> clientes = clienteService.findAll();
            response.put("data", clientes);
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cliente cliente) {
        Map<String, Object> response = new HashMap<>();
        try {
            Cliente updatedCliente = clienteService.update(cliente);
            response.put("data", updatedCliente);
            response.put("msj", "ok");
        } catch (Exception e) {
            response.put("error", e.toString());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	
	
	
	

}