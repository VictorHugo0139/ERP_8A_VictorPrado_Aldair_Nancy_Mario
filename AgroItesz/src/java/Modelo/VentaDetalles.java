/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author Nancy
 */
public class VentaDetalles {
    
    private int idVentaDetalle;
    private float precioVenta;
    private float cantidad;
    private float subtotal;
    private int idVenta;
    private int idPresentacion;
    private char estatus;
    
    

    public VentaDetalles() {
    }

    public VentaDetalles(int idVentaDetalle, float precioVenta, float cantidad, float subtotal, int idVenta, int idPresentacion, char estatus) {
        this.idVentaDetalle = idVentaDetalle;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idVenta = idVenta;
        this.idPresentacion = idPresentacion;
        this.estatus = estatus;
    }

    
    public int getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(int idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
}
