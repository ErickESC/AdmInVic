package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * Usuario
 */
public class Usuario {

    private int matricula;
    private String contrasenia;
    private String cargo;

    public Usuario () {}

    public Usuario (int matricula, String contrasenia, String cargo) {
        this.matricula = matricula;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}