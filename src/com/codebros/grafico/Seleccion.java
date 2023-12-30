/**
 *
 *  Esta clase construye un frame que permitirá al usuario
 *  seleccionar la cantidad de jugadores, sus nombres y el tablero.
 *
 *  @author CodeBros
 */

package com.codebros.grafico;

import com.codebros.jugadores.Ficha;
import com.codebros.jugadores.Jugador;
import com.codebros.modelo.Tablero;
import com.codebros.modelo.TarjetaJugador;
import com.codebros.sql_conexion.ConexionBD;
import com.codebros.utilidades.Fondo;
import com.codebros.utilidades.JFramePersonalizado;
import com.codebros.utilidades.Sonido;
import com.codebros.utilidades.TipoSonido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class Seleccion extends JFramePersonalizado implements Runnable {

    private final Color modalidad42 = new Color(27, 59, 222);
    private final Color modalidad21 = new Color(225, 40, 40);
    private final Color colorBoton = new Color(255, 255, 255);
    private final List<TarjetaJugador> tarjetas;
    boolean conectado = false;
    private JButton agregar, jugar, reiniciar;
    private JLabel olas, comprobandoConexion;
    private Timer timerBoton;
    private boolean es42 = true;

    public Seleccion() {
        super(new Fondo("resources\\img\\fondos\\FondoSeleccionar.png"));
        this.tarjetas = new ArrayList<>();
        initComponents();
        setSonidoFondo(TipoSonido.OLAS);

        repaint();
    }

    private void initComponents() {

        agregar = new JButton(new ImageIcon(new ImageIcon("resources\\img\\botones\\BotonAgregar.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        agregar.setBounds(950, 10, 100, 100);
        agregar.setBorder(null);
        agregar.setContentAreaFilled(false);
        agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        agregar.addActionListener(e -> {
            addJugador();
            if (tarjetas.size() == 5) {
                timerBoton.removeActionListener(timerBoton.getActionListeners()[0]);
                agregar.setEnabled(false);
            }
            new Sonido(TipoSonido.POP).play(0);
        });
        add(agregar);

        timerBoton = new Timer(3600, e -> {
            agregar.setEnabled(true);
            reiniciar.setVisible(true);
        });

        reiniciar = new JButton(new ImageIcon("resources\\img\\botones\\BotonReiniciar.png"));
        reiniciar.setBorder(null);
        reiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reiniciar.setBounds(810, 35, 113, 47);
        reiniciar.addActionListener(e -> reiniciar());
        reiniciar.setVisible(false);
        add(reiniciar);

        JLabel seleccionarLabel = new JLabel(new ImageIcon("resources\\img\\SeleccionaPersonajeLabel.png"));
        seleccionarLabel.setBounds(0, 0, 726, 102);
        add(seleccionarLabel);

        JLabel modoJuego = new JLabel("Selecciona un modo de juego: ");
        modoJuego.setFont(new Font("Arial", Font.BOLD, 15));
        modoJuego.setBounds(670, 533, 235, 50);
        add(modoJuego);

        // Interruptor, creado completamente en Graphics2D
        JComponent switch1 = new JComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor((es42) ? modalidad42 : modalidad21);
                g2.fill(new RoundRectangle2D.Double(5, 5,
                        getWidth() - 10, getHeight() - 10, getHeight() - 10, getHeight() - 10));

                g2.setColor(colorBoton);
                g2.setFont(new Font("Tahoma", Font.BOLD, 15));
                g2.setColor(Color.WHITE);
                g2.drawString((es42 ? "42 Km" : "21 Km"), getWidth() / 2 - (es42 ? 7 : 40), getHeight() / 2 + 5);

                if (es42) {
                    g2.fillOval(7, 7, getHeight() - 14, getHeight() - 14);
                } else {
                    g2.fillOval(getWidth() - getHeight() + 7, 7, getHeight() - 14, getHeight() - 14);
                }
            }
        };
        switch1.setLocation(900, 533);
        switch1.setSize(120, 50);
        switch1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        switch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEnabled()) {
                    es42 = !es42;
                    new Sonido(TipoSonido.POP).play(0);
                    repaint();
                }
            }
        });
        add(switch1);

        tarjetas.addAll(Arrays.asList(new TarjetaJugador(), new TarjetaJugador()));
        tarjetas.get(0).setBounds(200, 120, 200, 400);
        tarjetas.get(1).setBounds(500, 120, 200, 400);
        tarjetas.forEach(this::add);

        // Label de información de estado de conexión a la base
        comprobandoConexion = new JLabel();
        comprobandoConexion.setFont(new Font("Arial", Font.BOLD, 19));
        comprobandoConexion.setHorizontalAlignment(SwingConstants.CENTER);
        comprobandoConexion.setForeground(Color.WHITE);
        comprobandoConexion.setBounds(5, 572, 450, 27);
        comprobandoConexion.setVisible(false);
        add(comprobandoConexion);

        jugar = new JButton(new ImageIcon("resources\\img\\botones\\botonjugar.png"));
        jugar.setBounds(1050, 528, 120, 60);
        jugar.setBorder(null);
        jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jugar.setHorizontalAlignment(SwingConstants.LEFT);
        jugar.addActionListener(e -> {
            comprobandoConexion.setText("Comprobando conexión con base de datos...");
            comprobandoConexion.setVisible(true);
            repaint();

            jugar.setEnabled(false);
            crearPartida();
        });
        add(jugar);

        olas = new JLabel(new ImageIcon("resources\\img\\Olas.png"));
        add(olas);
        new Thread(this).start();

        repaint();
    }

    private void addJugador() {
        //Nos permite el adicionar una tarjeta para incorporar a otro participante.
        agregar.setEnabled(false);
        timerBoton.start();
        tarjetas.add(new TarjetaJugador());
        actualizar();
    }

    // Mueve las tarjetas anteriores para acomodar la nueva
    private void actualizar() {
        remove(olas);
        TarjetaJugador nuevo = tarjetas.get(tarjetas.size() - 1);
        TarjetaJugador anterior = tarjetas.get(tarjetas.size() - 2);
        IntStream.range(0, tarjetas.size() - 1).forEach(i -> tarjetas.get(i).mover(tarjetas.get(i).getX() - 50, tarjetas.get(i).getY(), 3));
        nuevo.setBounds(1300, 120, 200, 400);
        add(nuevo);
        nuevo.mover(anterior.getX() + 150, nuevo.getY(), 3);
        add(olas);
    }

    private void reiniciar() {
        //Nos da la oportunidad de reiniciar la ventana
        // en caso de que hubieramos añadido a un jugador extra al juego por error.
        dispose();
        TarjetaJugador.reiniciar();
        new Seleccion();
        System.gc();
    }

    public void crearPartida() {
        new Thread(() -> {

            conectado = false;
            try {
                ConexionBD.getInstancia().conectar();
                conectado = true;
            } catch (SQLException e) {
                conectado = false;
            }

            if (conectado) {

                comprobandoConexion.setForeground(Color.BLUE);
                comprobandoConexion.setText("Conexión exitosa");

                try {
                    Thread.sleep(1500);

                    comprobandoConexion.setForeground(Color.BLACK);
                    comprobandoConexion.setText("Creando partida...");

                    List<Ficha> jugadores = new ArrayList<>();
                    for (TarjetaJugador jugador : tarjetas) {
                        if (jugador.getTipo().equals(Jugador.TIPO)) {
                            jugadores.add(new Jugador(jugador.getId(), jugador.getNombre()));
                        }
                    }

                    new Juego(new Tablero(es42), jugadores);
                    dispose();
                    System.gc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                comprobandoConexion.setForeground(Color.RED);
                comprobandoConexion.setText("Error en conexión. Consulte manual de usuario");
            }

            jugar.setEnabled(true);
        }).start();
    }


    @Override
    public void run() {
        //variables para movimiento
        int y = 200, dy = -5;

        //hilo para el movimiento de olas
        while (true) {

            //calculos de movimentos
            y = y + dy;

            //condicionales de movimento
            if (y == 100) {
                dy = -dy;
            }

            if (y == 500) {
                dy = -dy;
            }

            //Posicionamiento de olas
            olas.setBounds(0, y, 1200, 600);
            try {
                //tiempo de respuesta
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
