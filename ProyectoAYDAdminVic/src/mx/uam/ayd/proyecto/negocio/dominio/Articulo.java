package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * Articulo
 */
public class Articulo {

    private String idArticulo;
    private String descripcion;
    private byte[] imagen;
    private float precioVenta;
    private float precioMayoreo;
    private float precioAdquicicion;
    private int articulosTotales;

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] img) {
        this.imagen = img;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioMayoreo() {
        return precioMayoreo;
    }

    public void setPrecioMayoreo(float precioMayoreo) {
        this.precioMayoreo = precioMayoreo;
    }

    public float getPrecioAdquicicion() {
        return precioAdquicicion;
    }

    public void setPrecioAdquicicion(float precioAdquicicion) {
        this.precioAdquicicion = precioAdquicicion;
    }

    public int getArticulosTotales() {
        return articulosTotales;
    }

    public void setArticulosTotales(int articulosTotales) {
        this.articulosTotales = articulosTotales;
    }

    // ELIMINAR al finalizar la implementacion
    @Override
    public String toString() {
        return "Articulo [articulosTotales=" + articulosTotales + ", descripcion="
                + descripcion + ", idArticulo=" + idArticulo + ", img=" + imagen + ", precioAdquicicion="
                + precioAdquicicion + ", precioMayoreo=" + precioMayoreo + ", precioVenta=" + precioVenta + "]";
    }

}