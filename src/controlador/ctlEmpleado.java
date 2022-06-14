package controlador;

import consulta.consultaEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloEmpleado;
import vista.frmEmpleado;

/**
 *
 * @author Fernando
 */
public class ctlEmpleado implements ActionListener {
    
     private modeloEmpleado modEm;
    private consultaEmpleado cEm;
    private frmEmpleado frmEm;
    
    public ctlEmpleado (modeloEmpleado modEm, consultaEmpleado cEm, frmEmpleado frmEm) {
        
        
        this.modEm = modEm;
        this.cEm = cEm;
        this.frmEm = frmEm;
        this.frmEm.btnEregistrar.addActionListener(this);
        this.frmEm.btnEmodificar.addActionListener(this);
        this.frmEm.btnEeliminar.addActionListener(this);
        this.frmEm.btnEbuscar.addActionListener(this);
    }
    
    public void iniciar() {
        frmEm.setTitle("Agregar Empleado");
        frmEm.setLocationRelativeTo(null);
        frmEm.txtEid.setVisible(false);
        frmEm.setVisible(true);
    }
    
     public void limpiar() {
        frmEm.txtEid.setText(null);
        frmEm.txtEcedula.setText(null);
        frmEm.txtEnombre.setText(null);
        frmEm.txtEapellido.setText(null);
        frmEm.txtEedad.setText(null);
        frmEm.txtEdireccion.setText(null);
        frmEm.txtEtelefono.setText(null);
        frmEm.txtEcorreo.setText(null);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmEm.btnEregistrar) {
           modEm.setCedula(frmEm.txtEcedula.getText());
           modEm.setNombreEm(frmEm.txtEnombre.getText()); 
           modEm.setApellidoEm(frmEm.txtEapellido.getText()); 
           modEm.setEdadEm(Integer.parseInt(frmEm.txtEedad.getText())); 
           modEm.setDireccionEm(frmEm.txtEdireccion.getText()); 
           modEm.setTelefonoEm(Integer.parseInt(frmEm.txtEtelefono.getText())); 
           modEm.setCorreoEm(frmEm.txtEcorreo.getText()); 
           
           if (cEm.registrar(modEm) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
        
        if (e.getSource() == frmEm.btnEmodificar) {
           modEm.setIdEmpleado(Integer.parseInt(frmEm.txtEid.getText())); 
           modEm.setCedula(frmEm.txtEcedula.getText());
           modEm.setNombreEm(frmEm.txtEnombre.getText()); 
           modEm.setApellidoEm(frmEm.txtEapellido.getText()); 
           modEm.setEdadEm(Integer.parseInt(frmEm.txtEedad.getText())); 
           modEm.setDireccionEm(frmEm.txtEdireccion.getText()); 
           modEm.setTelefonoEm(Integer.parseInt(frmEm.txtEtelefono.getText())); 
           modEm.setCorreoEm(frmEm.txtEcorreo.getText()); 
           
           if (cEm.modificar(modEm) ) {
               JOptionPane.showMessageDialog(null,"Registro Modificado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Modificar");
               limpiar();
           }
        }
        
         if (e.getSource() == frmEm.btnEeliminar) {
           modEm.setIdEmpleado(Integer.parseInt(frmEm.txtEid.getText())); 
           
           if (cEm.eliminar(modEm) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frmEm.btnEbuscar) {
           modEm.setCedula(frmEm.txtEcedula.getText()); 
           
           if (cEm.buscar(modEm) ) {
                
               frmEm.txtEid.setText(String.valueOf(modEm.getIdEmpleado()));
               frmEm.txtEcedula.setText(modEm.getCedula());
               frmEm.txtEnombre.setText(modEm.getNombreEm());
               frmEm.txtEapellido.setText(modEm.getApellidoEm());
               frmEm.txtEedad.setText(String.valueOf(modEm.getEdadEm()));
               frmEm.txtEdireccion.setText(modEm.getDireccionEm());
               frmEm.txtEtelefono.setText(String.valueOf(modEm.getTelefonoEm()));
               frmEm.txtEcorreo.setText(modEm.getCorreoEm());         
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }  
//         if (e.getSource() == frmEm.btnLimpiar) {
//             limpiar();
//         }
    }   
}
