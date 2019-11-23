package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 * ServicioVenta
 */
public interface ServicioVenta {

    public Articulo buscaArticulo (String idArticulo);

    public boolean actualizaStockArticulo(String idArticulo);

    // TODO domini/Venta DAOVenta
    public boolean registraVenta();
}