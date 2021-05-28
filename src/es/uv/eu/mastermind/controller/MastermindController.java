package es.uv.eu.mastermind.controller;

import es.uv.eu.mastermind.model.*;
import es.uv.eu.mastermind.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @brief Controlador de la aplicación
 * @author Raúl Abella Bioque
 * @author Cristal Campos Abad
 */
public class MastermindController {
    
    // VISTAS DE JUGADORES
    private VistaJugador1 jugador1;
    private VistaJugador2 jugador2;
    // RESULTADO
    private VistaFinal fin;
    // RANKING
    private Ranking rank;
    // ABOUT
    private VentanaAbout about;
    // MODELO
    private MastermindModelo model;
    
    /**
     * @brief Constructor
     * @param jugador1 Vista J1
     * @param jugador2 Vista J2
     * @param fin Vista final
     * @param rank Ranking
     * @param about About
     * @param model Modelo
     */
    public MastermindController(VistaJugador1 jugador1, VistaJugador2 jugador2, VistaFinal fin, Ranking rank, VentanaAbout about, MastermindModelo model)
    {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fin = fin;
        this.rank = rank;
        this.about = about;
        this.model = model;
        
        jugador1.addWindowListener(new MastermindControllerWindowListener());
        jugador1.setActionListener(new MastermindControllerActionListener());
        jugador2.addWindowListener(new MastermindControllerWindowListener());
        jugador2.setActionListener(new MastermindControllerActionListener());
        fin.addWindowListener(new MastermindControllerWindowListener());
        fin.setActionListener(new MastermindControllerActionListener());
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
                    
                    fin.setVisible(false);
                    
                    model.setJugador(1);
                    model.resetJuego();
                    
                    jugador1.resetSolucion();
                    jugador2.resetIntentos();
                    break;
                case "Empezar":
                    System.out.println("Empezamos juego");
                    
                    jugador2.setSize(800, 550);
                    jugador2.setVisible(true);
                    jugador2.muestraUsuario();
                    
                    jugador1.setVisible(false);
                    
                    fin.setVisible(false);
                    
                    model.setJugador(2);
                    model.resetIntento();
                    model.resetPaso();
                    break;
                case "Siguiente":
                    if ((model.pasarRonda(pistas)) && (model.calculaPuntos() < 100))
                    {
                        pistas = !pistas; //Se invierte pistas, es como un interruptor
                        if (pistas) //Si toca mostrar las pistas
                            model.comprobarIntento();
                        
                        jugador2.actualizaPistas(pistas);
                        jugador2.actualizaAnterior();
                        jugador2.actualizaIntentos();
                        
                        model.resetIntento();
                        model.resetPaso();
                    }
                    else if (model.getPuntos() == 100) //Si hemos ganado
                    {
                        fin.mostrarImagen("victoria");
                        fin.setSize(800, 550);
                        fin.setVisible(true);
                        
                        model.setRanking();
                        
                        pistas = false;
                        
                        jugador2.actualizaPistas(pistas);
                        jugador1.actualizaEstado();
                        jugador2.actualizaEstado();
                        jugador2.setVisible(false);
                        model.resetJuego();
                    }
                    else //Hemos perdido
                    {
                        fin.mostrarImagen("derrota");
                        fin.setSize(800, 550);
                        fin.setVisible(true);
                        
                        model.setRanking();
                        
                        pistas = false;
                        
                        jugador2.actualizaPistas(pistas);
                        jugador1.actualizaEstado();
                        jugador2.actualizaEstado();
                        jugador2.setVisible(false);
                        model.resetJuego();
                    }
                        
                    jugador2.actualizaTitulo();
                    break;
                case "Registrar":
                    System.out.println("Registrar usuario");
                    
                    model.setUsuario(jugador2.getUsuario());
                    break;
                case "points":
                    System.out.println("Ranking");
                    
                    rank.setVisible(true);
                    rank.setSize(800, 550);
                    rank.actualizaRanking();
                    break;
                case "help":
                    System.out.println("About");
                    
                    about.setVisible(true);
                    about.setSize(800, 550);
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
