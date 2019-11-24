package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

public interface ServicioUsuario {

    public boolean registraUsuario(Usuario usuario);

    public boolean eliminaUsuario(Usuario usuario);

    public Usuario buscaUsuario(String nombre);

    public boolean actualizaUsuario(Usuario usuarioActualizado);
}
