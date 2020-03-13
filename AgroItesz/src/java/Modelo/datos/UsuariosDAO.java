package Modelo.datos;

import Conexion.Conexion;
import Modelo.Usuarios;
import Modelo.Validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO implements Validar {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    

    public Usuarios validar(String user, String pw) {
        Usuarios us = new Usuarios();
        sql = "select * from Usuario where nombre=? and contrasenia=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pw);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString("nombre"));
                us.setContrasenia(rs.getString("contrasenia"));
                us.setEstatus(rs.getString("estatus").charAt(0));
            }
        } catch (Exception e) {
        }
        return us;
    }

    @Override
    public int validar(Usuarios usr) {
        int r=0;
        String sql = "select * from Usuario where nombre=? and contrasenia=?;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getContrasenia());
            rs = ps.executeQuery();
            while (rs.next()) {
                r=r+1;
                usr.setNombre(rs.getString("nombre"));
                usr.setContrasenia(rs.getString("contrasenia"));
//                usr.setEstatus(rs.getString("estatus").charAt(0));
            }
            cn.closeConnection();
            if (r==1) {
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
