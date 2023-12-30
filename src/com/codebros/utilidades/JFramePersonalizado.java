/**
 *
 *  Clase hija de JFrame con las modificaciones necesarias para
 *  el desarrollo del juego
 *
 *  @author CodeBros
 */

package com.codebros.utilidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class JFramePersonalizado extends JFrame {

    private final ImageIcon muteIcon, unmuteIcon;
    private int auxPaint = 0;
    private Point initialClick;
    private Sonido sonidoFondo;
    private JButton cerrar, mute, info;

    public JFramePersonalizado(Fondo fondo) {
        setContentPane(fondo != null ? fondo : new JPanel());

        try {
            getContentPane().setBackground(new Color(144, 245, 220));
            setIconImage(ImageIO.read(new File("resources\\img\\icono.png")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Caracteristicas por defecto de FramePersonalizado
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

        muteIcon = new ImageIcon("resources\\img\\botones\\mute.png");
        unmuteIcon = new ImageIcon("resources\\img\\botones\\unmute.png");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int estaX = getLocation().x;
                int estaY = getLocation().y;

                int xMovida = e.getX() - initialClick.x;
                int yMovida = e.getY() - initialClick.y;

                int X = estaX + xMovida;
                int Y = estaY + yMovida;
                setLocation(X, Y);
            }
        });

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }).start();
    }


    private void inicializarBotones() {
        //boton de cierre
        cerrar = new JButton(new ImageIcon("resources\\img\\botones\\botonsalir.png"));
        cerrar.setBounds(1150, 10, 40, 40);
        cerrar.setBorder(null);
        cerrar.setContentAreaFilled(false);
        cerrar.setFocusable(false);
        cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cerrar.addActionListener(e -> System.exit(0));

        //boton información
        info = new JButton(new ImageIcon("resources\\img\\botones\\info.png"));
        info.setBounds(1060, 10, 40, 40);
        info.setBorder(null);
        info.setContentAreaFilled(false);
        info.setFocusable(false);
        info.setCursor(new Cursor(Cursor.HAND_CURSOR));
        info.addActionListener(e -> VentanaInformacion.mostrar());
    }

    //Getter del sonido
    public Sonido getSonidoFondo() {
        return sonidoFondo;
    }

    // Setter del sonido de fondo
    protected void setSonidoFondo(TipoSonido sonido) {
        this.sonidoFondo = new Sonido(sonido);
        this.sonidoFondo.loop();

        mute = new JButton();
        mute.setBounds(1105, 10, 40, 40);
        mute.setContentAreaFilled(false);
        mute.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mute.setMargin(new Insets(0, 0, 0, 0));
        mute.setFocusPainted(false);
        mute.setBorder(null);
        mute.addActionListener(e -> {
            getSonidoFondo().muteUnmute();
            mute.setIcon(getSonidoFondo().isMuted() ? muteIcon : unmuteIcon);
        });
        mute.setFocusable(false);
        mute.setIcon(unmuteIcon);
    }

    //sobrescritura del metodo paint para pintar los botones
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (auxPaint++ == 0) {
            inicializarBotones();
        }
        getContentPane().add(cerrar, 0);
        getContentPane().add(info, 0);

        if (mute != null) {
            remove(mute);
            getContentPane().add(mute, 0);
        }
    }

    //metodo para parar musica
    @Override
    public void dispose() {
        if (getSonidoFondo() != null) {
            getSonidoFondo().stop();
        }
        super.dispose();
    }
}
