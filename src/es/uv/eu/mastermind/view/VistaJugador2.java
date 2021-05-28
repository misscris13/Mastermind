package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    // MENU
    private JuegoMenu menu;
    // COLORES, PISTAS Y PUNTOS
    private Combinacion combinacion;

    // NORTE, USUARIO Y SUR
    private JPanel cabecera, usuarioPanel, pie, intentos;
    // MENSAJE BIENVENIDA Y TIP DE USUARIO
    private JLabel titulo, usuarioGuia, tituloAnterior;
    // FUENTE DEL TEXTO
    private Font fuente;
    // BOTON "SIGUIENTE", "REGISTRAR"
    private JButton siguiente, usuarioBoton;
    // CAMPO DE USUARIO
    private JTextField usuario;
    // MODELO
    private MastermindModelo model;
    
    // INTENTOS ANTERIORES
    private JTextField[] anterior1 = new JTextField[4];
    private JTextField[] anterior2 = new JTextField[4];
    private JTextField[] anterior3 = new JTextField[4];
    private JTextField[] anterior4 = new JTextField[4];
    private JPanel pAnterior1, pAnterior2, pAnterior3, pAnterior4;
    
    /**
     * @brief Constructor de la ventana
     * @param model Modelo
     */
    public VistaJugador2(MastermindModelo model)
    {
        super("MasterMind");
        
        this.model = model;
        
        combinacion = new Combinacion(model);
        menu = new JuegoMenu();
        cabecera = new JPanel();
        usuarioPanel = new JPanel();
        pie = new JPanel();
        intentos = new JPanel();
        pAnterior1 = new JPanel();
        pAnterior2 = new JPanel();
        pAnterior3 = new JPanel();
        pAnterior4 = new JPanel();
        usuario = new JTextField(10);
        
        siguiente = new JButton("Siguiente");
        siguiente.setActionCommand("Siguiente");
        usuarioBoton = new JButton("Registrar");
        usuarioBoton.setActionCommand("Registrar");
        
        this.setLayout(new BorderLayout());
        
        this.setJMenuBar(menu);
        
        titulo = new JLabel("", SwingConstants.CENTER);
        actualizaTitulo();
    
        fuente = new Font("Sans", Font.BOLD, 20);
        
        titulo.setFont(fuente);
        titulo.setForeground(Color.BLUE);
        
        usuarioGuia = new JLabel("Escribe tu usuario", SwingConstants.CENTER);
        
        usuarioPanel.add(usuarioGuia);
        usuarioPanel.add(usuario);
        usuarioPanel.add(usuarioBoton);
        
        cabecera.setLayout(new BorderLayout());
        cabecera.add(titulo, BorderLayout.NORTH);
        cabecera.add(usuarioPanel);
        
        this.add(cabecera, BorderLayout.NORTH);
        
        this.add(combinacion);
        
        //INTENTOS ANTERIORES
        for (int i = 0; i < 4; i++)
        {
            anterior1[i] = new JTextField("            ");
            anterior1[i].setEditable(false);
            anterior1[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            pAnterior1.add(anterior1[i]);
            
            anterior2[i] = new JTextField("            ");
            anterior2[i].setEditable(false);
            anterior2[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            pAnterior2.add(anterior2[i]);
            
            anterior3[i] = new JTextField("            ");
            anterior3[i].setEditable(false);
            anterior3[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            pAnterior3.add(anterior3[i]);
            
            anterior4[i] = new JTextField("            ");
            anterior4[i].setEditable(false);
            anterior4[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            
            pAnterior4.add(anterior4[i]);
        }
        
        intentos.setLayout(new BoxLayout(intentos, BoxLayout.Y_AXIS));
        
        tituloAnterior = new JLabel("Combinación anterior", SwingConstants.CENTER);
        tituloAnterior.setFont(new Font("Sans", Font.BOLD, 20));
        
        intentos.add(tituloAnterior);
        intentos.add(pAnterior1);
        intentos.add(pAnterior2);
        intentos.add(pAnterior3);
        intentos.add(pAnterior4);
        
        this.add(intentos, BorderLayout.EAST);
        
        //Boton empezar
        pie.add(siguiente);
        this.add(pie, BorderLayout.SOUTH);
        
        usuarioPanel.setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * @brief Actualiza la combinación
     */
    public void actualizaEstado()
    {
        combinacion.actualizaEstado();
    }
    
    /**
     * @brief Actualiza las pistas
     * @param mostrar Si toca mostrar o no las pistas
     */
    public void actualizaPistas(Boolean mostrar)
    {
        if (mostrar)
            combinacion.muestraPistas();
        else
            combinacion.escondePistas();
    }
    
    /**
     * @brief Actualiza el intento anterior
     */
    public void actualizaAnterior()
    {
        combinacion.actualizaAnterior();
    }
    
    /**
     * @brief Actualiza el título (indicador de ronda)
     */
    public void actualizaTitulo()
    {
        titulo.setText("Jugador 2, es tu turno. Ronda " + String.valueOf(model.getRondaActual() + 1) + "/" + String.valueOf(model.getRondas()));
    }
    
    /**
     * @brief Actualiza los intentos anteriores
     */
    public void actualizaIntentos()
    {
        int ronda = model.getRondaActual();
        
        switch (ronda)
        {
            case 0:
                for (int i = 0; i < 4; i++)
                    anterior1[i].setBackground(model.getIntento(i));
                pAnterior1.repaint();
                break;
            case 1:
                for (int i = 0; i < 4; i++)
                    anterior2[i].setBackground(model.getIntento(i));
                pAnterior2.repaint();
                break;
            case 2:
                for (int i = 0; i < 4; i++)
                    anterior3[i].setBackground(model.getIntento(i));
                pAnterior3.repaint();
                break;
            case 3:
                for (int i = 0; i < 4; i++)
                    anterior4[i].setBackground(model.getIntento(i));
                pAnterior4.repaint();
                break;
        }
    }
    
    /**
     * @brief Reinicia los intentos anteriores
     */
    public void resetIntentos()
    {
        combinacion.resetCombinacion();
        
        for (int i = 0; i < 4; i++)
        {
            anterior1[i].setBackground(Color.GRAY);
            pAnterior1.repaint();
            
            anterior2[i].setBackground(Color.GRAY);
            pAnterior2.repaint();
            
            anterior3[i].setBackground(Color.GRAY);
            pAnterior3.repaint();
            
            anterior4[i].setBackground(Color.GRAY);
            pAnterior4.repaint();
        }
    }
    
    /**
     * @brief Devuelve el usuario y oculta la caja de texto
     * @return Nombre
     */
    public String getUsuario()
    {
        usuarioPanel.setVisible(false);
        return usuario.getText();
    }
    
    /**
     * @brief Muestra la caja de texto para introducir el usuario
     */
    public void muestraUsuario()
    {
        usuarioPanel.setVisible(true);
    }
    
    /**
     * @brief Añadido de los oyentes de acción
     * @param al Oyente de acción
     */
    public void setActionListener(ActionListener al)
    {
        menu.setActionListener(al);
        combinacion.setActionListener(al);
        siguiente.addActionListener(al);
        usuarioBoton.addActionListener(al);
    }
}

   
