package Modelo;


public class Cultivos {
    private int idCultivo;
    private String nombre;
    private int CostoAsesoria;
    private char estado;
    //Hola
    
    public Cultivos(int idCultivo, String nombre, int CostoAsesoria, char estado){
        this.idCultivo = idCultivo;
        this.nombre = nombre;
        this.CostoAsesoria = CostoAsesoria;
        this.estado = estado;
    }

    public Cultivos() {
        
    }

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoAsesoria() {
        return CostoAsesoria;
    }

    public void setCostoAsesoria(int CostoAsesoria) {
        this.CostoAsesoria = CostoAsesoria;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
}


