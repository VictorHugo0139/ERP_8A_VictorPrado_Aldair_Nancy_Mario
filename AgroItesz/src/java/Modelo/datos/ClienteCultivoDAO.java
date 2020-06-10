
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.ClienteCultivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteCultivoDAO implements CRUD{
    private static ClienteCultivoDAO clcudao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static ClienteCultivoDAO getClienteCultivoDAO(){
    if(clcudao==null){
        clcudao= new ClienteCultivoDAO();
    }                   
    return clcudao;                     
}

    public ClienteCultivoDAO() {
    }
    
    @Override
    public String insertar(Object obj) {
        ClienteCultivo clienCul=(ClienteCultivo) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into ClientesCultivos(extension,ubicacion,idCliente,idCultivo,idCiudad,estatus)\n" +
        "values (?,?,?,?,?,?)");  
        try {
            ps=con.prepareStatement(sql);
            ps.setDouble(1, clienCul.getExtencion());
            ps.setString(2, clienCul.getUbicacion());
            ps.setInt(3, clienCul.getIdCliente());
            ps.setInt(4, clienCul.getIdCultivo());
            ps.setInt(5, clienCul.getIdCiudad());
            ps.setString(6, ""+clienCul.getEstatus());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update ClientesCultivos set estatus='I' where idClienteCultivo=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

  public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update ClientesCultivos set estatus='A' where idClienteCultivo=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
       ClienteCultivo clcu=(ClienteCultivo) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update ClientesCultivos set extension=?, ubicacion, idCliente=?, idCultivo=?, idCiudad=?, estatus=? where idClienteCultivo=? ");
        try {
            ps=con.prepareStatement(sql);
            ps.setDouble(1, clcu.getExtencion());
            ps.setString(2, clcu.getUbicacion());
            ps.setInt(3, clcu.getIdCliente());
            ps.setInt(4, clcu.getIdCultivo());
            ps.setInt(5, clcu.getIdCiudad());
            ps.setString(6, ""+clcu.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<ClienteCultivo> consultar() {
        List<ClienteCultivo> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select*from ClientesCultivos;");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new ClienteCultivo(rs.getInt("idClienteCultivo"),
                        rs.getFloat("extension"),
                        rs.getString("ubicacion"), 
                        rs.getInt("idCliente"),
                        rs.getInt("idCultivo"),
                        rs.getInt("idCiudad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datos; 
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<ClienteCultivo> OneClient(int idClient) {
        
        List<ClienteCultivo> datos=new ArrayList<>();
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("select*from ClientesCultivo where idClienteCultivo="+idClient);
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new ClienteCultivo(rs.getInt("idClienteCultivo"),
                        rs.getFloat("extencion"),
                        rs.getString("ubicacion"), 
                        rs.getInt("idCliente"),
                        rs.getInt("idCultivo"),
                        rs.getInt("idTransporte"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCultivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    public String OneCliente(int idEmpleado) {
        String nombre="";
        con=cn.getConexion();
        sql=("select*from ClientesCultivo where idClienteCultivo=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idEmpleado));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("extension");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    
}
