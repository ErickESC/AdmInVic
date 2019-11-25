package mx.uam.ayd.proyecto.datos;

import java.sql.SQLException;

import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

/**
 * DAOUsuarioBD
 */
public class DAOUsuarioBD implements DAOUsuario {

    private String nombreBD;
    private java.sql.PreparedStatement ps;

    public DAOUsuarioBD(String baseDeDatos) {
        nombreBD = baseDeDatos;
    }

    @Override
    public boolean crea(Usuario usuario) {
        boolean exito = false;
        try {
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement("INSERT INTO Usuario (contrasenia, cargo) VALUES (?, ?)",
                    java.sql.Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getContrasenia());
            ps.setString(2, usuario.getCargo());
            ps.executeUpdate();
            java.sql.ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                System.out.println("La nueva Matricula es => " + keys.getInt(1));
                exito = true;
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public boolean elimina(Usuario usuario) {
        boolean exito = false;
        try {
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement("DELETE FROM Usuario WHERE matricula = ?");
            ps.setInt(1, usuario.getMatricula());
            exito = ps.executeUpdate() == 1;
            ps.close();
            System.out.println("Exito al Eliminar "+exito);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public Usuario recupera(String nombre) {
        Usuario usuario = null;
        try {
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement("SELECT * FROM Usuario WHERE matricula = ?");
            ps.setString(1, nombre);
            java.sql.ResultSet res = ps.executeQuery();
            if(res.next()){
                int matricula = res.getInt("matricula");
                String contrasenia = res.getString("contrasenia");
                String cargo = res.getString("cargo");
                usuario = new Usuario(matricula, contrasenia, cargo);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public boolean actualiza(Usuario usuarioActualizado) {
        boolean exito = false;
        try {
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement("UPDATE Usuario SET contrasenia = ?, cargo = ? WHERE matricula = ?");
            ps.setString(1, usuarioActualizado.getContrasenia());
            ps.setString(2, usuarioActualizado.getCargo());
            ps.setInt(3, usuarioActualizado.getMatricula());
            exito = ps.executeUpdate() == 1;
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }
}