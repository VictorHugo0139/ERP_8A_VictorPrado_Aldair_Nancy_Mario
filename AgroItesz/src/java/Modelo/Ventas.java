/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class Ventas {
    private int idVenta;
    private Date fecha;
    private float totalPagar;
    private float CantPagada;
    private String comentarios;
    private char estatus;
    private char tipo;
    private int idCliente;
    private int idSucursal;
    private int idEmpleado;

    public Ventas() {
    }

    public Ventas(int idVenta, Date fecha, float totalPagar, float CantPagada, String comentarios, char estatus, char tipo, int idCliente, int idSucursal, int idEmpleado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.totalPagar = totalPagar;
        this.CantPagada = CantPagada;
        this.comentarios = comentarios;
        this.estatus = estatus;
        this.tipo = tipo;
        this.idCliente = idCliente;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public float getCantPagada() {
        return CantPagada;
    }

    public void setCantPagada(float CantPagada) {
        this.CantPagada = CantPagada;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
