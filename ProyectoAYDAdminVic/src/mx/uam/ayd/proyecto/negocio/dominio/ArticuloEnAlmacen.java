package mx.uam.ayd.proyecto.negocio.dominio;

import java.sql.Timestamp;

/**
 * @author erick
 *
 */
public class ArticuloEnAlmacen {
	
	private String idArticulo;
	private java.sql.Date fechaLlegada;
	private java.sql.Timestamp fechaPartida;
	private int articulosTotalesEnAlmacen;
	
	/*
	 * Constructor
	 * 
	 */
	
	public ArticuloEnAlmacen( String idArticulo, java.sql.Date fechaLlegada, java.sql.Timestamp fechaPartida, int articulosTotalesEnAlmacen) {
		
		this.idArticulo=idArticulo;
		this.fechaLlegada=fechaLlegada;
		this.fechaPartida=fechaPartida;
		this.articulosTotalesEnAlmacen=articulosTotalesEnAlmacen;

	}
	
	/*
	 * set's y get's
	 */
	
	//ARTICULO
	
	public void setIdArticulo(String newIdArticulo) {
		
		this.idArticulo=newIdArticulo;
		
	}
	
	public String getIdArticulo() {
		
		return this.idArticulo;
		
	}
	
	//FECHA LLEGADA
	
	public void setFechaLlegada(java.sql.Date newfechaLlegada) {
		
		this.fechaLlegada=newfechaLlegada;
		
	}
	
	public java.sql.Date getFechaLlegada() {
		
		return this.fechaLlegada;
		
	}
	
	//FECHA PARTIDA
	
	public void setFechaPartida(java.sql.Timestamp newFechaPartida) {
		
		this.fechaPartida=newFechaPartida;
		
	}
	
	public java.sql.Timestamp getFechaPartida() {
		
		return this.fechaPartida;
		
	}
	
	//ARTICULOS TOTALES EN ALMACEN
	
	
	public void setArticulosTotalesEnAlmacen(int newArticulosTotal) {
		
		this.articulosTotalesEnAlmacen=newArticulosTotal;
		
	}
	
	public int getArticulosTotalesEnAlmacen() {
		
		return this.articulosTotalesEnAlmacen;
		
	}

}
