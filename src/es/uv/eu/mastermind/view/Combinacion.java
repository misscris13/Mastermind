/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @brief Botones de colores
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class Combinacion extends JPanel
{
    private String[] nombreBotones = {"Negro", "Naranja", "Rosa", "Amarillo", "Blanco", "Rojo", "Azul", "Verde",};
    private Color[] colores = {Color.BLACK, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    private JButton[] botonesColor = new JButton[8];
    private Font fuente;
    private JLabel paso, combinacionFrase;
    private JTextField[] vTFields1 = new JTextField[4];
    private JTextField[] vTFields2 = new JTextField[4];
    private JPanel status, status2, status3, combinaciones, titulo;
    private MastermindModelo model;
    
    public Combinacion(MastermindModelo model)
    {
        this.model = model;
        
        status = new JPanel();
        status2 = new JPanel();
        status3 = new JPanel();
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

        status3.setLayout(new BorderLayout());
        
        status.add(combinacionFrase);
        
        // Intento (status)
        for(int i = 0; i < 4; i++)
        {
            vTFields1[i] = new JTextField("            ");
            vTFields1[i].setEditable(false);
            vTFields1[i].setBackground(model.getIntento(i));
            vTFields1[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            status.add(vTFields1[i]);
        }
        
        // Pistas (status2)
        for(int i = 0; i < 4; i++)
        {
            vTFields2[i] = new JTextField("       ");
            vTFields2[i].setEditable(false);
            vTFields2[i].setBackground(model.getIntento(i));
            vTFields2[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            status2.add(vTFields2[i]);
        }

        status3.add(status);
        
        status3.add(status2, BorderLayout.SOUTH);
        escondePistas();
        
        this.add(status3, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public void actualizaEstado()
    {
        for(int i = 0; i < 4; i++)
        {
            if(model.getJugador() == 1)
                vTFields1[i].setBackground(model.getSolucion(i));
            else if (model.getJugador() == 2)
                vTFields1[i].setBackground(model.getIntento(i));
        }
    }
    
    public void muestraPistas()
    {
        int[] pistas = model.getPistas();
        
        for (int i = 0; i < pistas.length; i++)
        {
            switch(pistas[i])
            {
                case 0:
                    vTFields2[i].setBackground(Color.WHITE);
                    break;
                case 1:
                    vTFields2[i].setBackground(Color.RED);
                    break;
                case 2:
                    vTFields2[i].setBackground(Color.BLACK);
                    break;
            }
        }
        
        status2.setVisible(true);
    }
    
    public void escondePistas()
    {
        status2.setVisible(false);
    }
    
    /**
     * @brief Añadido de los oyentes de accion
     * @param al Oyente de accion
     */
    public void setActionListener(ActionListener al)
    {
        for(int i = 0; i < 8; i++)
        {
            botonesColor[i].addActionListener(al);
        }
    }
}
