
package Modelo;


public class OfertasAsosaciones {
    
    private int idOfertaAsociacion;
    private int idAsosiacion;
    private int idOferta;
    private char  Estatus;

    public OfertasAsosaciones(int idOfertaAsociacion, int idAsosiacion, int idOferta, char Estatus) {
        this.idOfertaAsociacion = idOfertaAsociacion;
        this.idAsosiacion = idAsosiacion;
        this.idOferta = idOferta;
        this.Estatus = Estatus;
    }
    
    public OfertasAsosaciones(){
        
    }

    public int getIdOfertaAsociacion() {
        return idOfertaAsociacion;
    }

    public void setIdOfertaAsociacion(int idOfertaAsociacion) {
        this.idOfertaAsociacion = idOfertaAsociacion;
    }

    public int getIdAsosiacion() {
        return idAsosiacion;
    }

    public void setIdAsosiacion(int idAsosiacion) {
        this.idAsosiacion = idAsosiacion;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public char getEstatus() {
        return Estatus;
    }

    public void setEstatus(char Estatus) {
        this.Estatus = Estatus;
    }

    
    
}
