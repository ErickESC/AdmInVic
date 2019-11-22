package mx.uam.ayd.proyecto.presentacion;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * Control para la historia de usuario Listar Catalogo
 * 
 * @author humbertocervantes
 *
 */
public class ControlListarCatalogo {
	
	private ServicioLibro servicioLibro;
	
	public ControlListarCatalogo(ServicioLibro servicioLibro) {
		this.servicioLibro = servicioLibro;
	}
	
	
	public void inicia() {
		
		// OJO: ESTE CODIGO SOLO ES PARA DEMOSTRAR LA FUNCIONALIDAD, NO DEBE IR AQUI
		ArrayList<Libro> libros = servicioLibro.dameLibros();
		
		for(Libro l:libros) {
			System.out.println(l.getDescripcion());
		}
	}

}
