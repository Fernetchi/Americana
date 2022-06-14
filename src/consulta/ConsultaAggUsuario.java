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
import modelo.modeloAggUsuario;

/**
 *
 * @author Fernando
 */
public class ConsultaAggUsuario extends conexion{
    
    public boolean registrar (modeloAggUsuario modAgg) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuarios(usuario, clave, nombreU, apellidoU, idtipo) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg.getUsuario());
            ps.setString(2,modAgg.getClave());
            ps.setString(3,modAgg.getNombreU());
            ps.setString(4,modAgg.getApellidoU());
            ps.setString(5,modAgg.getTipo());
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
