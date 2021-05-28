package es.uv.eu.mastermind.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @brief Constructor de la clase JuegoMenu
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class JuegoMenu extends JMenuBar
{
    private JMenu menu, ayuda, ranking;
    private JMenuItem salir,volver, help, points;

    /**
     * @brief Constructor del menú
     */
    public JuegoMenu()
    {
        menu = new JMenu("Menu");
        salir = new JMenuItem("Salir");
        volver = new JMenuItem("Volver a Empezar");
        salir.setActionCommand("Salir");
        volver.setActionCommand("VolverEmpezar");
      
        menu.add(volver);
        menu.add(salir);

        ayuda = new JMenu("¿Qué es?");

        help = new JMenuItem("Ayuda");
        help.setActionCommand("help");

        ayuda.add(help);

        ranking = new JMenu("Ranking");
        //ranking.setBackground(Color.CYAN);
        ranking.setForeground(Color.BLUE);

        points = new JMenuItem("Puntos");
        points.setActionCommand("points");

        ranking.add(points);

        this.add(menu);
        this.add(ayuda);
        this.add(ranking);

        this.setVisible(true);
    }

    /**
     * @brief Añadido de los oyentes de acción
     * @param al Oyente de acción
     */
    public void setActionListener(ActionListener al) {
        
        volver.addActionListener(al);
        salir.addActionListener(al);
        help.addActionListener(al);
        points.addActionListener(al);
    }
}
