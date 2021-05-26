/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.mastermind.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @brief Constructor de la clase JuegoMenu
 * @author Raúl
 */
public class JuegoMenu extends JMenuBar {

    private JMenu menu, ayuda, ranking;
    private JMenuItem salir,volver, help, points;

    public JuegoMenu() {

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

    public void setActionListener(ActionListener al) {
        
        volver.addActionListener(al);
        salir.addActionListener(al);
        help.addActionListener(al);
        points.addActionListener(al);

    }

}
