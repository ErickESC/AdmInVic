package mx.uam.ayd.proyecto.datos;

import java.sql.Date;
import java.sql.Timestamp;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

public class pruebas {
	
	private DAOArticulo dao;
	
	public pruebas(DAOArticulo dao) {
		// Creamos conexion al DAO
		this.dao = dao;
	}
	
	public Articulo buscaArticulo(String id) {
		
		return dao.recupera(id);
		
	}
	
	public boolean agregaArticulo(String id, String descripcion , byte[] imagen,double PV ,double PM, double PA,int articulosTotales) {
		
		// Regla de negocio: RN-01 no puede haber dos libros con el mismo nombre
		if(dao.recupera(id) != null) 
			return false;
		
		Articulo articulo=new Articulo(id, descripcion, imagen,PV,PM,PA, articulosTotales);
		dao.crea(articulo);
		return true;
		
	}
	
	public boolean eliminaArticulo(String id) {
		
		java.util.Date k = new java.util.Date();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		String s="concha";
		byte[] img = s.getBytes();

		Articulo articulo=new Articulo(id, "",img, 4.4,5.5,9.9, 1);
		if(dao.borra(articulo) == true)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id;
		String descripcion;
		
		double precioVenta;
		double precioMayoreo;
		double precioAdquisicion;
		int articulosTotal;
		
		String s="concha";
		char a= 'E';
		byte[] img; //= s.getBytes();
		img=null;
		
		id= "mapache";
		descripcion="mapachegordo";
		precioVenta=2.3;
		precioMayoreo=6.6;
		precioAdquisicion=4.4;
		articulosTotal=3;
		
		DAOArticulo dao=new DAOArticuloBD();
		
		pruebas p=new pruebas(dao);
		
		boolean respuesta;
		
		System.out.println("1");
		respuesta=p.agregaArticulo(id, descripcion, img, precioVenta, precioMayoreo, precioAdquisicion, articulosTotal);
		System.out.println(respuesta);
		
		/*System.out.println("2");
		Articulo articulo= dao.recupera("mapache");
		System.out.println(articulo.getIdArticulo());*/
		
		System.out.println("3");
		respuesta=p.eliminaArticulo(id);
		System.out.println(respuesta);
		
		
		
		
		
	}

}
