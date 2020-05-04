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
public class Ofertas {

    private int idOfertas;
    private String Nombre;
    private String Descripcion;
    private int PorDescuento;
    private int FechaInicio;
    private int FechaFin;
    private int canMinProducto;
    private char Estatus;
    private int idProducto;

    public Ofertas(int idOfertas, String Nombre, String Descripcion, int PorDescuento, int FechaInicio, int FechaFin, int canMinProducto, char Estatus, int idProducto) {
        this.idOfertas = idOfertas;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.PorDescuento = PorDescuento;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.canMinProducto = canMinProducto;
        this.Estatus = Estatus;
        this.idProducto = idProducto;
    }
    
    public Ofertas(){
        
    }
    
    public int getIdOfertas() {
        return idOfertas;
    }

    public void setIdOfertas(int idOfertas) {
        this.idOfertas = idOfertas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPorDescuento() {
        return PorDescuento;
    }

    public void setPorDescuento(int PorDescuento) {
        this.PorDescuento = PorDescuento;
    }

    public int getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(int FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public int getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(int FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getCanMinProducto() {
        return canMinProducto;
    }

    public void setCanMinProducto(int CantMinProducto) {
        this.canMinProducto = CantMinProducto;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    

}
