/**
 *
 *  Esta clase construye un botón que representa una sola respuesta,
 *  así como dotar a esta respuesta de una parte lógica
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import com.codebros.interfaces.Movible;

import javax.swing.*;
import java.awt.*;


public class Respuesta extends JButton implements Movible {

    private String texto;
    private final boolean esCorrecta;
    private int actX, actY, velX, velY, destX, destY, movimientos, velocidad;

    public Respuesta(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;

        setBounds(50,460,500,70);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setMargin(new Insets(0,0,0,0));
        setFont(new Font("Arial", Font.BOLD, 13));
        setIcon(new ImageIcon("resources\\img\\botones\\Boton_Respuesta.png"));
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(null);

        if (this.esCorrecta) {
            this.texto = this.texto.replace("*", "");
        }

        setText("<html><center>" + this.texto + "</center></html>");
        setToolTipText(this.texto);
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }

    @Override
    public void mover(int x, int y, int velocidad) {
        //variables auxiliares
        actX = getX();
        actY = getY();
        destX = x;
        destY = y;
        velX = (actX == x ? 0 : (destX > getX() ? 1 : -1));
        velY = (actY == y ? 0 : (destY > getY() ? 1 : -1));
        this.velocidad = velocidad;

        if (movimientos++ == 0) {
            new Thread(this).start();
        }
    }


    public void run() {
        while (true) {

            //calculos para movimiento
            actX = actX + velX;
            actY = actY + velY;

            setLocation(actX, actY);

            //condicionales de movimiento
            if (actY == destY) {
                velY = 0;
            }

            if (actX == destX) {
                velX = 0;
            }
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
