package mx.uam.ayd.proyecto.datos;

import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

/**
 * DAOUsuario
 */
public interface DAOUsuario {

    public boolean crea(Usuario usuario);

    public boolean elimina(Usuario usuario);

    public Usuario recupera(String nombre);

    public boolean actualiza(Usuario usuarioActualizado);
}