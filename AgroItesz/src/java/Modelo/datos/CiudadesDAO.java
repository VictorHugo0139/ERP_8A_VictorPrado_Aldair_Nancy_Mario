
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

    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudades> filtrar(String campo, String criterio) {
         List<Ciudades> datos=new ArrayList<>();
        cn.setUserName(UsuariosDAO.name);
        cn.setPassword(UsuariosDAO.p);
        con=cn.getConnection();
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
    
}
