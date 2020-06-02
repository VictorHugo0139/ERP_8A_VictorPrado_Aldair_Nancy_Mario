
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Visitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VisitasDAO implements CRUD{
    private static VisitasDAO vidao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static VisitasDAO getVisitasDAO(){
    if(vidao==null){
        vidao= new VisitasDAO();
    }                   
    return vidao;                     
}

    private VisitasDAO() {
        
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
    public List<Visitas> consultar() {
        List<Visitas> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Visitas");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Visitas(rs.getInt("idVisita"),
                        rs.getDate("fechaPlaneada"),
                        rs.getDate("fechaReal"),
                        rs.getString("comentarios"),
                        rs.getString("Estado").charAt(0),
                        rs.getFloat("costo"),
                        rs.getInt("idClienteCultivo"),
                        rs.getInt("idEmpleado"),
                        rs.getInt("idTransporte")));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VisitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
