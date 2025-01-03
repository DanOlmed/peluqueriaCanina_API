package ar.com.peluqueriacanina.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombre;
   private String apellido;

   
   public Cliente() {}

   
   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getNombre() {
       return nombre;
   }

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getApellido() {
       return apellido;
   }

   public void setApellido(String apellido) {
       this.apellido = apellido;
   }


public Cliente(int id, String nombre, String apellido) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellido = apellido;
}
   
}
