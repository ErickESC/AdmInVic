package mx.uam.ayd.proyecto.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * 
 * Implementacion de DAOArticulo que se conecta con una base de datos relacional
 * 
 * @author Erick
 *
 */

public class DAOArticuloBD implements DAOArticulo{

	/**
	 * Este metodo permite agregar un articulo al registro de articulos
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	@Override
	public boolean crea(Articulo articulo) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Articulo VALUES ('" + articulo.getIdArticulo() + "','"+ articulo.getDescripcion() + "','" + articulo.getImagen() + 
					                                  "','" + articulo.getPrecioVenta() + "','" + articulo.getPrecioMayoreo() + "','" + articulo.getPrecioAdquisicion() +
			                                          "','" + articulo.getArticulosTotal() + "')",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    String llave = rs.getString(1);
			    articulo.setIdArticulo(llave); // Asigna la llave al articulo
			}
			
			return true;
		} catch (SQLException e) {
			
			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Este metodo busca un articulo a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	@Override
	public Articulo recupera(String id) {
		
        Articulo articulo=null;
        
        try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Articulo WHERE idArticulo = '" + id + "'");
			
			if(rs.next())
			{
				articulo = new Articulo(rs.getString("idArticulo"), rs.getString("descripcion"), rs.getBytes(2), Integer.parseInt(rs.getString("precioVenta")),
						                Integer.parseInt(rs.getString("precioMayoreo")), Integer.parseInt(rs.getString("precioAdquisicion")), Integer.parseInt(rs.getString("articulosTotal")));
			}
			
			return articulo;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza articulo
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	@Override
	public boolean actualiza(Articulo articulo) {
		
	       try{
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();

				// Recibe los resutados
				ResultSet rs = statement.executeQuery("Update Articulo Set "
						+ "                               descripcion ='" + articulo.getDescripcion() +
						                              "', imagen='" + articulo.getImagen() +
						                              "', precioVenta=" + articulo.getPrecioVenta() +
						                              "', precioAdquisicion=" + articulo.getPrecioAdquisicion() +
						                              "', precioMayoreo=" + articulo.getPrecioMayoreo() +
						                              "', articulosTotal=" + articulo.getPrecioMayoreo() +
						                              "' Where idArticulo='"+articulo.getIdArticulo()+"'");
				
				return true;

			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}

	}
	
	/**
	 * Retira un articulo del registro de articulos
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	@Override
	public boolean borra(Articulo articulo) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Articulo WHERE idArticulo = '"+articulo.getIdArticulo()+"'");
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los articulos
	 * 
	 * @return un ArrayList con todos los articulos del registro de articulos
	 */
	@Override
	public ArrayList<Articulo> recuperaTodos() {
		
		ArrayList <Articulo> articulos = new ArrayList<Articulo>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Articulo");

			
			while(rs.next())
			{
				
				Articulo articulo = new Articulo(rs.getString("idArticulo"), rs.getString("descripcion"), rs.getBytes(2), Integer.parseInt(rs.getString("precioVenta")),
		                Integer.parseInt(rs.getString("precioMayoreo")), Integer.parseInt(rs.getString("precioAdquisicion")), Integer.parseInt(rs.getString("articulosTotal")));
				
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}

}
