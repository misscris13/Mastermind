package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.controller.MastermindController;
import es.uv.eu.mastermind.model.MastermindModelo;

/**
 * @brief Clase main de la aplicación
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MastermindModelo model = new MastermindModelo();
        VistaJugador1 view = new VistaJugador1(model);
        VistaJugador2 view2 = new VistaJugador2(model);
        VistaFinal fin = new VistaFinal(model);
        Ranking rank = new Ranking(model);
        VentanaAbout about = new VentanaAbout();
        MastermindController controlador = new MastermindController(view, view2, fin, rank, about, model);

        view.setSize(800, 550);
        view.setVisible(true);
    }
    
}
