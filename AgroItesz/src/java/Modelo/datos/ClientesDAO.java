package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO implements CRUD {

    private static ClientesDAO cldao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static ClientesDAO getClientesDAO() {
        if (cldao == null) {
            cldao = new ClientesDAO();
        }
        return cldao;
    }

    public ClientesDAO() {
    }

    @Override
    public String insertar(Object obj) {
        Clientes cl = (Clientes) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("insert into Clientes(nombre,razonSocial,limiteCredito,direccion,codigoPostal,rfc,telefono,email,tipo,idCiudad,estatus)\n"
                + "values (?,?,?,?,?,?,?,?,?,?,?)");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getRazonSocial());
            ps.setFloat(3, cl.getLimiteCredito());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCodigoPostal());
            ps.setString(6, cl.getRfc());
            ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getEmail());
            ps.setString(9, "" + cl.getTipo());
            ps.setInt(10, cl.getIdCiudad());
            ps.setString(11, "" + cl.getEstado());
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
        sql = ("update Clientes set estatus='I' where idCliente=? ");
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
        sql = ("update Clientes set estatus='A' where idCliente=? ");
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
        Clientes cl = (Clientes) obj;
        String respuesta = "";
        con = cn.getConexion();
        sql = ("update Clientes set nombre=?, razonSocial=?, limiteCredito=?, direccion=?, codigoPostal=?, rfc=?, telefono=?, email=?, tipo=?, idCiudad=?, estatus=? where idCliente=?");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getRazonSocial());
            ps.setFloat(3, cl.getLimiteCredito());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getCodigoPostal());
            ps.setString(6, cl.getRfc());
            ps.setString(7, cl.getTelefono());
            ps.setString(8, cl.getEmail());
            ps.setString(9, "" + cl.getTipo());
            ps.setInt(10, cl.getIdCiudad());
            ps.setString(11, "" + cl.getEstado());
            ps.setInt(12, cl.getIdCliente());
            int filas = ps.executeUpdate();
            respuesta = "se actualizaron " + filas + " filas";
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public List<Clientes> consultar() {
        List<Clientes> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Clientes");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    public List<Clientes> filtrar(String campo, String criterio) {
        List<Clientes> datos = new ArrayList<>();
        con = cn.getConexion();
//        String c="\'"+criterio+"\'";
//        System.out.println(campo+" y "+criterio);
        if ("Ciudad".equals(campo)) {
sql = "select*from clientes c join ciudades ci on c.idCiudad=ci.idCiudad where ci.nombre like'%"+criterio+"%';";
         try {
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
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
        } else {
            if ("estatus".equals(campo)) {
                if (criterio.startsWith("in")|criterio.startsWith("In")) {
                    sql = "select * from Clientes where " + campo + " = 'I'";
                    try {
                        ps = con.prepareStatement(sql);
                        rs = ps.executeQuery();
                        while (rs.next()) {
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
                } else {
                    if (criterio.startsWith("ac")|criterio.startsWith("Ac")) {
                        sql = "select * from Clientes where " + campo + " = 'A'";
                        try {
                            ps = con.prepareStatement(sql);
                            rs = ps.executeQuery();
                            while (rs.next()) {
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
                    } else {
                        return datos;
                    }
                }
            } else {
                sql = "select * from Clientes where " + campo + " like '%" + criterio + "%'";
//        sql=("select * from Clientes where ? like CONCAT( '%',?,'%');");
                try {
                    ps = con.prepareStatement(sql);
//            ps.setString(1, campo);
//            ps.setString(2, criterio);
                    rs = ps.executeQuery();
                    while (rs.next()) {
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
                        System.out.println(rs.getInt("idCliente") + "," + rs.getString("nombre"));
                    }
                    cn.closeConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return datos;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Clientes> consultarId(int id) {
        List<Clientes> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Clientes where idCliente=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
}
