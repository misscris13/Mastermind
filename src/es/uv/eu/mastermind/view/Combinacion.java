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
 * @brief Botones de colores, pistas e intentos
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class Combinacion extends JPanel
{
    //NOMBRES DE LOS BOTONES
    private String[] nombreBotones = {"Negro", "Naranja", "Rosa", "Amarillo", "Blanco", "Rojo", "Azul", "Verde",};
    //COLORES
    private Color[] colores = {Color.BLACK, Color.ORANGE, Color.PINK, Color.YELLOW, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN};
    //VECTOR DE BOTONES
    private JButton[] botonesColor = new JButton[8];
    
    private Font fuente;
    private JLabel paso, combinacionFrase, puntos;
    
    //VECTOR DE INTENTOS
    private JTextField[] vTFields1 = new JTextField[4];
    //VECTOR DE PISTAS
    private JTextField[] vTFields2 = new JTextField[4];
    //VECTOR DE INTENTOS ANTERIORES
    private JTextField[] anterior = new JTextField[4];
    
    private JPanel statusCombinacion, statusPistas, status, combinaciones, titulo;
    private MastermindModelo model;
    
    /**
     * @brief Constructor del panel
     * @param model Modelo
     */
    public Combinacion(MastermindModelo model)
    {
        this.model = model;
        
        statusCombinacion = new JPanel();
        statusPistas = new JPanel();
        status = new JPanel();
        combinaciones = new JPanel();
        titulo = new JPanel();
        puntos = new JLabel();

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

        status.setLayout(new BorderLayout());
        
        statusCombinacion.add(combinacionFrase);
        
        // Intento
        for(int i = 0; i < 4; i++)
        {
            vTFields1[i] = new JTextField("            ");
            vTFields1[i].setEditable(false);
            vTFields1[i].setBackground(model.getIntento(i));
            vTFields1[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            statusCombinacion.add(vTFields1[i]);
        }
        
        statusPistas.add(puntos);
        
        // Pistas
        for(int i = 0; i < 4; i++)
        {
            vTFields2[i] = new JTextField("       ");
            vTFields2[i].setEditable(false);
            vTFields2[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            statusPistas.add(vTFields2[i]);
        }
        
        // Anterior
        for(int i = 0; i < 4; i++)
        {
            anterior[i] = new JTextField("            ");
            anterior[i].setEditable(false);
            anterior[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }
        
        status.add(statusCombinacion);
        
        status.add(statusPistas, BorderLayout.SOUTH);
        escondePistas();
        
        this.add(status, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    /**
     * @brief Actualiza la combinación actual
     */
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
    
    /**
     * @brief Actualiza la combinación anterior
     */
    public void actualizaAnterior()
    {
        for (int i = 0; i < 4; i++)
        {
            anterior[i].setBackground(vTFields1[i].getBackground());
        }
    }
    
    /**
     * @brief Muestra las pistas
     */
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
        
        puntos.setText(String.valueOf(model.calculaPuntos()) + " puntos");
        statusPistas.setVisible(true);
    }
    
    /**
     * @brief Esconde las pistas
     */
    public void escondePistas()
    {
        statusPistas.setVisible(false);
    }
    
    /**
     * @brief Reinicia la combinación actual
     */
    public void resetCombinacion()
    {
        for (int i = 0; i < 4; i++)
        {
            vTFields1[i].setBackground(Color.GRAY);
        } 
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
