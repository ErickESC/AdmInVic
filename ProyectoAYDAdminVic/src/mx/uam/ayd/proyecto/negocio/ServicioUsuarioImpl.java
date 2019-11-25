package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;

import mx.uam.ayd.proyecto.presentacion.VistaEnviarArticulosResurtir;

public class ServicioUsuarioImpl implements ServicioUsuario{
	
	ArrayList<String> lista =new ArrayList<String>();
	ArrayList<Integer> cant =new ArrayList<Integer>();
	
	private VistaEnviarArticulosResurtir ventana;
	
	/**
	 * Permite actualizar un Articulo mientras exista ya un ArticuloEnAlmacen con el mismo id
	 * 	
	 * @param id
	 * @return true si se actualizo correctamente, false si no
	 */
	
	@Override
	public boolean realizaLista(ArrayList<String> ids, ArrayList<Integer> cants) {
		
		Formatter archivo=null;
		
		try {
			
			LocalDate hoy = LocalDate.now();
			
			archivo = new Formatter("/home/erick/Desktop/Lista"+hoy.getDayOfMonth()+hoy.getMonthValue()+hoy.getYear()+".txt");
			
			for(int i=0; i<lista.size();i++) {
				
				archivo.format("% s %d %n", lista.get(i),cant.get(i));
				
			}
			
		}catch(Exception e){
			System.out.println("Error: "+ e.toString());
		}finally{
			archivo.close();
		}
		return true;
		
	} 
	
	
	

}
