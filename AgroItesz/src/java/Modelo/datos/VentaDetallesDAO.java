/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private static VentaDetallesDAO VDdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static VentaDetallesDAO getVentaDetallesDAO() {
        if (VDdao == null) {
            VDdao = new VentaDetallesDAO();
        }
        return VDdao;
    }

    private VentaDetallesDAO() {
    }

    @Override
    public String insertar(Object obj) {
        VentaDetalles vD = (VentaDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into vetaDetalle(idVentaDetalle,precioVenta,cantidad,subtotal,idVenta,idPresentacion,estatus)\n"
                + "values (?,?,?,?,?,?,?)");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vD.getIdVentaDetalle());
            ps.setFloat(2, vD.getPrecioVenta());
            ps.setFloat(3, vD.getCantidad());
            ps.setFloat(4, vD.getSubtotal());
            ps.setInt(5, vD.getIdVenta());
            ps.setInt(6, vD.getIdPresentacion());
            ps.setInt(7, vD.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se insertaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDetallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Clientes set estatus='I' where idVentaDetalle=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDetallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentaDetalle set estatus='A' where idVentaDetalle=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDetallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
        VentaDetalles vD = (VentaDetalles) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update VentaDetalles set precioVenta=?,cantidad=?,subtotal=?,idVenta=?,idPresentacion=?,estatus=?,where idVentaDetalle=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vD.getIdVentaDetalle());
            ps.setFloat(2, vD.getPrecioVenta());
            ps.setFloat(3, vD.getCantidad());
            ps.setFloat(4, vD.getSubtotal());
            ps.setInt(5, vD.getIdVenta());
            ps.setInt(6, vD.getIdPresentacion());
            ps.setInt(7, vD.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDetallesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<?> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**  @Override
    public List<VentasDetalles> consultar() {
        List<VentasDetalles> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from VentasDetalles");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new VentasDetalles(rs.getInt("idVentasDetalles")
                        
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<Clientes> filtrar(String campo, String criterio) {
        List<Clientes> datos = new ArrayList<>();
        con = cn.getConexion();
//        String c="\'"+criterio+"\'";
//        System.out.println(campo+" y "+criterio);
        if ("Ciudad".equals(campo)) {
            sql = "select*from clientes c join ciudades ci on c.idCiudad=ci.idCiudad where ci.nombre like'%" + criterio + "%';";
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    datos.add(new Clientes(rs.getInt("idCliente"),
                            rs.getString("nombre"),
                            rs.getString("razonSocial"),
                            rs.getFloat("limiteCredito"),
                            rs.getString("direccion"),
                            rs.getString("codigoPostal"),
                            rs.getString("rfc"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getString("tipo").charAt(0),
                            rs.getInt("idCiudad"),
                            rs.getString("estatus").charAt(0)));
                }
                cn.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if ("estatus".equals(campo)) {
                if (criterio.startsWith("in") | criterio.startsWith("In")) {
                    sql = "select * from Clientes where " + campo + " = 'I'";
                    try {
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            datos.add(new Clientes(rs.getInt("idCliente"),
                                    rs.getString("nombre"),
                                    rs.getString("razonSocial"),
                                    rs.getFloat("limiteCredito"),
                                    rs.getString("direccion"),
                                    rs.getString("codigoPostal"),
                                    rs.getString("rfc"),
                                    rs.getString("telefono"),
                                    rs.getString("email"),
                                    rs.getString("tipo").charAt(0),
                                    rs.getInt("idCiudad"),
                                    rs.getString("estatus").charAt(0)));
                        }
                        cn.closeConnection();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (criterio.startsWith("ac") | criterio.startsWith("Ac")) {
                        sql = "select * from Clientes where " + campo + " = 'A'";
                        try {
                            ps = con.prepareStatement(sql);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                datos.add(new Clientes(rs.getInt("idCliente"),
                                        rs.getString("nombre"),
                                        rs.getString("razonSocial"),
                                        rs.getFloat("limiteCredito"),
                                        rs.getString("direccion"),
                                        rs.getString("codigoPostal"),
                                        rs.getString("rfc"),
                                        rs.getString("telefono"),
                                        rs.getString("email"),
                                        rs.getString("tipo").charAt(0),
                                        rs.getInt("idCiudad"),
                                        rs.getString("estatus").charAt(0)));
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
                sql = "select * from Clientes where " + campo + " like '%" + criterio + "%'";
//        sql=("select * from Clientes where ? like CONCAT( '%',?,'%');");
                try {
                    ps = con.prepareStatement(sql);
//            ps.setString(1, campo);
//            ps.setString(2, criterio);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        datos.add(new Clientes(rs.getInt("idCliente"),
                                rs.getString("nombre"),
                                rs.getString("razonSocial"),
                                rs.getFloat("limiteCredito"),
                                rs.getString("direccion"),
                                rs.getString("codigoPostal"),
                                rs.getString("rfc"),
                                rs.getString("telefono"),
                                rs.getString("email"),
                                rs.getString("tipo").charAt(0),
                                rs.getInt("idCiudad"),
                                rs.getString("estatus").charAt(0)));
                        System.out.println(rs.getInt("idCliente") + "," + rs.getString("nombre"));
                    }
                    cn.closeConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return datos;
    }

    public List<Clientes> consultarId(int id) {
        List<Clientes> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Clientes where idCliente=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Clientes(rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("razonSocial"),
                        rs.getFloat("limiteCredito"),
                        rs.getString("direccion"),
                        rs.getString("codigoPostal"),
                        rs.getString("rfc"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("tipo").charAt(0),
                        rs.getInt("idCiudad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }*/
}


