package mx.uam.ayd.proyecto.datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Date;

public class pruebas {
	
	private DAOArticulo dao;
	private DAOArticuloEnAlmacen daoAlmacen;
	
	public pruebas(DAOArticulo dao,DAOArticuloEnAlmacen daoAlmacen) {
		// Creamos conexion al DAO
		this.dao = dao;
		this.daoAlmacen=daoAlmacen;
	}
	/*
	 * 
	 * Prueba de DAOAlmacen
	 * 
	 * 
	 * 
	 */
	
	public ArticuloEnAlmacen buscaArticuloEnAlmacen(String id) {
		
		return daoAlmacen.recupera(id);
		
	}
	
	public boolean agregaArticuloEnAlmacen(String id, Date fechaRegistro, Timestamp fechaPartida, int articulosTotales) {
		
		// Regla de negocio: RN-01 no puede haber dos articulos con el mismo nombre debe agregarse a cantidad
		if(daoAlmacen.recupera(id) != null) 
			return false;
		
		ArticuloEnAlmacen articulo=new ArticuloEnAlmacen(id, fechaRegistro, fechaPartida, articulosTotales);
		daoAlmacen.crea(articulo);
		return true;
	}
	
	public boolean eliminaArticuloEnAlmacen(String id) {
		
		Date k = null;
		Timestamp t = null;
		ArticuloEnAlmacen articulo=new ArticuloEnAlmacen(id, k, t, 1);
		if(daoAlmacen.borra(articulo) == true)
			return true;
		
		return false;
	}
	
	
	/*
	 * 
	 * Prueba de DAOArticulo
	 * 
	 * 
	 */
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
		DAOArticuloEnAlmacen daoAlmacen=new DAOArticuloEnAlmacenBD();
		
		pruebas p=new pruebas(dao, daoAlmacen);
		
		boolean respuesta;
		
		/*ArrayList<String> lista=new ArrayList<String>();
		lista.add("M");
		System.out.println(lista.get(0));*/
		
		/*System.out.println("COMIENZA PRUEBA PARA DAOARTICULO");
		System.out.println("1");
		respuesta=p.agregaArticulo("mapache", "mapachegordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticulo("gato", "gatogordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticulo("perro", "perrogordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);*/
		
		
		System.out.println("2");
		Articulo articulo= dao.recupera("mapache");
		System.out.println(articulo.getIdArticulo() +"   "+articulo.getPrecioVenta());
		System.out.println("2");
		Articulo art= dao.recupera("gato");
		System.out.println(art.getIdArticulo());
		System.out.println("2");
		Articulo alo= dao.recupera("perro");
		System.out.println(alo.getIdArticulo());
		
		/*System.out.println("COMIENZA PRUEBA PARA DAOAlmacen");
		System.out.println("1");
		Date date = new Date(0);
		//Caso 1: obtener la hora y salida por pantalla con formato:
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yy");
		dateFormat.format(date);
		respuesta=p.agregaArticuloEnAlmacen("mapache", date, null, 5);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticuloEnAlmacen("gato", date, null, 5);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticuloEnAlmacen("perro", date, null, 5);
		System.out.println(respuesta);*/
		
		
		/*System.out.println("3");
		respuesta=p.eliminaArticulo("mapache");
		System.out.println(respuesta);*/
		
		
		
		
		
		
		
	}

}
