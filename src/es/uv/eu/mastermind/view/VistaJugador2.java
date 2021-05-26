/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.mastermind.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Raúl
 */
public class VistaJugador2 extends JFrame{
    private JuegoMenu menu;
    private Combinacion combinacion;

    private JPanel titulo, empezar;
    private JLabel texto, paso;
    private Font fuente;
    private JButton jugar;
    
    public VistaJugador2(){
            super("MasterMind");
        
        combinacion = new Combinacion();
        menu = new JuegoMenu();
        titulo = new JPanel();
        empezar = new JPanel();
        
        jugar = new JButton("Siguiente");
        jugar.setActionCommand("Siguiente");
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(menu);
        
        texto = new JLabel("Jugador 2, es tu turno", SwingConstants.CENTER);
    
        fuente = new Font("Sans", Font.BOLD, 20);
        
        texto.setFont(fuente);
        texto.setForeground(Color.BLUE);
        
        titulo.add(texto);
        
        this.add(titulo,BorderLayout.NORTH);
        
        this.add(combinacion, BorderLayout.CENTER);
          
        
        
        //Boton empezar
        empezar.add(jugar);
        this.add(empezar,BorderLayout.SOUTH);
        
        
        this.setVisible(false);
    
    
    }
     public void setActionListener(ActionListener al) {

         menu.setActionListener(al);
        //combinacion.setActionListener(al);
        jugar.addActionListener(al);
    }
    
}

   
