package es.uv.eu.mastermind.controller;

import es.uv.eu.mastermind.model.MastermindModelo;
import es.uv.eu.mastermind.view.VistaJugador1;
import es.uv.eu.mastermind.view.VistaJugador2;
import java.awt.Color;
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
    private MastermindModelo model;
    
    public MastermindController(VistaJugador1 jugador1, VistaJugador2 jugador2, MastermindModelo model){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.model = model;
        
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
        // Determina si hay que mostrar las pistas o no
        Boolean pistas = false;
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
                    jugador1.setSize(800, 550);
                    jugador1.setVisible(true);
                    jugador2.setVisible(false);
                    model.setJugador(1);
                    model.resetPaso();
                    break;
                case "Empezar":
                    System.out.println("Empezamos juego");
                    jugador2.setSize(800, 550);
                    jugador2.setVisible(true);
                    jugador1.setVisible(false);
                    model.setJugador(2);
                    model.resetPaso();
                    break;
                case "Siguiente":
                    pistas = !pistas;
                    if (pistas)
                        model.comprobarIntento();
                    jugador2.actualizaPistas(pistas);
                    //model.resetIntento();
                    break;
                case "Salir":
                    System.out.println("Salir");
                    System.exit(0);
                    break;
                case "Negro":
                case "Naranja":
                case "Rosa":
                case "Amarillo":
                case "Blanco":
                case "Rojo":
                case "Azul":
                case "Verde":
                    System.out.println(command);
                    if (model.getPaso() < 4)
                    {
                        if (model.getJugador() == 1)
                        {
                            model.setSolucion(command);
                            jugador1.actualizaEstado();
                        }
                        else if (model.getJugador() == 2)
                        {
                            model.setIntento(command);
                            jugador2.actualizaEstado();
                        }
                    }
                    else
                        System.out.println("Vector de colores lleno.");
            }
        }
    }
    
    
}
