package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * ArticuloEnVenta
 */
public class ArticuloEnVenta {

    private Articulo articulo;
    private int cantidad;

    public ArticuloEnVenta(Articulo articulo) {
        this.articulo = articulo;
        cantidad = 1;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulos) {
        this.articulo = articulos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float totalAPagar() {
        return articulo.getPrecioVenta() * this.cantidad;
    }

    public void sumarArticulo() {
        this.cantidad += 1;
    }
}