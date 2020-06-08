
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Mantenimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MantenimientosDAO implements CRUD{
    private static MantenimientosDAO madao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static MantenimientosDAO getMantenimientosDAO(){
    if(madao==null){
        madao= new MantenimientosDAO();
    }                   
    return madao;                     
}

    private MantenimientosDAO() {
    }

    @Override
    public String insertar(Object obj) {
        Mantenimientos ma=(Mantenimientos) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into Mantenimientos(fecha,taller,costo,comentarios,tipo,idUnidadTransporte,estatus)\n" +
        "values (?,?,?,?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setDate(1, ma.getFecha());
            ps.setString(2, ma.getTaller());
            ps.setFloat(3, ma.getCosto());
            ps.setString(4, ma.getComentarios());
            ps.setString(5, ma.getTipo());
            ps.setInt(6, ma.getIdUnidadTransporte());
            ps.setString(7, ""+ma.getEstatus()); 
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Mantenimientos set estatus='I' where idMantenimiento=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Mantenimientos set estatus='A' where idMantenimiento=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
        Mantenimientos ma=(Mantenimientos) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Mantenimientos set fecha=?, taller=?, costo=?, comentarios=?, tipo=?, idUnidadTransporte=?, estatus=? where idMantenimiento=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, ma.getFecha());
            ps.setString(2, ma.getTaller());
            ps.setFloat(3, ma.getCosto());
            ps.setString(4, ma.getComentarios());
            ps.setString(5, ma.getTipo());
            ps.setInt(6, ma.getIdUnidadTransporte());
            ps.setString(7, ""+ma.getEstatus()); 
            ps.setInt(8, ma.getIdMantenimiento());
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Mantenimientos> consultar() {
        List<Mantenimientos> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Mantenimientos");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Mantenimientos(rs.getInt("idMantenimiento"),
                        rs.getDate("fecha"),
                        rs.getString("taller"),
                        rs.getInt("costo"),
                        rs.getString("comentarios"),
                        rs.getString("tipo"),
                        rs.getInt("idUnidadTransporte"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
