package ar.com.peluqueriacanina.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import ar.com.peluqueriacanina.model.Turno;
import ar.com.peluqueriacanina.service.TurnoService;
@Service
public class TurnoServiceImp implements TurnoService {

	private List<Turno> turnos = new ArrayList<>();
    private int currentId = 1;
	
	@Override
	public Turno findById(int id) {
		return turnos.stream()
                .filter(c -> c.getTurnoId() == id)
                .findFirst()
                .orElse(null);
	}
	
	@Override
	public Turno save(Turno model) {
		model.setTurnoId(currentId++);
        turnos.add(model);
        return model;
	}

	

	@Override
	public List<Turno> findAll() {
		
		return new ArrayList<>(turnos);
	}

	@Override
	public Boolean delete(int id) {
		 Optional<Turno> turno = turnos.stream()
	                .filter(c -> c.getTurnoId() == id)
	                .findFirst();

	        if (turno.isPresent()) {
	          turnos.remove(turno.get());
	            return true;
	        } else {
	            return false;
	        }
	    }

	

	@Override
	public Turno update(Turno model) {
		Optional<Turno> turnoOptional =turnos.stream()
                .filter(c -> c.getTurnoId() == model.getTurnoId())
                .findFirst();

        if (turnoOptional.isPresent()) {
           Turno turno=turnoOptional.get();
           turno.setDia(model.getDia());
           turno.setHora(model.getHora());
           turno.setMascota(model.getMascota());
           
            
           
            return turno;
        } else {
            return null;
        }
		
	}

	@Override
	public List<Turno> findAll(int id) {
		
		return null;
	}

	
	
	

}
