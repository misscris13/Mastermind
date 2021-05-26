/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.mastermind.view;

import es.uv.eu.mastermind.controller.MastermindController;

/**
 *
 * @author Raúl
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaJugador1 view = new VistaJugador1();
        VistaJugador2 view2 = new VistaJugador2();
        MastermindController controlador = new MastermindController(view, view2);

        view.setSize(800, 550);
        view.setVisible(true);
    }
    
}
