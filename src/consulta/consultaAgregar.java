
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.modeloAgregar;


public class consultaAgregar extends conexion {
    
    public boolean registrar (modeloAgregar modAgg) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO registroencuesta (codigoEn, nombreEn, apellidoEn, edadEn, sexoEn, dptoEn, ciudadEn, barrioEn) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg.getCodigo());
            ps.setString(2,modAgg.getNombre());
            ps.setString(3,modAgg.getApellido());
            ps.setInt(4,modAgg.getEdad());
            ps.setString(5,modAgg.getSexo());
            ps.setString(6,modAgg.getDpto());
            ps.setString(7,modAgg.getCiudad());
            ps.setString(8,modAgg.getBarrio());
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
    
    public boolean modificar (modeloAgregar modAgg) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE registroencuesta SET codigoEn=?, nombreEn=?, apellidoEn=?, edadEn=?, sexoEn=?, dptoEn=?, ciudadEn=?, barrioEn=? WHERE idRegistro=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg.getCodigo());
            ps.setString(2,modAgg.getNombre());
            ps.setString(3,modAgg.getApellido());
            ps.setInt(4,modAgg.getEdad());
            ps.setString(5,modAgg.getSexo());
            ps.setString(6,modAgg.getDpto());
            ps.setString(7,modAgg.getCiudad());
            ps.setString(8,modAgg.getBarrio());
            ps.setInt(9,modAgg.getIdRegistro());
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
    
    public boolean eliminar (modeloAgregar modAgg) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM registroencuesta WHERE idRegistro=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,modAgg.getIdRegistro());
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
    
    public boolean buscar (modeloAgregar modAgg) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM registroencuesta WHERE codigoEn=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg.getCodigo());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modAgg.setIdRegistro(Integer.parseInt(rs.getString("idRegistro")));
                modAgg.setCodigo(rs.getString("codigoEn"));
                modAgg.setNombre(rs.getString("nombreEn"));
                modAgg.setApellido(rs.getString("apellidoEn"));
                modAgg.setEdad(Integer.parseInt(rs.getString("edadEn")));
                modAgg.setSexo(rs.getString("sexoEn"));
                modAgg.setDpto(rs.getString("dptoEn"));
                modAgg.setCiudad(rs.getString("ciudadEn"));
                modAgg.setBarrio(rs.getString("barrioEn"));
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
