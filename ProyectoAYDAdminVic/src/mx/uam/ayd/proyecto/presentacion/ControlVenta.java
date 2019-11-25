package mx.uam.ayd.proyecto.presentacion;

import java.util.List;
import java.util.stream.Collectors;

import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnVenta;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * ControlVenta
 */
public class ControlVenta {

    private ServicioVenta servicioVenta;
    private VentanaVenta ventana;
    private Venta listaDeVenta;

    /** 
     * Cosntructor del control de venta de Articulos
     */
    public ControlVenta (ServicioVenta servicioVenta) {
        this.servicioVenta = servicioVenta;
        listaDeVenta = new Venta(1);
    }

    public void inicia() {
        ventana = new VentanaVenta(this);
        ventana.abre();
    }

    public void eliminarDeLista(String idArticulo) {
        listaDeVenta.eliminarArticulo(idArticulo);
    }

    public Articulo buscaArticulo (String idArticulo) {
        Articulo articulo = servicioVenta.buscaArticulo(idArticulo);
        if(articulo != null){
            listaDeVenta.agregarArticulo(articulo);
        }
        return articulo;
    }
    
    public ArticuloEnStock buscaArticuloEnStock (String idArticulo) {
        ArticuloEnStock stock = servicioVenta.consultarStock(idArticulo);
        return stock;
    }

    public boolean actualizaStock() {
        listaDeVenta.getIdArticulo().stream().forEach( e -> {
            String idArticulo = e.getArticulo().getIdArticulo();
            ArticuloEnStock articuloStock = buscaArticuloEnStock(idArticulo);
            Articulo articulo = servicioVenta.buscaArticulo(idArticulo);
            articulo.setArticulosTotales(articulo.getArticulosTotales() - e.getCantidad());
            articuloStock.setArticulosTotalesEnStock(
                articuloStock.getArticulosTotalesEnStock() - e.getCantidad()
            );
            System.out.println("Articulo: "+articulo.getArticulosTotales()+" Stock:"+articuloStock.getArticulosTotalesEnStock());
            if(servicioVenta.actualizaStockArticulo(articulo, articuloStock)) {
                System.out.println("Stock actualizado");
                servicioVenta.registraVenta(listaDeVenta);
            }
        });
        return false;
    }

    public List<String> registarVenta () {
        List<ArticuloEnVenta> lista = listaDeVenta.getIdArticulo().stream().filter( e -> {
            ArticuloEnStock articuloStock = buscaArticuloEnStock(e.getArticulo().getIdArticulo());
            return articuloStock.getArticulosTotalesEnStock() < e.getCantidad();
        }).collect(Collectors.toList());
        return lista.stream().map( e -> e.getArticulo().getIdArticulo() ).collect(Collectors.toList());
    }

    public void actualizaCantidad(String idArticulo, int cantidad) {
        listaDeVenta.actualizaCantidadArticulo(idArticulo, cantidad);
        listaDeVenta.getIdArticulo().stream().forEach( e -> System.out.println(e.getCantidad()));
    }

    public float totalApagar() {
        return listaDeVenta.getCostoTotal();
    }
}