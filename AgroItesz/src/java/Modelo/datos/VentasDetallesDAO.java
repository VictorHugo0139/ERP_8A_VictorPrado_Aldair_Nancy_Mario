package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;

import Modelo.VentasDetalles;
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
public class VentasDetallesDAO implements CRUD {

    private static VentasDetallesDAO vDdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static VentasDetallesDAO getVentasDetallesDAO() {
        if (vDdao == null) {
            vDdao = new VentasDetallesDAO();
        }
        return vDdao;
    }

    private VentasDetallesDAO() {
    }

    @Override
    public String insertar(Object obj) {
        VentasDetalles vD = (VentasDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into VentasDetalle(precioVenta,cantidad,subtotal,idVenta,idPresentacion,estatus)\n"
                + "values (?,?,?,?,?,'A')");
        try {
            ps = con.prepareStatement(sql);
            ps.setFloat(1, vD.getPrecioVenta());
            ps.setFloat(2, vD.getCantidad());
            ps.setFloat(3, vD.getSubtotal());
            ps.setInt(4, vD.getIdVenta());
            ps.setInt(5, vD.getIdPresentacion());
//            ps.setString(6, "" + vD.getEstatus());
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
        sql = ("update VentasDetalle set estatus='I' where idVentaDetalle=? ");
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
        sql = ("update VentasDetalle set estatus='A' where idVentaDetalle=? ");
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
        VentasDetalles vD = (VentasDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentasDetalle set precioVenta=?,cantidad=?,subtotal=?,idVenta=?,idPresentacion=?,estatus=? where idVentaDetalle=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setFloat(1, vD.getPrecioVenta());
            ps.setFloat(2, vD.getCantidad());
            ps.setFloat(3, vD.getSubtotal());
            ps.setInt(4, vD.getIdVenta());
            ps.setInt(5, vD.getIdPresentacion());
            ps.setString(6, "" + vD.getEstatus());
            ps.setInt(7, vD.getIdVentaDetalle());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<VentasDetalles> consultar() {
        List<VentasDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from VentasDetalle");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new VentasDetalles(rs.getInt("IdVentaDetalle"),
                        rs.getFloat("precioVenta"),
                        rs.getFloat("cantidad"),
                        rs.getFloat("subtotal"),
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
    public List<VentasDetalles> filtrar(String campo, String criterio) {
        List<VentasDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
//        String c="\'"+criterio+"\'";
//        System.out.println(campo+" y "+criterio);
        if ("Ventas".equals(campo)) {

            sql = "select*from VentasDetalle vD join ventas v on v  vD.idVentas=v.idVentas where v.cliente like'%" + criterio + "%';";
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    while (rs.next()) {
                        datos.add(new VentasDetalles(rs.getInt("IdVentaDetalle"),
                                rs.getFloat("precioVenta"),
                                rs.getFloat("cantidad"),
                                rs.getFloat("subtotal"),
                                rs.getInt("IdVenta"),
                                rs.getInt("IdPresentacion"),
                                rs.getString("estatus").charAt(0)));

                    }
                }
                cn.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if ("estatus".equals(campo)) {
                if (criterio.startsWith("in") | criterio.startsWith("In")) {
                    sql = "select * from VentasDetalle where " + campo + " = 'I'";
                    try {
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            while (rs.next()) {
                                datos.add(new VentasDetalles(rs.getInt("IdVentaDetalle"),
                                        rs.getFloat("precioVenta"),
                                        rs.getFloat("cantidad"),
                                        rs.getFloat("subtotal"),
                                        rs.getInt("IdVenta"),
                                        rs.getInt("IdPresentacion"),
                                        rs.getString("estatus").charAt(0)));

                            }
                        }
                        cn.closeConnection();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (criterio.startsWith("ac") | criterio.startsWith("Ac")) {
                        sql = "select * from VentasDetalle where " + campo + " = 'A'";
                        try {
                            ps = con.prepareStatement(sql);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                while (rs.next()) {
                                    datos.add(new VentasDetalles(rs.getInt("IdVentaDetalle"),
                                            rs.getFloat("precioVenta"),
                                            rs.getFloat("cantidad"),
                                            rs.getFloat("subtotal"),
                                            rs.getInt("IdVenta"),
                                            rs.getInt("IdPresentacion"),
                                            rs.getString("estatus").charAt(0)));

                                }
                            }
                            cn.closeConnection();
                        } catch (SQLException ex) {
                            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        return datos;
                    }
                }
            } else {
                sql = "select * from VentasDetalle where " + campo + " like '%" + criterio + "%'";
//        sql=("select * from Clientes where ? like CONCAT( '%',?,'%');");
                try {
                    ps = con.prepareStatement(sql);
//            ps.setString(1, campo);
//            ps.setString(2, criterio);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        while (rs.next()) {
                            datos.add(new VentasDetalles(rs.getInt("IdVentaDetalle"),
                                    rs.getFloat("precioVenta"),
                                    rs.getFloat("cantidad"),
                                    rs.getFloat("subtotal"),
                                    rs.getInt("IdVenta"),
                                    rs.getInt("IdPresentacion"),
                                    rs.getString("estatus").charAt(0)));

                        }
                    }
                    cn.closeConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return datos;
    }

    public List<VentasDetalles> consultarId(int id) {
        List<VentasDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from ventasDetalles ");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new VentasDetalles());
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
        sql = ("select*from VentasDetalle where idVentaDetalles=?;");
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
