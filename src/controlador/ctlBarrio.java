/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaBarrio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloBarrio;
import vista.frmBarrio;

/**
 *
 * @author Fernando
 */
public class ctlBarrio implements ActionListener {
    private modeloBarrio modBarrio;
    private consultaBarrio Cbarrio;
    private frmBarrio frmTown;
    
    public ctlBarrio (modeloBarrio modBarrio, consultaBarrio Cbarrio, frmBarrio frmTown) {
        
        this.modBarrio = modBarrio;
        this.Cbarrio = Cbarrio;
        this.frmTown = frmTown;
        this.frmTown.btnBregistrar.addActionListener(this);
        this.frmTown.btnBeliminar.addActionListener(this);
        this.frmTown.btnBbuscar.addActionListener(this);
    }

    
     public void limpiar() {
        frmTown.txtBarrio.setText(null);
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmTown.btnBregistrar) {
            
           modBarrio.setBarrio(frmTown.txtBarrio.getText());

           
           if (Cbarrio.registrar(modBarrio) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
               
         if (e.getSource() == frmTown.btnBeliminar) {
           modBarrio.setBarrio(frmTown.txtBarrio.getText());
           
           if (Cbarrio.eliminar(modBarrio) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frmTown.btnBbuscar) {
           modBarrio.setBarrio(frmTown.txtBarrio.getText()); 
           
           if (Cbarrio.buscar(modBarrio) ) {
                
               modBarrio.setBarrio(frmTown.txtBarrio.getText());
               
               JOptionPane.showMessageDialog(null,"Se enccontró resultado");
           
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }       
    }     

}
