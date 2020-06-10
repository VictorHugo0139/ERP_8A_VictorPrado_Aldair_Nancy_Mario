
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Clientes;
import Modelo.OfertasAsosaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfertasAsociacionesDAO implements CRUD{
    private static OfertasAsociacionesDAO OAdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static OfertasAsociacionesDAO getOfertasAs(){
    if(OAdao==null){
        OAdao= new OfertasAsociacionesDAO();
    }                   
    return OAdao;                     
}

    private OfertasAsociacionesDAO() {
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
    public List<OfertasAsosaciones> consultar() {
        List<OfertasAsosaciones> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from OfertasAsociacion");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new OfertasAsosaciones(rs.getInt("idOfertaAsociacion"),
                        rs.getInt("idAsosiacion"),
                        rs.getInt("idOferta"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasAsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
