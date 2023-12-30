/**
 *
 *  Esta clase construye a la ficha de la ignorancia,
 *  se encarga de darle nombre e ícono.
 *
 *  @author CodeBros
 */

package com.codebros.jugadores;

import javax.swing.*;

public class Ignorancia extends Ficha {

    public static final String TIPO = "Ignorancia";

    public Ignorancia(){
        //Nos permite darle una imagen a la ignorancia dentro del tablero
        super(new ImageIcon("resources\\img\\fichas\\ficha0.png"));
        nombre = TIPO;
    }


}
