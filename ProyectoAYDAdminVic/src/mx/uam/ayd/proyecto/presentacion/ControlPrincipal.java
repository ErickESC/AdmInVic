package mx.uam.ayd.proyecto.presentacion;

import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

/**
 * La clase ControlPrincipal controla la aplicacion
 *
 */
public class ControlPrincipal {

	// Ventana principal
	private VentanaPrincipal ventana;
	
	private ControlAgregarLibro controlAgregarLibro;
	private ControlListarCatalogo controlListarCatalogo;
	private ControlRezago controlRezago;
		

	public ControlPrincipal(ControlRezago controlRezago,ControlAgregarLibro controlAgregarLibro, ControlListarCatalogo controlListarCatalogo) {
		this.controlAgregarLibro = controlAgregarLibro;
		this.controlListarCatalogo = controlListarCatalogo;
		this.controlRezago=controlRezago;
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
		controlAgregarLibro.inicia();
		
	}
	
	public void prubea() {
		
		controlRezago.inicia();
		
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
