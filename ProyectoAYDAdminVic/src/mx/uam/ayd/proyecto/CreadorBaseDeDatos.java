package mx.uam.ayd.proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import mx.uam.ayd.proyecto.datos.DatabaseException;
import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

/**
 * Esta clase crea la base de datos, solo debe ser usada 
 * cuando se crea la misma
 * 
 * @author Erick
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
		try
	    {
			log.info("Creando base de datos");
			
			Connection connection = ManejadorBaseDatos.getConnection();
	
			Statement statement = connection.createStatement();
			
			/*
			log.info("destruyendo todo");
			
			statement.execute("MySQL\n" + 
					"DROP TABLE IF EXISTS usuario, Articulo, ArticuloEnAlmacen, ArticuloEnStock, ArticuloEnVenta, Venta");
			*/
			///*
			log.info("Creando tabla Usuario");                
	
	        statement.execute("CREATE TABLE usuario(" +
	        		"matricula INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	            	"contraseña VARCHAR(20), " +
	    			"cargo VARCHAR(12))");
	        
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
	        		"idVenta VARCHAR(11) NOT NULL,"+
	        		"idArticulo VARCHAR(12) NOT NULL,"+
	        		"cantidad INTEGER," +
	            	"TotalVenta FLOAT, " +
	            	"fechaVenta DATE, " +
	    			"numeroCaja INTEGER, " +
	            	"PRIMARY KEY(idVenta, idArticulo), " +
	        		"FOREIGN KEY (idArticulo) REFERENCES ArticuloEnVenta(idArticulo))");
	        //*/
	
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