package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @brief Vista del Ranking
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class Ranking extends JFrame
{
    private JPanel ranking;
    private JLabel[] puestos;
    private JLabel titulo;
    private Font fuente;
    private MastermindModelo model;
    
    /**
     * @brief Constructor del panel
     * @param model Modelo
     */
    public Ranking(MastermindModelo model)
    {
        this.model = model;
        
        ranking = new JPanel();
        ranking.setLayout(new BoxLayout(ranking, BoxLayout.Y_AXIS));
        
        puestos = new JLabel[10];
        
        for (int i = 0; i < puestos.length; i++)
            puestos[i] = new JLabel("", SwingConstants.CENTER);
        
        titulo = new JLabel("Top 10 Jugadores", SwingConstants.CENTER);
    
        fuente = new Font("Sans", Font.BOLD, 35);
        
        titulo.setFont(fuente);
        titulo.setForeground(Color.BLUE);
        
        this.setLayout(new BorderLayout());
        
        this.add(titulo, BorderLayout.NORTH);
        actualizaRanking();
        
        this.setVisible(false);
    }
    
    /**
     * @brief Actualiza las etiquetas del ranking
     */
    public void actualizaRanking()
    {
        ranking = new JPanel();
        ranking.setLayout(new BoxLayout(ranking, BoxLayout.Y_AXIS));
        for (int i = 0; i < puestos.length; i++)
        {
            puestos[i].setText("    " + String.valueOf(i+1) + "º " + String.valueOf(model.getRanking()[i]) + " " + String.valueOf(model.getRankingPuntos()[i]) + " pts.");
            puestos[i].setFont(new Font("Sans", Font.PLAIN, 20));
            ranking.add(puestos[i]);
        }
        this.add(ranking);
    }
}
