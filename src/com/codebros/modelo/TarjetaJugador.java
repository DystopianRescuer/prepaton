/**
 *
 *  Esta clase construye un Label usado en la pantalla de selección de jugadores
 *  para funcionar como una representación gráfica de un jugador, así como
 *  para que el usuario cambie el nombre de este.
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import com.codebros.interfaces.Movible;
import com.codebros.jugadores.Ignorancia;
import com.codebros.jugadores.Jugador;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class TarjetaJugador extends JLabel implements Movible {

    //elementos de clase
    private static int ultimoID;
    private final int id;
    private final Font LETRA = new Font("Tahoma", Font.BOLD, 17);
    private final String tipo;
    private JTextField nombre;
    private JButton editar;
    private int actX, actY, velX, velY, destX, destY, movimientos, velocidad;

    public TarjetaJugador() {
        this.id = ++ultimoID;
        if (ultimoID > 1) {
            super.setIcon(new ImageIcon("resources\\img\\tarjetas\\Tarjeta" + (id-1) + ".png"));
            this.tipo = Jugador.TIPO;
            nombre = new JTextField("Jugador" + (id - 1));
            nombre.setFont(LETRA);
            nombre.setHorizontalAlignment(JTextField.CENTER);
            nombre.setOpaque(false);
            nombre.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    if(nombre.getText().length()>=10&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                        getToolkit().beep();
                        evt.consume();
                    }
                }
            });
            nombre.setBounds(20, 27, 120, 30);
            nombre.setEditable(false);
            nombre.setHighlighter(null);
            nombre.setBorder(null);
            add(nombre);
            editar = new JButton(new ImageIcon(("resources\\img\\lapiz.png")));
            editar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            editar.setBorder(null);
            editar.setContentAreaFilled(false);
            editar.setBounds(140, 20, 50, 50);
            editar.addActionListener(ev -> {
                nombre.setEditable(true);
                nombre.setText(null);
                nombre.setHighlighter(new DefaultHighlighter());
                nombre.setBorder(new BasicBorders.MenuBarBorder(Color.BLACK, Color.white));
                editar.setVisible(false);
            });
            add(editar);
        } else {
            super.setIcon(new ImageIcon("resources\\img\\tarjetas\\Tarjeta0.png"));
            this.tipo = Ignorancia.TIPO;
        }
    }

    public static void reiniciar() {
        ultimoID = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return (!nombre.getText().isBlank() ? nombre.getText() : ("Jugador" + (id - 1)));
    }

    public int getId() {
        return id;
    }


    public void mover(int x, int y, int velocidad) {
        if (movimientos++ == 0) {
            new Thread(this).start();
        }

        //Nos permite el obtener la ubicación de cada uno de los objetos a los cuales se les dará movimiento posteriormente, además de asignarles una cierta velocidad.
        actX = getX();
        actY = getY();
        destX = x;
        destY = y;
        velX = (actX == x ? 0 : (destX > getX() ? 1 : -1));
        velY = (actY == y ? 0 : (destY > getY() ? 1 : -1));
        this.velocidad = velocidad;

    }


    public void run() {
        //Nos permite el generar movimiento de todos las tarjetas de cada jugador.

        while (true) {
            //calculos para movimiento
            actX += velX;
            actY += velY;


            setLocation(actX, actY);

            //condionales de movimiento
            if (actY == destY) {
                velY = 0;
            }

            if (actX == destX) {
                velX = 0;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(velocidad);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

