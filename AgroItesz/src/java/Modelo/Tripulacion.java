/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author resid
 */
public class Tripulacion {
    
    private int idEmpleado;
    private int idEnvio;
    private String rol;
    private char estado;
    private int idTripulacion;

    public Tripulacion(int idEmpleado, int idEnvio, String rol, char estado, int idTripulacion) {
        this.idEmpleado = idEmpleado;
        this.idEnvio = idEnvio;
        this.rol = rol;
        this.estado = estado;
        this.idTripulacion = idTripulacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Tripulacion() {
    }
    
    public int getIdTripulacion() {
        return idTripulacion;
    }

    public void setIdTripulacion(int idTripulacion) {
        this.idTripulacion = idTripulacion;
    }
    
}