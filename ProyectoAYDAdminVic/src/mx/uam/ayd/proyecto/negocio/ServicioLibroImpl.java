package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;

import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.negocio.dominio.Libro;

public class ServicioLibroImpl implements ServicioLibro {
	private DAOLibro daoLibro;
	
	public ServicioLibroImpl(DAOLibro dao) {
		// Creamos conexion al DAO
		this.daoLibro = dao;
	}
	
	public Libro buscaLibro(String nombre) {
		// Si hubiera lógica de negocio se aplicaría aquí
		return daoLibro.recupera(nombre);
	}
	
	public boolean agregaLibro(String nombre, String autor) {
		
		// Regla de negocio: RN-01 no puede haber dos libros con el mismo nombre
		if(daoLibro.recupera(nombre) != null) 
			return false;

		// No hay dos libros, creamos el libro
		Libro libro = new Libro();
		libro.setNombre(nombre);
		libro.setAutor(autor);
		
		// Le pedimos al DAO que lo almacene
		return daoLibro.crea(libro);
	

	}
	
	public  ArrayList<Libro> dameLibros() {
		return daoLibro.recuperaTodos();
	}

}

