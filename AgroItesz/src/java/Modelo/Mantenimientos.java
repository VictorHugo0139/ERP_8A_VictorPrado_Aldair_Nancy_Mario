
package Modelo;

import java.sql.Date;

public class Mantenimientos {
    
    private int idMantenimiento;
    private Date fecha;
    private String taller;
    private float costo;
    private String comentarios;
    private String tipo;
    private int idUnidadTransporte;
    private char Estatus;

    public Mantenimientos(int idMantenimiento, Date fecha, String taller, float costo, String comentarios, String tipo, int idUnidadTransporte, char Estatus) {
        this.idMantenimiento = idMantenimiento;
        this.fecha = fecha;
        this.taller = taller;
        this.costo = costo;
        this.comentarios = comentarios;
        this.tipo = tipo;
        this.idUnidadTransporte = idUnidadTransporte;
        this.Estatus = Estatus;
    }
    
    public Mantenimientos(){
    
}

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }
    
    
}
