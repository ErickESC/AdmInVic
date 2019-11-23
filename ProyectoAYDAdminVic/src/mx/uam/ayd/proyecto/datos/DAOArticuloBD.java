package mx.uam.ayd.proyecto.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * DAOArticuloDB
 */
public class DAOArticuloBD implements DAOArticulo {

	private String nombreBD;
	private Statement statement = null;

	/**
	 * Constructor del DAO 
	 * @param baseDeDatos Es el nombre de la base de datos a la que deseamos conectarnos
	 */
	public DAOArticuloBD (String baseDeDatos ) {
		nombreBD = baseDeDatos;
		try {
			statement = ManejadorBaseDatos.getConnection(nombreBD).createStatement();
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

    /**
	 * Metodo para insertar un nuevo Articulo a la Base de datos
	 * @param articulo que deseamos insertar
	 * @return true si se creo exitosamente, false sino
	 */
	public boolean crea(Articulo articulo) {
		try {
			// Crea la instruccion
			String sql = "INSERT INTO Articulo VALUES (" +
				"'"+articulo.getIdArticulo()+"',"+ 
				"'"+articulo.getDescripcion()+"',"+
				articulo.getImagen()+","+
				articulo.getPrecioVenta()+","+
				articulo.getPrecioMayoreo()+","+
				articulo.getPrecioAdquicicion()+","+
				articulo.getArticulosTotales()+")";
					
            // Ejecuta la instruccion
			statement.execute(sql);
			return true;
		} catch (SQLException e) {			
			// Cacha excepcion
			e.printStackTrace();
			return false;
        }
	}
	
	/**
	 * Este metodo extrae el registro con el identicador que se le pase por parametro 
	 * @param id identificador del Articulo
	 * @return una referencia al Articulo o null si no se encontro
	 */
	public Articulo recupera(String id) {
		Articulo articulo = null;
		try{
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Articulo WHERE idArticulo = '"+id+"'");
			if(rs.next())
			{
				articulo = new Articulo();
				articulo.setIdArticulo(rs.getString("idArticulo"));
				articulo.setDescripcion(rs.getString("descripcion"));
				articulo.setImagen(rs.getBytes("imagen"));
				articulo.setPrecioVenta(rs.getFloat("precioVenta"));
				articulo.setPrecioMayoreo(rs.getFloat("precioMayoreo"));
				articulo.setPrecioAdquicicion(rs.getFloat("precioAdquisicion"));
				articulo.setArticulosTotales(rs.getInt("articulosTotal"));
			}			
			return articulo;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Este metodo elimana el Articulo que resive por parametro de la base de datos
	 * @param articulo el Articulo que deseamos elimar de la base de datos
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean borra(Articulo articulo) {
        try{
			// Recibe los resutados
			statement.execute("DELETE FROM Articulo WHERE idArticulo = '"+articulo.getIdArticulo()+"'");
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
        }
	}

	/**
	 * Este metodo extrae todos Articulos de la base de datos
	 * @return un ArrayList con todos los Articulos
	 */
	public List<Articulo> recuperaTodos() {
		List<Articulo> articulos = new ArrayList<Articulo>();	
		try{
			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Articulo");			
			while(rs.next()) {
				Articulo articulo = new Articulo();
				articulo.setIdArticulo(rs.getString("idArticulo"));
				articulo.setDescripcion(rs.getString("descripcion"));
				articulo.setImagen(rs.getBytes("imagen"));
				articulo.setPrecioVenta(rs.getFloat("precioVenta"));
				articulo.setPrecioMayoreo(rs.getFloat("precioMayoreo"));
				articulo.setPrecioAdquicicion(rs.getFloat("precioAdquisicion"));
				articulo.setArticulosTotales(rs.getInt("articulosTotal"));
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return articulos;
	}	
	
	/**
	 * Este metodo actualiza el Artculo que se pasa por parametro dentro de base de datos
	 * @param articulo el Articulo con la información que deseamos actualizar
	 * @return true si se retiro exitosamente, false sino
	 */
	public boolean actualiza(Articulo articulo) {
		try{
			// Recibe los resutados
			String sql = "UPDATE Articulo SET "
				+ "descripcion = '"+articulo.getDescripcion()
				+ "', imagen = "+ articulo.getImagen()
				+ ", precioVenta = "+ articulo.getPrecioVenta()
				+ ", precioMayoreo = " + articulo.getPrecioMayoreo()
				+ ", precioAdquisicion = " + articulo.getPrecioAdquicicion()
				+", articulosTotal = " + articulo.getArticulosTotales()+
				" WHERE idArticulo = '"+articulo.getIdArticulo()+"'";
			statement.execute(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
        }
	}
    
}