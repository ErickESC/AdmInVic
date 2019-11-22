package mx.uam.ayd.proyecto.negocio.dominio;


/**
 * Entidad libro
 * 
 * 
 * @author humberto
 *
 */
public class Libro extends Titulo {

	// Autor del libro
	private String autor;

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Libro: "+getNombre()+" del autor:"+autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String aut) {
		autor = aut;
	}
	

}
