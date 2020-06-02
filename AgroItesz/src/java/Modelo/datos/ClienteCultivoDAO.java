
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

    private ClienteCultivoDAO() {
    }
    
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteCultivo> consultar() {
        List<ClienteCultivo> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select*from ClientesCultivo;");
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
    public List<ClienteCultivo> consultarId(int id) {
        List<ClienteCultivo> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from ClientesCultivo where idCliente=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    
}
