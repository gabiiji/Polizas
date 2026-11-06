package polizas.Marcas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MarcasVista extends JPanel{
    protected JButton btnl,btn_a, btn_u,btn_d;
    protected JTextField txtl;
    protected JLabel lb11, lb12;
    
    protected JTable tabla;
    protected MarcasTM marcasModelo;
    protected String[] columnas = {"Id", "Nombre"};
    
    
    
    protected JComboBox cmbMarcas;
    
    public MarcasVista(){
        setLayout(null);
        
        this.lb11 = new JLabel ("Welcome to Marcas Admin");
        lb11.setBounds(350, 5, 150, 30);
        
        lb12 = new JLabel("Ingresar tu nombre: ");
        lb12.setBounds(50, 40, 150, 30);
        
        this.txtl = new JTextField("Marca 1");
        this.txtl.setBounds(170, 40, 250, 30);
        
        cmbMarcas = new JComboBox();
        cmbMarcas.setBounds(500, 40, 250, 30);
        add(cmbMarcas);
        
        this.btnl = new JButton("Consultar");
        this.btnl.setBounds(150, 90, 100, 30);
        
        this.btn_a = new  JButton("Agregar");
        this.btn_a.setBounds(250, 90, 100, 30);
        this.add(btn_a);
        
        this.btn_u = new  JButton("Actualizar");
        this.btn_u.setBounds(350, 90, 100, 30);
        this.add(btn_u);
        
        this.btn_d = new  JButton("Eliminar");
        this.btn_d.setBounds(450, 90, 100, 30);
        this.add(btn_d);
        
        marcasModelo = new MarcasTM();
        tabla = new JTable(marcasModelo);
        
        marcasModelo.fireTableDataChanged();
        JScrollPane sc = new JScrollPane(tabla);
        sc.setBounds(200,150,800, 500);
        
        this.add(sc, BorderLayout.CENTER);
        
        this.add(lb11);
        this.add(lb12);
        this.add(txtl);
        this.add(btnl);
    }
    
    public void actualizarVista(List<Marca> lista){
        marcasModelo.vaciarLista();
        marcasModelo.fireTableDataChanged();
        marcasModelo.llenar(lista);
        
        cmbMarcas.removeAllItems();
        for (Marca m : lista){
            cmbMarcas.addItem(m);
        }    
    }
}

 