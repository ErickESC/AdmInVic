/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.negocio;
import java.sql.Date;
import java.util.ArrayList;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;
/**
 *
 * @author Cruz
 */
public interface ServicioHistorial {
    
   /**
	 * Recupera una Venta a partir de su nombre
	 * 
	 * @param nombre
	 * @return Venta o null
	 */
	public Venta buscaVenta(String id);
	
	/**
	 * Permite agregar una Venta mientras no exista ya una Venta con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	public boolean agregaVenta(String id , int total, String articuloEnVenta, Date date); 
        
	/**
	 * Permite eliminar una Venta
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	public boolean eliminaVenta(String id);
	
	/**
	 * Permite actualizar una Venta mientras exista una Venta con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean atualizaVenta(String id , int total, String articuloEnVenta, Date date); 
	
	/**
	 * Permite recuperar las Ventas
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	public  ArrayList<Venta> dameVentas();
	
	/**
	 * Permite recuperar los ArticuloEnAlmacen registrados dentro de un lapso
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	public  ArrayList<Venta> dameVentaLapso(Date max, Date min);
}
