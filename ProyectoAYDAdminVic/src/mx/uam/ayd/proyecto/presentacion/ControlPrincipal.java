package mx.uam.ayd.proyecto.presentacion;

import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

/**
 * La clase ControlPrincipal controla la aplicacion
 *
 */
public class ControlPrincipal {

	// Ventana principal
	private VentanaPrincipal ventana;
	
	private ControlRezago controlRezago;
	private ControlEnviarProductoAResurtir controlResurtir;
		

	public ControlPrincipal(ControlRezago controlRezag, ControlEnviarProductoAResurtir controlResurtir) {
		this.controlRezago=controlRezago;
		this.controlResurtir=controlResurtir;
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
	
	public void Rezago() {
		
		controlRezago.inicia();
		
	}
	
	public void enviaLista() {
		
		controlResurtir.inicia();
		
	}

	/**
	 * Arranca la historia de usuario de listar catalogo
	 * 
	 */
	
	
	/**
	 * Termina la aplicación
	 */
	public void termina() {
		ManejadorBaseDatos.shutdown();
		System.exit(0);
	}
	
}
