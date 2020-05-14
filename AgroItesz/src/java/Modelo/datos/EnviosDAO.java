package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Envios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnviosDAO implements CRUD{
    private static EnviosDAO endao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static EnviosDAO getEnviosDAO(){
    if(endao==null){
        endao= new EnviosDAO();
    }                   
    return endao;                     
}

    private EnviosDAO() {
        
    }
    
    
    @Override
    public String insertar(Object obj) {
        Envios en=(Envios) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into Envios(fechaEntregaPlaneada,fechaEntregaReal,direccion,codigoPostal,idVenta,idUnidadTransporte,idCiudad,estatus)\n" +
        "values (?,?,?,?,?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setDate(1, en.getFechaEntregaPlaneada());
            ps.setDate(2, en.getFechaEntregaReal());
            ps.setString(3, en.getDireccion());
            ps.setInt(4, en.getCodigoPostal());
            ps.setInt(5, en.getIdVenta());
            ps.setInt(6, en.getIdTransporte());
            ps.setInt(7, en.getIdCiudad());
            ps.setString(8, ""+en.getEstado());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Envios set estatus='I' where idEnvio=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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

    @Override
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
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Envios> consultar() {
        List<Envios> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Envios");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Envios(rs.getInt("idEnvio"),
                        rs.getDate("fechaEntregaPlaneada"),
                        rs.getDate("fechaEntregaReal"),
                        rs.getString("Direccion"),
                        rs.getInt("codigoPostal"),
                        rs.getInt("idVenta"),
                        rs.getInt("idUnidadTransporte"),
                        rs.getInt("idCiudad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
