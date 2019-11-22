/**
 * 
 */
package mx.uam.ayd.proyecto.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;

/**
 * @author erick
 *
 */
public class DAOArticuloEnStockBD implements DAOArticuloEnStock {

	/**
	 * Este metodo permite agregar un articulo al registro de articulos en el stock
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	@Override
	public boolean crea(ArticuloEnStock articulo) {
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO ArticuloEnStock VALUES ('" + articulo.getIdArticulo() + "','"+ articulo.getFechaLlegada() + 
					                                  "','" + articulo.getArticulosTotalesEnStock() + "')",Statement.RETURN_GENERATED_KEYS);
			
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
	 * Este metodo busca un articulos en el stock a partir de su id
	 * 
	 * @param id el identificador del articulo a buscar
	 * @return una referencia al articulo o null si no se encontro
	 */
	@Override
	public ArticuloEnStock recupera(String id) {
		ArticuloEnStock articulo=null;
        
        try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnStock WHERE idArticulo = '" + id + "'");
			
			if(rs.next())
			{
				articulo = new ArticuloEnStock(rs.getString("idArticulo"), rs.getDate("fechaLlegada"), Integer.parseInt(rs.getString("articulosTotalesEnStock")));
			}
			
			return articulo;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Actualiza articulo articulos en el stock
	 * 
	 * @param articulo
	 * @return true si se actualizo correctamente, false si no
	 */
	@Override
	public boolean actualiza(ArticuloEnStock articulo) {
	       try{
				
				Statement statement = ManejadorBaseDatos.getConnection().createStatement();

				// Recibe los resutados
				ResultSet rs = statement.executeQuery("Update ArticuloEnStock Set "
						+ "                               fechaLlegada ='" + articulo.getFechaLlegada() +
						                              "', articulosTotalesEnStock=" + articulo.getArticulosTotalesEnStock() +
						                              "' Where idArticulo='"+articulo.getIdArticulo()+"'");
				
				return true;

			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}

	/**
	 * Retira un articulo del registro de articulos en el stock
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	@Override
	public boolean borra(ArticuloEnStock articulo) {
        try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM ArticuloEnStock WHERE idArticulo = '"+articulo.getIdArticulo()+"'");
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los articulos en el stock
	 * 
	 * @return un ArrayList con todos los articulos de articulos en el stock
	 */
	@Override
	public ArrayList<ArticuloEnStock> recuperaTodos() {
		ArrayList <ArticuloEnStock> articulos = new ArrayList<ArticuloEnStock>();
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM ArticuloEnStock");

			
			while(rs.next())
			{
				
				ArticuloEnStock articulo = new ArticuloEnStock(rs.getString("idArticulo"), rs.getDate("fechaLlegada"), Integer.parseInt(rs.getString("articulosTotalesEnAlmacen")));
				articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}

}
