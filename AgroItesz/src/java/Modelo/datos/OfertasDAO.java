
package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Ofertas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OfertasDAO implements CRUD{
    private static OfertasDAO ofdao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static OfertasDAO getOfertasDAO(){
    if(ofdao==null){
        ofdao= new OfertasDAO();
    }                   
    return ofdao;                     
}

    private OfertasDAO() {
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
    public List<Ofertas> consultar() {
        List<Ofertas> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Ofertas");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Ofertas(rs.getInt("idOferta"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("porDescuento"),
                        rs.getInt("fechaInicio"),
                        rs.getInt("fechaFin"),
                        rs.getInt("canMinProducto"),
                        rs.getString("estatus").charAt(0),
                        rs.getInt("idProducto")));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OfertasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
