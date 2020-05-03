/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.datos;

import Conexion.Conexion;

/**
 *
 * @author Nancy
 */
public class OfertasAsosacionesDAO {
    private static OfertasAsosacionesDAO ofAdao;
    
    public static OfertasAsosacionesDAO getOfertasAsociacionesDAO(){
    if(ofAdao==null){
        ofAdao= new OfertasAsosacionesDAO();
    }                   
    return ofAdao;                     
}

    private OfertasAsosacionesDAO() {
    }

}
