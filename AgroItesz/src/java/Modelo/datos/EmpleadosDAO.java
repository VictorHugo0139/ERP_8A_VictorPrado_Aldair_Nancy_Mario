/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Empleados;
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
 * @author Victor
 */
public class EmpleadosDAO implements CRUD {

    private static EmpleadosDAO edao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public static EmpleadosDAO getEmpleadosDAO() {
        if (edao == null) {
            edao = new EmpleadosDAO();
        }
        return edao;
    }

    private EmpleadosDAO() {
    }

    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleados> consultar() {
        List<Empleados> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Empleados");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Empleados(rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("aPaterno"),
                        rs.getString("aMaterno"),
                        rs.getString("sexo").charAt(0),
                        rs.getDate("fechaContratacion"),
                        rs.getDate("fechaNacimiento"),
                        rs.getFloat("salario"),
                        rs.getString("nss"),
                        rs.getString("estadoCivil"),
                        rs.getInt("diasVacacionales"),
                        rs.getInt("diasPermiso"),
                        rs.getString("fotografia"),
                        rs.getString("direccion"),
                        rs.getString("colonia"),
                        rs.getString("codigoPostal"),
                        rs.getString("escolaridad"),
                        rs.getFloat("porcentajeComision"),
                        rs.getString("estatus").charAt(0),
                        rs.getInt("idDepartamento"),
                        rs.getInt("idPuesto"),
                        rs.getInt("idCiudad"),
                        rs.getInt("idSucursal")
                ));
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

    public List<Empleados> consultarId(int id) {
        List<Empleados> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from Empleados where idEmpleado=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Empleados(rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("aPaterno"),
                        rs.getString("aMaterno"),
                        rs.getString("sexo").charAt(0),
                        rs.getDate("fechaContratacion"),
                        rs.getDate("fechaNacimiento"),
                        rs.getFloat("salario"),
                        rs.getString("nss"),
                        rs.getString("estadoCivil"),
                        rs.getInt("diasVacacionales"),
                        rs.getInt("diasPermiso"),
                        rs.getString("fotografia"),
                        rs.getString("direccion"),
                        rs.getString("colonia"),
                        rs.getString("codigoPostal"),
                        rs.getString("escolaridad"),
                        rs.getFloat("porcentajeComision"),
                        rs.getString("estatus").charAt(0),
                        rs.getInt("idDepartamento"),
                        rs.getInt("idPuesto"),
                        rs.getInt("idCiudad"),
                        rs.getInt("idSucursal")
                ));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public String OneEmpleado(int idEmpleado) {
        String nombre="";
        con=cn.getConexion();
        sql=("select*from Empleados where idEmpeado=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idEmpleado));
            rs=ps.executeQuery();
            while(rs.next()){
                nombre=rs.getString("nombre");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
    
    public int OneEmpleado(String idEmpleado) {
        int id=0;
        con=cn.getConexion();
        sql=("select*from Empleados where nombre=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idEmpleado));
            rs=ps.executeQuery();
            while(rs.next()){
                id=rs.getInt("idEmpleado");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
     public int OneSucursal(int idEmpleado) {
        int id=0;
        con=cn.getConexion();
        sql=("Select s.idSucursal from Empleados e join Sucursales s on e.idSucursal=s.idSucursal where e.idEmpleado=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idEmpleado));
            rs=ps.executeQuery();
            while(rs.next()){
                id=rs.getInt("idSucursal");
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
}
