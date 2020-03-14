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
    public static String name;
    public static String p;

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
        int r = 0;
        String sql = "select * from Usuario where nombre=? and contrasenia=?;";
        try {
            cn.setUserName(usr.getNombre());
            cn.setPassword(usr.getContrasenia());
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getContrasenia());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
//                usr.setNombre(rs.getString("nombre"));
//                usr.setContrasenia(rs.getString("contrasenia"));
                usr.setEstatus(rs.getString("estatus").charAt(0));
            }
//            cn.closeConnection();
            if (r == 1) {
                r = 0;
                sql = "select sp.name as login\n"
                        + "from sys.server_principals sp\n"
                        + "left join sys.sql_logins sl\n"
                        + "          on sp.principal_id = sl.principal_id\n"
                        + "where sp.type not in ('G', 'R') and sp.name=? \n"
                        + "order by sp.name;";
//                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, usr.getNombre());
                rs = ps.executeQuery();
                while (rs.next()) {
                    r = r + 1;
                }
                cn.closeConnection();
                if (r == 1) {
                    if (usr.getEstatus() == 'a') {
                        name = usr.getNombre();
                        p = usr.getContrasenia();
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
