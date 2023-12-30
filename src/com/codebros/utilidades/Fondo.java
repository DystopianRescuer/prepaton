/**
 *
 *  Clase auxiliar encargada de crear un Container con una
 *  imagen para que los frames la usen como fondo
 *
 *  @author CodeBros
 */

package com.codebros.utilidades;

import javax.swing.*;
import java.awt.*;


public class Fondo extends JPanel {

    private final Image fondo;

    //Constructor de clase
    public Fondo(String fondo) {
        setLayout(null);
        this.fondo = new ImageIcon(fondo).getImage();
    }

    //Pinta la imagen a lo largo de todo el panel
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
