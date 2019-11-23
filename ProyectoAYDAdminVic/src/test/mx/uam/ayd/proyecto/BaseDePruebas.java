package test.mx.uam.ayd.proyecto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import mx.uam.ayd.proyecto.configuracion.ConfiguracionBD;
import mx.uam.ayd.proyecto.datos.DatabaseException;
import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;

public class BaseDePruebas {
	
	// El logger
    static Logger log = Logger.getRootLogger();
    
    public static void crearBaseDePruebas() {
        try
	    {
			log.info("Creando base de datos");
		
			Connection connection = ManejadorBaseDatos.getConnection(ConfiguracionBD.PRUEBAS);	
			Statement statement = connection.createStatement();

			/* log.info("Creando tabla Usuario");                
			statement.execute("CREATE TABLE Usuario(" +
				"matricula INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
				"contraseña VARCHAR(20), " +
				"cargo VARCHAR(12))");	 */

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
				"articulosTotalesEnAlmacen INTEGER, CONSTRAINT Fk_IdArticulo_Almacen " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");

			log.info("Creando tabla ArticuloEnStock");                
			statement.execute("CREATE TABLE ArticuloEnStock(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"fechaLlegada DATE, " +
				"articulosTotalesEnStock INTEGER, CONSTRAINT Fk_IdArticulo_Stok " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");

			log.info("Creando tabla ArticuloEnVenta");                
			statement.execute("CREATE TABLE ArticuloEnVenta(" +
				"idArticulo VARCHAR(12) PRIMARY KEY NOT NULL,"+
				"articulosTotalesEnVenta INTEGER, CONSTRAINT Fk_IdArticulo_Venta " +
				"FOREIGN KEY (idArticulo) REFERENCES Articulo(idArticulo))");

			log.info("Creando tabla Venta");                
			statement.execute("CREATE TABLE Venta(" +
				"idVenta VARCHAR(11) NOT NULL,"+
				"idArticulo VARCHAR(12) NOT NULL,"+
				"TotalVenta FLOAT, " +
				"fechaVenta DATE, " +
				"numeroCaja INTEGER, " +
				"PRIMARY KEY(idVenta, idArticulo), CONSTRAINT Fk_Venta " +
				"FOREIGN KEY (idArticulo) REFERENCES ArticuloEnVenta(idArticulo))");
            
            // Creando datos de prueba
            statement.execute("INSERT INTO Articulo VALUES ('abc001', 'Producto 1', null, 15, 9.5, 7.5, 10)");
            statement.execute("INSERT INTO Articulo VALUES ('abc002', 'Producto 2', null, 10, 9.5, 8.5, 10)");
            statement.execute("INSERT INTO Articulo VALUES ('abc003', 'Producto 3', null, 16, 8.5, 5.5, 10)");
	        // ManejadorBaseDatos.shutdown();
	    }
	    catch(DatabaseException ex)
	    {
	        log.error("Excepcion de la base de datos",ex.getRealException());
	    }
	    catch(SQLException e){
	    	log.error("Excepcion de la base de datos",e);
	    }        
    }
    
    public static void eliminarBaseDePruebas() {
        try
	    {
			log.info("Creando base de datos");		
			Connection connection = ManejadorBaseDatos.getConnection(ConfiguracionBD.PRUEBAS);	
            Statement statement = connection.createStatement();
            // Eliminando Tablas de pruebas
            // statement.execute("DROP TABLE Usuario");
            statement.execute("ALTER TABLE Venta DROP CONSTRAINT Fk_Venta");
            statement.execute("ALTER TABLE ArticuloEnAlmacen DROP CONSTRAINT Fk_IdArticulo_Almacen");
            statement.execute("ALTER TABLE ArticuloEnStock DROP CONSTRAINT Fk_IdArticulo_Stok");
            statement.execute("ALTER TABLE ArticuloEnVenta DROP CONSTRAINT Fk_IdArticulo_Venta");
            statement.execute("DROP TABLE ArticuloEnAlmacen");
            statement.execute("DROP TABLE ArticuloEnStock");
            statement.execute("DROP TABLE ArticuloEnVenta");
            statement.execute("DROP TABLE Venta");
            statement.execute("DROP TABLE Articulo");
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
