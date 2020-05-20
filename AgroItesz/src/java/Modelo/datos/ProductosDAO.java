
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductosDAO implements CRUD{
    
    private static ProductosDAO fdao;
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
    
    public static ProductosDAO getProducosDAO(){
    if(fdao==null){
        fdao= new ProductosDAO();
    }                   
    return fdao;                     
}

    private ProductosDAO() {
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
    public List<Productos> consultar() {
        List<Productos> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Productos;");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Productos(rs.getInt("idProducto"),
                        rs.getString("nombre"), 
                        rs.getString("descripcion"),
                        rs.getInt("puntoReorden"),
                        rs.getInt("precioCompra"),
                        rs.getInt("precioVenta"),
                        rs.getString("ingredienteActivo"),
                        rs.getString("bandatoxicologica"),
                        rs.getString("aplicacion"),
                        rs.getString("uso"),
                        rs.getInt("idLaboratorio"),
                        rs.getInt("idCategorias"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datos; 
    }

    @Override
    public List<Productos> filtrar(String campo, String criterio) {
        List<Productos> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Productos where ? like '%?%';");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, campo);
            ps.setString(2, criterio);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Productos(rs.getInt("idProducto"),
                        rs.getString("nombre"), 
                        rs.getString("descripcion"),
                        rs.getInt("puntoReorden"),
                        rs.getInt("precioCompra"),
                        rs.getInt("precioVenta"),
                        rs.getString("ingredienteActivo"),
                        rs.getString("bandatoxicologica"),
                        rs.getString("aplicacion"),
                        rs.getNString("uso"),
                        rs.getInt("idLaboratorio"),
                        rs.getInt("idCategoria"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    public String OneProduct(int idProduct) {
        String nombre="";
        con=cn.getConexion();
        sql=("select * from Productos where idProducto=?;");
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, String.valueOf(idProduct));
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
}
