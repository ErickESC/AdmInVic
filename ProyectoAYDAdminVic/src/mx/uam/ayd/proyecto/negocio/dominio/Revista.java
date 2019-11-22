package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * Entidad revista
 * 
 * @author humbertocervantes
 *
 */
public class Revista extends Titulo {
	
	// Numbero de la revista
	private int numero;
	
	@Override
	String getDescripcion() {
		return "Revista: "+getNombre()+" numero: "+numero;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int num) {
		numero = num;
	}
	

}
