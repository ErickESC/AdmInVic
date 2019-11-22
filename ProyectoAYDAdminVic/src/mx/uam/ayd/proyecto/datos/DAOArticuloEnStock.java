package mx.uam.ayd.proyecto.datos;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;

/**
 * DAO para la entidad ArticuloEnStock
 * 
 * @author erick
 *
 */

public interface DAOArticuloEnStock {
	
	/**
	 * Este metodo permite agregar un articulo al registro de articulos en el stock
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(ArticuloEnStock articulo);
	
	/**
	 * Este metodo busca un articulos en el stock a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	public ArticuloEnStock recupera(String id);
	
	/**
	 * Actualiza articulo articulos en el stock
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(ArticuloEnStock articulo);

	/**
	 * Retira un articulo del registro de articulos en el stock
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(ArticuloEnStock articulo);
	
	/**
	 * Regresa la lista de todos los articulos en el stock
	 * 
	 * @return un ArrayList con todos los articulos de articulos en el stock
	 */
	public ArrayList<ArticuloEnStock> recuperaTodos();

}
