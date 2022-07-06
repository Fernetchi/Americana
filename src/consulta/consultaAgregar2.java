
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modCiudad;
import modelo.modCiudad2;
import modelo.modDepto;
import modelo.modDepto2;
import modelo.modeloAgregar;
import modelo.modeloAgregar2;
import modelo.modeloBarrio;
import modelo.modeloBarrio2;


public class consultaAgregar2 extends conexion {
    
    public ArrayList BuscarDpto (modDepto2 modDpto2) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Connection con = getConexion();
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM departamento";
        ArrayList<String> agg = new ArrayList();
        try { 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                    while (rs.next()) {
                        String lsDescripcion = rs.getString("nombreDpto");
                        agg.add(lsDescripcion);
                    }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return agg;
    }
    
    public ArrayList BuscarCiudad (modCiudad2 modCity2) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Connection con = getConexion();
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM ciudad";
        ArrayList<String> agg = new ArrayList();
        try { 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                    while (rs.next()) {
                        String lsCiudad = rs.getString("nombreCiudad");
                        agg.add(lsCiudad);
                    }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return agg;
    }
    
    public ArrayList BuscarBarrio (modeloBarrio2 modBarrio2) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Connection con = getConexion();
        java.sql.Connection con = getConexion();
        String sql = "SELECT * FROM barrio";
//        System.out.println(sql);
        ArrayList<String> agg = new ArrayList();
        try { 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                    while (rs.next()) {
                        String lsBarrio = rs.getString("nombreBarrio");
                        agg.add(lsBarrio);
                    }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            con.close();
        }
        return agg;
    }
    
    public ResultSet ObtieneIdDepto(modeloAgregar2 modA2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT iddepartamento FROM departamento WHERE nombreDpto LIKE '%" + modA2.getDpto() + "%'; ";
//        System.out.println(sql);
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
    public ResultSet ObtieneIdCiudad(modeloAgregar2 modA2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT idciudad FROM ciudad WHERE nombreCiudad LIKE '%" + modA2.getCiudad() + "%'; ";
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
    public ResultSet ObtieneIdBarrio(modeloAgregar2 modA2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT idbarrio FROM barrio WHERE nombreBarrio LIKE '%" + modA2.getBarrio() + "%'; ";
        
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
    public boolean registrar (modeloAgregar2 modA2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO registroencuesta (codigoEn, nombreEn, apellidoEn, edadEn, sexoEn, departamento_iddepartamento, ciudad_idciudad, barrio_idbarrio) VALUES (?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
//            ps.setInt(1,modA.getIdRegistro());
            ps.setString(1,modA2.getCodigo());
            ps.setString(2,modA2.getNombre());
            ps.setString(3,modA2.getApellido());
            ps.setInt(4,modA2.getEdad());
            ps.setString(5,modA2.getSexo());
//            ps.setString(6,modAgg.getDpto());
            ps.setInt(6,modA2.getRelacionDpto());
            ps.setInt(7,modA2.getRelacionCiudad());
            ps.setInt(8,modA2.getRelacionBarrio());
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
    
    public boolean modificar (modeloAgregar2 modAgg2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE registroencuesta SET codigoEn=?, nombreEn=?, apellidoEn=?, edadEn=?, sexoEn=?, ciudadEn=?, barrioEn=?, departamento_iddepartamento WHERE idRegistro=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg2.getCodigo());
            ps.setString(2,modAgg2.getNombre());
            ps.setString(3,modAgg2.getApellido());
            ps.setInt(4,modAgg2.getEdad());
            ps.setString(5,modAgg2.getSexo());
            ps.setString(6,modAgg2.getDpto());
            ps.setString(7,modAgg2.getCiudad());
            ps.setString(8,modAgg2.getBarrio());
            ps.setInt(9,modAgg2.getIdRegistro());
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
    
    public boolean eliminar (modeloAgregar2 modAgg2) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM registroencuesta WHERE idRegistro=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,modAgg2.getIdRegistro());
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
    
    public boolean buscar (modeloAgregar2 modAgg2) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM registroencuesta WHERE codigoEn=?";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,modAgg2.getCodigo());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                modAgg2.setIdRegistro(Integer.parseInt(rs.getString("idRegistro")));
                modAgg2.setCodigo(rs.getString("codigoEn"));
                modAgg2.setNombre(rs.getString("nombreEn"));
                modAgg2.setApellido(rs.getString("apellidoEn"));
                modAgg2.setEdad(Integer.parseInt(rs.getString("edadEn")));
                modAgg2.setSexo(rs.getString("sexoEn"));
                modAgg2.setDpto(rs.getString("departamento_iddepartamento"));
                modAgg2.setCiudad(rs.getString("ciudadEn"));
                modAgg2.setBarrio(rs.getString("barrioEn"));
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
