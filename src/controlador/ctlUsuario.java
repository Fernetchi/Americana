
package controlador;

import consulta.conUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modUsuario;
import vista.frmUsuario;


public class ctlUsuario implements ActionListener {
    
     private modUsuario mUsuario;
    private conUsuario cUsuario;
    private frmUsuario frmU;
    
    public ctlUsuario(modUsuario Musuario, conUsuario Cusuario, frmUsuario frmU){
        this.mUsuario = Musuario;
        this.cUsuario = Cusuario;
        this.frmU = frmU;
        this.frmU.btnAceptar.addActionListener(this);
    }
    
   public void validarcampoUsuario() {
        if ("".equals(frmU.txtUsuario.getText())) {

            JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
            frmU.txtUsuario.requestFocus();
        } else {
            frmU.txtPass.requestFocus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

