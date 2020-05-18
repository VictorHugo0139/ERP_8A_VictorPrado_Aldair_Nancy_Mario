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
public class Presentacion {

    public int idPresentacion;
    public float precioCompra;
    public float precioVenta;
    public float puntoReorden;
    public int idProducto;
    public int idEmpaque;

    public Presentacion(int idPresentacion, float precioCompra, float precioVenta, float puntoReorden, int idProducto, int idEmpaque) {
        this.idPresentacion = idPresentacion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.puntoReorden = puntoReorden;
        this.idProducto = idProducto;
        this.idEmpaque = idEmpaque;
    }

    public Presentacion() {
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(float puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdEmpaque() {
        return idEmpaque;
    }

    public void setIdEmpaque(int idEmpaque) {
        this.idEmpaque = idEmpaque;
    }
    

}
