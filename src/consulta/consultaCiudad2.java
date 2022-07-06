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
import modelo.modCiudad;
import modelo.modCiudad2;
import modelo.modDepto;

public class consultaCiudad2 extends conexion {
    
    public boolean registrar (modCiudad2 modCity2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO ciudad (nombreCiudad) VALUES (?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modCity2.getCiudad()); 
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

    
    public boolean eliminar (modCiudad2 modCity2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM ciudad WHERE nombreCiudad=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modCity2.getCiudad());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
    
    
    public boolean buscar (modCiudad2 modCity2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM ciudad WHERE nombreCiudad=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modCity2.getCiudad());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modCity2.setCiudad(rs.getString("nombreCiudad"));
                return true;
            }      
            return false;  
        } catch (SQLException e) {
            
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
}
