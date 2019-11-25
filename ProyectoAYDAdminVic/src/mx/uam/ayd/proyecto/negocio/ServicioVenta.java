package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnStock;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * ServicioVenta
 */
public interface ServicioVenta {

    public Articulo buscaArticulo (String idArticulo);

    public boolean registraVenta(Venta venta);

    public ArticuloEnStock consultarStock(String idArticulo);

	public boolean actualizaStockArticulo(Articulo articulo, ArticuloEnStock articuloStock);
}