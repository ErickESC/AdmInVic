package mx.uam.ayd.proyecto.datos;

import java.sql.SQLException;
import java.sql.Statement;

import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

/**
 * DAOUsuarioBD
 */
public class DAOUsuarioBD implements DAOUsuario {

    private String nombreBD;
    private Statement statement = null;
    private java.sql.PreparedStatement ps;
    
    public DAOUsuarioBD (String baseDeDatos ) {
		nombreBD = baseDeDatos;
		try {
			statement = ManejadorBaseDatos.getConnection(nombreBD).createStatement();
		} catch (DatabaseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

    @Override
    public boolean crea(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean elimina(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Usuario recupera(String nombre) {
        Usuario usuario = null;
        try {
            java.sql.ResultSet rs = statement.executeQuery("SELECT * FROM Usuario WHERE matricula = " + nombre);
            if (rs.next()) {
                int matricula = rs.getInt("matricula");
                String contrasenia = rs.getString("contrasenia");
                String cargo = rs.getString("cargo");
                usuario = new Usuario(matricula, contrasenia, cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public boolean actualiza(Usuario usuarioActualizado) {
        // TODO Auto-generated method stub
        return false;
    }
}