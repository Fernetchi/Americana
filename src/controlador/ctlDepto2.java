/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaDepto;
import consulta.consultaDepto2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modDepto;
import modelo.modDepto2;
import vista.frmDepto;
import vista.frmDepto2;

/**
 *
 * @author Fernando
 */
public class ctlDepto2 implements ActionListener {
    
     private modDepto2 modDpto2;
    private consultaDepto2 Cdpto2;
    private frmDepto2 frmDpto2;
    
    public ctlDepto2 (modDepto2 modDpto2, consultaDepto2 Cdpto2, frmDepto2 frmDpto2) {
        
        this.modDpto2 = modDpto2;
        this.Cdpto2 = Cdpto2;
        this.frmDpto2 = frmDpto2;
        this.frmDpto2.btnDregistrar.addActionListener(this);
        this.frmDpto2.btnDeliminar.addActionListener(this);
        this.frmDpto2.btnDbuscar.addActionListener(this);
    }
    
    public void iniciar() {
        frmDpto2.setTitle("Agregar Sitio");
        frmDpto2.setLocationRelativeTo(null);
    }

    
     public void limpiar() {
        frmDpto2.txtDepto.setText(null);
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmDpto2.btnDregistrar) {
            
           modDpto2.setDepto(frmDpto2.txtDepto.getText());

           
           if (Cdpto2.registrar(modDpto2) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
               
         if (e.getSource() == frmDpto2.btnDeliminar) {
           modDpto2.setDepto(frmDpto2.txtDepto.getText());
           
           if (Cdpto2.eliminar(modDpto2) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frmDpto2.btnDbuscar) {
           modDpto2.setDepto(frmDpto2.txtDepto.getText()); 
           
           if (Cdpto2.buscar(modDpto2) ) {
                
               modDpto2.setDepto(frmDpto2.txtDepto.getText());
               
               JOptionPane.showMessageDialog(null,"Se enccontró resultado");
           
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }
        
    }   
}
