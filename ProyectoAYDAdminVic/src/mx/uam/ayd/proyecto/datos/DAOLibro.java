package mx.uam.ayd.proyecto.datos;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * DAO Para la entidad libro
 * 
 * @author humbertocervantes
 *
 */
public interface DAOLibro {
	
	/**
	 * Este metodo permite agregar un libro a la libreria
	 * 
	 * @param libro el libro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Libro libro);
	
	/**
	 * Este metodo busca un libro a partir de su nombre
	 * 
	 * @param nombre el nombre del libro a buscar
	 * @return una referencia al libro o null si no se encontro
	 */
	public Libro recupera(String nombre);
	
	/**
	 * Actualiza libro
	 * 
	 * @param libro
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Libro libro);

	/**
	 * Retira un libro de la libreria
	 * 
	 * @param libro el libro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Libro libro);
	
	/**
	 * Regresa la lista de todos los libros
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Libro> recuperaTodos();


}
