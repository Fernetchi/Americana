
package controlador;

import consulta.consultaAgregar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modeloAgregar;
import vista.frmAgregar;


public class ctlAgregar implements ActionListener{
    
    private modeloAgregar modA;
    private consultaAgregar Cagg;
    private frmAgregar frm;
    
    public ctlAgregar (modeloAgregar modA, consultaAgregar Cagg, frmAgregar frm) {
        
        this.modA = modA;
        this.Cagg = Cagg;
        this.frm = frm;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar() {
        frm.setTitle("Formulario de Registro");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    
     public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtEdad.setText(null);
        frm.txtSexo.setText(null);
        frm.txtDpto.setText(null);
        frm.txtCiudad.setText(null);
        frm.txtBarrio.setText(null);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frm.btnRegistrar) {
           modA.setCodigo(frm.txtCodigo.getText());
           modA.setNombre(frm.txtNombre.getText()); 
           modA.setApellido(frm.txtApellido.getText()); 
           modA.setEdad(Integer.parseInt(frm.txtEdad.getText())); 
           modA.setSexo(frm.txtSexo.getText()); 
           modA.setDpto(frm.txtDpto.getText()); 
           modA.setCiudad(frm.txtCiudad.getText()); 
           modA.setBarrio(frm.txtBarrio.getText());
           
           if (Cagg.registrar(modA) ) {
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Guardar");
               limpiar();
           }
        }
        
        if (e.getSource() == frm.btnModificar) {
           modA.setIdRegistro(Integer.parseInt(frm.txtId.getText())); 
           modA.setCodigo(frm.txtCodigo.getText());
           modA.setNombre(frm.txtNombre.getText()); 
           modA.setApellido(frm.txtApellido.getText()); 
           modA.setEdad(Integer.parseInt(frm.txtEdad.getText())); 
           modA.setSexo(frm.txtSexo.getText()); 
           modA.setDpto(frm.txtDpto.getText()); 
           modA.setCiudad(frm.txtCiudad.getText()); 
           modA.setBarrio(frm.txtBarrio.getText());
           
           if (Cagg.modificar(modA) ) {
               JOptionPane.showMessageDialog(null,"Registro Modificado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Modificar");
               limpiar();
           }
        }
        
         if (e.getSource() == frm.btnEliminar) {
           modA.setIdRegistro(Integer.parseInt(frm.txtId.getText())); 
           
           if (Cagg.eliminar(modA) ) {
               JOptionPane.showMessageDialog(null,"Registro Eliminado");
               limpiar();
           } else {
               JOptionPane.showMessageDialog(null,"Error al Eliminar");
               limpiar();
           }
        }
         
         if (e.getSource() == frm.btnBuscar) {
           modA.setCodigo(frm.txtCodigo.getText()); 
           
           if (Cagg.buscar(modA) ) {
                
               frm.txtId.setText(String.valueOf(modA.getIdRegistro()));
               frm.txtCodigo.setText(modA.getCodigo());
               frm.txtNombre.setText(modA.getNombre());
               frm.txtApellido.setText(modA.getApellido());
               frm.txtEdad.setText(String.valueOf(modA.getEdad()));
               frm.txtSexo.setText(modA.getSexo());
               frm.txtDpto.setText(modA.getDpto());
               frm.txtCiudad.setText(modA.getCiudad());
               frm.txtBarrio.setText(modA.getBarrio());
           
           } else {
               JOptionPane.showMessageDialog(null,"No se enccontró resultado");
               limpiar();
           }
        }
        
         if (e.getSource() == frm.btnLimpiar) {
             limpiar();
         }
    }   
}
