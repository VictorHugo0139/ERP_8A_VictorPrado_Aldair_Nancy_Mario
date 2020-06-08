/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Clientes;
import Modelo.Miembros;
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
 * @author Nancy
 */
public class MiembrosDAO implements CRUD {

    private static MiembrosDAO midao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static MiembrosDAO getMiembrosDAO() {
        if (midao == null) {
            midao = new MiembrosDAO();
        }
        return midao;
    }

    private MiembrosDAO() {
    }

    @Override
    public String insertar(Object obj) {
        Miembros mi = (Miembros) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("SET IDENTITY_INSERT Miembros ON;\n" +
"insert into Miembros(idCliente,idAsosiacion,estatus,fechaIncorporacion)\n" +
"values (?,?,?,GETDATE());");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mi.getIdCliente());
            ps.setInt(2, mi.getidAsosaciones());
            ps.setString(3, "" + mi.getEstatus());
            int filas = ps.executeUpdate();
            respuesta = "se insertaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Miembros set estatus='I' where idCliente=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se eliminaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
public String reactivar(int id) {
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Miembros set estatus='A' where idCliente=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            respuesta = "se reactivaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
        Miembros mi = (Miembros) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Miembros set idAsosiacion=?, estatus=?  where idCliente=?;");
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mi.getidAsosaciones());
            ps.setString(2, "" + mi.getEstatus());
            ps.setInt(3, mi.getIdCliente());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Miembros> consultar() {
        List<Miembros> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Miembros");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Miembros(rs.getInt("idCliente"),
                        rs.getInt("idAsosiacion"),
                        rs.getString("estatus").charAt(0),
                        rs.getDate("fechaIncorporacion")));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MiembrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    
public String OneClient(int idClient) {
        String nombre="";
        con=cn.getConexion();
        sql=("select c.nombre from Miembros m join Clientes c on m.idCliente=c.idCliente where m.idCliente=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idClient));
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

public String OneAsociation(int idClient) {
        String nombre="";
        con=cn.getConexion();
        sql=("select a.nombre from Miembros m join Asociaciones a on m.idAsosiacion=a.idAsosiacion where m.idCliente=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idClient));
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

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
