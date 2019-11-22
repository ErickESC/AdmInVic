package mx.uam.ayd.proyecto.datos;

/**
 * Exceopciones generadas por la BD 
 * 
 */
public class DatabaseException extends RuntimeException{

	static final long serialVersionUID = 4243304904892048022L;
	
	Exception m_realException;

	public DatabaseException(String msg, Exception ex)
	{
		super(msg);
		m_realException = ex;
	}
	
	public Exception getRealException()
	{
		return m_realException;
	}
}
