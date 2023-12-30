/**
 *
 *  Esta clase construye el frame del juego
 *  así como toda la lógica que éste lleva detrás,
 *  recibiendo información de la pantalla de selección
 *
 *  @author CodeBros
 */

package com.codebros.grafico;

import com.codebros.jugadores.Ficha;
import com.codebros.jugadores.Ignorancia;
import com.codebros.jugadores.Jugador;
import com.codebros.modelo.*;
import com.codebros.sql_conexion.ConsultasSQL;
import com.codebros.utilidades.JFramePersonalizado;
import com.codebros.utilidades.Sonido;
import com.codebros.utilidades.TipoPregunta;
import com.codebros.utilidades.TipoSonido;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Juego extends JFramePersonalizado {
    //se crean elementos de clase
    private final List<Ficha> jugadores;
    private final List<Casilla> casillas;
    private List<JLabel> tarjetas;
    private final Map<TipoPregunta, ArrayList<Pregunta>> preguntas;
    private Ignorancia ignorancia;
    private final TablaParticipantes tabla;

    public Juego(Tablero tablero, List<Ficha> jugadoresDentro) {
        super(tablero);
        setTitle("Maratón");
        setSize(1200, 600);
        setLocationRelativeTo(null);

        this.jugadores = jugadoresDentro;
        this.casillas = tablero.getCasillas();

        //JLabel que muestra mensaje durante tiempo de carga
        JLabel cargando = new JLabel("Cargando...");
        cargando.setFont(new Font("Arial", Font.BOLD, 20));
        cargando.setBounds(5,5,130,23);
        add(cargando);

        // Instancia el hashmap que contendrá todas las preguntas del juego a través de un for
        preguntas = new HashMap<>();
        TipoPregunta auxTipoPregunta;
        for (int i = 0; i < TipoPregunta.values().length; i++) {
            try {
                auxTipoPregunta = TipoPregunta.values()[i];
                preguntas.put(auxTipoPregunta, ConsultasSQL.getPreguntas(auxTipoPregunta));
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        inicializarJugadores();
        inicializarTarjetas();
        setSonidoFondo(TipoSonido.FONDO);

        Dado.getInstancia().setJuego(this);

        tabla = new TablaParticipantes(this);

        nuevoTurno();

        remove(cargando);
        repaint();
    }

    private void inicializarJugadores(){

        for (Ficha jugador : this.jugadores) {
            jugador.setBounds(casillas.get(0).getX() + 25,
                    casillas.get(0).getY() + 25, 50, 50);
            add(jugador);
            casillas.get(0).addPrimeraVez(this.jugadores.size(), jugador);
        }

        ignorancia = new Ignorancia();
        ignorancia.setBounds(casillas.get(0).getX() + 25,
                casillas.get(0).getY() + 25, 50, 50);
        add(ignorancia);
        casillas.get(0).addPrimeraVez(jugadores.size(), ignorancia);

    }

    private void inicializarTarjetas(){
        tarjetas = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            tarjetas.add(new JLabel(new ImageIcon("resources\\img\\tarjetas\\TarjetaPregunta" + (i + 1) +".png")));
            tarjetas.get(i).setBounds(470,125, 250, 375);
            tarjetas.get(i).setVisible(false);
            add(tarjetas.get(i), 0);
        }
    }

    public List<JLabel> getTarjetas() {
        return tarjetas;
    }

    public Map<TipoPregunta, ArrayList<Pregunta>> getPreguntas(){
        return preguntas;
    }

    public List<Ficha> getJugadores() {
        return jugadores;
    }

    public Ignorancia getIgnorancia() {
        return ignorancia;
    }

    public void nuevoTurno() {
        Dado.getInstancia().lockUnlock();
    }

    public void aplicarMovimientosPendientes(){
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

                // Recorre las fichas y avanza las que tienen movimientos pendientes
                boolean ningunoCorrecto = true;
                Jugador aux;
                for(Ficha jugador : getJugadores()){
                    new Sonido(TipoSonido.MOVIMIENTOS).play(0);
                    aux = (Jugador)jugador;
                    if(aux.willMoveFoward()) {
                        aux.setCasilla(casillas.get(aux.getCasilla().getID() + 1));
                        aux.avanzaSiguienteRonda(false);
                        ningunoCorrecto = false;
                    }
                }
                nuevoTurno();

                // Si nadie respondió correctamente, avanza la ignorancia
                if(ningunoCorrecto) {
                    new Sonido(TipoSonido.MOVIMIENTOS).play(0);
                    ignorancia.setCasilla(casillas.get(ignorancia.getCasilla().getID() + 1));
                }

                tabla.actualizarKilometros();

                // Checa si existe alguna ficha dentro de la última casilla
                if(casillas.get(casillas.size() - 1).getJugadores().iterator().hasNext()){
                    new Thread(() -> {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Declara ganador y crea una "PantallaGanador"
                        new PantallaGanador(casillas.get(casillas.size() - 1).getJugadores());
                        dispose();
                    }).start();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}