package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * ServicioVentaImpl
 */
public class ServicioVentaImpl implements ServicioVenta {

    DAOArticulo daoArticulo;
    DAOArticuloEnStock daoArticuloEnStock;

    public ServicioVentaImpl(DAOArticulo daoArticulo, DAOArticuloEnStock daoArticuloEnStock) {
        this.daoArticulo = daoArticulo;
        this.daoArticuloEnStock = daoArticuloEnStock;
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
        // TODO Auto-generated method stub
        return false;
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