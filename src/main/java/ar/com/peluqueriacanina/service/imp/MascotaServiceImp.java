package ar.com.peluqueriacanina.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import ar.com.peluqueriacanina.model.Mascota;
import ar.com.peluqueriacanina.service.MascotaService;
@Service
public class MascotaServiceImp implements MascotaService {
	
	private List<Mascota> mascotas = new ArrayList<>();
    private int currentId = 1;
	
	@Override
	public Mascota findById(int id) {
		return mascotas.stream()
                .filter(c -> c.getMascotaId() == id)
                .findFirst()
                .orElse(null);
	}
	
	@Override
	public Mascota save(Mascota model) {
		model.setMascotaId(currentId++);
        mascotas.add(model);
        return model;
	}

	

	@Override
	public List<Mascota> findAll() {
		
		return new ArrayList<>(mascotas);
	}

	@Override
	public Boolean delete(int id) {
		 Optional<Mascota> mascota = mascotas.stream()
	                .filter(c -> c.getMascotaId() == id)
	                .findFirst();

	        if (mascota.isPresent()) {
	           mascotas.remove(mascota.get());
	            return true;
	        } else {
	            return false;
	        }
	    }

	

	@Override
	public Mascota update(Mascota model) {
		Optional<Mascota> mascotaOptional =mascotas.stream()
                .filter(c -> c.getMascotaId() == model.getMascotaId())
                .findFirst();

        if (mascotaOptional.isPresent()) {
            Mascota mascota= mascotaOptional.get();
           mascota.setNombre(model.getNombre());
            mascota.setAlergico(model.getAlergico());
            mascota.setAtencionEspecial(model.getAtencionEspecial());
            mascota.setCliente(model.getCliente());
            mascota.setColor(model.getColor());
            mascota.setObservaciones(model.getObservaciones());
            
           
            return mascota;
        } else {
            return null;
        }
		
	}

	@Override
	public List<Mascota> findAll(int id) {
		
		return null;
	}

	
	
	


}
