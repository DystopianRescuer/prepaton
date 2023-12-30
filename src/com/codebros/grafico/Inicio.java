/**
 * Esta clase construye un frame que muestra
 * la bienvenida al programa.
 *
 * @author CodeBros
 */

package com.codebros.grafico;

import com.codebros.utilidades.JFramePersonalizado;
import com.codebros.utilidades.TipoSonido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Inicio extends JFramePersonalizado implements Runnable {

    //Elementos de la clase
    private final JLabel nube2, fondo1, pez1, pez2, pez3, pez4, titulo, luna, juegoTipo, faro, barco, cangrejo, cangrejo2, logo, aviso, burbuja;
    private final String version = "1.2";

    //constructor de clase
    public Inicio() {
        super(null);

        //se establece el tipo de sonido
        setSonidoFondo(TipoSonido.INICIO);

        //se declara la Jlabel que funcionara para ser Aviso
        aviso = new JLabel(new ImageIcon("resources\\img\\Aviso.png"));
        aviso.setVisible(false);
        aviso.setBounds(500, 470, 300, 100);
        add(aviso);

        //se declara la Jlabel que funcionara para ser faro
        faro = new JLabel(new ImageIcon("resources\\img\\faro.png"));
        faro.setVisible(true);
        add(faro);

        //se declara la Jlabel que funcionara para ser Logo
        logo = new JLabel(new ImageIcon("resources\\img\\LOGO1.png"));
        logo.setVisible(false);
        logo.setBounds(1000, 400, 200, 200);
        add(logo);

        //se declara la Jlabel que funcionara para sera barco
        barco = new JLabel(new ImageIcon("resources\\img\\barco2.png"));
        barco.setVisible(false);
        add(barco);

        //se declara la Jlabel que funcionara para ser cangrejo
        cangrejo = new JLabel(new ImageIcon("resources\\img\\cangrejo.png"));
        cangrejo.setVisible(true);
        add(cangrejo);

        //se declara la Jlabel que funcionara para ser cangrejo2
        cangrejo2 = new JLabel(new ImageIcon("resources\\img\\cangrejo.png"));
        cangrejo2.setVisible(true);
        add(cangrejo2);

        //se declara la Jlabel que funcionara para ser Nube
        nube2 = new JLabel(new ImageIcon("resources\\img\\Nube.png"));
        nube2.setVisible(false);
        add(nube2);

        //se declara la Jlabel que funcionara para ser titulo
        titulo = new JLabel(new ImageIcon("resources\\img\\titulo1.png"));
        titulo.setVisible(true);
        add(titulo);

        //se declara la Jlabel que funcionara para ser luna
        luna = new JLabel(new ImageIcon("resources\\img\\luna.png"));
        luna.setVisible(true);
        add(luna);

        //se declara la Jlabel que funcionara para ser burbuja
        burbuja = new JLabel(new ImageIcon("resources\\img\\burbuja.png"));
        add(burbuja);

        Icon suba = new ImageIcon("resources\\img\\subtitulo3.PNG");
        juegoTipo = new JLabel(suba);
        add(juegoTipo);

        //se crean iconos que seran peces
        Icon pezpeque = new ImageIcon("resources\\img\\pezun.PNG");
        Icon pezpeque2 = new ImageIcon(new ImageIcon("resources\\img\\pezun.PNG").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT));

        //se declaran Jlabel que funcionaran como peces
        pez1 = new JLabel(pezpeque);
        add(pez1);
        pez2 = new JLabel(pezpeque);
        add(pez2);
        pez3 = new JLabel(pezpeque2);
        add(pez3);
        pez4 = new JLabel(pezpeque2);
        add(pez4);

        //se declara la Jlabel ---- eliminar
        JLabel continuar = new JLabel("Presione espacio para continuar");
        continuar.setBounds(500, 400, 500, 100);
        continuar.setVisible(false);
        continuar.setFont(new Font("Arial", Font.PLAIN, 20));
        add(continuar);

        JLabel versionLabel = new JLabel("<html><center><p>Prepatón by CodeBros. Versión " + version + " (Official Release)</center></html>");
        versionLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        versionLabel.setSize(getWidth() - 10, getHeight() - 10);
        versionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(versionLabel);

        //se declara la Jlabel que funcionara para ser fondo
        fondo1 = new JLabel(new ImageIcon("resources\\img\\fondos\\FondoInicio.png"));
        add(fondo1);

        Thread hilo = new Thread(this);
        hilo.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                    dispose();
                    new Seleccion();
                }
            }
        });
        repaint();
    }


    @Override
    public void run() {
        //se declaran variables que servirán para ordenar la animación
        int movX = 900, movY = 0, movDX = -4, movDY = 5, pos = 1, burbuja = 0, burY = 600, burX = 0, burdifY = 1, crabX = 500, difcrab = 1;

        while (true) {
            //se hace una suma para incrementar cx
            crabX += difcrab;

            //servirá para haces un sistema de palanca
            if (crabX < 450) {
                difcrab = 1;
            }

            //servirá para haces un sistema de palanca
            if (crabX > 500) {

                difcrab = -1;
            }

            //sistema para hacer visible la nube
            if (movY == -10) {
                nube2.setVisible(true);
            }

            if (movY == 80) {
                //sistema que ayuda al sistema de nubes
                burX = -200;

            }

            if (movY == 0) {
                //movimientos nubes
                burX = burX + burdifY;
                nube2.setBounds(burX, 50, 200, 100);
                titulo.setVisible(true);
                juegoTipo.setVisible(true);
                barco.setVisible(true);

                if (burX < -200) {
                    //hace visible el barco y ayuda al movmiento
                    burdifY = -burdifY;
                    // se cambia icono de barco para el cambio de dirección
                    barco.setIcon(new ImageIcon("resources\\img\\barco2.png"));
                }

                if (burX > 1400) {
                    //sistema de cambio de dirección
                    burdifY = -burdifY;
                    // se cambia icono de barco para el cambio de dirección
                    barco.setIcon(new ImageIcon("resources\\img\\barco.png"));
                }
            }

            if (pos == 2) {
                //sistema en donde los objetos obtienen movimiento
                fondo1.setBounds(0, movY, 1200, 2100);
                titulo.setBounds(350, movY - 50, 550, 375);
                luna.setBounds(1000, movY + 10, 195, 180);
                faro.setBounds(80, movY + 120, 250, 500);
                barco.setBounds(burX + 200, movY + 400, 200, 100);
                cangrejo.setBounds(crabX, movY + 300, 40, 40);
                cangrejo.setBounds(crabX, movY + 300, 40, 40);
                cangrejo2.setBounds(crabX + 400, movY + 350, 40, 40);
                //creamos movimiento de subtitulo
                juegoTipo.setBounds(30, movY + 192, 1200, 100);
            }

            if (movX < -400) {
                //sistema para el estallido de burbuja
                burbuja = 1;
                this.burbuja.setIcon(new ImageIcon("resources\\img\\bru2.PNG"));
            }

            if (movX < -420) {
                //se ponen en visible logo y aviso
                //burbuja es llevada fuera del escenario para evitar bugs
                this.burbuja.setLocation(1000, 1000);
                logo.setVisible(true);
                aviso.setVisible(true);
            }

            // codigo de burbujas
            if (burbuja == 0) {
                //so
                // sistema para el movimiento de burbuja
                burY = burY - 1;
                //se mueve la burbuja
                this.burbuja.setBounds(400, burY, 100, 100);
                //se mueven los peces mediante variables
                pez1.setBounds(movX, movY + 1400, 200, 100);
                pez2.setBounds(movX + 90, movY + 1500, 200, 100);
                pez3.setBounds(movX + 100, movY + 1200, 200, 100);
                pez4.setBounds(movX + 200, movY + 1300, 200, 100);

            }
            //sistemas de ayuda para los movimientos
            if (pos == 2) {
                if (movY < 0) {
                    if (movY == -1050) {
                        movDY = 1;
                    }

                    if (movY == -950) {
                        movDY = 5;
                    }
                    movX = movX + movDX;
                    movY = movY + movDY;
                }
            }
            // se instauran las posiciones en primer momento
            if (pos == 1) {
                movX = 800;
                movY = -1400;
                pos = 2;
            }

            try {
                //tiempo de respuesta
                Thread.sleep(20);

            } catch (InterruptedException ignored) {
            }
        }
    }
}