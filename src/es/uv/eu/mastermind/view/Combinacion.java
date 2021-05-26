/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.mastermind.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Raúl
 */
public class Combinacion extends JPanel {

    private String[] nombreBotones = {"Negro", "Naranja", "Rosa", "Amarillo", "Blanco", "Rojo", "Azul", "Verde",};
    private Color[] colores = {Color.BLACK, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    private JButton[] botonesColor = new JButton[8];
    private Font fuente;
    private JLabel paso, combinacionFrase;
    private JTextField rect1, rect2, rect3, rect4;
    private JPanel status, combinaciones, titulo;
    private Color color1 = Color.BLACK;
    private Color color2 = Color.BLACK;
    private Color color3 = Color.BLACK;
    private Color color4 = Color.BLACK;

    public Combinacion() {

        
        status = new JPanel();
        combinaciones = new JPanel();
        titulo = new JPanel();

        this.setLayout(new BorderLayout());

        paso = new JLabel("1º Elegid la combinación", SwingConstants.CENTER);
        combinacionFrase = new JLabel("Combinación elegida", SwingConstants.CENTER);
        fuente = new Font("Sans", Font.BOLD, 20);
        
        paso.setFont(fuente);
        combinacionFrase.setFont(fuente);
        
        titulo.add(paso);
        this.add(titulo,BorderLayout.NORTH);
        
        //  ASPECTO PANEL
        combinaciones.setLayout(new GridLayout(4, 2, 10, 10));
        
         //  BUCLE BOTONES
            for(int i = 0; i < 8; i++)
            {
                botonesColor[i] = new JButton(nombreBotones[i]);
                
                //  ASPECTO
                botonesColor[i].setBackground(colores[i]);
               
                botonesColor[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                
                //  COLORES
                if(nombreBotones[i].equals("Negro") || nombreBotones[i].equals("Azul"))
                    botonesColor[i].setForeground(Color.WHITE);
                
                botonesColor[i].setActionCommand(nombreBotones[i]);
                combinaciones.add(botonesColor[i]);
            }

        this.add(combinaciones, BorderLayout.CENTER);

        rect1 = new JTextField("            ");
        rect1.setEditable(false);
        rect1.setBackground(color1);
        rect1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        rect2 = new JTextField("            ");
        rect2.setEditable(false);
        rect2.setBackground(color2);
        rect2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        rect3 = new JTextField("            ");
        rect3.setEditable(false);
        rect3.setBackground(color3);
        rect3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        rect4 = new JTextField("            ");
        rect4.setEditable(false);
        rect4.setBackground(color4);
        rect4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        status.add(combinacionFrase);
        status.add(rect1);
        status.add(rect2);
        status.add(rect3);
        status.add(rect4);

        this.add(status, BorderLayout.SOUTH);

        this.setVisible(true);

    }

}
