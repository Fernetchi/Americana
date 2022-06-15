/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.modeloSalario;
import vista.frmSalario;

/**
 *
 * @author Fernando
 */
public class consultaSalario extends conexion {
    
     public boolean registrar (modeloSalario modSa) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO salario(sueldo, cargo, empleados_idempleado) VALUES (?,?,? )";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1,modSa.getSueldoSa());
            ps.setString(2,modSa.getCargoSa());
            ps.setString(3,modSa.getEmpleadofk());
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
    
