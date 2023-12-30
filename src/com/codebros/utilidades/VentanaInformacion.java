/**
 *
 *  Esta clase construye un frame que muestra
 *  algo de información acerca del programa.
 *
 *  @author CodeBros
 */
package com.codebros.utilidades;

import javax.swing.*;
import java.awt.*;


public class VentanaInformacion extends JFramePersonalizado implements Runnable {

    private static VentanaInformacion instancia;
    private JLabel planeta1;

    //constructor de clase
    private VentanaInformacion() {
        super(null);
        setSize(600, 400);
        setTitle("Información");
        crearGUI();
        new Thread(this).start();
    }

    public static void mostrar() {
        if (instancia != null) {
            instancia.setVisible(true);
        } else {
            instancia = new VentanaInformacion();
        }
    }

    //metodo para instancia elementos
    private void crearGUI() {

        //Boton salir
        Icon sal = new ImageIcon("resources\\img\\Salir.png");
        JButton salir = new JButton(sal);
        salir.addActionListener(e -> setVisible(false));
        salir.setContentAreaFilled(false);
        salir.setBorder(null);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setBounds(245, 300, 100, 50);
        add(salir);

        //Jlabel de información
        JLabel texto = new JLabel(new ImageIcon("resources\\img\\Texto1.png"));
        texto.setBounds(0, 0, 600, 400);
        add(texto);

        //Planeta de fondo
        Icon bar = new ImageIcon("resources\\img\\Planeta1.png");
        planeta1 = new JLabel(bar);
        add(planeta1);

        // Fondo
        JLabel fondo = new JLabel(new ImageIcon("resources\\img\\fondoe.png"));
        fondo.setBounds(0, 0, 600, 400);
        add(fondo);

        repaint();
    }

    @Override
    public void run() {
        //variables para el movimiento
        int movX = 200, difX = 1, movX2 = 720, difX2 = 1, movY = 200;

        while (true) {
            //calculos para movimientos
            movX = movX + difX;
            movX2 = movX2 + difX2;
            movY = movY - 1;

            //condicionales de movimiento
            if (movY < -400) {
                movY = 410;
            }

            if (movX < -400) {
                difX = -difX;
                Icon fon = new ImageIcon("resources\\img\\Planeta2.PNG");
                planeta1.setIcon(fon);
            }

            if (movX == 600) {
                difX = -difX;
                Icon fon = new ImageIcon("resources\\img\\Planeta3.PNG");
                planeta1.setIcon(fon);
            }

            planeta1.setBounds(movX, movY, 400, 400);

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
