/**
 * 
 */
package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.datos.DAOArticuloEnAlmacen;
import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

/**
 * @author erick
 *
 */
public class ServicioAlmacenImpl implements ServicioAlmacen {

	private DAOArticuloEnAlmacen daoAlmacen;
	
	public ServicioAlmacenImpl(DAOArticuloEnAlmacen dao) {
		// Creamos conexion al DAO
		this.daoAlmacen = dao;
	}
	
	/**
	 * Recupera un ArticuloEnAlmacen a partir de su nombre
	 * 
	 * @param nombre
	 * @return ArticuloEnAlmacen o null
	 */
	@Override
	public ArticuloEnAlmacen buscaArticuloEnAlmacen(String id) {
		
		return daoAlmacen.recupera(id);
		
	}

	/**
	 * Permite agregar un ArticuloEnAlmacen mientras no exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se agrego correctamente, false si no
	 */
	@Override
	public boolean agregaArticuloEnAlmacen(String id, Date fechaRegistro, Timestamp fechaPartida, int articulosTotales) {
		
		// Regla de negocio: RN-01 no puede haber dos libros con el mismo nombre
		if(daoAlmacen.recupera(id) != null) 
			return false;
		
		ArticuloEnAlmacen articulo=new ArticuloEnAlmacen(id, fechaRegistro, fechaPartida, articulosTotales);
		daoAlmacen.crea(articulo);
		return true;
	}

	/**
	 * Permite eliminar un ArticuloEnAlmacen
	 * 	
	 * @param id
	 * @return true si se elimino correctamente, false si no
	 */
	@Override
	public boolean eliminaArticuloEnAlmacen(String id) {
		
		Date k = null;
		Timestamp t = null;
		ArticuloEnAlmacen articulo=new ArticuloEnAlmacen(id, k, t, 1);
		if(daoAlmacen.borra(articulo) == true)
			return true;
		
		return false;
	}

	/**
	 * Permite actualizar un ArticuloEnAlmacen mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	@Override
	public boolean atualizaArticuloEnAlmacen(String id, Date fechaRegistro, Timestamp fechaPartida, int articulosTotales) {
		
		if(daoAlmacen.recupera(id) != null) 
			return false;
		
		ArticuloEnAlmacen articulo=new ArticuloEnAlmacen(id, fechaRegistro, fechaPartida, articulosTotales);
		
		daoAlmacen.crea(articulo);
		
		return true;
	}

	/**
	 * Permite recuperar los ArticuloEnAlmacen
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	@Override
	public ArrayList<ArticuloEnAlmacen> dameArticuloEnAlmacen() {
		
		
		
		return null;
	}

	/**
	 * Permite recuperar los ArticuloEnAlmacen registrados dentro de un lapso
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	@Override
	public ArrayList<ArticuloEnAlmacen> dameArticuloEnAlmacenLapso(Date max, Date min) {
		
		ArrayList<ArticuloEnAlmacen> lapso=daoAlmacen.recuperaLapso(max, min);
		
		return lapso;
	}

}
