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
public class OfertasDAO {
    private static OfertasDAO odao;
    
    public static OfertasDAO getOfertasDAO(){
    if(odao==null){
        odao= new OfertasDAO();
    }                   
    return odao;                     
}

    private OfertasDAO() {
    }

}
