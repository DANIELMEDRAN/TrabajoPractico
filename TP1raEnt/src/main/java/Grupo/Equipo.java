package Grupo;
import java.util.ArrayList;

public class Equipo {
   
   private String nombre;
   private String id;
   private String descripcion;
   private ArrayList<Equipo> Equipos; 
	   
   public Equipo(String nombre, String id, String descripcion) {
       super();
       this.nombre = nombre;
       this.id = id;
       this.descripcion = descripcion;
       this.Equipos = new ArrayList<Equipo>();
   }
   
   public Equipo(String string) {
	
   }

public String getNombre() {
       return nombre;
   }
   
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
   
   public String getId() {
       return id;
   }
   
   public void setId(String id) {
       this.id = id;
   }
   
   public String getDescripcion() {
       return descripcion;
   }
   
   public void setDescripcion(String descripcion) {
       this.descripcion = descripcion;
   }

public ArrayList<Equipo> getEquipos() {
	return Equipos;
}

public void setEquipos(ArrayList<Equipo> equipos) {
	Equipos = equipos;
}
}	

