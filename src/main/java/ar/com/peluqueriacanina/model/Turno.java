package ar.com.peluqueriacanina.model;
import java.util.Date;

import lombok.Data;

@Data
public class Turno {

	private int turnoId;
	private Date dia;
	private String hora;
	private Mascota mascota;
	
}
