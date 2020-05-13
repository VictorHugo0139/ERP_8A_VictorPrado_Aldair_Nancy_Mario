
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransporteDAO implements CRUD{
private static TransporteDAO trdao;
    Conexion cn=Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static TransporteDAO getTransporteDAO(){
    if(trdao==null){
        trdao= new TransporteDAO();
    }                   
    return trdao;                     
}

    private TransporteDAO() {
    }

    
    @Override
    public String insertar(Object obj) {
        Transporte tr=(Transporte) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("insert into UnidadesTransporte(placas,marca,modelo,anio,capacidad,estatus)\n" +
"values (?,?,?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, tr.getPlacas());
            ps.setString(2, tr.getMarca());
            ps.setString(3, tr.getModelo());
            ps.setInt(4, tr.getAño());
            ps.setInt(5, tr.getCapacidad());
            ps.setString(6, ""+tr.getEstado());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("update UnidadesTransporte set estatus='I' where idUnidadTransporte=? "); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas= ps.executeUpdate();
            respuesta="se eliminaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update UnidadesTransporte set estatus='A' where idUnidadTransporte=? ");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    @Override
    public String actualizar(Object obj) {
        Transporte tr = (Transporte) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update UnidadesTransporte set placas=?, marca=?, modelo=?, anio=?, capacidad=?, estatus=? where idUnidadTransporte=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tr.getPlacas());
            ps.setString(2, tr.getMarca());
            ps.setString(3, tr.getModelo());
            ps.setInt(4, tr.getAño());
            ps.setInt(5, tr.getCapacidad());
            ps.setString(6, "" + tr.getEstado());
            ps.setInt(7, tr.getIdTransporte());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Transporte> consultar() {
        List<Transporte> datos=new ArrayList<>();
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConexion();
        sql=("select * from unidadesTransporte");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Transporte(rs.getInt("idUnidadTransporte"),
                        rs.getString("placas"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getInt("capacidad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public String OneTransport(int idTransport) {
        String nombre="";
        con=cn.getConexion();
        sql=("select*from UnidadesTransporte where idUnidadTransporte=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idTransport));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("Modelo");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
