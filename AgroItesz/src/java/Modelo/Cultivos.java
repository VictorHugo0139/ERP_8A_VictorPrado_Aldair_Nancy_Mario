package Modelo;


public class Cultivos {
    private int idCultivo;
    private String nombre;
    private float CostoAsesoria;
    private char estado;
    //Hola

    public Cultivos(int idCultivo, String nombre, float CostoAsesoria, char estado) {
        this.idCultivo = idCultivo;
        this.nombre = nombre;
        this.CostoAsesoria = CostoAsesoria;
        this.estado = estado;
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

    public float getCostoAsesoria() {
        return CostoAsesoria;
    }

    public void setCostoAsesoria(float CostoAsesoria) {
        this.CostoAsesoria = CostoAsesoria;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    

    public Cultivos() {
        
    }

   
    
}


