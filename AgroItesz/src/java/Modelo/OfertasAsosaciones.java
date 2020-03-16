/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Nancy
 */
public class OfertasAsosaciones {
    
    private int idAsosaciones;
    private int idOferta;
    private char  Estatus;

    public int getIdAsosaciones() {
        return idAsosaciones;
    }

    public void setIdAsosaciones(int idAsosaciones) {
        this.idAsosaciones = idAsosaciones;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }
    
}
