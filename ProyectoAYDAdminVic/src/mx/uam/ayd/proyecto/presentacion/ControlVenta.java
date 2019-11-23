package mx.uam.ayd.proyecto.presentacion;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;

/**
 * ControlVenta
 */
public class ControlVenta {

    private ServicioVenta servicioVenta;
    private VentanaVenta ventana;

    /** 
     * Cosntructor del control de venta de Articulos
     */
    public ControlVenta (ServicioVenta servicioVenta) {
        this.servicioVenta = servicioVenta;
    }

    public void inicia() {
        ventana = new VentanaVenta(this);
        ventana.abre();
    }

    public Articulo buscaArticulo (String idArticulo) {
        return servicioVenta.buscaArticulo(idArticulo);
    }
    
    public ArticuloEnStock buscaArticuloEnStock (String idArticulo) {
        ArticuloEnStock test = new ArticuloEnStock(idArticulo,null,10);
        return test;
    }

    public List<String> registarVenta (List<Map<String,Integer>> listaDeIds) {
        return listaDeIds.stream().filter( elemento -> {
            String[] datos = elemento.toString().replace("{","").replace("}","").split("=");
            String id = datos[0];
            int cantidad = Integer.valueOf(datos[1]);
            ArticuloEnStock articuloStock = buscaArticuloEnStock(id);
            System.out.println("En Stock: "+articuloStock.getArticulosTotalesEnStock()+" Cantidad: "+cantidad);
            if(articuloStock.getArticulosTotalesEnStock() >= cantidad){
                return false;
            } else {
                return true;
            }
        }).map( elemento -> elemento.toString().replace("{","").replace("}","").split("=")[0] ).collect(Collectors.toList());
    }
}