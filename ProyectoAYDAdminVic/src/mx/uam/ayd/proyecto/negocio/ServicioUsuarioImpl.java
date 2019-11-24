package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.datos.DAOUsuario;
import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

public class ServicioUsuarioImpl implements ServicioUsuario {

    private DAOUsuario daoUsuario;

    public ServicioUsuarioImpl(DAOUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    @Override
    public boolean registraUsuario(Usuario usuario) {
        return daoUsuario.crea(usuario);
    }

    @Override
    public boolean eliminaUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public Usuario buscaUsuario(String nombre) {
        return daoUsuario.recupera(nombre);
    }

    @Override
    public boolean actualizaUsuario(Usuario usuarioActualizado) {
        return daoUsuario.actualiza(usuarioActualizado);
    }

}
