/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Ventas;
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
 * @author Victor
 */
public class VentasDAO implements CRUD{
    
    private static VentasDAO vdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static VentasDAO getVentasDAO() {
        if (vdao == null) {
            vdao = new VentasDAO();
        }
        return vdao;
    }

    private VentasDAO() {
    }


    @Override
    public String insertar(Object obj) {
    Ventas v = (Ventas) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into Ventas(fecha,totalPagar,CantPagada,comentarios,estatus,tipo,idCliente,idSucursal,idEmpleado)\n"
                + "values (?,?,?,?,?,?,?,?,?)");
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, v.getFecha());
            ps.setFloat(2, v.getTotalPagar());
            ps.setFloat(3, v.getCantPagada());
            ps.setString(4, v.getComentarios());
            ps.setString(5,""+v.getEstatus());
            ps.setString(6,""+v.getTipo());
            ps.setInt(7, v.getIdCliente());
            ps.setInt(8, v.getIdSucursal());
            ps.setInt(9, v.getIdEmpleado());
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
        sql = ("update Ventas set estatus='I' where idVenta=? ");
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
        sql = ("update Ventas set estatus='A' where idVenta=? ");
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
         Ventas v = (Ventas) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Ventas set fecha=?, totalPagar=?, CantPagada=?, comentarios=?, estatus=?, tipo=?, idCliente=?, idSucursal=?, idEmpleado=? where idVenta=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, v.getFecha());
            ps.setFloat(2, v.getTotalPagar());
            ps.setFloat(3, v.getCantPagada());
            ps.setString(4, v.getComentarios());
            ps.setString(5,""+v.getEstatus());
            ps.setString(6,""+v.getTipo());
            ps.setInt(7, v.getIdCliente());
            ps.setInt(8, v.getIdSucursal());
            ps.setInt(9, v.getIdEmpleado());
            ps.setInt(10, v.getIdVenta());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Ventas> consultar() {
        List<Ventas> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Ventas");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Ventas(rs.getInt("idVenta"),
                        rs.getDate("fecha"),
                        rs.getFloat("totalPagar"),
                        rs.getFloat("CantPagada"),
                        rs.getString("comentarios"),
                        rs.getString("estatus").charAt(0),
                        rs.getString("tipo").charAt(0),
                        rs.getInt("idCliente"),
                        rs.getInt("idSucursal"),
                        rs.getInt("idEmpleado")));
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
    
    public List<Ventas> consultarId(int id) {
        List<Ventas> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Clientes where idCliente=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Ventas());
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public String OneBuild(int idTransport) {
        String nombre="";
        con=cn.getConexion();
        sql=("select*from Ventas where idVenta=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idTransport));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("Fecha");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
}
