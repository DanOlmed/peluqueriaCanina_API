package ar.com.peluqueriacanina.service.imp;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import ar.com.peluqueriacanina.model.Cliente;
import ar.com.peluqueriacanina.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{
	
	private List<Cliente> clientes = new ArrayList<>();
    private int currentId = 1;
	
	@Override
	public Cliente findById(int id) {
		return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
	}
	
	@Override
	public Cliente save(Cliente model) {
		model.setId(currentId++);
        clientes.add(model);
        return model;
	}

	

	@Override
	public List<Cliente> findAll() {
		
		return new ArrayList<>(clientes);
	}

	@Override
	public Boolean delete(int id) {
		 Optional<Cliente> cliente = clientes.stream()
	                .filter(c -> c.getId() == id)
	                .findFirst();

	        if (cliente.isPresent()) {
	            clientes.remove(cliente.get());
	            return true;
	        } else {
	            return false;
	        }
	    }

	

	@Override
	public Cliente update(Cliente model) {
		Optional<Cliente> clienteOptional = clientes.stream()
                .filter(c -> c.getId() == model.getId())
                .findFirst();

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNombre(model.getNombre());
            cliente.setApellido(model.getApellido());
           
            return cliente;
        } else {
            return null;
        }
		
	}

	@Override
	public List<Cliente> findAll(int id) {
		
		return null;
	}
	
	

}
