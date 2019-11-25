/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.util.ArrayList;
import mx.uam.ayd.proyecto.datos.DAOVenta;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 *
 * @author Cruz
 */
public class ServicioHistorialImpl implements ServicioHistorial{
    private DAOVenta daoVenta;

        
	public ServicioHistorialImpl(DAOVenta dao) {
		// Creamos conexion al DAO
		this.daoVenta = dao;
	}
	
	/**
	 * Recupera una Venta a partir de su nombre
	 * 
	 * @param nombre
	 * @return Venta o null
	 */
	@Override
	public Venta buscaVenta(String id) {
		
		return daoVenta.recupera(id);
		
	}

	/**
	 * Permite agregar una Venta mientras no exista un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	@Override
	public boolean agregaVenta(String id , int total, String articuloEnVenta, Date date) {
		
		// Regla de negocio: RN-01 no puede haber dos Ventas con el mismo id
		if(daoVenta.recupera(id) != null) 
			return false;
		Venta articulo= new Venta(id ,total,articuloEnVenta,date);
		daoVenta.crea(articulo);
		return true;
	}

	/**
	 * Permite eliminar una Venta
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	@Override
	public boolean eliminaVenta(String id) {
		
		Date k = null;
		Venta articulo=new Venta(id, 0, "art", k);
		if(daoVenta.borra(articulo) == true)
			return true;
		
		return false;
	}

	/**
	 * Permite actualizar una Venta mientras exista una Venta con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	@Override
	public boolean atualizaVenta(String id , int total, String articuloEnVenta, Date date) {
		
		if(daoVenta.recupera(id) != null) 
			return false;
		
		Venta articulo=new Venta(id ,total,articuloEnVenta,date);
		
		daoVenta.crea(articulo);
		
		return true;
	}

	/**
	 * Permite recuperar las Ventas
	 * 
	 * @return arreglo con Ventas
	 */
	@Override
	public ArrayList<Venta> dameVentas() {
		
		ArrayList<Venta> ventas = daoVenta.recuperaTodos();
		
		return ventas;
	}

	/**
	 * Permite recuperar las Ventas registradas dentro de un lapso
	 * 
	 * @return arreglo con Ventas
	 */
	@Override
	public ArrayList<Venta> dameVentaLapso(Date max, Date min) {
		
		ArrayList<Venta> lapso=daoVenta.recuperaLapso(max, min);
		
		return lapso;
	}
    
}
