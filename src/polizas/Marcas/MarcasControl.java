
package polizas.Marcas;

import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;


public class MarcasControl {
    private MarcasVista mv;
    private MarcasModelo mm;
    private List<Marca> lista;
    
    public MarcasControl (MarcasVista marcasVista){
        this.mv = marcasVista;
        this.mm = new MarcasModelo();
        
        marcasEventos();
    }
    public void marcasEventos(){
        mv.btnl.addActionListener(e ->{
            lista = mm.read();
            mv.actualizarVista(lista);
        });
        mv.btn_a.addActionListener(e ->{
            Object marca = new Marca(0, mv.txtl.getText()); 
            JOptionPane.showMessageDialog(null, mm.create(marca));
            mv.actualizarVista(mm.read());
        });
        
        mv.btn_u.addActionListener(e -> {
            int fila = mv.tabla.getSelectedRow();
            if (fila != -1) {
                Marca m = mv.marcasModelo.getMarca(fila);
                m.setNombre(mv.txtl.getText()); 
                int resultado = mm.update(m);
                JOptionPane.showMessageDialog(null, resultado > 0 ? "Registro actualizado con éxito" : "Error al actualizar");
                mv.actualizarVista(mm.read());
                mv.txtl.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un registro de la tabla para actualizar.");
            }
        });
        
        mv.btn_d.addActionListener(e -> {
            int fila = mv.tabla.getSelectedRow();
            if (fila != -1) {
                Marca m = mv.marcasModelo.getMarca(fila);
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar la marca: " + m.getNombre() + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    int resultado = mm.delete(m);
                    JOptionPane.showMessageDialog(null, resultado > 0 ? "Registro eliminado con éxito" : "Error al eliminar");
                    mv.actualizarVista(mm.read());
                    mv.txtl.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un registro de la tabla para eliminar.");
            }
        });
        
        
        mv.tabla.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Registro" + mv.marcasModelo.getValueAt(mv.tabla.getSelectedRow(), 1));
                mv.txtl.setText((String) mv.marcasModelo.getValueAt(mv.tabla.getSelectedRow(),1));
            }
        });
        
        mv.tabla.getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()){
                int fila = mv.tabla.getSelectedRow();
                System.out.println("Regiistro: " + fila + "Valor: " + mv.tabla.getValueAt(fila, 1));
                System.out.println("Registro" + fila + "Valor: " + mv.tabla.getValueAt(fila, 1));
            }
        });
        mv.cmbMarcas.addActionListener(e ->{
            Marca marca =(Marca) mv.cmbMarcas.getSelectedItem();
        });
    }
}
