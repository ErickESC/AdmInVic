package mx.uam.ayd.proyecto.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Libro;

/**
 * 
 * Implementacion de DAOLibro que se conecta con una base de datos relacional
 * 
 * @author humbertocervantes
 *
 */
public class DAOLibroBD implements DAOLibro {
	
	/**
	 * Este metodo permite agregar un libro a la libreria
	 * 
	 * @param libro el libro a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Libro libro) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Libro VALUES (DEFAULT,'"+libro.getNombre()+"','"+libro.getAutor()+"')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    int llave = rs.getInt(1);
			    libro.setId(llave); // Asigna la llave al libor
			}
				
					
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}

	}
	
	/**
	 * Este metodo busca un titulo
	 * 
	 * @param nombre el nombre del titulo a buscar
	 * @return una referencia al Titulo o null si no se encontro
	 */
	public Libro recupera(String nombre) {
		Libro libro = null;
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Libro WHERE nombre = '"+nombre+"'");
			
			if(rs.next())
			{
				libro = new Libro();
				libro.setNombre(rs.getString("nombre"));
				// Nota el campo asociado al nodo padre no se asigna aqui
				libro.setAutor(rs.getString("autor"));
				libro.setId(Integer.parseInt(rs.getString("id")));
			}
			
			return libro;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retira un libro de la libreria
	 * 
	 * @param libro el libro a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Libro libro) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Libro WHERE nombre = '"+libro.getNombre()+"'");

			
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los libros
	 * 
	 * @return un ArrayList con todos los libros de la libreria
	 */
	public ArrayList<Libro> recuperaTodos() {

		ArrayList <Libro> libros = new ArrayList<Libro>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Libro");

			
			while(rs.next())
			{
				Libro libro = new Libro();
				libro.setNombre(rs.getString("nombre"));
				libro.setAutor(rs.getString("autor"));

				libros.add(libro);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return libros;

	}	
	
	/**
	 * 
	 */
	public boolean actualiza(Libro libro) {
		// FALTA IMPLEMENTARLO
		return true;
	}

}
