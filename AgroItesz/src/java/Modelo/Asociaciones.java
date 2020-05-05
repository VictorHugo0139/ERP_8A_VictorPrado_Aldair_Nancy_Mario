
package Modelo;


public class Asociaciones {
    private int idAsociacion;
    private String nombre;
    private char Estatus;

    public Asociaciones(int idAsociacion, String nombre, char Estatus) {
        this.idAsociacion = idAsociacion;
        this.nombre = nombre;
        this.Estatus = Estatus;
    }
    
    public Asociaciones(){
        
    }
    
    public int getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(int idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }
}
