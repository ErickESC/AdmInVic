/**
 * 
 */
package mx.uam.ayd.proyecto.datos;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

/**
 * DAO para la entidad Articulo
 * 
 * @author erick
 *
 */
public interface DAOArticulo {
	
	/**
	 * Este metodo permite agregar un articulo al registro de articulos
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Articulo articulo);
	
	/**
	 * Este metodo busca un articulo a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	public Articulo recupera(String id);
	
	/**
	 * Actualiza articulo
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Articulo articulo);

	/**
	 * Retira un articulo del registro de articulos
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Articulo articulo);
	
	/**
	 * Regresa la lista de todos los articulos
	 * 
	 * @return un ArrayList con todos los articulos del registro de articulos
	 */
	public ArrayList<Articulo> recuperaTodos();
	
}
