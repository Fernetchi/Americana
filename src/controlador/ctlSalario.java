/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaSalario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloSalario;
import vista.frmSalario;

/**
 *
 * @author Fernando
 */
public class ctlSalario implements ActionListener {
    
    private modeloSalario modSa;
    private consultaSalario conSa;
    private frmSalario frmSa;
    
    public ctlSalario(modeloSalario modSa, consultaSalario conSa, frmSalario frmSa) {
        this.modSa = modSa;
        this.conSa = conSa;
        this.frmSa = frmSa;
        this.frmSa.btnSguardar.addActionListener(this);
    }
    
        public void iniciar() {
        frmSa.setTitle("Pago de Salario");
        frmSa.setLocationRelativeTo(null);
        frmSa.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == frmSa.btnSguardar) {
           
            modSa.setCargoSa(frmSa.txtScargo.getText());
           modSa.setSueldoSa(Integer.parseInt(frmSa.txtSsalario.getText()));
           
//           modSa.setEmpleadofk((frmSa.cboSlario.getSelectedItem().toString()));
           
           if (conSa.registrar(modSa) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
//               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
//               limpiar();
           }
        }
    }
}
