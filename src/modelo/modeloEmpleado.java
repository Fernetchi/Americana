/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class modeloEmpleado {
    private int idEmpleado;
    private String cedula;
    private String nombreEm;
    private String apellidoEm;
    private int edadEm;
    private String direccionEm;
    private int telefonoEm;
    private String correoEm;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEm() {
        return nombreEm;
    }

    public void setNombreEm(String nombreEm) {
        this.nombreEm = nombreEm;
    }

    public String getApellidoEm() {
        return apellidoEm;
    }

    public void setApellidoEm(String apellidoEm) {
        this.apellidoEm = apellidoEm;
    }

    public int getEdadEm() {
        return edadEm;
    }

    public void setEdadEm(int edadEm) {
        this.edadEm = edadEm;
    }

    public String getDireccionEm() {
        return direccionEm;
    }

    public void setDireccionEm(String direccionEm) {
        this.direccionEm = direccionEm;
    }

    public int getTelefonoEm() {
        return telefonoEm;
    }

    public void setTelefonoEm(int telefonoEm) {
        this.telefonoEm = telefonoEm;
    }

    public String getCorreoEm() {
        return correoEm;
    }

    public void setCorreoEm(String correoEm) {
        this.correoEm = correoEm;
    }
}
