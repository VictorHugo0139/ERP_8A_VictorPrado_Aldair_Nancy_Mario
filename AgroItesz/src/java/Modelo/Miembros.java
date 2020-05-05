/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

public class Miembros {
    private int idCliente;
    private int idAsosaciones;
    private  char Estatus;
    private Date FechaIncorporacion;

    public Miembros() {
    }

    public Miembros(int idCliente, int idAsosaciones, char Estatus, Date FechaIncorporacion) {
        this.idCliente = idCliente;
        this.idAsosaciones = idAsosaciones;
        this.Estatus = Estatus;
        this.FechaIncorporacion = FechaIncorporacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getidAsosaciones() {
        return idAsosaciones;
    }

    public void setdAsosacione(int idAsosaciones) {
        this.idAsosaciones = idAsosaciones;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }

    public Date getFechaIncorporacion() {
        return FechaIncorporacion;
    }

    public void setFechaIncorporacion(Date FechaIncorporacion) {
        this.FechaIncorporacion = FechaIncorporacion;
    }
    
            
}
