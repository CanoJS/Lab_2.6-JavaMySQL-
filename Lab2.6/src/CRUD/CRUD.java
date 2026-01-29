
package CRUD;

import Controlador.CtrlAlumno;
import Modelo.Alumno;
import Modelo.CAlumno;
import Vista.frmAlumno;

public class CRUD {
    
    public static void main(String[] args){
        
        Alumno mod = new Alumno();
        CAlumno modC = new CAlumno();
        frmAlumno frm = new frmAlumno();
        
        CtrlAlumno ctrl = new CtrlAlumno(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}
