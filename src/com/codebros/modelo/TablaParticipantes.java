/**
 *
 *  Esta clase construye un Label que reunirá a los jugadores
 *  en la partida y actualizará su kilometro en cada ronda
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import com.codebros.grafico.Juego;
import com.codebros.jugadores.Ficha;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TablaParticipantes extends JLabel {

    private final Juego juego;
    private final List<JLabel> kilometros;
    private final Font LETRA42 = new Font("Corbel", Font.BOLD, 13);
    private final Font LETRA21 = LETRA42.deriveFont(17f);
    private final boolean es42;


    public TablaParticipantes(Juego juego) {
        this.juego = juego;
        this.juego.add(this);

        this.es42 = ((Tablero)juego.getContentPane()).is42();
        try {
            super.setIcon(new ImageIcon(ImageIO.read(new File(es42 ? "resources\\img\\participantes42.png" : "resources\\img\\participantes21.png"))));
            setSize(getIcon().getIconWidth(), getIcon().getIconHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(es42){
            setLocation(992,67);
        } else {
            setLocation(890,63);
        }

        this.kilometros = new ArrayList<>();
        inicializarJugadores();
    }

    int auxY, auxX;
    public void inicializarJugadores() {

        auxY = (es42 ? 160 : 110);
        auxX = (es42 ? 160 : 233);
        JLabel auxLabelNombre, auxLabelKm;
        for(Ficha jugador : this.juego.getJugadores()){
            auxLabelNombre = new JLabel(jugador.getNombre());
            auxLabelNombre.setIcon(jugador.getIcon());
            auxLabelNombre.setForeground(Color.WHITE);
            auxLabelNombre.setFont(es42 ? LETRA42 : LETRA21);
            auxLabelNombre.setBounds(20,auxY,280,50);
            add(auxLabelNombre);

            auxLabelKm = new JLabel(String.valueOf(jugador.getCasilla().getID()));
            auxLabelKm.setForeground(Color.WHITE);
            auxLabelKm.setFont(LETRA21);
            auxLabelKm.setBounds(auxX,auxY,280,50);
            add(auxLabelKm);
            kilometros.add(auxLabelKm);

            auxY += (es42 ? 35 : 28);
        }
        inicializarIgnorancia();
    }

    public void inicializarIgnorancia(){
        JLabel auxLabelNombre = new JLabel(juego.getIgnorancia().getNombre());
        auxLabelNombre.setIcon(juego.getIgnorancia().getIcon());
        auxLabelNombre.setForeground(Color.WHITE);
        auxLabelNombre.setFont(es42 ? LETRA42 : LETRA21);
        auxLabelNombre.setBounds(20,auxY,280,50);
        add(auxLabelNombre);

        JLabel auxLabelKm = new JLabel(String.valueOf(juego.getIgnorancia().getCasilla().getID()));
        auxLabelKm.setForeground(Color.WHITE);
        auxLabelKm.setFont(LETRA21);
        auxLabelKm.setBounds(auxX,auxY,280,50);
        add(auxLabelKm);
        kilometros.add(auxLabelKm);
    }

    public void actualizarKilometros() {
        // Recorre todos los labels con los kilómetros y los actualiza
        for(int i = 0; i < kilometros.size() - 1; i++){
            kilometros.get(i).setText(String.valueOf(juego.getJugadores().get(i).getCasilla().getID()));
        }
        kilometros.get(kilometros.size() - 1).setText(String.valueOf(juego.getIgnorancia().getCasilla().getID()));
    }

}
