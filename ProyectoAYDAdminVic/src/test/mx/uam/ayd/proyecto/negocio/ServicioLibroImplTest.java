package test.mx.uam.ayd.proyecto.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mx.uam.ayd.proyecto.datos.DAOLibro;
import mx.uam.ayd.proyecto.negocio.ServicioLibro;
import mx.uam.ayd.proyecto.negocio.ServicioLibroImpl;
import mx.uam.ayd.proyecto.negocio.dominio.Libro;
import test.mx.uam.ayd.proyecto.datos.DAOLibroMock;

/**
 * Caso de pruebas para un servicio con dependencias
 * 
 * @author humbertocervantes
 *
 */
public class ServicioLibroImplTest {
	
	private ServicioLibro servicio;

	@Before
	public void setUp() throws Exception {
		
		// El servicio depende de un DAOLibro, creamos un Mock y lo conectamos
		DAOLibro dao = new DAOLibroMock();
		servicio = new ServicioLibroImpl(dao);

		
		// Creamos un libro de prueba
		Libro prueba = new Libro();
		prueba.setAutor("Juan");
		prueba.setNombre("Prueba");
		dao.crea(prueba);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscaLibro() {
		// Buscamos primero un libro que si existe
		Libro resultado = servicio.buscaLibro("Prueba");
		
		assertNotNull("regreso null, pero debio regresar un libro", resultado);
		
		// Buscamos ahora un libro que no existe
		resultado = servicio.buscaLibro("NoExiste");
		assertNull("regreso un libro pero debio regresar null", resultado);

	}

	@Test
	public void testAgregaLibro() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDameLibros() {
//		fail("Not yet implemented");
	}

}
