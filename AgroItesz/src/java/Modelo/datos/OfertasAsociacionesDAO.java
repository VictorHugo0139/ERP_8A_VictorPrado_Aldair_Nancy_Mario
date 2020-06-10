
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
        OfertasAsosaciones ofa=(OfertasAsosaciones) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into OfertasAsociacion(idAsociacion,idOferta,estatus)\n" +
            "values (?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, ofa.getIdAsosiacion());
            ps.setInt(2, ofa.getIdOferta());
            ps.setString(3, ""+ofa.getEstatus());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasAsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update OfertasAsociacion set estatus='I' where idOfertaAsociacion=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasAsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update OfertasAsociacion set estatus='A' where idOfertaAsociacion=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasAsociacionesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
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
