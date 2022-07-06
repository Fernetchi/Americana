/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import consulta.consultaAgregar;
import controlador.ctlAgregar;

/**
 *
 * @author Fernando
 */
public class frmBarrio extends javax.swing.JFrame {

    /**
     * Creates new form frmBarrio
     */
    public frmBarrio() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtBarrio.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBarrio = new javax.swing.JTextField();
        btnBregistrar = new javax.swing.JButton();
        btnBeliminar = new javax.swing.JButton();
        btnBbuscar = new javax.swing.JButton();
        btnBvolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Barrio:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 101, -1, -1));
        getContentPane().add(txtBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 98, 187, -1));

        btnBregistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBregistrar.setText("Registrar");
        btnBregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 138, -1, -1));

        btnBeliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBeliminar.setText("Eliminar");
        btnBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBeliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 138, -1, -1));

        btnBbuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBbuscar.setText("Buscar");
        getContentPane().add(btnBbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 97, -1, -1));

        btnBvolver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBvolver.setText("Volver");
        btnBvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnBvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 11, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/agregarEmpleado1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBregistrarActionPerformed
        txtBarrio.requestFocus();
    }//GEN-LAST:event_btnBregistrarActionPerformed

    private void btnBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeliminarActionPerformed
        txtBarrio.requestFocus();
    }//GEN-LAST:event_btnBeliminarActionPerformed

    private void btnBvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBvolverActionPerformed
         modelo.modeloAgregar modA = new modelo.modeloAgregar();
        consultaAgregar Cagg= new consultaAgregar();
        frmAgregar frm = new frmAgregar();
        ctlAgregar ctl = new ctlAgregar(modA, Cagg, frm);
        ctl.iniciar();
        frm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBvolverActionPerformed

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
            java.util.logging.Logger.getLogger(frmBarrio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBarrio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBarrio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBarrio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBarrio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBbuscar;
    public javax.swing.JButton btnBeliminar;
    public javax.swing.JButton btnBregistrar;
    public javax.swing.JButton btnBvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField txtBarrio;
    // End of variables declaration//GEN-END:variables
}