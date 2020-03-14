
package Modelo;

public class Transporte {
    private int idTransporte;
    private String Placas;
    private String Marca;
    private String Modelo;
    private int Año;
    private int Capacidad;
    private char estado;
    
    public Transporte(){
        
    }

    public Transporte(int idTransporte, String Placas, String Marca, String Modelo, int Año, int Capacidad, char estado) {
        this.idTransporte = idTransporte;
        this.Placas = Placas;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Año = Año;
        this.Capacidad = Capacidad;
        this.estado = estado;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getPlacas() {
        return Placas;
    }

    public void setPlacas(String Placas) {
        this.Placas = Placas;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
}
