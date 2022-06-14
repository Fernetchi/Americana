/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.ConsultaAggUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloAggUsuario;
import vista.frmAgregarUsuario;



/**
 *
 * @author Fernando
 */
public class ctlAgregarUsuario implements ActionListener {
    private modeloAggUsuario modAgg;
    private ConsultaAggUsuario cAgg;
    public frmAgregarUsuario frmAgg;
    
     public void limpiar() {
        frmAgg.txtUnombre.setText(null);
        frmAgg.txtUapellido.setText(null);
        frmAgg.txtUnick.setText(null);
        frmAgg.txtUpass.setText(null);

     }
    
    
     public ctlAgregarUsuario (modeloAggUsuario modAgg, ConsultaAggUsuario cAgg, frmAgregarUsuario frmAgg) {
        
        this.modAgg = modAgg;
        this.cAgg = cAgg;
        this.frmAgg = frmAgg;
        this.frmAgg.btnUaceptar.addActionListener(this);
        this.frmAgg.btnUcancelar.addActionListener(this);
    }
     
      public void iniciar() {
        frmAgg.setTitle("Formulario de Registro de Usuarios");
        frmAgg.setLocationRelativeTo(null);
      }
      
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmAgg.btnUaceptar) {
           modAgg.setNombreU(frmAgg.txtUnombre.getText());
           modAgg.setApellidoU(frmAgg.txtUapellido.getText()); 
           modAgg.setUsuario(frmAgg.txtUnick.getText()); 
           modAgg.setClave(frmAgg.txtUpass.getText());
           modAgg.setTipo(frmAgg.comboxtipo.getSelectedItem().toString());
           
           
           if (cAgg.registrar(modAgg) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
    }
}
