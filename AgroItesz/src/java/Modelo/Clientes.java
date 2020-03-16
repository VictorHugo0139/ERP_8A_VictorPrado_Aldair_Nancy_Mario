
package Modelo;

public class Clientes {
    private int idCliente;
    private String nombre;
    private String razonSocial;
    private float limiteCredito;
    private String direccion;
    private String codigoPostal;
    private String rfc;
    private String telefono;
    private String email;
    private char tipo;
    private int idCiudad;
    private char estado;

    public Clientes(int idCliente, String nombre, String razonSocial, float limiteCredito, String direccion, String codigoPostal, String rfc, String telefono, String email, char tipo, int idCiudad, char estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.limiteCredito = limiteCredito;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.rfc = rfc;
        this.telefono = telefono;
        this.email = email;
        this.tipo = tipo;
        this.idCiudad = idCiudad;
        this.estado = estado;
    }

    public Clientes() {
       
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
}
