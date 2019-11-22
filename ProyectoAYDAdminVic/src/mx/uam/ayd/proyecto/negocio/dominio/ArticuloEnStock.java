package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * @author erick
 *
 */

public class ArticuloEnStock {
	
	private String idArticulo;
	private java.sql.Date fechaLlegada;
	private int articulosTotalesEnStock;
	
	/*
	 * Constructor
	 * 
	 */
	
	public ArticuloEnStock( String idArticulo, java.sql.Date fechaLlegada, int articulosTotalesEnStock) {
		
		this.idArticulo=idArticulo;
		this.fechaLlegada=fechaLlegada;
		this.articulosTotalesEnStock=articulosTotalesEnStock;

	}
	
	/*
	 * set's y get's
	 */
	
	//ARTICULO En Stock
	
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
	
	//ARTICULOS TOTALES EN Stock
	
	
	public void setArticulosTotalesEnStock(int newArticulosTotal) {
		
		this.articulosTotalesEnStock=newArticulosTotal;
		
	}
	
	public int getArticulosTotalesEnStock() {
		
		return this.articulosTotalesEnStock;
		
	}

}
