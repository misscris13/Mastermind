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
    // MENU
    private JuegoMenu menu;
    // COLORES, PISTAS Y PUNTOS
    private Combinacion combinacion;

    // NORTE, USUARIO Y SUR
    private JPanel cabecera, usuarioPanel, pie;
    // MENSAJE BIENVENIDA Y TIP DE USUARIO
    private JLabel titulo, usuarioGuia;
    // FUENTE DEL TEXTO
    private Font fuente;
    // BOTON "SIGUIENTE", "REGISTRAR"
    private JButton siguiente, usuarioBoton;
    // CAMPO DE USUARIO
    private JTextField usuario;
    // MODELO
    private MastermindModelo model;
    
    public VistaJugador2(MastermindModelo model)
    {
        super("MasterMind");
        
        this.model = model;
        
        combinacion = new Combinacion(model);
        menu = new JuegoMenu();
        cabecera = new JPanel();
        usuarioPanel = new JPanel();
        pie = new JPanel();
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
        
        //Boton empezar
        pie.add(siguiente);
        this.add(pie, BorderLayout.SOUTH);
        
        usuarioPanel.setVisible(true);
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
    
    public void actualizaTitulo()
    {
        titulo.setText("Jugador 2, es tu turno. Ronda " + String.valueOf(model.getRondaActual() + 1) + "/" + String.valueOf(model.getRondas()));
    }
    
    public String getUsuario()
    {
        usuarioPanel.setVisible(false);
        return usuario.getText();
    }
    
    public void muestraUsuario()
    {
        usuarioPanel.setVisible(true);
    }
    
    public void setActionListener(ActionListener al)
    {
        menu.setActionListener(al);
        combinacion.setActionListener(al);
        siguiente.addActionListener(al);
        usuarioBoton.addActionListener(al);
    }
}

   
