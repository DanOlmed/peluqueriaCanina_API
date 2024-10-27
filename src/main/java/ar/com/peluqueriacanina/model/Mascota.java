package ar.com.peluqueriacanina.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mascotaId;
	private String nombre;
	private String raza;
	private String color;
	private String alergico;
	private String atencionEspecial;
	private String observaciones;
	@ManyToOne
	private Cliente cliente;
	
	
	
	public Mascota() {
		super();
	}



	public Mascota(int mascotaId, String nombre, String raza, String color, String alergico, String atencionEspecial,
			String observaciones, Cliente cliente) {
		super();
		this.mascotaId = mascotaId;
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.alergico = alergico;
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
		this.cliente = cliente;
	}



	public int getMascotaId() {
		return mascotaId;
	}



	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRaza() {
		return raza;
	}



	public void setRaza(String raza) {
		this.raza = raza;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getAlergico() {
		return alergico;
	}



	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}



	public String getAtencionEspecial() {
		return atencionEspecial;
	}



	public void setAtencionEspecial(String atencionEspecial) {
		this.atencionEspecial = atencionEspecial;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
