/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.negocio.dominio;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Cruz
 */
public class Venta {
    private String idVenta;
    private int total;
    private String  articuloEnVenta;
    private java.sql.Date date;

    
    /**
     * Constructor
     * @param idVenta
     * @param total
     * @param articuloEnVenta
     * @param date 
     */
    public Venta(String idVenta, int total, String articuloEnVenta, Date date) {
        this.idVenta = idVenta;
        this.total = total;
        this.articuloEnVenta = articuloEnVenta;
        this.date = date;
    }
    
    //Getter y Setters 

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getArticuloEnVenta() {
        return articuloEnVenta;
    }

    public void setArticuloEnVenta(String articuloEnVenta) {
        this.articuloEnVenta = articuloEnVenta;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    

}
