
package Modelo;

public class Productos {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private int puntoReorden;
    private int precioCompra;
    private int precioVenta;
    private String ingredienteActivo;
    private String bandaToxicologica;
    private String aplicacion;
    private String uso;
    private int idLaboratorio;
    private int idCategoria;
    private char estatus;
    
    public Productos(int idProducto, String nombre, String descripcion, int puntoReorden, int precioCompra,int precioVenta, String ingredienteActivo,
                String bandaToxicologica, String aplicacion, String uso, int idLaboratotio, int idCategoria, char estatus){

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntoReorden = puntoReorden;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.ingredienteActivo = ingredienteActivo;
        this.bandaToxicologica = bandaToxicologica;
        this.aplicacion = aplicacion;
        this.uso = uso;
        this.idLaboratorio = idLaboratotio;
        this.idCategoria = idCategoria;
        this.estatus = estatus;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(int puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getIngredienteActivo() {
        return ingredienteActivo;
    }

    public void setIngredienteActivo(String ingredienteActivo) {
        this.ingredienteActivo = ingredienteActivo;
    }

    public String getBandaToxicologica() {
        return bandaToxicologica;
    }

    public void setBandaToxicologica(String bandaToxicologica) {
        this.bandaToxicologica = bandaToxicologica;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
}

