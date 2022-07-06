/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import consulta.consultaCiudad;
import consulta.consultaDepto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modCiudad;
import vista.frmCiudad;
import vista.frmDepto;

/**
 *
 * @author Fernando
 */
public class ctlCiudad implements ActionListener {
 private modCiudad modCity;
    private consultaCiudad Ccity;
    private frmCiudad frmCity;
    
    public ctlCiudad (modCiudad modCity, consultaCiudad Ccity, frmCiudad frmCity) {
        
        this.modCity = modCity;
        this.Ccity = Ccity;
        this.frmCity = frmCity;
        this.frmCity.btnCregistrar.addActionListener(this);
        this.frmCity.btnCeliminar.addActionListener(this);
        this.frmCity.btnCbuscar.addActionListener(this);
    }

    
     public void limpiar() {
        frmCity.txtCiudad.setText(null);
        
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmCity.btnCregistrar) {
            
           modCity.setCiudad(frmCity.txtCiudad.getText());

           
           if (Ccity.registrar(modCity) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
               
         if (e.getSource() == frmCity.btnCeliminar) {
           modCity.setCiudad(frmCity.txtCiudad.getText());
           
           if (Ccity.eliminar(modCity) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frmCity.btnCbuscar) {
           modCity.setCiudad(frmCity.txtCiudad.getText()); 
           
           if (Ccity.buscar(modCity) ) {
                
               modCity.setCiudad(frmCity.txtCiudad.getText());
               
               JOptionPane.showMessageDialog(null,"Se enccontró resultado");
           
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }       
    }     
}
