
package consulta;

import bd.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.Sistema;
import vista.Sistema2;
import vista.frmUsuario;



public class conUsuario extends conexion {
   
   Connection con = getConexion();
   public void validarUsuario (String usuario, String pass) {
       
       try{
            String sql = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "' and clave = '" + pass+ "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                usuario = rs.getString("usuario");
                pass = rs.getString("clave");
                
                if (usuario != null && pass != null) {
                    String tipo = rs.getString("idtipo");
                    
                    switch (tipo) {
                    
                        case "Administrador":                          
                         Sistema frmS = new Sistema();
                         frmS.setVisible(true);
                         break;
                        case "Usuario":
                         Sistema2 frm2 = new Sistema2();
                         frm2.setVisible(true);
                         break;
                }
               }

            } else {
                JOptionPane.showMessageDialog(null,"Acceso denegado");
                frmUsuario frm = new frmUsuario();
                frm.setVisible(true);
            }
            
            
       } catch (SQLException e) {
          System.out.println("Error" + e.getMessage()); 
       }
    }

   
}
