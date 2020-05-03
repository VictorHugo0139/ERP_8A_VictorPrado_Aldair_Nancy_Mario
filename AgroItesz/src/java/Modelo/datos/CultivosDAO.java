/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Cultivos;
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
 * @author resid
 */
public class CultivosDAO implements CRUD {

    private static CultivosDAO culdao;
    Conexion cn=Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static CultivosDAO getCultivosDAO(){
    if(culdao==null){
        culdao= new CultivosDAO();
    }                   
    return culdao;                     
}

    public CultivosDAO() {
    }

    
    @Override
    public String insertar(Object obj) {
        Cultivos cult=(Cultivos) obj;
        String respuesta="";
        con=cn.getConexion();
        sql = ("insert into cultivos values (?,?,?,?)");
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cult.getIdCultivo());
            ps.setString(2, cult.getNombre());
            ps.setFloat(3, cult.getCostoAsesoria());
            ps.setInt(4, cult.getEstado());
            int filas =ps.executeUpdate();
            respuesta = "Se Insertaron "+filas+" filas correctamente";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CultivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int id) {
//        Cultivos cl=(Cultivos) obj;
        String respuesta="";
        con=cn.getConexion();
        sql=("delete from Cultivos where idCultivo=? "); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas= ps.executeUpdate();
            respuesta="se eliminaron "+filas+" filas correctamente";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CultivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
       Cultivos cult=(Cultivos) obj;
        String respuesta="";
        con=cn.getConexion();
        sql = "update Cultivos set nombre=?,costoAsesoria=?,estatus=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cult.getNombre());
            ps.setFloat(2, cult.getCostoAsesoria());
            ps.setInt(3, cult.getEstado());
            int filas= ps.executeUpdate();
            respuesta="se actualizaron "+filas+" filas correctamente";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CultivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }

    @Override
    public List<Cultivos> consultar() 
    {
          List <Cultivos> datos = new ArrayList<>();
          cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql = "select * from Cultivos";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                datos.add(new Cultivos (rs.getInt("idCultivo"),
                rs.getString("nombre"),
                rs.getInt("costoAsesoria"),
                rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CultivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  return datos;
    }

    @Override
    public List<Cultivos> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
