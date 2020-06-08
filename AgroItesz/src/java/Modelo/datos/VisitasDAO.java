
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
        Visitas vi=(Visitas) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into Visitas(fechaPlaneada,fechaReal,comentarios,estatus,costo,idClienteCultivo,idEmpleado,idUnidadTransporte)\n" +
        "values (?,?,?,?,?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setDate(1, vi.getFechaPlaneada());
            ps.setDate(2, vi.getFechaReal());
            ps.setString(3, vi.getComentarios());
            ps.setString(4, "" + vi.getEstado());
            ps.setFloat(5, vi.getCosto());
            ps.setInt(6, vi.getIdClienteCultivo());
            ps.setInt(7, vi.getIdEmpleado());
            ps.setInt(8, vi.getIdTransporte());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VisitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Visitas set estatus='I' where idVisita=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VisitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Visitas set estatus='A' where idVisita=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VisitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
        Visitas vi=(Visitas) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Visitas set fechaPlaneada=?, fechaReal=?, comentarios=?, estatus=?, costo=?, idClienteCultivo=?, idEmpleado=?, idUnidadTransporte=? where idVisita=? ");
        try {
            ps.setDate(1, vi.getFechaPlaneada());
            ps.setDate(2, vi.getFechaReal());
            ps.setString(3, vi.getComentarios());
            ps.setString(4, "" + vi.getEstado());
            ps.setFloat(5, vi.getCosto());
            ps.setInt(6, vi.getIdClienteCultivo());
            ps.setInt(7, vi.getIdEmpleado());
            ps.setInt(8, vi.getIdTransporte());
            ps.setInt(9, vi.getIdVisita());
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(VisitasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Visitas> consultar() {
        List<Visitas> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from visitas");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Visitas(rs.getInt("idVisita"),
                        rs.getDate("fechaPlaneada"),
                        rs.getDate("fechaReal"),
                        rs.getString("comentarios"),
                        rs.getString("estatus").charAt(0),
                        rs.getFloat("costo"),
                        rs.getInt("idClienteCultivo"),
                        rs.getInt("idEmpleado"),
                        rs.getInt("idUnidadTransporte")));
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
