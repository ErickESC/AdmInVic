package mx.uam.ayd.proyecto.presentacion;

import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

/**
 * La clase ControlPrincipal controla la aplicacion
 *
 */
public class ControlPrincipal {

	// Ventana principal
	private VentanaPrincipal ventana;
	
	private ControlListarCatalogo controlListarCatalogo;
	private ControlVenta controlVenta;
		

	public ControlPrincipal(
		ControlAgregarLibro controlAgregarLibro,
		ControlListarCatalogo controlListarCatalogo,
		ControlVenta controlVenta
	) {
		this.controlListarCatalogo = controlListarCatalogo;
		this.controlVenta = controlVenta;
	}
	
	/**
	 * Arranca el control principal y por lo tanto la aplicacion.
	 *
	 */
	public void inicia() {
		
		
		// Crea la ventana principal y la muestra
		ventana = new VentanaPrincipal(this);
		ventana.setVisible(true);
	}	

	/**
	 * Arranca la historia de usuario de agregar libro
	 */
	public void agregarLibro() {
		controlVenta.inicia();
		
	}

	/**
	 * Arranca la historia de usuario de listar catalogo
	 * 
	 */
	public void listarCatalogo() {
		controlListarCatalogo.inicia();
	}
	
	/**
	 * Termina la aplicación
	 */
	public void termina() {
		ManejadorBaseDatos.shutdown();
		System.exit(0);
	}
	
}
