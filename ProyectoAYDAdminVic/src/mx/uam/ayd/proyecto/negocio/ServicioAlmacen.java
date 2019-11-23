/**
 * 
 */
package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;
import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * Modulo con la logica de negocio de Rezago
 * @author erick
 *
 */
public interface ServicioAlmacen {

	/**
	 * Recupera un ArticuloEnAlmacen a partir de su nombre
	 * 
	 * @param nombre
	 * @return ArticuloEnAlmacen o null
	 */
	public ArticuloEnAlmacen buscaArticuloEnAlmacen(String id);
	
	/**
	 * Permite agregar un ArticuloEnAlmacen mientras no exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	public boolean agregaArticuloEnAlmacen(String id , Date fechaRegistro, Timestamp fechaPartida, int articulosTotales); 
	
	/**
	 * Permite eliminar un ArticuloEnAlmacen
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	public boolean eliminaArticuloEnAlmacen(String id);
	
	/**
	 * Permite actualizar un ArticuloEnAlmacen mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean atualizaArticuloEnAlmacen(String id, Date fechaRegistro, Timestamp fechaPartida, int articulosTotales); 
	
	/**
	 * Permite recuperar los ArticuloEnAlmacen
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	public  ArrayList<ArticuloEnAlmacen> dameArticuloEnAlmacen();
	
	/**
	 * Permite recuperar los ArticuloEnAlmacen registrados dentro de un lapso
	 * @return 
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	public  Map <ArticuloEnAlmacen, String> consultaRezago(Date max, Date min);
	
	
	
}
