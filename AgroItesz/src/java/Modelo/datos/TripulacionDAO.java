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
        sql=("insert into Tripulacion(idEmpleado,idEnvio)\n" +
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

    public String eliminar(String rol) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Tripulacion set estatus='I' where rol=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rol);
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
        sql = ("update Envios set estatus='A' where idEnvio=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String actualizar(Object obj) {
        Envios en=(Envios) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Envios set fechaEntregaPlaneada=?, fechaEntregaReal=?, direccion=?, codigoPostal=?, idVenta=?, idUnidadTransporte=?, idCiudad=?, estatus=? where idEnvio=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, en.getFechaEntregaPlaneada());
            ps.setDate(2, en.getFechaEntregaReal());
            ps.setString(3, en.getDireccion());
            ps.setInt(4, en.getCodigoPostal());
            ps.setInt(5, en.getIdVenta());
            ps.setInt(6, en.getIdTransporte());
            ps.setInt(7, en.getIdCiudad());
            ps.setString(8, ""+en.getEstado());
            ps.setInt(9, en.getIdEnvio());
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
        sql=("select * from Triulacion");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Tripulacion(rs.getInt("idEmpleado"),
                        rs.getInt("idEnvio"),
                        rs.getString("rol"),
                        rs.getString("estatus").charAt(0)));
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
