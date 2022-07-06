/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando
 */
public class modeloSalario {
    
    private int idSalario;
    private int sueldoSa;
    private String cargoSa;
    private String empleado;
    private int relacionSalario;

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getRelacionSalario() {
        return relacionSalario;
    }

    public void setRelacionSalario(int relacionSalario) {
        this.relacionSalario = relacionSalario;
    }

    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    public int getSueldoSa() {
        return sueldoSa;
    }

    public void setSueldoSa(int sueldoSa) {
        this.sueldoSa = sueldoSa;
    }

    public String getCargoSa() {
        return cargoSa;
    }

    public void setCargoSa(String cargoSa) {
        this.cargoSa = cargoSa;
    }
   
}
