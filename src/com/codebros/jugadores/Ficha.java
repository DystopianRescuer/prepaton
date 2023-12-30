/**
 *
 *  Esta clase construye al jugador, es usado como clase padre; la instancia
 *  ocurre gracias a sus clases hijas, pero esta clase les aporta la lógica común.
 *
 *  @author CodeBros
 */

package com.codebros.jugadores;

import com.codebros.interfaces.Movible;
import com.codebros.modelo.Casilla;

import javax.swing.*;
import java.awt.*;


public class Ficha extends JLabel implements Movible {

    protected String nombre;
    public Casilla casilla;
    private final ImageIcon ficha;

    private int actX, actY, velX = 0, velY = 0, destX = 0, destY = 0, movimientos, velocidad;

    //Método para determinar características de fichas
    protected Ficha(ImageIcon icon) {
        super.setIcon(new ImageIcon(icon.getImage()
                .getScaledInstance(50,50, Image.SCALE_AREA_AVERAGING)));
        this.ficha = icon;
        setSize(50, 50);
    }

    public Casilla getCasilla() {
        return this.casilla;
    }

    public void setCasilla(Casilla casilla) {
        if (this.casilla != null) {
            this.casilla.removeJugador(this);
        }
        this.casilla = casilla;
        casilla.addJugador(this);
    }

    public String getNombre() {
        return nombre;
    }

    public ImageIcon getFicha() {
        return ficha;
    }

    //implementación de la interfaz Movible
    @Override
    public void mover(int x, int y, int velocidad) {
        if (movimientos++ == 0) {
            new Thread(this).start();
        }
        this.velocidad = velocidad;
        //variables axuliares
        actX = getX();
        actY = getY();
        destX = (casilla.getX() + x) - 20;
        destY = (casilla.getY() + y) - 20;
        velY = Integer.compare(destY, actY);
        velX = Integer.compare(destX, actX);

        //new Sonido(TipoSonido.MOVIMIENTO).play(0);
    }


    //metodo run para implemetación de hilos
    @Override
    public void run() {
       //hilo que realiza los movimientos
        while (true) {

            actX = actX + velX;
            actY = actY + velY;

            setLocation(actX, actY);

            if (actY == destY) {
                velY = 0;
            }

            if (actX == destX) {
                velX = 0;
            }
            try {
                //determina la velocidad del hilo
                Thread.sleep(velocidad);
            } catch (InterruptedException ignored) {
            }
        }

    }
}
