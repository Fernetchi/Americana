/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import bd.conexion;
import consulta.consultaAgregar;
import controlador.ctlAgregar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import modelo.modeloAgregar;

/**
 *
 * @author Fernando
 */
public class frmBuscarEncuesta extends javax.swing.JFrame {
     conexion c= new conexion();
       Connection con = c.getConexion();
        Statement stmt = null;
        PreparedStatement ps;
        String titulos[] = {"Codigo","Nombre", "Apellido", "Edad", "Sexo"};
//        String titulos[] = {"idRegistro","codigoEn", "nombreEn", "apellidoEn", "edadEn", "sexoEn", "dptoEn", "ciudadEn", "barrioEn"};

        String fila [] = new String [6];
        DefaultTableModel modelo;
        
       
    public frmBuscarEncuesta() {
        initComponents();
        this.setTitle("Busqueda de Encuestas");
        this.setLocationRelativeTo(null);
        
        try {
           
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("SELECT * FROM registroencuesta");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("codigoEn");
                   fila[1] = rs.getString("nombreEn");
                   fila[2] = rs.getString("apellidoEn");
                   fila[3] = rs.getString("edadEn");
                   fila[4] = rs.getString("sexoEn");
                   
                   
                   
                   modelo.addRow(fila);     
               }    
               tabla.setModel(modelo);
        }
        catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error al extraer los datos de la tabla" + e.getMessage());
        }
            
    }
        
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtScodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuNuevo = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Edad", "Sexo", "Departamento", "Ciudad", "Barrio"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 650, 380));

        jLabel1.setText("Código:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, 20));

        txtScodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtScodigoActionPerformed(evt);
            }
        });
        txtScodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtScodigoKeyReleased(evt);
            }
        });
        getContentPane().add(txtScodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 46, 52, -1));

        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 46, -1, 20));

        txtSnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSnombreActionPerformed(evt);
            }
        });
        txtSnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSnombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtSnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 46, 195, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/fondoBuscarEncuesta.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 360, 360));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/fondoBuscarEncuesta.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 290, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/fondoBuscarEncuesta.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 360, 210));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/fondoBuscarEncuesta.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 360));

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 255));

        jMenu2.setText("Archivos");

        jMenuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuNuevo.setText("Nuevo");
        jMenuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuNuevo);

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtScodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtScodigoActionPerformed
      
    }//GEN-LAST:event_txtScodigoActionPerformed

    private void txtSnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSnombreActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        Sistema frmS = new Sistema();
                frmS.setVisible(true);
                this.dispose(); 
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void txtScodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScodigoKeyReleased
       try{ 
        String cod = txtScodigo.getText();
        
        String sql = "SELECT * FROM registroencuesta WHERE codigoEn LIKE '" + cod + "'";
        
        ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("idRegistro");
                   fila[1] = rs.getString("codigoEn");
                   fila[2] = rs.getString("nombreEn");
                   fila[3] = rs.getString("apellidoEn");
                   fila[4] = rs.getString("edadEn");
                   fila[5] = rs.getString("sexoEn");
                   
                   
                   modelo.addRow(fila);     
               }    
               tabla.setModel(modelo);
       } catch (SQLException e) {
           System.err.println(e);
       }
    }//GEN-LAST:event_txtScodigoKeyReleased

    private void txtSnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSnombreKeyReleased
        try{ 
        String nom = txtSnombre.getText();
        
        String sql = "SELECT * FROM registroencuesta WHERE nombreEn LIKE '" + nom + "'";
        
        ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("idRegistro");
                   fila[1] = rs.getString("codigoEn");
                   fila[2] = rs.getString("nombreEn");
                   fila[3] = rs.getString("apellidoEn");
                   fila[4] = rs.getString("edadEn");
                   fila[5] = rs.getString("sexoEn");
                   
                   
                   modelo.addRow(fila);     
               }    
               tabla.setModel(modelo);
       } catch (SQLException e) {
           
       }
    }//GEN-LAST:event_txtSnombreKeyReleased

    private void jMenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoActionPerformed
        modeloAgregar modA = new modeloAgregar();
        consultaAgregar Cagg= new consultaAgregar();
        frmAgregar frm = new frmAgregar();
        ctlAgregar ctl = new ctlAgregar(modA, Cagg, frm);
        ctl.iniciar();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEncuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmBuscarEncuesta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuNuevo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtScodigo;
    public javax.swing.JTextField txtSnombre;
    // End of variables declaration//GEN-END:variables

    private void conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
