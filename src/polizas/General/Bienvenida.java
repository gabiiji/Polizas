package polizas.General;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import polizas.Inicio;

public class Bienvenida extends JFrame {

    protected JPanel panelIzquierdo, panelDerecho, panelCentral, panelSuperior;
    private JMenuBar mb;
    private JMenu mA, mBD;
    JMenuItem home;
    JMenuItem mBD_a;
    JMenuItem mBD_c;
    JMenuItem mensaje;
    JMenuItem mMarcas;

    CardLayout cardLayout;
    JButton btnl;

    public Bienvenida() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        panelIzquierdo = new JPanel();
        panelIzquierdo.add(new JLabel("Panel Izquierdo... "));
        panelIzquierdo.setBackground(Color.decode("#92ada6"));
        panelIzquierdo.setPreferredSize(new Dimension(200, getHeight()));

        cardLayout = new CardLayout();
        panelCentral = new JPanel(cardLayout);
        panelCentral.add(new JLabel("Welcom to Java... "));

        panelSuperior = new JPanel();
        JLabel titulo = new JLabel("App");
        panelSuperior.setBackground(Color.decode("#b0d6a5"));
        panelSuperior.add(titulo);

        panelDerecho = new JPanel();
        panelDerecho.add(new JLabel("Panel derecho... "));
        panelDerecho.setBackground(Color.decode("#92ada6"));
        panelDerecho.setPreferredSize(new Dimension(200, getHeight()));

        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelIzquierdo, BorderLayout.WEST);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelDerecho, BorderLayout.EAST);

        this.menu();
        this.setVisible(true);
    }

    private void menu() {
        this.mb = new JMenuBar();
        setJMenuBar(mb);

        this.mA = new JMenu("Archivos");
        home = new JMenuItem("Home");
        this.mA.add(home);

        this.mensaje = new JMenuItem("Mensaje");
        this.mA.add(mensaje);

        this.mBD = new JMenu("Base de Datos");

        mMarcas = new JMenuItem("Marcas");
        mBD.add(mMarcas);

        this.mb.add(mA);
        this.mb.add(mBD);
    }

}
