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
import modelo.modeloEmpleado;

/**
 *
 * @author Fernando
 */
public class consultaEmpleado extends conexion {
    
    public boolean registrar (modeloEmpleado modEm) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO empleados (cedulaEm, nomEm, apellidoEm, edadEm, direccionEm, telefonoEm, correoEm) VALUES (?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modEm.getCedula());
            ps.setString(2,modEm.getNombreEm());
            ps.setString(3,modEm.getApellidoEm());
            ps.setInt(4,modEm.getEdadEm());
            ps.setString(5,modEm.getDireccionEm());
            ps.setInt(6,modEm.getTelefonoEm());
            ps.setString(7,modEm.getCorreoEm());
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
    
    public boolean modificar (modeloEmpleado modEm) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE empleados SET cedulaEm=?, nomEm=?, apellidoEm=?, edadEm=?,direccionEm=?, telefonoEm=?, correoEm=? WHERE idempleado=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modEm.getCedula());
            ps.setString(2,modEm.getNombreEm());
            ps.setString(3,modEm.getApellidoEm());
            ps.setInt(4,modEm.getEdadEm());
            ps.setString(5,modEm.getDireccionEm());
            ps.setInt(6,modEm.getTelefonoEm());
            ps.setString(7,modEm.getCorreoEm());
            ps.setInt(8,modEm.getIdEmpleado());
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
    
    public boolean eliminar (modeloEmpleado modEm) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM empleados WHERE idempleado=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,modEm.getIdEmpleado());
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
    
    public boolean buscar (modeloEmpleado modEm) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM empleados WHERE cedulaEm=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modEm.getCedula());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modEm.setIdEmpleado(Integer.parseInt(rs.getString("idempleado")));
                modEm.setCedula(rs.getString("cedulaEm"));
                modEm.setNombreEm(rs.getString("nomEm"));
                modEm.setApellidoEm(rs.getString("apellidoEm"));
                modEm.setEdadEm(Integer.parseInt(rs.getString("edadEm")));
                modEm.setDireccionEm(rs.getString("direccionEm"));
                modEm.setTelefonoEm(Integer.parseInt(rs.getString("telefonoEm")));
                modEm.setCorreoEm(rs.getString("correoEm"));
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
