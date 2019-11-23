package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.datos.DAOArticulo;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * ServicioVentaImpl
 */
public class ServicioVentaImpl implements ServicioVenta {

    DAOArticulo daoArticulo;

    public ServicioVentaImpl(DAOArticulo daoArticulo) {
        this.daoArticulo = daoArticulo;
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

}