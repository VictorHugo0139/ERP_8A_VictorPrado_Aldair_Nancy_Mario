
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

public class TransportesDAO implements CRUD{
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    @Override
    public String insertar(Object obj) {
        Transporte tr=(Transporte) obj;
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConnection();
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
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    @Override
    public String eliminar(int id) {
        String respuesta="";
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConnection();
        sql=("update Transporte set estatus='I' where idUnidadTransporte=? "); 
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas= ps.executeUpdate();
            respuesta="se eliminaron "+filas+" filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
