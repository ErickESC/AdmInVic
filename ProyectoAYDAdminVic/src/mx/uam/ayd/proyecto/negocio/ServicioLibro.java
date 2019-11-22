package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * 
 * Modulo con la logica de negocio de Libros
 * 
 * @author humbertocervantes
 *
 */
public interface ServicioLibro {
	
	/**
	 * Recupera un libro a partir de su nombre
	 * 
	 * @param nombre
	 * @return Libro o null
	 */
	public Libro buscaLibro(String nombre);
	
	/**
	 * Permite agregar un libro mientras no exista ya un libro con el mismo nombre
	 * 	
	 * @param nombre
	 * @param autor
	 * @return true si se agrego correctamente, false si no
	 */
	public boolean agregaLibro(String nombre, String autor); 
	
	/**
	 * Permite recuperar los libros
	 * 
	 * @return arreglo con libors
	 */
	public  ArrayList<Libro> dameLibros();


}
