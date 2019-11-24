/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.datos;

import java.sql.Date;
import java.util.ArrayList;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 *
 * @author Cruz
 */
public interface DAOVenta {
    /**
	 * Este metodo permite agregar un articulo al registro de articulos
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Venta articulo);
	
	/**
	 * Este metodo busca un articulo a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	public Venta recupera(String id);
	
	/**
	 * Actualiza articulo
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Venta articulo);

	/**
	 * Retira un articulo del registro de articulos
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Venta articulo);
	
	/**
	 * Regresa la lista de todos los articulos
	 * 
	 * @return un ArrayList con todos los articulos del registro de articulos
	 */
	public ArrayList<Venta> recuperaTodos();
        
        /**
         * Regresa la lista de las Ventas en un lapso de tiempo
         * 
         * @param max
         * @param min
         * @return 
         */
        public ArrayList<Venta> recuperaLapso(java.sql.Date max, java.sql.Date min);
}
