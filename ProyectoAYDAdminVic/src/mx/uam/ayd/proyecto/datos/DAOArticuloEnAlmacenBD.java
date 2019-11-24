package mx.uam.ayd.proyecto.datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

/**
 * 
 * Implementacion de DAOArticulo que se conecta con una base de datos relacional
 * 
 * @author Erick
 *
 */

public class DAOArticuloEnAlmacenBD implements DAOArticuloEnAlmacen {

	/**
	 * Este metodo permite agregar un articulo al registro de articulos en el almacen
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	@Override
	public boolean crea(ArticuloEnAlmacen articulo) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO ArticuloEnAlmacen VALUES ('" + articulo.getIdArticulo() + "','"+ articulo.getFechaLlegada() + "','" + articulo.getFechaPartida() + 
					                                  "'," + articulo.getArticulosTotalesEnAlmacen() + ")",Statement.RETURN_GENERATED_KEYS);
			
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
	 * Este metodo busca un articuloen el almacen a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	@Override
	public ArticuloEnAlmacen recupera(String id) {
        
		
		ArticuloEnAlmacen articulo=null;
        
        try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnAlmacen WHERE idArticulo = '" + id + "'");
			
			if(rs.next())
			{
				articulo = new ArticuloEnAlmacen(rs.getString("idArticulo"), rs.getDate("fechaRegistro"), rs.getTimestamp("fechaLlegada"), rs.getInt("articulosTotalesEnAlmacen"));
			}
			
			return articulo;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza articulo en el almacen
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	@Override
	public boolean actualiza(ArticuloEnAlmacen articulo) {
	       try{
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();

				// Recibe los resutados
				ResultSet rs = statement.executeQuery("Update ArticuloEnAlmacen Set "
						+ "                               fechaRegistro ='" + articulo.getFechaLlegada() +
						                              "', fechaPartida='" + articulo.getFechaPartida() +
						                              "', articulosTotalesEnAlmacen=" + articulo.getArticulosTotalesEnAlmacen() +
						                              "' Where idArticulo='"+articulo.getIdArticulo()+"'");
				
				return true;

			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}

	/**
	 * Retira un articulo del registro de articulos en el almacen
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	@Override
	public boolean borra(ArticuloEnAlmacen articulo) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM ArticuloEnAlmacen WHERE idArticulo = '"+articulo.getIdArticulo()+"'");
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los articulos en el almacen
	 * 
	 * @return un ArrayList con todos los articulos de articulos en el almacen
	 */
	@Override
	public ArrayList<ArticuloEnAlmacen> recuperaTodos() {
		
		ArrayList <ArticuloEnAlmacen> articulos = new ArrayList<ArticuloEnAlmacen>();
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnAlmacen");

			
			while(rs.next())
			{
				
				ArticuloEnAlmacen articulo = new ArticuloEnAlmacen(rs.getString("idArticulo"), rs.getDate("fechaRegistro"), rs.getTimestamp("fechaPartida"), rs.getInt("articulosTotalesEnAlmacen"));
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}

	@Override
	public ArrayList<ArticuloEnAlmacen> recuperaLapso(Date max, Date min) {
		
		ArrayList <ArticuloEnAlmacen> articulos = new ArrayList<ArticuloEnAlmacen>();
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnAlmacen WHERE articulosTotalesEnAlmacen>0 AND fechaRegistro "
					                            + "BETWEEN '"+ min + "' AND '"+ max +"' "
					                            + "ORDER BY articulosTotalesEnAlmacen");

			
			while(rs.next())
			{
				
				ArticuloEnAlmacen articulo = new ArticuloEnAlmacen(rs.getString("idArticulo"), rs.getDate("fechaRegistro"), rs.getTimestamp("fechaPartida"), Integer.parseInt(rs.getString("articulosTotalesEnAlmacen")));
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}

}
