/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.ayd.proyecto.presentacion;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mx.uam.ayd.proyecto.negocio.ServicioHistorial;
import mx.uam.ayd.proyecto.negocio.dominio.Venta;
/**
 *
 * @author Cruz
 */
public class ControlHistorial {
    private VistaHistorial ventana;
    private ServicioHistorial servicioHistorial;
    
    //public  ArrayList<Venta> dameVentaLapso(Date max, Date min);
  
    
/**
 * Este módulo se encarga de generar el historial correspondiente y
 * de mostrarlo en una tabla de VistaHistorial
 * @param ta es la tabla de Vista Historial
 * @param fechaMax Fecha maxima que el usuario digita
 * @param fechaMin Fecha minima que el usuario digita
 */
    public void consultaUnHistorial(JTable ta,Date fechaMax, Date fechaMin){
        
        ArrayList<Venta> n = servicioHistorial.dameVentaLapso(fechaMax, fechaMin);
       
        String columnas[] = {"producto","id","existencia","fecha"};
        
        DefaultTableModel dtm = new DefaultTableModel(null,columnas);
        
        
        for(Venta objeto:n){
            Object Filas[] = {objeto.getArticuloEnVenta(),objeto.getIdVenta(),objeto.getTotal(),objeto.getDate()};
            dtm.addRow(Filas);
            
        }
        ta.setModel(dtm);
    }
    

}


