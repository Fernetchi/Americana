/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaSalario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloEmpleado;
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
        CargarEmpleado();
        }
        
        public void CargarEmpleado() {
        modeloEmpleado modEm = new modeloEmpleado();
        ArrayList Salario = null;
        try {
            Salario = conSa.BuscarEmpleado(modEm);
        } catch (SQLException ex) {
            Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = Salario.iterator();
        while (i.hasNext()) {
            frmSa.cboEm.addItem(i.next());
        }
    }

     @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmSa.btnSguardar) {

            
            modSa.setEmpleado(frmSa.cboEm.getSelectedItem().toString());
            modSa.setCargoSa(frmSa.txtScargo.getText());
            modSa.setSueldoSa(Integer.parseInt(frmSa.txtSsalario.getText()));
            ResultSet rs = conSa.ObtieneIdEmpleado(modSa);
            try { 
                while (rs.next()) {
                        modSa.setRelacionSalario(rs.getInt("idempleado"));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
                    }
            if (conSa.registrar(modSa)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                
            }
                
        }
    }
}
