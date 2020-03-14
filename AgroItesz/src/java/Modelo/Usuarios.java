
package Modelo;

public class Usuarios {
    private String nombre;
    private String contrasenia;
    private char estatus;
    private int idTipoEmpleado;
    private int idTipoUsuario;

    public Usuarios() {
    }

    public Usuarios(String nombre, String contrasenia, char estatus, int idTipoEmpleado, int idTipoUsuario) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.estatus = estatus;
        this.idTipoEmpleado = idTipoEmpleado;
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public int getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
}
