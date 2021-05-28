package es.uv.eu.mastermind.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @brief Panel About
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class VentanaAbout extends JFrame
{
    private JPanel titulo, descripcion, fin;
    private JLabel texto, texto2, l1, l2 , l3, l4, l5, l6;
    private Font fuente, fuente2;
    
    /**
     * @brief Constructor de la ventana
     */
    public VentanaAbout()
    {
        super("About");

        titulo = new JPanel();
        descripcion = new JPanel();
        fin = new JPanel();
        this.setLayout(new BorderLayout());

        texto = new JLabel("¿Qué es Maestro de los Colores?", SwingConstants.CENTER);

        fuente = new Font("Sans", Font.BOLD, 40);

        texto.setFont(fuente);
        texto.setForeground(Color.RED);

        titulo.add(texto);

        this.add(titulo, BorderLayout.NORTH);
        
        fuente = new Font("Sans", Font.BOLD, 20);
        
        l1 = new JLabel("Bienvenido a Mastermind. El objetivo del juego consiste en:", SwingConstants.CENTER);
        l1.setFont(fuente);
        l2 = new JLabel("Un Jugador 1 elige una combinación de colores.", SwingConstants.CENTER);
        l2.setFont(fuente);
        l3 = new JLabel("Un segundo Jugador intenta adivinar dicha combinación.", SwingConstants.CENTER);
        l3.setFont(fuente);
        l4 = new JLabel("Se disponen de 5 intentos. No adivinarlo a tiempo significa perder.", SwingConstants.CENTER);
        l4.setFont(fuente);
        l5 = new JLabel("Al finalizar cada intento se proporcionarán unas pistas de colores:", SwingConstants.CENTER);
        l5.setFont(fuente);
        l6 = new JLabel("Negro (color y posición correctos), Rojo (color correcto) o Blanco (incorrecto).", SwingConstants.CENTER);
        l6.setFont(fuente);
        
        descripcion.add(l1);
        descripcion.add(l2);
        descripcion.add(l3);
        descripcion.add(l4);
        descripcion.add(l5);
        descripcion.add(l6);
        
        this.add(descripcion);
        
        texto2 = new JLabel("Designed by Cristal & Raúl", SwingConstants.CENTER);

        fuente2 = new Font("Time New Roman", Font.BOLD, 20);

        texto2.setFont(fuente2);
        texto2.setForeground(Color.GRAY);

        fin.add(texto2);

        this.add(fin, BorderLayout.SOUTH);
        
        this.setVisible(false);
    }
}
