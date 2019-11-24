package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * Modulo con parte de la logica de negocio de Rezago
 * @author erick
 *
 */

public interface ServicioArticulo {
	
	/**
	 * Recupera un Articulo a partir de su nombre
	 * 
	 * @param nombre
	 * @return ArticuloEnAlmacen o null
	 */
	public Articulo buscaArticulo(String id);
	
	/**
	 * Permite agregar un Articulo mientras no exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	public boolean agregaArticulo(String id, String descripcion , byte[] imagen,double PV ,double PM, double PA,int articulosTotales); 
	
	/**
	 * Permite eliminar un Articulo
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	public boolean eliminaArticulo(String id);
	
	/**
	 * Permite actualizar un Articulo
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	/*public boolean actualizaArticulo(String id);*/
	
	
	
	/**
	 * Permite actualizar un Articulo mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean realizaDescuentos(String id, String descripcion , byte[] imagen,double PV ,double PM, double PA,int articulosTotales); 
	
	/**
	 * Permite recuperar los Articulo
	 * 
	 * @return arreglo con Articulo
	 */
	public  ArrayList<Articulo> dameArticulo();	
	

}
