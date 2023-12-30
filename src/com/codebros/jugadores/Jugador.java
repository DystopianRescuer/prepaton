/**
 *
 *  Esta clase construye a un jugador ordinario, dótandolo de
 *  ícono, y una variable auxiliar de avance.
 *
 *  @author CodeBros
 */

package com.codebros.jugadores;

import javax.swing.*;


public class Jugador extends Ficha {

    public static final String TIPO = "jugador";

    private boolean avanza;

    public Jugador(int id, String nombre) {
        super(new ImageIcon("resources\\img\\fichas\\ficha" + (id-1) + ".png"));
        super.nombre = nombre;
    }

    // Consulta sobre si se moverá en esta ronda (en inglés para mejor interpretación)
    public boolean willMoveFoward() {
        return avanza;
    }

    // Método usado para determinar si la ficha avanza en la siguiente ronda
    public void avanzaSiguienteRonda(boolean siAvanza) {
        this.avanza = siAvanza;
    }
}
