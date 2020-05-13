/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Victor
 */
public class Sucursal {
    int idSucursal;
    String nombre;
    String telefono;
    String direccion;
    String colonia;
    String codigoPostal;
    float Presupuesto;
    char estatus;
    int idCiudad;

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String nombre, String telefono, String direccion, String colonia, String codigoPostal, float Presupuesto, char estatus, int idCiudad) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.Presupuesto = Presupuesto;
        this.estatus = estatus;
        this.idCiudad = idCiudad;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirección() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public float getPresupuesto() {
        return Presupuesto;
    }

    public void setPresupuesto(float Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
}
