package mx.uam.ayd.proyecto;

import mx.uam.ayd.proyecto.configuracion.ConfiguracionBD;
import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloBD;
import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.datos.DAOLibroBD;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.ServicioLibroImpl;
import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.ServicioVentaImpl;
import mx.uam.ayd.proyecto.presentacion.ControlAgregarLibro;
import mx.uam.ayd.proyecto.presentacion.ControlListarCatalogo;
import mx.uam.ayd.proyecto.presentacion.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.ControlVenta;

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
	private static DAOArticulo daoArticulo;
	private static ServicioLibro servicioLibro;
	private static ServicioVenta servicioVenta;
	private static ControlAgregarLibro controlAgregarLibro;
	private static ControlListarCatalogo controlListarCatalogo;
	private static ControlPrincipal controlPrincipal;
	private static ControlVenta controlVenta;
	
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
		daoArticulo = new DAOArticuloBD(ConfiguracionBD.PRODUCCION);

		/* Articulo atr = new Articulo();
		atr.setIdArticulo("abc002");
		atr.setDescripcion("Ejemplo para test");
		atr.setArticulosTotales(10);
		atr.setImagen(null);
		atr.setPrecioAdquicicion(5.5f);
		atr.setPrecioMayoreo(8.5f);
		atr.setPrecioVenta(15.45f);
		System.out.println(daoArticulo.crea(atr)); */
		// System.out.println(daoArticulo.recupera("abc002"));

		servicioLibro = new ServicioLibroImpl(daoLibro);
		servicioVenta = new ServicioVentaImpl(daoArticulo);
		controlAgregarLibro = new ControlAgregarLibro(servicioLibro);
		controlListarCatalogo = new ControlListarCatalogo(servicioLibro);
		controlVenta = new ControlVenta(servicioVenta);
		
		controlPrincipal = new ControlPrincipal(
			controlAgregarLibro,
			controlListarCatalogo,
			controlVenta
		);

	}
	

}