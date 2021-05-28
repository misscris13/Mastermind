package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.model.MastermindModelo;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * @brief Panel de dibujado de la imagen
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class PanelDibujado extends JPanel
{
    private BufferedImage imagen;
    private MastermindModelo model;
    
    /**
     * @brief Constructor del panel
     * @param model Modelo
     */
    public PanelDibujado(MastermindModelo model)
    {
        this.model = model;
        imagen = model.getImagen();
    }
    
    /**
     * @brief Actualiza la imagen y repinta el panel
     */
    public void updateImagen()
    {
        imagen = model.getImagen();
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(imagen, 0, 0, this);
    }    
}
