/**
 *
 *  Clase auxilar para la gestión de sonidos dentro
 *  del programa.
 *
 *  @author CodeBros
 */

package com.codebros.utilidades;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class Sonido {

    private Clip audioClip;
    private AudioInputStream audioStream;

     //constructor de clase
    public Sonido(TipoSonido sonido) {
        //recibe el sonido a reproducir
        File audioFile = new File(sonido.getRuta());
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //metodo para iniciar musica
    public void play(int tiempoEspera) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(tiempoEspera);
            } catch (InterruptedException ignored) {
            }
            audioClip.setFramePosition(0);
            audioClip.start();
        }).start();
    }

    //metodo  con hilo que hace infinita la musica
    public void loop() {
        new Thread(() -> {
            audioClip.setFramePosition(0);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }).start();
    }

    //metodo encargado de mutear o desmutear
    public void muteUnmute() {
        if (audioClip.isRunning()) {
            audioClip.stop();
        } else {
            audioClip.start();
        }
    }

    public boolean isMuted(){
        return !audioClip.isRunning();
    }

    public void stop() {
        audioClip.stop();
    }
}
