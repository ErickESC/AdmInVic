package mx.uam.ayd.proyecto.presentacion;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.datos.DAOArticuloEnAlmacen;
import mx.uam.ayd.proyecto.negocio.ServicioAlmacen;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

public class ControlEnviarProductoAResurtir {
	
	private static final long serialVersionUID = 1L;
	
	ServicioUsuario servicioUsuario;
	ServicioAlmacen servicioAlmacen;
	
	private VistaEnviarArticulosResurtir ventana;
	
	ArrayList<String> lista =new ArrayList<String>();
	ArrayList<Integer> cant =new ArrayList<Integer>();
	
	public ControlEnviarProductoAResurtir(ServicioUsuario servicio,ServicioAlmacen servicioAlmacen ) {
		
		this.servicioUsuario=servicio;
		this.servicioAlmacen= servicioAlmacen;
		
	}
	
	/*
	 * 
	 * inicia la ventana
	 * 
	 */
	
	public void inicia() {
		// Aquí inicia el caso de uso
		// 2. El sistema muestra la ventana de Enviar producto a resurtir
		ventana = new VistaEnviarArticulosResurtir(this);
		ventana.setVisible(true);
	}
	
	/*
	 * 
	 * agrega de a lista el objeto selecionado
	 * 
	 */
	
	public void agregaALista(String id, String cantidad) {
		
		if(lista.contains(id)) {
			
			ventana.muestraMensaje("articulo ya agregado");
			return;
			
		}else {
			
			lista.add(id);
			cant.add(Integer.parseInt(cantidad));
			ventana.muestraMensaje("articulo agregado a lista");
		}
	}
	
	/*
	 * 
	 * elimina de la lista el objeto selecionado
	 * 
	 */
	
	public void eliminaDeLista(String id) {
		
		if(lista.contains(id)) {
			
			cant.remove(lista.indexOf(id));
			lista.remove(id);
			ventana.muestraMensaje("Articulo eliminado de lista");
			
		}else
			ventana.muestraMensaje("Articulo eliminado anteriormente lista");
		
	}
	
	/*
	 * 
	 * genera la lista de articulos
	 * 
	 */
	
	public void enviarLista() {
		
		boolean respuesta;
		respuesta =servicioUsuario.realizaLista(lista, cant);
		if(respuesta) {
			ventana.muestraMensaje("lista enviada con exito");
		}
		
		for(int i=0;i<lista.size();i++) {
			
			ArticuloEnAlmacen articulo=servicioAlmacen.buscaArticuloEnAlmacen(lista.get(i));
			servicioAlmacen.atualizaArticuloEnAlmacen(articulo.getIdArticulo(), articulo.getFechaLlegada(), 
					                                  articulo.getFechaPartida(), articulo.getArticulosTotalesEnAlmacen()-cant.get(i));
			
		}
		
	}
	
	

}
