
package Modelo;

import java.sql.Date;

public class Envios {
    private int idEnvio;
    private Date fechaEntregaPlaneada;
    private Date fechaEntregaReal;
    private String direccion;
    private int codigoPostal;
    private int idVenta;
    private int idTransporte;
    private int idCiudad;
    private char Estado;

    public Envios(int idEnvio, Date fechaEntregaPlaneada, Date fechaEntregaReal, String direccion, int codigoPostal, int idVenta, int idTransporte, int idCiudad, char Estado) {
        this.idEnvio = idEnvio;
        this.fechaEntregaPlaneada = fechaEntregaPlaneada;
        this.fechaEntregaReal = fechaEntregaReal;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.idVenta = idVenta;
        this.idTransporte = idTransporte;
        this.idCiudad = idCiudad;
        this.Estado = Estado;
    }
    
    public Envios(){
        
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Date getFechaEntregaPlaneada() {
        return fechaEntregaPlaneada;
    }

    public void setFechaEntregaPlaneada(Date fechaEntregaPlaneada) {
        this.fechaEntregaPlaneada = fechaEntregaPlaneada;
    }

    public Date getFechaEntregaReal() {
        return fechaEntregaReal;
    }

    public void setFechaEntregaReal(Date fechaEntregaReal) {
        this.fechaEntregaReal = fechaEntregaReal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDirección(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public char getEstado() {
        return Estado;
    }

    public void setEstado(char Estado) {
        this.Estado = Estado;
    }
}

