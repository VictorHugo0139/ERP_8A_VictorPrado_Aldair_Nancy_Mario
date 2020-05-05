
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

public class AsociacionesDAO implements CRUD{
    private static AsociacionesDAO asdao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static AsociacionesDAO geAsociacionestDAO(){
    if(asdao==null){
        asdao= new AsociacionesDAO();
    }                   
    return asdao;                     
}

    private AsociacionesDAO() {
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
    public List<Asociaciones> consultar() {
        List<Asociaciones> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Asociaciones");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Asociaciones(rs.getInt("idAsosiacion"),
                        rs.getString("nombre"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
