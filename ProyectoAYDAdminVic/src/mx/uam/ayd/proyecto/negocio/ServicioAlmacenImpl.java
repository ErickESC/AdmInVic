/**
 * 
 */
package mx.uam.ayd.proyecto.negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnAlmacen;
import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

/**
 * @author erick
 *
 */
public class ServicioAlmacenImpl implements ServicioAlmacen {

	private DAOArticuloEnAlmacen daoAlmacen;
	private DAOArticulo daoArticulo;
	
	public ServicioAlmacenImpl(DAOArticuloEnAlmacen dao, DAOArticulo daoArticulo) {
		// Creamos conexion al DAO
		this.daoAlmacen = dao;
		this.daoArticulo=daoArticulo;
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
		
		ArrayList<ArticuloEnAlmacen> lista=daoAlmacen.recuperaTodos();
		
		return lista;
	}

	/**
	 * Permite recuperar los ArticuloEnAlmacen registrados dentro de un lapso
	 * 
	 * @return arreglo con ArticuloEnAlmacen
	 */
	@Override
	public java.util.Map<Articulo, String> consultaRezago(Date max, Date min) {
		
		
		double precioDescuento;
		
		ArrayList<ArticuloEnAlmacen> lapso=daoAlmacen.recuperaLapso(max, min);
		
		System.out.println(lapso.get(0).getIdArticulo());
		
		ArrayList<Articulo> articulos=new ArrayList<Articulo>();
		java.util.Map <Articulo, String> descuento=new HashMap <Articulo, String>();
		
		
		//Llamamos a DAOArticulo para conocer los precios de los articulos requeridos
		//Llenamos un arreglo de articulos para poder realizar la logica de negocio
		for(int i=0; i<lapso.size();i++) {
			
			articulos.add(daoArticulo.recupera(lapso.get(i).getIdArticulo()));
			System.out.println(articulos.get(i).getIdArticulo());
		}
		
		
		for(int i=0; i<articulos.size();i++) {
				
			LocalDate hoy = LocalDate.now();
			hoy.getMonthValue();
			int desc=hoy.getMonthValue()-lapso.get(i).getFechaLlegada().getMonth();
			int anio=-hoy.getDayOfMonth()+lapso.get(i).getFechaLlegada().getYear();
			System.out.println(desc);
			System.out.println(anio);
			
			/*
			 * Logica de negocio que obedece la regla NO-6
			 */
			
			if((anio==0 && desc<5) || (anio==1 && -5>desc)) {		
				
				if(desc<0) { desc=desc+(-1); }//considerando si checas en enero y registraste algo en diciembre
				double porcentaje=desc*0.05;
				double precio=articulos.get(i).getPrecioVenta();
				double precioDesc = precio-(precio*porcentaje);
			    String descuentoHecho=Double.toString(precioDesc);
				descuento.put(articulos.get(i), descuentoHecho);
				
				
			}
			
			double porcentaje=0.4;
			double precio=articulos.get(i).getPrecioVenta();
			double precioDesc = precio-(precio*porcentaje);
		    String descuentoHecho=Double.toString(precioDesc);
			descuento.put(articulos.get(i), descuentoHecho);
					
		}
		
		
		return descuento;
	}

}
