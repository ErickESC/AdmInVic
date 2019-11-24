package mx.uam.ayd.proyecto.presentacion;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mx.uam.ayd.proyecto.negocio.ServicioAlmacen;
import mx.uam.ayd.proyecto.negocio.ServicioArticulo;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
/*
 * @author Erick
 * 
 */
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

public class ControlRezago extends javax.swing.JFrame {
	
	// La ventana
	private VistaRezago ventana;
	
	// Servicio en la capa de negocio
	private ServicioAlmacen servicioAlmacen;
	private ServicioArticulo servicioArticulo;
	
	DefaultTableModel modelo= new DefaultTableModel();
	
    ArrayList<ArticuloEnAlmacen> almacen=new ArrayList<ArticuloEnAlmacen>();
    java.util.Map <ArticuloEnAlmacen, String> descuento=new HashMap <ArticuloEnAlmacen, String>();
    java.util.Map <Articulo, String> articulos=new HashMap <Articulo, String>();
    ArrayList<String> lista =new ArrayList<String>();
    ArrayList<String> listaprecio =new ArrayList<String>(); 
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
		
		java.util.Map <ArticuloEnAlmacen, String> rezagados=new HashMap <ArticuloEnAlmacen, String>();
		
		rezagados=(Map<ArticuloEnAlmacen, String>) servicioAlmacen.consultaRezago(max, min);
		
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIP");
		modelo.addColumn("CANT");
		modelo.addColumn("F.REG");
		modelo.addColumn("P.VENTA");
		modelo.addColumn("DESC(%)");
		modelo.addColumn("P.DESC");
		
		
		/*Iterator it = rezagados.keySet().iterator();
		int i=0;
		while(it.hasNext()) {
			
			//Iterator itd = descuento.keySet().iterator();
			ArticuloEnAlmacen key = (ArticuloEnAlmacen) it.next();
			Articulo art=(Articulo) servicioArticulo.buscaArticulo(key.getIdArticulo());
			double desc=(Double.parseDouble(rezagados.get(key))*100)/art.getPrecioVenta();
			modelo.addRow(new Object[] {art.getIdArticulo(),art.getDescripcion(),
					                    key.getFechaLlegada(),art.getPrecioVenta(),
					                    desc,rezagados.get(key)});	
		}*/
		
		modelo.addRow(new Object[] {"M","A","P","A","C","H","E"});
		
		tabla.setModel(modelo);
		
	}
	
	public void generaPrueba( JTable tabla) {
		
		modelo.addColumn("ID");
		modelo.addColumn("DESCRIP");
		modelo.addColumn("CANT");
		modelo.addColumn("F.REG");
		modelo.addColumn("P.VENTA");
		modelo.addColumn("DESC(%)");
		modelo.addColumn("P.DESC");
		
		modelo.addRow(new Object[] {"M","A","P","A","C","H","E"});
		
		tabla.setModel(modelo);
		
		/*java.util.Date fecha = new Date();
		System.out.println (fecha);*/
		
	}
	
	public void GeneraDescuentos(HashMap <ArticuloEnAlmacen, String> listaAplicables) {
		
		ArrayList<Articulo> listaAplicados= new ArrayList<Articulo>();
		
		Iterator it = listaAplicables.keySet().iterator();
		int i=0;
		while(it.hasNext()){
		  ArticuloEnAlmacen key = (ArticuloEnAlmacen) it.next();
		  listaAplicados.set(i, servicioArticulo.buscaArticulo(key.getIdArticulo()));
		  listaAplicados.get(i).setPrecioVenta(Integer.parseInt(listaAplicables.get(key)));
		  servicioArticulo.realizaDescuentos(listaAplicados.get(i).getIdArticulo(), 
				                             listaAplicados.get(i).getDescripcion(), 
				                             listaAplicados.get(i).getImagen(), 
				                             listaAplicados.get(i).getPrecioVenta(), 
				                             listaAplicados.get(i).getPrecioMayoreo(), 
				                             listaAplicados.get(i).getPrecioAdquisicion(), 
				                             listaAplicados.get(i).getArticulosTotal());
		  i++;
		}	
	}
	
	
	
	public void agregaALista(String id, String precio) {
		
		if(!lista.contains(id)) {
			
			lista.add(id);
			listadescuento.add(Double.parseDouble(precio));
			ventana.muestraMensaje("Articulo agregado con exito");
			
		}
		ventana.muestraMensaje("Articulo ya agregado anteriormente");
		
		
	}
	
	public void eliminaDeLista(String id, String precio) {
		
		if(lista.contains(id)) {
			
			lista.remove(id);
			listadescuento.remove(Double.parseDouble(precio));
			ventana.muestraMensaje("Articulo retirado de la lista");
			
		}
		ventana.muestraMensaje("Articulo ya retirado anteriormente");
		
		
	}
	
	public void aplicarDescuento() {
		
		
		
	}
	
	public void pasaLista(ArrayList<String> ids, ArrayList<String> precios) {
		
		
		
	}
	

}
