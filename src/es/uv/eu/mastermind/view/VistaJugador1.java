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
import javax.swing.SwingConstants;

/**
 * @brief Vista del Jugador 1
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class VistaJugador1 extends JFrame
{
    //MENU
    private JuegoMenu menu;
    //COLORES, PISTAS Y PUNTOS
    private Combinacion combinacion;
    
    //NORTE, SUR
    private JPanel cabecera, pie;
    //MENSAJE DE BIENVENIDA
    private JLabel titulo;
    //FUENTE
    private Font fuente;
    //BOTON "EMPEZAR"
    private JButton jugar;
    //MODELO
    private MastermindModelo model;
    
    /**
     * @brief Constructor de la ventana
     * @param model Modelo
     */
    public VistaJugador1(MastermindModelo model)
    {
        super("MasterMind");
        
        this.model = model;
        
        combinacion = new Combinacion(model);
        menu = new JuegoMenu();
        cabecera = new JPanel();
        pie = new JPanel();
        
        jugar = new JButton("Empezar Juego");
        jugar.setActionCommand("Empezar");
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(menu);
        
        titulo = new JLabel("Bienvenido a Maestro de los colores", SwingConstants.CENTER);
    
        fuente = new Font("Sans", Font.BOLD, 40);
        
        titulo.setFont(fuente);
        titulo.setForeground(Color.RED);
        
        cabecera.add(titulo);
        
        this.add(cabecera,BorderLayout.NORTH);
        
        this.add(combinacion, BorderLayout.CENTER);
        
        //Boton empezar
        pie.add(jugar);
        this.add(pie,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    /**
     * @brief Añadido de los oyentes de acción
     * @param al Oyente de acción
     */
    public void setActionListener(ActionListener al)
    {
        menu.setActionListener(al);
        combinacion.setActionListener(al);
        jugar.addActionListener(al);
    }
    
    /**
     * @brief Actualiza la combinación
     */
    public void actualizaEstado()
    {
        combinacion.actualizaEstado();
    }
    
    /**
     * @brief Reinicia los colores de la combinación
     */
    public void resetSolucion()
    {
        combinacion.resetCombinacion();
    }
}
