/**
 *
 *  Esta clase construye la parte lógica de la pregunta.
 *
 *  @author CodeBros
 */
package com.codebros.modelo;

import java.util.ArrayList;
import java.util.List;


public class Pregunta {

    private final String pregunta;
    private final List<Respuesta> respuestas;

    public Pregunta(String pregunta, String... respuestas) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();

        for(String respuesta: respuestas){
            this.respuestas.add(new Respuesta(respuesta, respuesta.contains("*")));
        }
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    // Auxiliar para imprimir pregunta en consola
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder();
        for(Respuesta respuesta: respuestas){
            aux.append(respuesta).append("\n");
        }
        return pregunta + "\n" + aux;
    }
}
