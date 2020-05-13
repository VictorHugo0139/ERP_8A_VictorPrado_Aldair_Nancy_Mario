package Modelo.datos;

import Conexion.Conexion;
import Modelo.CRUD;
import Modelo.Envios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnviosDAO implements CRUD{
    private static EnviosDAO endao;    
    Conexion cn= Conexion.getInsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql;
public static EnviosDAO getEnviosDAO(){
    if(endao==null){
        endao= new EnviosDAO();
    }                   
    return endao;                     
}

    private EnviosDAO() {
        
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
    public List<Envios> consultar() {
        List<Envios> datos=new ArrayList<>();
        con=cn.getConexion();
        sql=("select * from Envios");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                datos.add(new Envios(rs.getInt("idEnvio"),
                        rs.getDate("fechaEntregaPlaneada"),
                        rs.getDate("fechaEntregaReal"),
                        rs.getString("Direccion"),
                        rs.getInt("codigoPostal"),
                        rs.getInt("idVenta"),
                        rs.getInt("idUnidadTransporte"),
                        rs.getInt("idCiudad"),
                        rs.getString("estatus").charAt(0)));
            }
            cn.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EnviosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    @Override
    public List<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
