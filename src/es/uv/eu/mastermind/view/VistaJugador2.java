package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @brief Vista del Jugador 2
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class VistaJugador2 extends JFrame
{
    private JuegoMenu menu;
    private Combinacion combinacion;

    private JPanel titulo, empezar;
    private JLabel texto, paso;
    private Font fuente;
    private JButton jugar;
    private JTextField usuario;
    
    private MastermindModelo model;
    
    public VistaJugador2(MastermindModelo model)
    {
        super("MasterMind");
        
        this.model = model;
        
        combinacion = new Combinacion(model);
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
        
        titulo.setLayout(new BorderLayout());
        titulo.add(texto, BorderLayout.NORTH);
        //titulo.add(usuario);
        
        this.add(titulo,BorderLayout.NORTH);
        
        this.add(combinacion, BorderLayout.CENTER);
        
        //Boton empezar
        empezar.add(jugar);
        this.add(empezar,BorderLayout.SOUTH);
        
        this.setVisible(false);
    }
    
    public void actualizaEstado()
    {
        combinacion.actualizaEstado();
    }
    
    public void actualizaPistas(Boolean mostrar)
    {
        if (mostrar)
            combinacion.muestraPistas();
        else
            combinacion.escondePistas();
    }
    
    public void setActionListener(ActionListener al)
    {
        menu.setActionListener(al);
        combinacion.setActionListener(al);
        jugar.addActionListener(al);
    }
    
    
}

   
