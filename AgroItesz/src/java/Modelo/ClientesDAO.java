
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO implements CRUD{
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    @Override
    public String insertar(Object obj) {
        Clientes cl=(Clientes) obj;
        String respuesta="";
        con=cn.getConnection();
        sql=("insert into clientes values(?,?,?,?,?,?,?,?,?,?,?,?)"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cl.getIdCliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getRazonSocial());
            ps.setFloat(4, cl.getLimiteCredito());
            ps.setString(5, cl.getDireccion());
            ps.setString(6, cl.getCodigoPostal());
            ps.setString(7, cl.getRfc());
            ps.setString(8, cl.getTelefono());
            ps.setString(9, cl.getEmail());
            ps.setString(10, ""+cl.getTipo());
            ps.setInt(11, cl.getIdCiudad());
            ps.setString(12, ""+cl.getEstado());
            int filas= ps.executeUpdate();
            respuesta="se insertaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String eliminar(Object obj) {
        Clientes cl=(Clientes) obj;
        String respuesta="";
        con=cn.getConnection();
        sql=("delete from Clientes where idCliente=? "); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cl.getIdCliente());
            int filas= ps.executeUpdate();
            respuesta="se eliminaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String actualizar(Object obj) {
         Clientes cl=(Clientes) obj;
        String respuesta="";
        con=cn.getConnection();
        sql=("update Clientes set nombre=?, razonSocial=?, limiteCredito=?, direccion=?, codigoPostal=?, rfc=?, telefono=?, email=?, tipo=?, idCiudad=?, estatus=? where idCliente=?"); 
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getRazonSocial());
            ps.setFloat(3, cl.getLimiteCredito());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCodigoPostal());
            ps.setString(6, cl.getRfc());
            ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getEmail());
            ps.setString(9, ""+cl.getTipo());
            ps.setInt(10, cl.getIdCiudad());
            ps.setString(11, ""+cl.getEstado());
            ps.setInt(12, cl.getIdCliente());
            int filas= ps.executeUpdate();
            respuesta="se actualizaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Clientes> consultar() {
        List<Clientes> datos=new ArrayList<>();
        con=cn.getConnection();
        sql=("select * from Clientes");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Clientes(rs.getInt("idCliente"),
                        rs.getString("nombre"),
                        rs.getString("razonSocial"),
                        rs.getFloat("limiteCredito"),
                        rs.getString("direccion"),
                        rs.getString("codigoPostal"),
                        rs.getString("rfc"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("tipo").charAt(0),
                        rs.getInt("idCiudad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
