/**
 *
 *  Esta clase construye el Container que representa el tablero,
 *  así como la instanciación de las "decoraciones" de este.
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import com.codebros.utilidades.Fondo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Tablero extends Fondo {

    private final boolean es42;
    private List<Casilla> casillas;

    public Tablero(boolean es42) {
        super(es42 ? "resources\\img\\tableros\\tablero42.png" : "resources\\img\\tableros\\tablero21.png");
        this.es42 = es42;

        inicializarCasillas();
        inicializarDecoraciones();
    }

    //Método para inicializar y posicionar casillas
    private void inicializarCasillas() {
        casillas = new ArrayList<>();

        int auxX = 83, auxY = 38;
        if (es42) {
            for(int i = 0; i < 10; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX, auxY, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX += 91;
            }

            auxY = 129;
            for (int i = 0; i < 2; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 91, auxY, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxY += 91;
            }

            for (int i = 0; i < 9; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 182, auxY - 91, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX -= 91;
            }

            for (int i = 0; i < 10; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 91, auxY, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX += 91;
            }

            for (int i = 0; i < 1; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 182, auxY + 91, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxY += 91;
            }

            for (int i = 0; i < 10; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 182, auxY + 91, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX -= 91;
            }

        } else {
            auxX = 328;
            for (int i = 0; i < 6; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX, auxY, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX += 91;
            }

            System.out.println(54);
            auxY = 129;
            for (int i = 0; i < 4; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 98, auxY, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxY += 91;
            }

            for (int i = 0; i < 7; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 192, auxY - 95, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX -= 91;
            }

            for (int i = 0; i < 2; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX - 91, auxY - 191, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxY -= 91;
            }

            for (int i = 0; i < 3; i++) {
                casillas.add(new Casilla());
                casillas.get(casillas.size() - 1).setBounds(auxX, auxY - 97, 91, 91);
                add(casillas.get(casillas.size() - 1));
                auxX += 91;
            }
        }
    }

    private void inicializarDecoraciones() {
        if (es42) {
            //Elementos de tablero 42 Km
            Icon bar = new ImageIcon("resources\\img\\barco2.png");

            JLabel barco1 = new JLabel(bar);
            add(barco1);

            JLabel barco2 = new JLabel(bar);
            add(barco2);

            //  hilo que funcionara para el tablero de 42 casillas
            new Thread(() -> {

                // variables que serviran para el movimiento
                int x = 200, dx = 1, x2 = 720, dx2 = 1, y = 2000;
                while (true) {
                    //calculos para poder mover cada uno de los elementos
                    x = x + dx;
                    x2 = x2 + dx2;
                    y = y - 1;

                    if (y == -200) {
                        y = 2000;
                    }

                    if (x < -300) {
                        dx = -dx;
                        barco1.setIcon(new ImageIcon("resources\\img\\barco2.png"));
                    }

                    if (x == 740) {
                        dx = -dx;
                        barco1.setIcon(new ImageIcon("resources\\img\\barco.png"));
                    }

                    if (x2 < -300) {
                        dx2 = -dx2;
                        Icon fon1 = new ImageIcon("resources\\img\\barco2.PNG");
                        barco2.setIcon(fon1);
                    }

                    if (x2 == 740) {
                        dx2 = -dx2;
                        Icon fon1 = new ImageIcon("resources\\img\\barco.PNG");
                        barco2.setIcon(fon1);
                    }
                    barco1.setBounds(x, 120, 150, 100);
                    barco2.setBounds(x2, 400, 150, 100);

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ignored) {
                    }
                }
            }).start();
        } else {
            // elementos del tablero de 21 Km
            JLabel confeti = new JLabel(new ImageIcon("resources\\img\\confeti.PNG"));
            add(confeti);

            JLabel cangrejo = new JLabel(new ImageIcon("resources\\img\\Kingcangrejo.PNG"));
            add(cangrejo);

            JLabel marea = new JLabel(new ImageIcon("resources\\img\\marea.png"));
            add(marea);

            Icon tortu = new ImageIcon(("resources\\img\\tortuga.gif"));
            JLabel tortuga = new JLabel(tortu);
            add(tortuga);

            Icon cangrejito = new ImageIcon("resources\\img\\cangrejo3.png");
            JLabel cangrejo3 = new JLabel(cangrejito);
            add(cangrejo3);

            // hilo  movimiento
            new Thread(() -> {

                //variables que serviran para los movimientos
                int x = 560, y = 0, dx = 1, dy = 1, perimetrox = 200, yc = 130, yy2 = 400;
                while (true) {

                    x += dx;
                    y += dy;
                    perimetrox -= 3;
                    yc += 3;
                    yy2 -= 1;

                    confeti.setBounds(530, yc, 200, perimetrox);
                    tortuga.setBounds(10, yy2, 50, 50);

                    //condicionales movimiento
                    if (yc == 334) {
                        yc = 130;
                        perimetrox = 200;
                    }

                    if (y < -1) {
                        dy = -dy;
                    }

                    if (y > 60) {
                        dy = -dy;
                    }

                    if (x == 559) {
                        dx = -dx;
                    }

                    if (x == 569) {
                        dx = -dx;
                    }

                    if (yy2 < -100) {
                        yy2 = 800;
                    }
                    //movimiento objetos
                    cangrejo.setBounds(x, 300, 100, 100);
                    cangrejo3.setBounds(x - 400, 100, 50, 50);
                    marea.setBounds(0, y, 1200, 600);

                    try {
                        //velocidad Thread
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public boolean is42() {
        return es42;
    }
}
