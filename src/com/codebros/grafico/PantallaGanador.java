/**
 *
 *  Esta clase construye un frame que muestra
 *  a el(los) ganador(es) del juego
 *
 *  @author CodeBros
 */

package com.codebros.grafico;

import com.codebros.jugadores.Ficha;
import com.codebros.jugadores.Ignorancia;
import com.codebros.utilidades.Fondo;
import com.codebros.utilidades.JFramePersonalizado;
import com.codebros.utilidades.Sonido;
import com.codebros.utilidades.TipoSonido;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PantallaGanador extends JFramePersonalizado {

    public PantallaGanador(List<Ficha> ganadores) {
        super(new Fondo("resources\\img\\fondos\\FondoFinal.png"));
        //Sonido
        Sonido sonido = new Sonido(!ganadores.get(0).getNombre().equals(Ignorancia.TIPO) ? TipoSonido.VICTORIA : TipoSonido.PERDERDOR);
        sonido.play(0);

        JLabel mensaje = new JLabel(new ImageIcon(!ganadores.get(0).getNombre()
                .equals(Ignorancia.TIPO) ? "resources\\img\\JugadorGanaLabel.gif" : "resources\\img\\IgnoranciaGanaLabel.gif"));
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setVerticalAlignment(SwingConstants.TOP);
        mensaje.setSize(getWidth(), 200);
        add(mensaje);

        JLabel auxFicha, auxCorona;

        //Pone cada ficha ganadora en su lugar, así como su corona
        for (int i = 0; i < ganadores.size(); i++) {
            Ficha jugador = ganadores.get(i);
            auxFicha = new JLabel(jugador.getFicha());
            auxFicha.setBounds((getWidth() + 70) / (ganadores.size() + 1) * (i + 1) - 240, 215, auxFicha.getIcon().getIconWidth(), auxFicha.getIcon().getIconHeight());

            auxCorona = new JLabel(new ImageIcon(new ImageIcon("resources\\img\\coronitas\\Corona" + (i + 1) + ".png")
                    .getImage().getScaledInstance(200, 140, Image.SCALE_AREA_AVERAGING)));
            auxCorona.setBounds((getWidth() + 70) / (ganadores.size() + 1) * (i + 1) - 140, 210, 200, 140);

            add(auxFicha);
            add(auxCorona, 0);
        }

        repaint();
    }
}
