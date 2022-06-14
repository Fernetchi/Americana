/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import bd.conexion;
import consulta.consultaAgregar;
import consulta.consultaEmpleado;
import controlador.ctlAgregar;
import controlador.ctlEmpleado;
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
import modelo.modeloEmpleado;

/**
 *
 * @author Fernando
 */
public class frmListarEmpleados extends javax.swing.JFrame {
     conexion c= new conexion();
       Connection con = c.getConexion();
        Statement stmt = null;
        PreparedStatement ps;
        String titulos[] = {"Id","Cedula", "Nombre", "Apellido", "Edad", "Dirección", "Teléfono", "Correo"};
        
        String fila [] = new String [8];
        DefaultTableModel modelo;
        
    public frmListarEmpleados() {
        initComponents();
        this.setTitle("Listado de Empleados");
        this.setLocationRelativeTo(null);
        
        try {
           
               stmt = con.createStatement();
               ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
               
               modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("idempleado");
                   fila[1] = rs.getString("cedulaEm");
                   fila[2] = rs.getString("nomEm");
                   fila[3] = rs.getString("apellidoEm");
                   fila[4] = rs.getString("edadEm");
                   fila[5] = rs.getString("direccionEm");
                   fila[6] = rs.getString("telefonoEm");
                   fila[7] = rs.getString("correoEm");
                   
                   
                   modelo.addRow(fila);     
               }    
               tablaEmpleados.setModel(modelo);
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
        tablaEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSEcedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSEnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuNuevo = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cedula", "Nombre", "Apellido", "Edad", "Dirección", "Teléfono", "Correo"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 590, 270));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cedula:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        txtSEcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEcedulaActionPerformed(evt);
            }
        });
        txtSEcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSEcedulaKeyReleased(evt);
            }
        });
        getContentPane().add(txtSEcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 20));

        txtSEnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSEnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSEnombreActionPerformed(evt);
            }
        });
        txtSEnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSEnombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtSEnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 195, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/fondoBuscarEncuesta.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 350));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/fondoBuscarEncuesta.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 230, 350));

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

    private void txtSEcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEcedulaActionPerformed
      
    }//GEN-LAST:event_txtSEcedulaActionPerformed

    private void txtSEnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSEnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSEnombreActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        Sistema frmS = new Sistema();
                frmS.setVisible(true);
                this.dispose(); 
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void txtSEcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEcedulaKeyReleased
       try{ 
        String ced = txtSEcedula.getText();
        
        String sql = "SELECT * FROM empleados WHERE cedulaEm LIKE '" + ced + "'";
        
        ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("idempleado");
                   fila[1] = rs.getString("cedulaEm");
                   fila[2] = rs.getString("nomEm");
                   fila[3] = rs.getString("apellidoEm");
                   fila[4] = rs.getString("edadEm");
                   fila[5] = rs.getString("direccionEm");
                   fila[6] = rs.getString("telefonoEm");
                   fila[7] = rs.getString("correoEm");
                   
                   
                   modelo.addRow(fila);     
               }    
               tablaEmpleados.setModel(modelo);
       } catch (SQLException e) {
           
       }
    }//GEN-LAST:event_txtSEcedulaKeyReleased

    private void txtSEnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEnombreKeyReleased
        try{ 
        String nom = txtSEnombre.getText();
        
        String sql = "SELECT * FROM empleados WHERE nomEm LIKE '" + nom + "'";
        
        ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           modelo = new DefaultTableModel(null,titulos);
            
               while(rs.next()) {
                   
                   fila[0] = rs.getString("idempleado");
                   fila[1] = rs.getString("cedulaEm");
                   fila[2] = rs.getString("nomEm");
                   fila[3] = rs.getString("apellidoEm");
                   fila[4] = rs.getString("edadEm");
                   fila[5] = rs.getString("direccionEm");
                   fila[6] = rs.getString("telefonoEm");
                   fila[7] = rs.getString("correoEm");
                   
                   
                   modelo.addRow(fila);     
               }    
               tablaEmpleados.setModel(modelo);
       } catch (SQLException e) {
           
       }
    }//GEN-LAST:event_txtSEnombreKeyReleased

    private void jMenuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoActionPerformed
        modeloEmpleado modEm = new modeloEmpleado();
        consultaEmpleado cEm= new consultaEmpleado();
        frmEmpleado frmEm = new frmEmpleado();
        ctlEmpleado ctlEm = new ctlEmpleado(modEm, cEm, frmEm);
        ctlEm.iniciar();
        frmEm.setVisible(true);
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
            java.util.logging.Logger.getLogger(frmListarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmListarEmpleados().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuNuevo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaEmpleados;
    public javax.swing.JTextField txtSEcedula;
    public javax.swing.JTextField txtSEnombre;
    // End of variables declaration//GEN-END:variables

    private void conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
