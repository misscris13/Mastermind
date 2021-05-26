package es.uv.eu.mastermind.controller;

import es.uv.eu.mastermind.view.VistaJugador1;
import es.uv.eu.mastermind.view.VistaJugador2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Raúl
 */
public class MastermindController {
    
    private VistaJugador1 jugador1;
    private VistaJugador2 jugador2;
    
    public MastermindController(VistaJugador1 jugador1, VistaJugador2 jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        
        jugador1.addWindowListener(new MastermindControllerWindowListener());
        jugador1.setActionListener(new MastermindControllerActionListener());
        jugador2.addWindowListener(new MastermindControllerWindowListener());
        jugador2.setActionListener(new MastermindControllerActionListener());
    
    }
     /**
     * @brief Clase empotrada del WindowListener
     * @author Raúl Abella Bioque
     * @author Cristal Campos Abad
     */
    class  MastermindControllerWindowListener extends WindowAdapter
    {
        /**
         * @brief Termina la ejecución cuando se cierra la ventana
         * @param e Evento de ventana
         */
        @Override
        public void windowClosing(WindowEvent e)
        {
            System.out.println("Exit");
            System.exit(0);
        }
    }
    /**
     * @brief Clase del ActionListener
     * @author Raúl Abella Bioque
     * @author Cristal Campos Abad
     */
    class MastermindControllerActionListener implements ActionListener
    {
        /**
         * @brief Determina las acciones a llevar a cabo dependiendo de la accion
         *        realizada
         * @param ae Evento de accion
         */
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            String command = ae.getActionCommand();
            switch(command)
            {
                case "VolverEmpezar":
                    System.out.println("Volver a Empezar juego");
                    jugador1.setSize(750, 350);
                    jugador1.setVisible(true);
                    jugador2.setVisible(false);
                    break;
                case "Empezar":
                    System.out.println("Empezamos juego");
                    jugador2.setSize(750, 350);
                    jugador2.setVisible(true);
                    jugador1.setVisible(false);
                    break;
                  case "Salir":
                    System.out.println("Salir");
                    System.exit(0);
                    break;
              
            }
        }
    }
    
    
}
