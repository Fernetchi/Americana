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
import modelo.modeloBarrio;
import modelo.modeloBarrio2;

/**
 *
 * @author Fernando
 */
public class consultaBarrio2 extends conexion {
     public boolean registrar (modeloBarrio2 modBarrio2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO barrio (nombreBarrio) VALUES (?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modBarrio2.getBarrio()); 
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

    
    public boolean eliminar (modeloBarrio2 modBarrio2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM barrio WHERE nombreBarrio=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modBarrio2.getBarrio());
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
    
    
    public boolean buscar (modeloBarrio2 modBarrio2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM barrio WHERE nombreBarrio=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modBarrio2.getBarrio());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modBarrio2.setBarrio(rs.getString("nombreBarrio"));
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
