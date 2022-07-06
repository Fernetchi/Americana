/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaDepto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modDepto;
import vista.frmDepto;

/**
 *
 * @author Fernando
 */
public class ctlDepto implements ActionListener {
    
     private modDepto modDpto;
    private consultaDepto Cdpto;
    private frmDepto frmDpto;
    
    public ctlDepto (modDepto modDpto, consultaDepto Cdpto, frmDepto frmDpto) {
        
        this.modDpto = modDpto;
        this.Cdpto = Cdpto;
        this.frmDpto = frmDpto;
        this.frmDpto.btnDregistrar.addActionListener(this);
        this.frmDpto.btnDeliminar.addActionListener(this);
        this.frmDpto.btnDbuscar.addActionListener(this);
    }
    
    public void iniciar() {
        frmDpto.setTitle("Agregar Sitio");
        frmDpto.setLocationRelativeTo(null);
    }

    
     public void limpiar() {
        frmDpto.txtDepto.setText(null);
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmDpto.btnDregistrar) {
            
           modDpto.setDepto(frmDpto.txtDepto.getText());

           
           if (Cdpto.registrar(modDpto) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
               
         if (e.getSource() == frmDpto.btnDeliminar) {
           modDpto.setDepto(frmDpto.txtDepto.getText());
           
           if (Cdpto.eliminar(modDpto) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frmDpto.btnDbuscar) {
           modDpto.setDepto(frmDpto.txtDepto.getText()); 
           
           if (Cdpto.buscar(modDpto) ) {
                
               modDpto.setDepto(frmDpto.txtDepto.getText());
               
               JOptionPane.showMessageDialog(null,"Se enccontró resultado");
           
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }
        
    }   
}
