/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Tripulacion;
import Modelo.Envios;
import Modelo.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TripulacionDAO {
    private static TripulacionDAO tripdao;
    Conexion cn=Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
 
    
  public static TripulacionDAO getTripulacionDAO(){
    if(tripdao==null){
        tripdao= new TripulacionDAO();
    }                   
    return tripdao;                     
}

    public TripulacionDAO() {
        
    }
    
    
    public String insertar(Object obj) {
        Tripulacion trip=(Tripulacion) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into Tripulacion(idEmpleado,idEnvio,rol,estatus)\n" +
        "values (?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, trip.getIdEmpleado());
            ps.setInt(2, trip.getIdEnvio());
            ps.setString(3, trip.getRol());
            ps.setString(4, ""+trip.getEstado());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Tripulacion set estatus='I' where idTripulacion=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(5, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Tripulacion set estatus='A' where idTripulacion=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(5, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String actualizar(Object obj) {
        Tripulacion trip=(Tripulacion) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Tripulacion set idEmpleado=?, idEnvio=?, rol=?, estatus=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, trip.getIdEmpleado());
            ps.setInt(2, trip.getIdEnvio());
            ps.setString(3, trip.getRol() );
            ps.setString(4, ""+trip.getEstado());
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public List<Tripulacion> consultar() {
        List<Tripulacion> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Tripulacion");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Tripulacion(rs.getInt("idEmpleado"),
                        rs.getInt("idEnvio"),
                        rs.getString("rol"),
                        rs.getString("estatus").charAt(0),
                        rs.getInt("idTripulacion")));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    
}
