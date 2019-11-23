package mx.uam.ayd.proyecto.datos;

import java.util.List;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * DAOArticulo
 */
public interface DAOArticulo {

    /**
	 * Este metodo permite agregar un articulo a la BD
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Articulo articulo);
	
	/**
	 * Este metodo busca un articulo a partir de su nombre
	 * 
	 * @param nombre el nombre del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	public Articulo recupera(String nombre);
	
	/**
	 * Actualiza articulo
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	public boolean actualiza(Articulo articulo);

	/**
	 * Retira un articulo de la libreria
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Articulo articulo);
	
	/**
	 * Regresa la lista de todos los articulos
	 * 
	 * @return un ArrayList con todos los articulos de la libreria
	 */
    public List<Articulo> recuperaTodos();
    
}