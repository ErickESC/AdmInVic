package test.mx.uam.ayd.proyecto.datos;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import mx.uam.ayd.proyecto.configuracion.ConfiguracionBD;
import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloBD;
import mx.uam.ayd.proyecto.datos.ManejadorBaseDatos;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import test.mx.uam.ayd.proyecto.BaseDePruebas;

public class DAOArticuloDBTest {

	private static DAOArticulo daoArticulo;
	private static Articulo a = null;
	private static Statement statement = null;

	@BeforeClass
	public static void setUpClass() throws Exception {
		Connection connection = ManejadorBaseDatos.getConnection(ConfiguracionBD.PRUEBAS);
		statement = connection.createStatement();
		// Modulo que vamos a probar
		BaseDePruebas.crearBaseDePruebas();
		daoArticulo = new DAOArticuloBD(ConfiguracionBD.PRUEBAS);
		a = new Articulo();
		a.setIdArticulo("abc00x");
		a.setDescripcion("descripcion de objeto precargado");
		a.setImagen(null);
		a.setPrecioVenta(10.0f);
		a.setPrecioMayoreo(9.0f);
		a.setPrecioAdquicicion(7.0f);
		a.setArticulosTotales(10);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDePruebas.eliminarBaseDePruebas();
	}


	@Test
	public void testCrea() throws SQLException {
		// Objeto de ejemplo
		assertTrue("No se ha podido insertar el objeto", daoArticulo.crea(a));
	}

	@Test
	public void testRecupera() throws SQLException {
		String id = daoArticulo.recupera("abc001").getIdArticulo();
		assertTrue("No se ha podido recuperar el objeto", id.equals("abc001"));
	}

	@Test
	public void testBorra() throws SQLException {
		assertTrue("No se ha podido eliminar el Objeto", daoArticulo.borra(a));
	}

	@Test
	public void testRecuperaTodos() throws SQLException {
		String sql = "INSERT INTO Articulo VALUES "
			+ "('abc004','Articulo nuevo 1',null,10.0,9.0,7.0,10), "
			+ "('abc005','Articulo nuevo 2',null,10.0,9.0,7.0,10)";
		statement.execute(sql);
		int elementos = daoArticulo.recuperaTodos().size();
		assertTrue("No se han podido recuperar todos los objetos", elementos == 6);
	}

	@Test
	public void testActualiza() throws SQLException {
		a.setIdArticulo("abc001");
		a.setDescripcion("Descipcion actualizada");
		assertTrue("No se ha podido Actualizar el objeto",daoArticulo.actualiza(a));
	}

	@Test
	public void recuperaNullTest() {
		assertNull(daoArticulo.recupera("test"));
	}

}
