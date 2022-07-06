/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modeloEmpleado;
import modelo.modeloSalario;
import vista.frmSalario;

/**
 *
 * @author Fernando
 */
public class consultaSalario extends conexion {
    
    
    
    public ArrayList BuscarEmpleado (modeloEmpleado modEm) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Connection con = getConexion();
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM empleados";
        ArrayList<String> agg = new ArrayList();
        try { 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                    while (rs.next()) {
                        String lsEmpleado = rs.getString("nomEm");
                        agg.add(lsEmpleado);
                    }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return agg;
    }
    
    
    public ResultSet ObtieneIdEmpleado(modeloSalario modSa) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT idempleado FROM empleados where nomEm LIKE '%" + modSa.getEmpleado() + "%'; ";
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
     public boolean registrar (modeloSalario modSa) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO salario(sueldo, cargo, empleados_idempleado) VALUES (?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1,modSa.getSueldoSa());
            ps.setString(2,modSa.getCargoSa());
            ps.setInt(3,modSa.getRelacionSalario());
            
            ps.execute();
            return true;
             
        } catch (SQLException e) {
            
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);            }
        }
        
    }
}
    
