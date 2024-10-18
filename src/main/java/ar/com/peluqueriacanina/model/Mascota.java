package ar.com.peluqueriacanina.model;
import lombok.Data;


@Data
public class Mascota {
	
	private int mascotaId;
	private String nombre;
	private String raza;
	private String color;
	private String alergico;
	private String atencionEspecial;
	private String observaciones;
	private Cliente cliente;
	

}
