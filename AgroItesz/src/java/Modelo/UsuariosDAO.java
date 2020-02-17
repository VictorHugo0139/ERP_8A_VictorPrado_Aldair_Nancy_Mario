
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuarios validar(String user, String pw){
         Usuarios us= new Usuarios();
         String sql="select * from Usuario where nombre=? and contrasenia=?;";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
//            ps.setString(1, user);
//            ps.setString(2, pw);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                us.setNombre(rs.getString("nombre"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setEstatus(rs.getString("estatus").charAt(0));
            }
        } catch (Exception e) {
        }
        return us;
    }
}
