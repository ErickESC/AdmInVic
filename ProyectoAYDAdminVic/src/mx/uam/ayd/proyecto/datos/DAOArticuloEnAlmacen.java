package mx.uam.ayd.proyecto.datos;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

/**
 * DAO para la entidad ArticuloEnAlmacen
 * 
 * @author erick
 *
 */

public interface DAOArticuloEnAlmacen {
	
	/**
	 * Este metodo permite agregar un articulo al registro de articulos en el almacen
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(ArticuloEnAlmacen articulo);
	
	/**
	 * Este metodo busca un articuloen el almacen a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	public ArticuloEnAlmacen recupera(String id);
	
	/**
	 * Actualiza articulo en el almacen
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(ArticuloEnAlmacen articulo);

	/**
	 * Retira un articulo del registro de articulos en el almacen
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(ArticuloEnAlmacen articulo);
	
	/**
	 * Regresa la lista de todos los articulos en el almacen
	 * 
	 * @return un ArrayList con todos los articulos de articulos en el almacen
	 */
	public ArrayList<ArticuloEnAlmacen> recuperaTodos();
	
	/**
	 * Este metodo busca un articulo a partir de un rango de fechas
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	
	public ArrayList<ArticuloEnAlmacen> recuperaLapso(java.sql.Date max, java.sql.Date min);

}
