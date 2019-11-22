package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * Entidad Titulo, para demostrar herencia
 * 
 * @author humbertocervantes
 *
 */
public abstract class Titulo {
	
	
	// Id para persistir
	private int id = 0;
	
	// Nombre del titulo	
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	abstract String getDescripcion();
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


}
