/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 *
 * @author Cruz
 */
public  class DAOVentaBD implements DAOVenta{
    /**
	 * Este metodo permite agregar un articulo al registro de articulos
	 * 
	 * @param articulo el articulo a agregar
	 * @return true si se creo exitosamente, false sino
	 */
	@Override
	public boolean crea(Venta articulo) {
		
		try {
			// Crea la instruccion
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();
					
			// Ejecuta la instruccion
			statement.execute("INSERT INTO Venta VALUES ('" + articulo.getIdVenta()+ "',"+ articulo.getTotal()+ ",'" + articulo.getArticuloEnVenta()+ 
					                                  "','" + articulo.getDate()+ "')",Statement.RETURN_GENERATED_KEYS);
                        
                        
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    String llave = rs.getString(1);
			    articulo.setIdVenta(llave); // Asigna la llave al articulo
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
	public Venta recupera(String id) {
		
        Venta articulo=null;
        
        try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Venta WHERE idVenta = '" + id + "'");
			
			if(rs.next())
			{
				articulo = new Venta(rs.getString("idVenta"),Integer.parseInt(rs.getString("total")),
                                        rs.getString("articuloEnVenta"), rs.getDate("date"));
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
	public boolean actualiza(Venta articulo) {
		
	       try{
				
		Statement statement = ManejadorBaseDatos.getConnection().createStatement();

		// Recibe los resutados
		ResultSet rs = statement.executeQuery("Update Venta Set "
						+ "   idVenta ='" + articulo.getIdVenta()+
						      "', total='" + articulo.getTotal()+
						      "', articuloEnVenta=" + articulo.getArticuloEnVenta()+
						      "', date=" + articulo.getDate());

		return true;
		}catch(SQLException e){
                    e.printStackTrace();
                    return false;
		}

	}
	
	/**
	 * Retira un articulo del registro de Venta
	 * 
	 * @param articulo el articulo a retirar
	 * @return true si se retiro exitosamente, false sino
	 */
	@Override
	public boolean borra(Venta articulo) {
		try{			
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			statement.execute("DELETE FROM Venta WHERE idVenta = '"+
                                articulo.getIdVenta()+"'");
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Regresa la lista de todos los articulos
	 * 
	 * @return un ArrayList con todos los articulos del registro de Venta
	 */
	@Override
	public ArrayList<Venta> recuperaTodos() {
		
		ArrayList <Venta> articulos = new ArrayList<Venta>();
		
		
		try{
			
			Statement statement = ManejadorBaseDatos.getConnection().createStatement();

			// Recibe los resutados
			ResultSet rs = statement.executeQuery("SELECT * FROM Venta");

			
			while(rs.next())
			{
                                Venta articulo = new Venta(rs.getString("idVenta"),Integer.parseInt(rs.getString("total")),
                                        rs.getString("articuloEnVenta"), rs.getDate("date"));
                                articulos.add(articulo);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}
    
        @Override
	public ArrayList<Venta> recuperaLapso(Date max, Date min) {
		
            ArrayList <Venta> articulos = new ArrayList<Venta>();
		
            try{
			
            Statement statement = ManejadorBaseDatos.getConnection().createStatement();

            // Recibe los resutados
            ResultSet rs = statement.executeQuery("SELECT * FROM Venta WHERE total>0 AND date "
					                    + "BETWEEN '"+ min + "' AND '"+ max +"' "
					                    + "ORDER BY total");

			
                while(rs.next())
			{
				
                    Venta articulo = new Venta(rs.getString("idVenta"), Integer.parseInt(rs.getString("total")),rs.getString("articuloEnVenta"), rs.getDate("date"));
                    articulos.add(articulo);
                               
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return articulos;
	}
    
}
