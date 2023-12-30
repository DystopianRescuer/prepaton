/**
 *
 *  Esta clase construye un componente que representa de forma lógica
 *  la casilla, permite que el programa sepa donde se encuentra cada una y así poder mover
 *  a los jugadores a esta, la casilla también guarda una lista de jugadores dentro de ella.
 *
 *  @author CodeBros
 */

package com.codebros.modelo;

import com.codebros.jugadores.Ficha;

import javax.swing.*;
import java.util.ArrayList;

public class Casilla extends JComponent {

    // matriz con primer indice numero de jugadores y segundo indice numero de jugador y retorna X y Y
    private static final String[][] lugar = { {},
                                            {"40,40"},
                                            {"20,40","60,40"},
                                            {"30,10","30,40","30,70"},
                                            {"20,20", "20,60", "60,20", "60,60"},
                                            {"20,20", "60,20", "40,40", "20,60", "60,60"} };
    private static int cantidadCasillas;
    private final ArrayList<Ficha> jugadores;
    private final int casilla;

    public Casilla() {
        this.casilla = cantidadCasillas++;
        this.jugadores = new ArrayList<>();
        this.setBounds(50, 150, 50, 50);
    }

    public ArrayList<Ficha> getJugadores() {
        return jugadores;
    }

    int auxIngreso = 0;
    public void addPrimeraVez(int ingreso, Ficha jugador){
        jugadores.add(jugador);
        jugador.casilla = this;
        if(auxIngreso++ == ingreso){
            acomodar();
        }
    }

    public void addJugador(Ficha jugador) {
        jugadores.add(jugador);
        acomodar();
    }

    public void removeJugador(Ficha jugador) {
        jugadores.remove(jugador);
        acomodar();
    }

    public int getID() {
        return casilla;
    }


    public void acomodar() {
        int cantidad = jugadores.size();

        String[] aux;
        for(int i = 0; i < cantidad; i++){
            aux = lugar[cantidad][i].split(",");
            jugadores.get(i).mover(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), 15);
        }
    }
}
