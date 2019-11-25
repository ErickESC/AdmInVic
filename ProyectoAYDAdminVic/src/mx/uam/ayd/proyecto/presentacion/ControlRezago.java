package mx.uam.ayd.proyecto.presentacion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.proyecto.negocio.ServicioAlmacen;
import mx.uam.ayd.proyecto.negocio.ServicioArticulo;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
/*
 * @author Erick
 * 
 */
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

public class ControlRezago extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// La ventana
	private VistaRezago ventana;
	
	// Servicio en la capa de negocio
	private ServicioAlmacen servicioAlmacen;
	private ServicioArticulo servicioArticulo;
	
	DefaultTableModel modelo= new DefaultTableModel();
	
    ArrayList<String> lista =new ArrayList<String>();
    ArrayList<Double> listadescuento =new ArrayList<Double>(); 
	
    /*
     * 
     * Constructor
     * 
     */
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
	
	public void generaListaRezago(Date max, Date min, JTable tabla){
		
		
		java.util.Map <Articulo, String> rezagados=new HashMap <Articulo, String>();
		
		
		rezagados=(Map<Articulo, String>) servicioAlmacen.consultaRezago(max, min);
	
		
		if(rezagados.isEmpty()) {
			
			ventana.muestraMensaje("No hay rezagos en ese lapso");
			return;
			
		}
		
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIP");
		modelo.addColumn("CANT");
		modelo.addColumn("F.REG");
		modelo.addColumn("P.VENTA");
		modelo.addColumn("DESC(%)");
		modelo.addColumn("P.DESC");
		
		
		Iterator it = rezagados.keySet().iterator();
		
		while(it.hasNext()) {
			
			Articulo key = (Articulo) it.next();
			ArticuloEnAlmacen art=(ArticuloEnAlmacen) servicioAlmacen.buscaArticuloEnAlmacen(key.getIdArticulo());
			double desc=(100-Double.parseDouble(rezagados.get(key))*100)/key.getPrecioVenta();
			modelo.addRow(new Object[] {key.getIdArticulo(),key.getDescripcion(),key.getArticulosTotal(),
					                    art.getFechaLlegada(),key.getPrecioVenta(),
					                    desc,rezagados.get(key)});	
		}
		
		tabla.setModel(modelo);
		
	}
	
	/*public void generaPrueba( JTable tabla) {
		
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIP");
		modelo.addColumn("CANT");
		modelo.addColumn("F.REG");
		modelo.addColumn("P.VENTA");
		modelo.addColumn("DESC(%)");
		modelo.addColumn("P.DESC");
		
		modelo.addRow(new Object[] {"M","A","P","A","C","H","E"});
		
		tabla.setModel(modelo);
		
	}*/
	
	public void GeneraDescuentos() {
		 
		boolean respuesta;
		
		if(lista.isEmpty()) {
			
			ventana.muestraMensaje("Lista Vacia");
			return;
			
		}
		
		for(int j=0;j<lista.size();j++) {
			
			
			
			Articulo articulo=servicioArticulo.buscaArticulo(lista.get(j));
			
			
			
			respuesta=servicioArticulo.realizaDescuentos(articulo.getIdArticulo(),articulo.getDescripcion(),articulo.getImagen(),
                    									 listadescuento.get(j), articulo.getPrecioMayoreo(),articulo.getPrecioAdquisicion(),
                    									 articulo.getArticulosTotal());
			
			if(respuesta==false) {
				  
				  ventana.muestraMensaje("Ocurrio un error al realizar los descuentos");
				  return;
				    
			  }
			
			
		}
		
		ventana.muestraMensaje("Descuentos aplicados con exito");
		lista.clear();
		listadescuento.clear();
	}
	
	
	
	public void agregaALista(String id, String precio) {
		
		if(id=="" || precio=="") {
			
			ventana.muestraMensaje("Seleccione un articulo");
			return;
			
		}
		
		if(!lista.contains(id)) {
			
			lista.add(id);
			listadescuento.add(Double.parseDouble(precio));
			ventana.muestraMensaje("Articulo agregado con exito");
			
		}else
		ventana.muestraMensaje("Articulo ya agregado anteriormente");
		
		
	}
	
	public void eliminaDeLista(String id, String precio) {
		
		
		if(id=="" || precio=="") {
			
			ventana.muestraMensaje("Seleccione un articulo");
			return;
			
		}
		if(lista.contains(id)) {
			
			listadescuento.remove(lista.indexOf(id));
			lista.remove(id);
			ventana.muestraMensaje("Articulo retirado de la lista");
			
		}else
		ventana.muestraMensaje("Articulo ya retirado anteriormente");
		
		
	}

}
