package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * Modulo con parte de la logica de negocio de Rezago
 * @author erick
 *
 */

public interface ServicioUsuario {
	
	/**
	 * Permite actualizar un Articulo mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean realizaLista(ArrayList<String> ids, ArrayList<Integer> cants); 

}
