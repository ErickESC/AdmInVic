package mx.uam.ayd.proyecto.datos;

import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * DAOVenta
 */
public interface DAOVenta {

    public boolean crea(Venta venta);
    
    public Venta recupera(String idVenta);
    
}