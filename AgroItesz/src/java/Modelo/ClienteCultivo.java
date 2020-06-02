
package Modelo;


public class ClienteCultivo {
    private int idClienteCultivo;
    private float extencion;
    private String ubicacion;
    private int idCliente;
    private int idCultivo;
    private int idCiudad;
    private char estatus;

    public ClienteCultivo(int idClienteCultivo, float extencion, String ubicacion, int idCliente, int idCultivo, int idCiudad, char estatus) {
        this.idClienteCultivo = idClienteCultivo;
        this.extencion = extencion;
        this.ubicacion = ubicacion;
        this.idCliente = idCliente;
        this.idCultivo = idCultivo;
        this.idCiudad = idCiudad;
        this.estatus = estatus;
    }
    
    public ClienteCultivo(){
        
    }

    public int getIdClienteCultivo() {
        return idClienteCultivo;
    }

    public void setIdClienteCultivo(int idClienteCultivo) {
        this.idClienteCultivo = idClienteCultivo;
    }

    public float getExtencion() {
        return extencion;
    }

    public void setExtencion(float extencion) {
        this.extencion = extencion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
    
    
}
