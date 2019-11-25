/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.presentacion;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import mx.uam.ayd.proyecto.negocio.ServicioLista;
import mx.uam.ayd.proyecto.negocio.dominio.Articulo;

/**
 *
 * @author Cruz
 */
public class ControlLista {
    private VistaLista vistaLista;
    private ServicioLista servicioLista;
    
    public void consultaLista(JTable ta){
        ArrayList<Articulo> m ;
        m=servicioLista.dameArticulo();
        String columnas[] = {"id","Precio de venta","existencia","articulos totales"};
        DefaultTableModel dtm = new DefaultTableModel(null,columnas);
    
        for(Articulo objeto:m){
            Object Filas[] = {objeto.getIdArticulo(),objeto.getPrecioVenta(),objeto.getArticulosTotal()};
            dtm.addRow(Filas);
            
        }
        ta.setModel(dtm);
    }
    
    
}
