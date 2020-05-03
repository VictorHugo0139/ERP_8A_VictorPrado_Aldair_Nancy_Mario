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
public class MiembrosDAO {
    private static MiembrosDAO midao;
    
    public static MiembrosDAO getMiembrosDAO(){
    if(midao==null){
        midao= new MiembrosDAO();
    }                   
    return midao;                     
}

    private MiembrosDAO() {
    }

    
}
