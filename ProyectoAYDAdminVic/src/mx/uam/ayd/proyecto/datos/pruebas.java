package mx.uam.ayd.proyecto.datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public ArrayList<ArticuloEnAlmacen> recuperaLapso(Date max, Date min) {
		
		ArrayList <ArticuloEnAlmacen> articulos = new ArrayList<ArticuloEnAlmacen>();
		
		try{
			
			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnAlmacen "
                    + "WHERE  (fechaRegistro <= '"+ max
                    + "' AND fechaRegistro >='"+ min
                    + "') AND articulosTotalesEnAlmacen > 0");
					                            

			
			while(rs.next())
			{
				
				ArticuloEnAlmacen articulo = new ArticuloEnAlmacen(rs.getString(1), rs.getDate(2), rs.getTimestamp(3), rs.getInt(4));
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}
	
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
		
		System.out.println("COMIENZA PRUEBA PARA DAOARTICULO");
		System.out.println("1");
		respuesta=p.agregaArticulo("leon", "leongordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticulo("lobo", "lobogordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticulo("oso", "osogordo", null, 7.0, 9.0, 9.8, 10);
		System.out.println(respuesta);
		
		
		/*System.out.println("2");
		Articulo articulo= dao.recupera("mapache");
		System.out.println(articulo.getIdArticulo() +"   "+articulo.getPrecioVenta());
		System.out.println("2");
		Articulo art= dao.recupera("gato");
		System.out.println(art.getIdArticulo());
		System.out.println("2");
		Articulo alo= dao.recupera("perro");
		System.out.println(alo.getIdArticulo());*/
		
		System.out.println("COMIENZA PRUEBA PARA DAOAlmacen");
		System.out.println("1");
		
		//Caso 1: obtener la hora y salida por pantalla con formato:
		int x=2019;
		java.sql.Date date=new  java.sql.Date(119,11,06);
		java.sql.Date date1=new  java.sql.Date(119,11,01);
		java.sql.Timestamp time=new java.sql.Timestamp(2019, 11, 05, 03, 01, 01, 00);
		respuesta=p.agregaArticuloEnAlmacen("leon", date, time, 5);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticuloEnAlmacen("lobo", date, time, 5);
		System.out.println(respuesta);
		System.out.println("1");
		respuesta=p.agregaArticuloEnAlmacen("oso", date, time, 5);
		System.out.println(respuesta);
		
		
		/*System.out.println("3");
		respuesta=p.eliminaArticulo("mapache");
		System.out.println(respuesta);*/
		System.out.println(date);
		//System.out.println(x);
		
		ArrayList <ArticuloEnAlmacen> articulos = new ArrayList<ArticuloEnAlmacen>();
		articulos=p.recuperaLapso(date, date1);
		for(int k=0;k<articulos.size();k++) {
			
			System.out.println(articulos.get(k).getIdArticulo());
			//System.out.println(articulos.get(k).getFechaLlegada());
			
			
			
		}
		
		
		
		
		
		
	}

}
