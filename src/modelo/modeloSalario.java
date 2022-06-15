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
    private double sueldoSa;
    private String cargoSa;
    private String empleadofk;

    public int getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(int idSalario) {
        this.idSalario = idSalario;
    }

    public double getSueldoSa() {
        return sueldoSa;
    }

    public void setSueldoSa(double sueldoSa) {
        this.sueldoSa = sueldoSa;
    }

    public String getCargoSa() {
        return cargoSa;
    }

    public void setCargoSa(String cargoSa) {
        this.cargoSa = cargoSa;
    }

    public String getEmpleadofk() {
        return empleadofk;
    }

    public void setEmpledoifk(String empledoifk) {
        this.empleadofk = empledoifk;
    }

    public void setEmpleadofk(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
