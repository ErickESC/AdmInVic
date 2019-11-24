package mx.uam.ayd.proyecto.presentacion;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.dominio.Usuario;

/**
 * ControlLogin
 */
public class ControlLogin {

    private VentanaLogin ventana;
    private ServicioUsuario servicioUsuario;

    public ControlLogin (ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public void inicia() {
        this.ventana = new VentanaLogin(this);
        ventana.abre();
    }

    private Usuario recuperaUsuario(String nombre) {
        return servicioUsuario.buscaUsuario(nombre);
    };

    public boolean login(String nombre, String password) {
        boolean res = false;
        Usuario usuario = recuperaUsuario(nombre);
        System.out.println(usuario.getContrasenia());
        if(usuario != null){
            res = usuario.getContrasenia().equals(password);
        }
        System.out.println(usuario);
        return res;
    }
}