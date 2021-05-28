package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @brief Vista Final
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class VistaFinal extends JFrame
{
    private JuegoMenu menu;
    
    private BufferedImage imagen;
    
    private JPanel titulo, empezar;
    private PanelDibujado imagenPanel;
    private JLabel texto;
    private Font fuente;
    private JButton jugar;
    
    private MastermindModelo model;
    
    /**
     * @brief Constructor de la ventana
     * @param model Modelo
     */
    public VistaFinal(MastermindModelo model)
    {
        super("MasterMind");
        
        this.model = model;
        
        imagen = model.getImagen();
        
        menu = new JuegoMenu();
        titulo = new JPanel();
        empezar = new JPanel();
        imagenPanel = new PanelDibujado(model);
        
        jugar = new JButton("Volver al Juego");
        jugar.setActionCommand("VolverEmpezar");
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(menu);
        
        texto = new JLabel("Has acabado el juego", SwingConstants.CENTER);
    
        fuente = new Font("Sans", Font.BOLD, 35);
        
        texto.setFont(fuente);
        texto.setForeground(Color.RED);
        
        titulo.add(texto);
        
        this.add(titulo,BorderLayout.NORTH);
        
        this.add(imagenPanel);
                
        //Boton empezar
        empezar.add(jugar);
        this.add(empezar,BorderLayout.SOUTH);
        
        this.setVisible(false);
    }
    
    /**
     * @brief Muestra la imagen final
     * @param img Nombre de la imagen, "victoria" o "derrota"
     */
    public void mostrarImagen(String img)
    {
        model.setImagen(img);
        imagenPanel.updateImagen();
    }
    
    /**
     * @brief Añadido de los oyentes de acción
     * @param al Oyente de acción
     */
    public void setActionListener(ActionListener al)
    {
        menu.setActionListener(al);
        jugar.addActionListener(al);
    }
}
