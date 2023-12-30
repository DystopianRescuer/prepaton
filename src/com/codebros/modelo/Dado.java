/**
 *
 *  Esta clase construye un JButton que usamos como dado, usa el patrón singleton por
 *  mero diseño, facilitando la adición y evitando multiples instancias de este.
 *  Es el encargado de lanzar las preguntas
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import com.codebros.grafico.Juego;
import com.codebros.grafico.FramePregunta;
import com.codebros.utilidades.Sonido;
import com.codebros.utilidades.TipoPregunta;
import com.codebros.utilidades.TipoSonido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Dado extends JButton implements ActionListener {

    private static Dado instancia;
    private int cara = 1;
    private boolean bloqueado = true;
    private Juego juegoActual;

    //Constructor de clase
    private Dado() {
        setBounds(1050, 450, 150, 150);
        setContentAreaFilled(false);
        setBorder(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setIcon(new ImageIcon("resources\\img\\dado\\dado.png"));

        JLabel base = new JLabel(new ImageIcon("resources\\img\\dado\\base.png"));
        base.setBounds(getX() - 30, getY() + 50, 200, 100);

        // Agrega la base, para esto, espera a que su componente padre deje de ser nulo
        new Thread(() -> {
            while (getParent() != null) {
                getParent().add(base,1);
            }
        }).start();

        addActionListener(this);
    }

    public static Dado getInstancia() {
        if (instancia == null) {
            instancia = new Dado();
        }
        return instancia;
    }

    public void setJuego(Juego juego) {
        juegoActual = juego;
        juegoActual.add(this,0);
    }

    // Método usado entre turnos
    public void lockUnlock() {
        bloqueado = !bloqueado;
    }

    // Consulta sobre el estado del dado
    public boolean isLocked() {
        return bloqueado;
    }

    private void lanzarPregunta(TipoPregunta tipo) {
        FramePregunta fp = null;
        try {
            // Lanza la pregunta y la elimina de la lista para evitar repetición
            fp = new FramePregunta(juegoActual, juegoActual.getPreguntas().get(tipo).remove(0));
        } catch (Exception e){
            JOptionPane.showMessageDialog(juegoActual, "Se han acabado las preguntas de esta materia, \n" +
                    "tira el dado de nuevo :)");
            juegoActual.nuevoTurno();
            juegoActual.getTarjetas().forEach(tarjeta -> tarjeta.setVisible(false));
        }
    }

    // Evento de click en el dado
    @Override
    public void actionPerformed(ActionEvent event) {
        if (!isLocked()) {
            cara = ThreadLocalRandom.current().nextInt(1, 7);

            // Bloquea el dado para evitar movimiento sobre movimiento
            lockUnlock();


            new Thread(() -> {
                try {

                    // Gif moviendose rápido y su sonido
                    setIcon(new ImageIcon("resources\\img\\dado\\dadogirando.gif"));
                    new Sonido(TipoSonido.DADO).play(0);

                    // Sleep thread 1.3 seg
                    TimeUnit.SECONDS.sleep((long) 1.3);

                    // Cara donde cayó
                    setIcon(new ImageIcon("resources\\img\\dado\\cara" + cara + ".png"));

                    // Sleep thread 2 seg
                    TimeUnit.SECONDS.sleep(1);

                    // Muestra carta de pregunta
                    juegoActual.getTarjetas().get(cara - 1).setVisible(true);

                    // Sleep thread 2 seg
                    TimeUnit.SECONDS.sleep(3);

                    // lanza la pregunta
                    lanzarPregunta(TipoPregunta.values()[cara - 1]);

                    // cerrar el hilo
                    Thread.currentThread().interrupt();
                } catch (InterruptedException e) {

                }
            }).start();
        } else {
            new Sonido(TipoSonido.ERROR).play(0);
        }
    }
}
