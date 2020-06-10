
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Asociaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsociacionesDAO implements CRUD {

    private static AsociacionesDAO Asdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static AsociacionesDAO geAsociacionestDAO() {
        if (Asdao == null) {
            Asdao = new AsociacionesDAO();
        }
        return Asdao;
    }

    private AsociacionesDAO() {
    }

    @Override
    public String insertar(Object obj) {
        Asociaciones As = (Asociaciones) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into Asociaciones(nombre,estatus)\n"
                + "values (?,?)");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, As.getNombre());
            ps.setString(2, "" + As.getEstatus());
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
        sql = ("update Asociaciones set estatus='I' where idAsosiacion=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }
    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Asociaciones set estatus='A' where idAsosiacion=? ");
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
        Asociaciones As = (Asociaciones) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Asociaciones set nombre=? ,estatus=? where idAsosiacion=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, As.getNombre());
            ps.setString(2, "" + As.getEstatus());
            ps.setInt(3,As.getIdAsociacion());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Asociaciones> consultar() {
        List<Asociaciones> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Asociaciones");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Asociaciones(rs.getInt("idAsosiacion"),
                        rs.getString("Nombre"),
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


    public List<Asociaciones> consultarId(int id) {
        List<Asociaciones> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Asociaciones where idAsosiacion=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Asociaciones(rs.getInt("idAsosiacion"),
                        rs.getString("Nombre"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
