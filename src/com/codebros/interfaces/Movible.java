/**
 *
 *  Esta interface permite modelar el comportamiento de movimiento
 *  en todas las "piezas" del juego.
 *
 *  @author CodeBros
 */

package com.codebros.interfaces;


public interface Movible extends Runnable {

    void mover(int x, int y, int velocidad);

}
