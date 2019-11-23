package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

public class ServicioArticuloImpl {
	
	/**
	 * Recupera un Articulo a partir de su nombre
	 * 
	 * @param nombre
	 * @return ArticuloEnAlmacen o null
	 */
	private DAOArticulo dao;
	
	public ServicioArticuloImpl(DAOArticulo dao) {
		
		this.dao=dao;
		
	}
	
	public Articulo buscaArticulo(String id) {
		
		dao.recupera(id);
		
		return null;
	}
	
	/**
	 * Permite agregar un Articulo mientras no exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	public boolean agregaArticulo(String id, String descripcion , byte[] imagen,double PV ,double PM, double PA,int articulosTotales) {
		
		// Regla de negocio: RN-01 no puede haber dos libros con el mismo nombre
		if(dao.recupera(id) != null) 
			return false;
		
		Articulo articulo=new Articulo(id, descripcion, imagen,PV,PM,PA, articulosTotales);
		dao.crea(articulo);
		return true;
		
	}
	
	/**
	 * Permite eliminar un Articulo
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	public boolean eliminaArticulo(String id) {

		Articulo articulo=new Articulo(id, "",null, 4.4,5.5,9.9, 1);
		if(dao.borra(articulo) == true)
			return true;
		
		return false;
	}
	
	/**
	 * Permite actualizar un Articulo mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean realizaDescuentos(String id, String descripcion , byte[] imagen,double PV ,double PM, double PA,int articulosTotales){
		
		Articulo articulo=new Articulo(id,  descripcion ,  imagen, PV , PM,  PA, articulosTotales);
		return dao.actualiza(articulo);

	}
	
	/**
	 * Permite recuperar los Articulo
	 * 
	 * @return arreglo con Articulo
	 */
	public  ArrayList<Articulo> dameArticulo(){
		
		return dao.recuperaTodos();
	}

}
