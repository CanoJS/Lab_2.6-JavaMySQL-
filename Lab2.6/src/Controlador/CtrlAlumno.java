
package Controlador;

import Modelo.Alumno;
import Modelo.CAlumno;
import Vista.frmAlumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlAlumno implements ActionListener {
    private Alumno mod;
    private CAlumno modC;
    private frmAlumno frm;
    
    public CtrlAlumno(Alumno mod, CAlumno modC, frmAlumno frm){
        
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnAgregar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Alumnos");
        frm.setLocationRelativeTo(null);
        frm.txtnombreP.setVisible(false);
        frm.txtDescripcion.setVisible(false);
        frm.txtId_alumnos.setVisible(false);
        frm.labID.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == frm.btnAgregar){
            mod.setMatricula(frm.txtMatricula.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setId_proyecto(Integer.parseInt(frm.txtId_proyecto.getText()));
            if(modC.Agregar(mod)){
                JOptionPane.showMessageDialog(null, "Alumno agregado correctamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al agregar alumno");
            }
        }
        
        if(e.getSource() == frm.btnModificar){
            mod.setMatricula(frm.txtMatricula.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setId_proyecto(Integer.parseInt(frm.txtId_proyecto.getText()));
            mod.setId_alumnos(Integer.parseInt(frm.txtId_alumnos.getText()));
            if(modC.Modificar(mod)){
                JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId_alumnos(Integer.parseInt(frm.txtId_alumnos.getText()));
            if(modC.Eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
        
        if(e.getSource() == frm.btnBuscar){
            mod.setMatricula(frm.txtMatricula.getText());
            if(modC.Buscar(mod)){
                frm.txtId_alumnos.setText(String.valueOf(mod.getId_alumnos()));
                frm.txtId_proyecto.setText(String.valueOf(mod.getId_proyecto()));
                frm.txtMatricula.setText(mod.getMatricula());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtnombreP.setText(mod.getNombreP());
                frm.txtDescripcion.setText(mod.getDescripcion());
                frm.txtnombreP.setVisible(true);
                frm.txtId_alumnos.setVisible(true);
                frm.labID.setVisible(true);
                frm.txtDescripcion.setVisible(true);
                frm.revalidate();
                frm.repaint();
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun alumno");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
        
    }
    
    public void limpiar() {
    frm.txtNombre.setText(null);
    frm.txtMatricula.setText(null);
    frm.txtId_proyecto.setText(null);
    frm.txtnombreP.setVisible(false);
    frm.txtId_alumnos.setVisible(false);
    frm.labID.setVisible(false);
    frm.txtDescripcion.setVisible(false);
    frm.revalidate();
    frm.repaint();
    }
    
}
