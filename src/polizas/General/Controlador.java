package polizas.General;

import polizas.Marcas.MarcasVista;
import javax.swing.JLabel;
import polizas.Marcas.MarcasControl;
//import polizas.General.Mensaje;

public class Controlador {
    protected Bienvenida vista;
    protected MarcasVista marcaVista;
    protected MarcasControl marcasControl;
 
    
    public Controlador (Bienvenida vista){
         this.vista = vista;
         this.eventos();
    }
    
    public void eventos(){
        
        vista.mensaje.addActionListener(e ->{
            vista.panelCentral.add(new Mensaje(), "mensaje");
            vista.cardLayout.show(vista.panelCentral, "mensaje");
        });
        
        vista.home.addActionListener(e->{
            vista.panelCentral.add(new JLabel("Panel Home"), "home");
            vista.cardLayout.show(vista.panelCentral, "home");
        });
        
        vista.mMarcas.addActionListener(e ->{
            marcaVista = new MarcasVista();
            marcasControl = new MarcasControl(marcaVista);
            vista.panelCentral.add(marcaVista, "mk");
            vista.cardLayout.show(vista.panelCentral, "mk");
        });
          
       }
    }


