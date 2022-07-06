
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.modCiudad;
import modelo.modDepto;
import modelo.modeloAgregar;
import modelo.modeloBarrio;


public class consultaAgregar extends conexion {
    
    public ArrayList BuscarDpto (modDepto modDpto) throws SQLException {
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
    
    public ArrayList BuscarCiudad (modCiudad modCity) throws SQLException {
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
    
    public ArrayList BuscarBarrio (modeloBarrio modBarrio) throws SQLException {
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
    
    public ResultSet ObtieneIdDepto(modeloAgregar modA) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT iddepartamento FROM departamento WHERE nombreDpto LIKE '%" + modA.getDpto() + "%'; ";
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
    
    public ResultSet ObtieneIdCiudad(modeloAgregar modA) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT idciudad FROM ciudad WHERE nombreCiudad LIKE '%" + modA.getCiudad() + "%'; ";
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
    public ResultSet ObtieneIdBarrio(modeloAgregar modA) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT idbarrio FROM barrio WHERE nombreBarrio LIKE '%" + modA.getBarrio() + "%'; ";
        
        
        try {
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return rs;
        }
    }
    
    public boolean registrar (modeloAgregar modA) {
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO registroencuesta (codigoEn, nombreEn, apellidoEn, edadEn, sexoEn, departamento_iddepartamento, ciudad_idciudad, barrio_idbarrio) VALUES (?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
//            ps.setInt(1,modA.getIdRegistro());
            ps.setString(1,modA.getCodigo());
            ps.setString(2,modA.getNombre());
            ps.setString(3,modA.getApellido());
            ps.setInt(4,modA.getEdad());
            ps.setString(5,modA.getSexo());
//            ps.setString(6,modAgg.getDpto());
            ps.setInt(6,modA.getRelacionDpto());
            ps.setInt(7,modA.getRelacionCiudad());
            ps.setInt(8,modA.getRelacionBarrio());
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
        
        String sql = "UPDATE registroencuesta SET codigoEn=?, nombreEn=?, apellidoEn=?, edadEn=?, sexoEn=?, ciudadEn=?, barrioEn=?, departamento_iddepartamento WHERE idRegistro=?";
        
        
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
                modAgg.setDpto(rs.getString("departamento_iddepartamento"));
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
