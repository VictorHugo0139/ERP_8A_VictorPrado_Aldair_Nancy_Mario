package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;

import Modelo.VentaDetalles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nancy
 */
public class VentaDetallesDAO implements CRUD {

    private static VentaDetallesDAO vDao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static VentaDetallesDAO getVentaDetallesDAO() {
        if (vDao == null) {
            vDao = new VentaDetallesDAO();
        }
        return vDao;
    }

    private VentaDetallesDAO() {
    }

    @Override
    public String insertar(Object obj) {
        VentaDetalles vD = (VentaDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into VentaDetalles(precioVenta,cantidad,subtotal,idVenta,idPresentacion,estatus;)\n"
                + "values (?,?,?,?,?,?)");
        try {
            ps = con.prepareStatement(sql);
            ps.setFloat(1, vD.getPrecioVenta());
            ps.setFloat(2, vD.getCantidad());
            ps.setFloat(3, vD.getSubtotal());
            ps.setInt(4, vD.getIdVenta());
            ps.setInt(5, vD.getIdPresentacion());
            ps.setInt(6, vD.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se insertaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentaDetalles set estatus='I' where idVentaDetalles=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentaDetalles set estatus='A' where idVentaDetalles=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
        VentaDetalles vD = (VentaDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentaDetalles set precioVenta=?,cantidad=?,subtotal=?,idVenta=?,idPresentacion=?,estatus=?where idVentaDetalle=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vD.getIdVentaDetalle());
            ps.setFloat(2, vD.getPrecioVenta());
            ps.setFloat(3, vD.getCantidad());
            ps.setFloat(4, vD.getSubtotal());
            ps.setInt(5, +vD.getIdVenta());
            ps.setInt(6, +vD.getIdPresentacion());
            ps.setInt(7, vD.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<VentaDetalles> consultar() {
        List<VentaDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from VentaDetalles");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new VentaDetalles(rs.getInt("IdVentaDetalle"),
                        rs.getFloat("PrecioVenta"),
                        rs.getFloat("Cantidad"),
                        rs.getFloat("Subtotal"),
                        rs.getInt("IdVenta"),
                        rs.getInt("IdPresentacion"),
                        rs.getString("estatus").charAt(0)));

            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<VentaDetalles> consultarId(int id) {
        List<VentaDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Clientes where idCliente=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new VentaDetalles());
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public String OneBuild(int idTransport) {
        String nombre = "";
        con = cn.getConexion();
        sql = ("select*from VentaDetalle where idVentaDetalles=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idTransport));
            rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("idVentaDetalles");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

}
