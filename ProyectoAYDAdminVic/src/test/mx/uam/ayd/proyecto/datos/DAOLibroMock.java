package test.mx.uam.ayd.proyecto.datos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * Esta clase es un Mock (sustituto) para realizar pruebas unitarias
 * de módulos que dependen de DAOLibro
 * 
 * @author humbertocervantes
 *
 */
public class DAOLibroMock implements DAOLibro {

	private Map <String, Libro> libros = new HashMap <String, Libro>();
	
	@Override
	public boolean crea(Libro libro) {
		return (libros.put(libro.getNombre(),libro)!=null);
	}

	@Override
	public Libro recupera(String nombre) {
		return libros.get(nombre);
	}

	@Override
	public boolean actualiza(Libro libro) {
		return true;
	}

	@Override
	public ArrayList<Libro> recuperaTodos() {
		
		Collection <Libro> coll = libros.values();
		return new ArrayList<Libro>(coll);
	}

	
	@Override
	public boolean borra(Libro libro) {
		return (libros.remove(libro.getNombre())!=null);
	}


}
