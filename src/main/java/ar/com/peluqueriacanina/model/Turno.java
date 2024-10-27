package ar.com.peluqueriacanina.model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;




@Entity
public class Turno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int turnoId;
	private Date dia;
	private String hora;
	@ManyToOne
	private Mascota mascota;
	
	
	public int getTurnoId() {
		return turnoId;
	}


	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}


	public Date getDia() {
		return dia;
	}


	public void setDia(Date dia) {
		this.dia = dia;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}


	public Turno(int turnoId, Date dia, String hora, Mascota mascota) {
		super();
		this.turnoId = turnoId;
		this.dia = dia;
		this.hora = hora;
		this.mascota = mascota;
	}


	public Turno() {
		super();
	}
	
	
	
	
}
