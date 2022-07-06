package controlador;

import consulta.consultaAgregar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modCiudad;
import modelo.modDepto;
import modelo.modeloAgregar;
import modelo.modeloBarrio;
import vista.frmAgregar;

public class ctlAgregar implements ActionListener {

    private modeloAgregar modA;
    private consultaAgregar Cagg;
    private frmAgregar frm;

    public ctlAgregar(modeloAgregar modA, consultaAgregar Cagg, frmAgregar frm) {

        this.modA = modA;
        this.Cagg = Cagg;
        this.frm = frm;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        CargarDpto();
        CargarCiudad();
        CargarBarrio();
    }

    public void iniciar() {
        frm.setTitle("Formulario de Registro");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }

    public void CargarDpto() {
        modDepto modDpto = new modDepto();
        ArrayList departamento = null;
        try {
            departamento = Cagg.BuscarDpto(modDpto);
        } catch (SQLException ex) {
            Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = departamento.iterator();
        while (i.hasNext()) {
            frm.cboDpto.addItem(i.next());
        }
    }

    public void CargarCiudad() {
        modCiudad modCity = new modCiudad();
        ArrayList ciudad = null;
        try {
            ciudad = Cagg.BuscarCiudad(modCity);
        } catch (SQLException ex) {
            Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = ciudad.iterator();
        while (i.hasNext()) {
            frm.cboCiudad.addItem(i.next());
        }
    }

    public void CargarBarrio() {
        modeloBarrio modBarrio = new modeloBarrio();
        ArrayList barrio = null;
        try {
            barrio = Cagg.BuscarBarrio(modBarrio);
        } catch (SQLException ex) {
            Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator<String> i = barrio.iterator();
        while (i.hasNext()) {
            frm.cboBarrio.addItem(i.next());
        }
    }

    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtApellido.setText(null);
        frm.txtEdad.setText(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnRegistrar) {

            modA.setCodigo(frm.txtCodigo.getText());
            modA.setNombre(frm.txtNombre.getText());
            modA.setApellido(frm.txtApellido.getText());
            modA.setEdad(Integer.parseInt(frm.txtEdad.getText()));
            modA.setSexo(frm.cboSexo.getSelectedItem().toString());
            modA.setDpto(frm.cboDpto.getSelectedItem().toString());
            modA.setCiudad(frm.cboCiudad.getSelectedItem().toString());
            modA.setBarrio(frm.cboBarrio.getSelectedItem().toString());
            ResultSet rs = Cagg.ObtieneIdDepto(modA);
            ResultSet rts = Cagg.ObtieneIdCiudad(modA);
            ResultSet rtst = Cagg.ObtieneIdBarrio(modA);

            try {
                while (rs.next()) {
                    modA.setRelacionDpto(rs.getInt("iddepartamento"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                while (rts.next()) {
                    modA.setRelacionCiudad(rts.getInt("idciudad"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                while (rtst.next()) {
                    modA.setRelacionBarrio(rtst.getInt("idbarrio"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctlAgregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Cagg.registrar(modA)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

        }

//        public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == frm.btnRegistrar) {
//            if (frm.txtUsuarioUsu.getText().equals("") 
//                    vista.txtNombreUsu.getText().equals("")
//                    String.valueOf(vista.txtContrasenaUsu.getPassword()).equals("")) {
//                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
//            } else {
//                us.setUsuario(vista.txtUsuarioUsu.getText());
//                us.setNombre_usuario(vista.txtNombreUsu.getText());
//                us.setContrasena_usuario(String.valueOf(vista.txtContrasenaUsu.getPassword()));
//                us.setCaja_usuario(vista.cbxCajaUsu.getSelectedItem().toString());
//                us.setRol_usuario(vista.cbxRolUsu.getSelectedItem().toString());
//                if (usCon.registrar(us)) {
//                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
//                }else {
//                    JOptionPane.showMessageDialog(null, "Error al registrar usuario");
//                }
//            }        
//        public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == frm.btnRegistrar) {
//            if (frm.txtUsuarioUsu.getText().equals("") 
//                    vista.txtNombreUsu.getText().equals("")
//                    String.valueOf(vista.txtContrasenaUsu.getPassword()).equals("")) {
//                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
//            } else {
//                us.setUsuario(vista.txtUsuarioUsu.getText());
//                us.setNombre_usuario(vista.txtNombreUsu.getText());
//                us.setContrasena_usuario(String.valueOf(vista.txtContrasenaUsu.getPassword()));
//                us.setCaja_usuario(vista.cbxCajaUsu.getSelectedItem().toString());
//                us.setRol_usuario(vista.cbxRolUsu.getSelectedItem().toString());
//                if (usCon.registrar(us)) {
//                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
//                }else {
//                    JOptionPane.showMessageDialog(null, "Error al registrar usuario");
//                }
//            }
        if (e.getSource() == frm.btnModificar) {
            modA.setIdRegistro(Integer.parseInt(frm.txtId.getText()));
            modA.setCodigo(frm.txtCodigo.getText());
            modA.setNombre(frm.txtNombre.getText());
            modA.setApellido(frm.txtApellido.getText());
            modA.setEdad(Integer.parseInt(frm.txtEdad.getText()));
            modA.setSexo(frm.cboSexo.getSelectedItem().toString());
            modA.setDpto(frm.cboDpto.getSelectedItem().toString());
            modA.setCiudad(frm.cboCiudad.getSelectedItem().toString());
            modA.setBarrio(frm.cboBarrio.getSelectedItem().toString());

            if (Cagg.modificar(modA)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            modA.setIdRegistro(Integer.parseInt(frm.txtId.getText()));

            if (Cagg.eliminar(modA)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBuscar) {
            modA.setCodigo(frm.txtCodigo.getText());

            if (Cagg.buscar(modA)) {

                frm.txtId.setText(String.valueOf(modA.getIdRegistro()));
                frm.txtCodigo.setText(modA.getCodigo());
                frm.txtNombre.setText(modA.getNombre());
                frm.txtApellido.setText(modA.getApellido());
                frm.txtEdad.setText(String.valueOf(modA.getEdad()));
                modA.setSexo(frm.cboSexo.getSelectedItem().toString());
                modA.setDpto(frm.cboDpto.getSelectedItem().toString());
                modA.setCiudad(frm.cboCiudad.getSelectedItem().toString());
                modA.setBarrio(frm.cboBarrio.getSelectedItem().toString());

            } else {
                JOptionPane.showMessageDialog(null, "No se enccontró resultado");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }
}
