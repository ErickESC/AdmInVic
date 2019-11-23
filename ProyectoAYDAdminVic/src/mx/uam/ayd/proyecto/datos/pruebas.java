package mx.uam.ayd.proyecto.datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String id;
		String descripcion;
		
		double precioVenta;
		double precioMayoreo;
		double precioAdquisicion;
		int articulosTotal;
		
		String s="concha";
		char a= 'E';
		byte[] img= s.getBytes();
		//img=null;
		
		id= "mapache";
		descripcion="mapachegordo";
	
		java.io.File fichero = new java.io.File("/home/erick/Desktop/mapache.txt");
		FileInputStream ficheroStream = new FileInputStream(fichero);
		byte contenido[] = new byte[(int)fichero.length()];
		ficheroStream.read(contenido);
		
		DAOArticulo dao=new DAOArticuloBD();
		
		pruebas p=new pruebas(dao);
		
		boolean respuesta;
		
		
		System.out.println("COMIENZA PRUEBA PARA DAOARTICULO");
		System.out.println("1");
		respuesta=p.agregaArticulo("mapache", "mapachegordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		
		System.out.println("2");
		Articulo articulo= dao.recupera("mapache");
		System.out.println(articulo.getIdArticulo());
		
		System.out.println("3");
		respuesta=p.eliminaArticulo(id);
		System.out.println(respuesta);
		
		
		
		
		
		
		
	}

}
