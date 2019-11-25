package mx.uam.ayd.proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import mx.uam.ayd.proyecto.configuracion.ConfiguracionBD;
import mx.uam.ayd.proyecto.datos.DatabaseException;
import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

/**
 * Esta clase crea la base de datos, solo debe ser usada 
 * cuando se crea la misma
 * 
 * @author humbertocervantes
 *
 */
public class CreadorBaseDeDatos {
	
	// El logger
	static Logger log = Logger.getRootLogger();

	
	/**
	 * Al ejecutar este metodo se crea la base de datos. NOTA: solo se puede crear una vez.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		java.sql.PreparedStatement ps;
		try
	    {
			log.info("Creando base de datos");
		
			Connection connection = ManejadorBaseDatos.getConnection(ConfiguracionBD.PRODUCCION);
	
			Statement statement = connection.createStatement();

			log.info("Creando tabla Usuario");
			statement.execute("CREATE TABLE Usuario("
					+ "matricula INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ "contrasenia VARCHAR(20), "
					+ "cargo VARCHAR(12)"
				+ ")"
			);
				

			log.info("Creando tabla Articulo");                
			statement.execute("CREATE TABLE Articulo(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"descripcion VARCHAR(200), " +
				"imagen BLOB, " +
				"precioVenta FLOAT, " +
				"precioMayoreo FLOAT, " +
				"precioAdquisicion FLOAT, " +
				"articulosTotal INTEGER)");
					

			log.info("Creando tabla ArticuloEnAlmacen");                
			statement.execute("CREATE TABLE ArticuloEnAlmacen(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"fechaRegistro DATE, " +
				"fechaPartida TIMESTAMP, " +
				"articulosTotalesEnAlmacen INTEGER, " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");
					

			log.info("Creando tabla ArticuloEnStock");                
			statement.execute("CREATE TABLE ArticuloEnStock(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"fechaLlegada DATE, " +
				"articulosTotalesEnStock INTEGER, " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");
					

			log.info("Creando tabla ArticuloEnVenta");                
			statement.execute("CREATE TABLE ArticuloEnVenta(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"articulosTotalesEnVenta INTEGER, " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");
		

			log.info("Creando tabla Venta");                
			statement.execute("CREATE TABLE Venta(" +
				"idVenta VARCHAR(25) NOT NULL,"+
				"idArticulo VARCHAR(12) NOT NULL,"+
				"TotalVenta FLOAT, " +
				"fechaVenta DATE, " +
				"numeroCaja INTEGER, " +
				"PRIMARY KEY(idVenta, idArticulo), CONSTRAINT Fk_Venta " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");

			// Creando un Usario
			log.info("creando (Usaurio): 1 ADMIN con password 123");
			statement.execute("INSERT INTO Usuario (contrasenia, cargo) VALUES ('12345', 'ADMIN')");
			
			// Creando un Articulo
			log.info("creando (Articulo): abc001");
			ps = connection.prepareStatement("INSERT INTO Articulo VALUES (?, ?, null, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "abc001");
			ps.setString(2, "Producto 1");
			ps.setFloat(3, 15);
			ps.setFloat(4, 9.5f);
			ps.setFloat(5, 7.5f);
			ps.setInt(6, 10);
			ps.executeUpdate();
			java.sql.ResultSet keys = ps.getGeneratedKeys();
			keys.next();
			System.out.println("Matricula => "+keys.getInt(1));
			ps.close();

			// Creando un Articulo en Almacen
			log.info("creando (Almacen): abc001");
			ps = connection.prepareStatement("INSERT INTO ArticuloEnAlmacen VALUES ("+ "'abc001', " + "?, " + "null, " + "5" + ")");
			ps.setDate(1, new java.sql.Date( java.util.Calendar.getInstance().getTime().getTime() ));
			ps.executeUpdate();
			ps.close();
			
			// Creando un Articulo en Stock
			log.info("creando (Stock): abc001");
			ps = connection.prepareStatement(
				"INSERT INTO ArticuloEnStock VALUES ("
				+ "'abc001', " + "?, " + "5" + ")"
			);
			ps.setDate(1, new java.sql.Date( java.util.Calendar.getInstance().getTime().getTime() ));
			ps.executeUpdate();
			ps.close();
			
			// Creando una venta ( 1.-idVenta, 2-idArticulo, 3.-TotalVenta, 4.-fechaVenta, 5.-numeroCaja )
			log.info("creando (Venta): abc001 x 1 ");
			ps = connection.prepareStatement("INSERT INTO Venta VALUES ( ?, ?, ?, ?, ?)");
			ps.setString(1, LocalDateTime.now().toString());
			ps.setString(2, "abc001");
			ps.setFloat(3, 15);
			ps.setDate(4, new java.sql.Date( java.util.Calendar.getInstance().getTime().getTime() ));
			ps.setInt(5, 1);
			ps.executeUpdate();
			ps.close();
					
	        ManejadorBaseDatos.shutdown();
	    }
	    catch(DatabaseException ex)
	    {
	            log.error("Excepcion de la base de datos",ex.getRealException());
	    }
	    catch(SQLException e){
	    	log.error("Excepcion de la base de datos",e);
	    }	
	}

}
