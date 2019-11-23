package mx.uam.ayd.proyecto.presentacion;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import mx.uam.ayd.proyecto.negocio.ServicioAlmacen;
import mx.uam.ayd.proyecto.negocio.ServicioArticulo;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
/*
 * @author Erick
 * 
 */
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

public class ControlRezago {
	
	// La ventana
	private VistaRezago ventana;
	
	// Servicio en la capa de negocio
	private ServicioAlmacen servicioAlmacen;
	private ServicioArticulo servicioArticulo;
	
	public ControlRezago(ServicioAlmacen servicioAlmacen, ServicioArticulo servicioArticulo) {
		this.servicioAlmacen = servicioAlmacen;
		this.servicioArticulo=servicioArticulo;
	}
	
	public void inicia() {
		// Aquí inicia el caso de uso
		// 2. El sistema muestra la ventana de agregar libro
		ventana = new VistaRezago(this);
		ventana.setVisible(true);
	}
	
	public Map <ArticuloEnAlmacen, String> generaListaRezago(Date max, Date min){
		
		java.util.Map <ArticuloEnAlmacen, String> descuento=new HashMap <ArticuloEnAlmacen, String>();
		
		descuento=servicioAlmacen.consultaRezago(max, min);
		
		return descuento;
		
	}
	
	
	

}
