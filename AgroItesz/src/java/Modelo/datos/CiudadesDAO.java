
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Ciudades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CiudadesDAO implements CRUD{

private static CiudadesDAO cdao;
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public static CiudadesDAO getCiudadesDAO(){
    if(cdao==null){
        cdao= new CiudadesDAO();
    }                   
    return cdao;                     
}

    public CiudadesDAO() {
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
    public List<Ciudades> consultar() {
        List<Ciudades> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select*from Ciudades;");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Ciudades(rs.getInt("idCiudad"),
                        rs.getString("nombre"), 
                        rs.getInt("idEstado"), 
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datos; 
    }

    @Override
    public List<Ciudades> filtrar(String campo, String criterio) {
         List<Ciudades> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select*from Ciudades where ? like '%?%';");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, campo);
            ps.setString(2, criterio);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Ciudades(rs.getInt("idCiudad"),
                        rs.getString("nombre"), 
                        rs.getInt("idEstado"), 
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    public String OneCity(int idCity) {
        String nombre="";
        con=cn.getConexion();
        sql=("select*from Ciudades where idCiudad=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idCity));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("nombre");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    
        public List<Ciudades> consultarId(int id) {
        List<Ciudades> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Ciudades where idCiudad=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 datos.add(new Ciudades(rs.getInt("idCiudad"),
                        rs.getString("nombre"), 
                        rs.getInt("idEstado"), 
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CiudadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
