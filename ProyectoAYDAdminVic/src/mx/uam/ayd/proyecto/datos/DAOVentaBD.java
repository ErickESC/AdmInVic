package mx.uam.ayd.proyecto.datos;

import java.sql.SQLException;
import java.time.LocalDateTime;

import mx.uam.ayd.proyecto.negocio.dominio.Venta;

/**
 * DAOVentaBD
 */
public class DAOVentaBD implements DAOVenta {

    private String nombreBD;
    private java.sql.PreparedStatement ps;

    public DAOVentaBD(String baseDeDatos) {
        nombreBD = baseDeDatos;
    }

    @Override
    public boolean crea(Venta venta) {
        boolean exito = false;
        try {
            String sql = "INSERT INTO Venta VALUES ( ?, ?, ?, ?, ?)";
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement(sql);
            ps.setString(1, LocalDateTime.now().toString());
			ps.setString(2, venta.getIds().get(0) );
			ps.setFloat(3, venta.getCostoTotal());
			ps.setDate(4, new java.sql.Date( java.util.Calendar.getInstance().getTime().getTime() ));
			ps.setInt(5, venta.getNumeroCaja());
			ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    @Override
    public Venta recupera(String idVenta) {
        Venta venta = null;
        try {
            ps = ManejadorBaseDatos.getConnection(nombreBD).prepareStatement("SELECT * FROM Venta WHERE idVenta = ?");
            ps.setString(1, idVenta);
            java.sql.ResultSet res = ps.executeQuery();
            if(res.next()){
                venta = new Venta();
                venta.setIdVenta(res.getString("idVenta")); 
                venta.setTotalVenta(res.getFloat("totalVenta")); 
                venta.setFechaVenta(res.getDate("fechaVenta")); 
                venta.setNumeroCaja(res.getInt("numeroCaja"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }

}