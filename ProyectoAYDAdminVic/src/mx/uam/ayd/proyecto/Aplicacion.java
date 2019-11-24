package mx.uam.ayd.proyecto;

import mx.uam.ayd.proyecto.configuracion.ConfiguracionBD;
import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloBD;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnStock;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnStockBD;
import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.datos.DAOLibroBD;
import mx.uam.ayd.proyecto.datos.DAOUsuario;
import mx.uam.ayd.proyecto.datos.DAOUsuarioBD;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.ServicioLibroImpl;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.ServicioUsuarioImpl;
import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.ServicioVentaImpl;
import mx.uam.ayd.proyecto.presentacion.ControlAgregarLibro;
import mx.uam.ayd.proyecto.presentacion.ControlListarCatalogo;
import mx.uam.ayd.proyecto.presentacion.ControlLogin;
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
	private static DAOArticuloEnStock daoArticuloEnStock;
	private static ControlAgregarLibro controlAgregarLibro;
	private static ControlListarCatalogo controlListarCatalogo;
	private static ControlPrincipal controlPrincipal;
	private static ControlVenta controlVenta;
	private static ControlLogin controlLogin;
	private static ServicioUsuario servicioUsuario;
	private static DAOUsuario daoUsuario;
	
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
		daoArticuloEnStock = new DAOArticuloEnStockBD(ConfiguracionBD.PRODUCCION);
		daoUsuario = new DAOUsuarioBD(ConfiguracionBD.PRODUCCION);

		servicioLibro = new ServicioLibroImpl(daoLibro);
		servicioVenta = new ServicioVentaImpl(daoArticulo, daoArticuloEnStock);
		servicioUsuario = new ServicioUsuarioImpl(daoUsuario);
		controlAgregarLibro = new ControlAgregarLibro(servicioLibro);
		controlListarCatalogo = new ControlListarCatalogo(servicioLibro);
		controlVenta = new ControlVenta(servicioVenta);
		controlLogin = new ControlLogin(servicioUsuario);
		
		controlPrincipal = new ControlPrincipal(
			controlAgregarLibro,
			controlListarCatalogo,
			controlVenta,
			controlLogin
		);

	}
	

}