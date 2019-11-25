package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnStock;
import mx.uam.ayd.proyecto.datos.DAOVenta;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * ServicioVentaImpl
 */
public class ServicioVentaImpl implements ServicioVenta {

    DAOArticulo daoArticulo;
    DAOArticuloEnStock daoArticuloEnStock;
    DAOVenta daoVenta; 

    public ServicioVentaImpl(DAOArticulo daoArticulo, DAOArticuloEnStock daoArticuloEnStock, DAOVenta daoVenta) {
        this.daoArticulo = daoArticulo;
        this.daoArticuloEnStock = daoArticuloEnStock;
        this.daoVenta = daoVenta;
    }

    @Override
    public Articulo buscaArticulo(String idArticulo) {
        Articulo articulo = daoArticulo.recupera(idArticulo);
        return articulo;
    }

    @Override
    public ArticuloEnStock consultarStock(String idArticulo) {
        ArticuloEnStock stock = daoArticuloEnStock.recupera(idArticulo);
        return stock;
    }

    @Override
    public boolean registraVenta(Venta venta) {
        return daoVenta.crea(venta);
    }

    @Override
    public boolean actualizaStockArticulo(Articulo articulo, ArticuloEnStock articuloStock) {
        if(daoArticuloEnStock.actualiza(articuloStock)) {
            if(daoArticulo.actualiza(articulo)) {
                return true;
            }
        }
        return false;
    }

}