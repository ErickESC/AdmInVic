package mx.uam.ayd.proyecto.presentacion;


import mx.uam.ayd.proyecto.negocio.ServicioLibro;

public class ControlAgregarLibro {
	
	// La ventana
	private VentanaAgregarLibro ventana;
	
	// Servicio en la capa de negocio
	private ServicioLibro servicioLibro;
	
	public ControlAgregarLibro(ServicioLibro servicio) {
		this.servicioLibro = servicio;
	}
	
	public void inicia() {
		// Aquí inicia el caso de uso
		// 2. El sistema muestra la ventana de agregar libro
		ventana = new VentanaAgregarLibro(this);
		ventana.setVisible(true);
	}

	public void agregaLibro(String nombre, String autor) {
		
		// 3.- El usuario introduce los datos del libro

		// Verifica primero que los datos no esten vacios
		if(nombre.equals("") || autor.equals("") ) {
				ventana.muestraMensaje("Los campos no deben estar vacios");	
		} else {
			
			System.out.println("Agregando libro: "+nombre+" del autor:"+autor);
			
			// 4.- El sistema valida y muestra un mensaje de exito
			if(servicioLibro.agregaLibro(nombre,autor)) {
	        
				ventana.muestraMensaje("Se agrego libro exitosamente");
			} else {
				
				// Flujo alternativo en 3, si no se puede agregar, muestra un mensaje de error
				ventana.muestraMensaje( "Un libro con ese nombre ya existe o o se pudo agregar");
	
			}
			
			// 5. El sistema cierra la ventana y regresa a la ventana principal
			ventana.cierra();

		}
	}
	
}
