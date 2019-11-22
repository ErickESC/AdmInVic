package mx.uam.ayd.proyecto;

import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.datos.DAOLibroBD;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.ServicioLibroImpl;
import mx.uam.ayd.proyecto.presentacion.ControlAgregarLibro;
import mx.uam.ayd.proyecto.presentacion.ControlListarCatalogo;
import mx.uam.ayd.proyecto.presentacion.ControlPrincipal;

/**
 * 
 * Clase principal que arranca la aplicacion
 * 
 * @author humbertocervantes
 *
 */
public class Aplicacion {
	
	// Modulos de la aplicacion
	private static DAOLibro daoLibro;
	private static ServicioLibro servicioLibro;
	private static ControlAgregarLibro controlAgregarLibro;
	private static ControlListarCatalogo controlListarCatalogo;
	private static ControlPrincipal controlPrincipal;
	
	/**
	 * Arranca la aplicación
	 * 
	 * @param args argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		
		creaYConectaModulos();

		controlPrincipal.inicia();
	}
	
	/**
	 * Conecta los modulos de la aplicacion.
	 *
	 */
	private static void creaYConectaModulos() {
		// Conecta los modulos
		daoLibro = new DAOLibroBD();
		servicioLibro = new ServicioLibroImpl(daoLibro);
		controlAgregarLibro = new ControlAgregarLibro(servicioLibro);
		
		controlListarCatalogo = new ControlListarCatalogo(servicioLibro);
		
		controlPrincipal = new ControlPrincipal(controlAgregarLibro, controlListarCatalogo);

	}
	

}