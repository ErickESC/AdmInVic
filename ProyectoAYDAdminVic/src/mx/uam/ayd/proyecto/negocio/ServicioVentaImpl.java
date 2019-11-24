package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.datos.DAOArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;

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
    public boolean actualizaStockArticulo(String idArticulo) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean registraVenta() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArticuloEnStock consultarStock(String idArticulo) {
        ArticuloEnStock stock = daoArticuloEnStock.recupera(idArticulo);
        System.out.println(stock.getIdArticulo() + " " + stock.getArticulosTotalesEnStock() + " " + stock.getFechaLlegada().toString() );
        return null;
    }

}