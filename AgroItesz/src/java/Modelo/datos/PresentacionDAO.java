/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Presentacion;

/**
 *
 * @author Nancy
 */
public class PresentacionDAO implements CRUD {
    
    private static PresentacionDAO pRdao;
    Conexion cn = Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
     public static PresentacionDAO getPresentacionDAO() {
        if (pRdao == null) {
            pRdao = new PresentacionDAO();
        }
        return pRdao;
    }

    public PresentacionDAO() {
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
    public List<Presentacion> consultar() {
        List<Presentacion > datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from PresentacionesProductos;");
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Presentacion(rs.getInt("idPresentacion"),
                        rs.getFloat("precioCompra"),
                        rs.getFloat("precioVenta"),
                        rs.getFloat("puntoReorden"),
                        rs.getInt("idProducto"),
                        rs.getInt("idEmpaque")));
                                
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
    
    
    
    
        public List<Presentacion> consultarId(int id) {
        List<Presentacion> datos = new ArrayList<>();
        con = cn.getConexion();
        sql = ("select * from PresentacionesProductos where idPresentacion=" + id);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(new Presentacion(rs.getInt("idPresentacion"),
                       rs.getFloat("precioCompra"),
                        rs.getFloat("precioVenta"),
                        rs.getFloat("puntoReorden"),
                        rs.getInt("puntoReorden"),
                        rs.getInt("idEmpaque")));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
    

