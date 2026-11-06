package polizas;

import javax.swing.SwingUtilities;
import polizas.General.Bienvenida;
import polizas.General.Controlador;


public class Inicio {
Controlador controlador;
Bienvenida vista;

    
   public Inicio (){
        vista = new Bienvenida();
        controlador = new Controlador(vista);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inicio::new);
    }
    
}
