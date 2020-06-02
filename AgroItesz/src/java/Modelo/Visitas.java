
package Modelo;

import java.sql.Date;

public class Visitas {
    private int idVisita;
    private Date fechaPlaneada;
    private Date fechaReal;
    private String comentarios;
    private char Estado;
    private float costo;
    private int idClienteCultivo;
    private int idEmpleado;
    private int idTransporte;

    public Visitas(int idVisita, Date fechaPlaneada, Date fechaReal, String comentarios, char Estado, float costo, int idClienteCultivo, int idEmpleado, int idTransporte) {
        this.idVisita = idVisita;
        this.fechaPlaneada = fechaPlaneada;
        this.fechaReal = fechaReal;
        this.comentarios = comentarios;
        this.Estado = Estado;
        this.costo = costo;
        this.idClienteCultivo = idClienteCultivo;
        this.idEmpleado = idEmpleado;
        this.idTransporte = idTransporte;
    }
    
    public Visitas(){
        
    }


    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Date getFechaPlaneada() {
        return fechaPlaneada;
    }

    public void setFechaPlaneada(Date fechaPlaneada) {
        this.fechaPlaneada = fechaPlaneada;
    }

    public Date getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(Date fechaReal) {
        this.fechaReal = fechaReal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public char getEstado() {
        return Estado;
    }

    public void setEstado(char Estado) {
        this.Estado = Estado;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getIdClienteCultivo() {
        return idClienteCultivo;
    }

    public void setIdClienteCultivo(int idClienteCultivo) {
        this.idClienteCultivo = idClienteCultivo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }
    

}
    