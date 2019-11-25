package mx.uam.ayd.proyecto.negocio.dominio;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Venta
 */
public class Venta {

    private String idVenta;
    private java.util.List<ArticuloEnVenta> articulosEnLista;
    private float totalVenta;
    private java.sql.Date fechaVenta;
    private int numeroCaja;

    public Venta() {
    }

    public Venta(int numeroCaja) {
        this.idVenta = java.time.LocalDateTime.now().toString();
        this.articulosEnLista = new java.util.ArrayList<ArticuloEnVenta>();
        this.totalVenta = 0;
        this.fechaVenta = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        this.numeroCaja = numeroCaja;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public java.util.List<ArticuloEnVenta> getIdArticulo() {
        return articulosEnLista;
    }

    public void setIdArticulo(java.util.List<ArticuloEnVenta> idArticulo) {
        this.articulosEnLista = idArticulo;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public java.sql.Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(java.sql.Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public java.util.List<String> getIds() {
        return articulosEnLista.stream().map(e -> e.getArticulo().getIdArticulo()).collect(Collectors.toList());
    }

    public float getCostoTotal() {
        float costo = this.articulosEnLista.stream().map(e -> e.totalAPagar()).reduce(0f, (c, e) -> c + e);
        return costo;
    }

    public void agregarArticulo(Articulo articulo) {
        int coincidencias = (int) articulosEnLista.stream()
                .filter(e -> e.getArticulo().getIdArticulo().equals(articulo.getIdArticulo())).count();
        if (coincidencias > 0) {
            articulosEnLista = articulosEnLista.stream().map(e -> {
                boolean existe = e.getArticulo().getIdArticulo().equals(articulo.getIdArticulo());
                if (existe) {
                    e.sumarArticulo();
                }
                return e;
            }).collect(Collectors.toList());
        } else {
            articulosEnLista.add(new ArticuloEnVenta(articulo));
        }
    }

    public void eliminarArticulo(String idArticulo) {
        articulosEnLista = articulosEnLista.stream().filter(e -> e.getArticulo().getIdArticulo().equals(idArticulo))
                .collect(Collectors.toList());
    }

    public void actualizaCantidadArticulo(String idArticulo, int cantidad) {
        articulosEnLista = articulosEnLista.stream().map(e -> {
            if (e.getArticulo().getIdArticulo().equals(idArticulo)) {
                e.setCantidad(cantidad);
            }
            return e;
        }).collect(Collectors.toList());
    }
    
}