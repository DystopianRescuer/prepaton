/**
 *
 *  Clase enumeradora encargada de clasificar las
 *  preguntas y facilitar su manejo
 *
 *  @author CodeBros
 */
package com.codebros.utilidades;


public enum TipoPregunta {
    MORFO("preguntas_morfo"),
    QUIMICA("preguntas_quimica"),
    BIOLOGIA("preguntas_biologia"),
    DERECHO("preguntas_derecho"),
    LITERATURA("preguntas_literatura"),
    FISICA("preguntas_fisica");

    private String tabla;

    TipoPregunta(String bd){
        this.tabla = bd;
    }

    @Override
    public String toString() {
        return tabla;
    }
}
