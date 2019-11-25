package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;

import mx.uam.ayd.proyecto.datos.Correo;
import mx.uam.ayd.proyecto.datos.controlador;
import mx.uam.ayd.proyecto.presentacion.VistaEnviarArticulosResurtir;

public class ServicioUsuarioImpl implements ServicioUsuario{
	
	ArrayList<String> lista =new ArrayList<String>();
	ArrayList<Integer> cant =new ArrayList<Integer>();
	
	private VistaEnviarArticulosResurtir ventana;
	
	private Correo c=new Correo();
	
	private String nombreArchivo;
	private String rutaArchivo;
	
	
	/**
	 * crea un archivo con la lista de articulos a resurtir
	 * 	
	 * @param lista de id's y lista de cantidades
	 * @return true si se realizo correctamente, false si no
	 */
	
	@Override
	public boolean realizaLista(ArrayList<String> ids, ArrayList<Integer> cants) {
		
		Formatter archivo=null;
		
		try {
			
			LocalDate hoy = LocalDate.now();
			
			archivo = new Formatter("/home/erick/Desktop/Lista"+hoy.getDayOfMonth()+hoy.getMonthValue()+hoy.getYear()+".txt");
			this.rutaArchivo=("/home/erick/Desktop/");
			this.nombreArchivo=("Lista"+hoy.getDayOfMonth()+hoy.getMonthValue()+hoy.getYear()+".txt");
			for(int i=0; i<lista.size();i++) {
				
				archivo.format("% s %d %n", lista.get(i),cant.get(i));
				
			}
			
			archivo.close();
			
		}catch(Exception e){
			System.out.println("Error: "+ e.toString());
			return false;
		}
		
		enviarCorreo();
		
		return true;
	} 
	
	/**
	 * envia un correo con la lista
	 * 	
	 * 
	 */
	
	public void enviarCorreo() {
		
		c.setContrasenia("gfxxcvtwttwudtgq");
		c.setUsuario("eekoston@gmail.com");
		c.setAsunto("Lista A Resurtir");
		c.setDestino("eekoston@gmail.com");
		c.setNombreArchivo(nombreArchivo);
		c.setRutaArchivo(rutaArchivo);
		controlador m=new controlador();
		if(m.enviarCorreo(c)) {
			
			ventana.muestraMensaje("Correo enviado con exito");
			
		}else {
			ventana.muestraMensaje("Error al enviar correo");
		}
		
		
	}
	
	

}
