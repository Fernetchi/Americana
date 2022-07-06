
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modDepto;


public class consultaDepto extends conexion {
    public boolean registrar (modDepto modDpto) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO departamento (nombreDpto) VALUES (?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modDpto.getDepto()); 
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

    
    public boolean eliminar (modDepto modDpto) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM departamento WHERE nombreDpto=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modDpto.getDepto());
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
    
    
    public boolean buscar (modDepto modDpto) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM departamento WHERE nombreDpto=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modDpto.getDepto());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modDpto.setDepto(rs.getString("nombreDpto"));
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
