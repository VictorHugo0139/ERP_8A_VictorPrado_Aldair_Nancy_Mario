/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Victor
 */
public class Empleados {
    int idEmpleado;
    String nombre;
    String aPaterno;
    String aMaterno;
    char sexo;
    Date fechaContratacion;
    Date fechaNacimiento;
    float salario;
    String nss;
    String estadoCivil;
    int diasVacacionales;
    int diasPermiso;
    String fotografia;
    String direccion;
    String colonia;
    String codigoPostal;
    String escolaridad;
    float porcentajeComision;
    char estatus;
    int idDepartamento;
    int idPuesto;
    int idCiudad;
    int idSucursal;

    public Empleados() {
    }

    public Empleados(int idEmpleado, String nombre, String aPaterno, String aMaterno, char sexo, Date fechaContratacion, Date fechaNacimiento, float salario, String nss, String estadoCivil, int diasVacacionales, int diasPermiso, String fotografia, String direccion, String colonia, String codigoPostal, String escolaridad, float porcentajeComision, char estatus, int idDepartamento, int idPuesto, int idCiudad, int idSucursal) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.sexo = sexo;
        this.fechaContratacion = fechaContratacion;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.nss = nss;
        this.estadoCivil = estadoCivil;
        this.diasVacacionales = diasVacacionales;
        this.diasPermiso = diasPermiso;
        this.fotografia = fotografia;
        this.direccion = direccion;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.escolaridad = escolaridad;
        this.porcentajeComision = porcentajeComision;
        this.estatus = estatus;
        this.idDepartamento = idDepartamento;
        this.idPuesto = idPuesto;
        this.idCiudad = idCiudad;
        this.idSucursal = idSucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getDiasVacacionales() {
        return diasVacacionales;
    }

    public void setDiasVacacionales(int diasVacacionales) {
        this.diasVacacionales = diasVacacionales;
    }

    public int getDiasPermiso() {
        return diasPermiso;
    }

    public void setDiasPermiso(int diasPermiso) {
        this.diasPermiso = diasPermiso;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
}
