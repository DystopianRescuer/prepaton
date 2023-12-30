/**
 *
 *  Clase enumeradora encargada de clasificar los
 *  sonidos y facilitar su manejo
 *
 *  @author CodeBros
 */
package com.codebros.utilidades;


public enum TipoSonido {
    MOVIMIENTOS("movimiento.wav"),
    INICIO("musica_inicio.wav"),
    FONDO("fondo.wav"),
    DADO("dado.wav"),
    TAMBORES("tambores.wav"),
    POP("pop.wav"),
    ERROR("error.wav"),
    OLAS("olas.wav"),
    CLICK("click.wav"),
    PERDERDOR("perdedor.wav"),
    VICTORIA("victoria.wav");

    private final String ruta;

    TipoSonido(String ruta){
        this.ruta = ruta;
    }

    public String getRuta() {
        return "resources\\audio\\" + ruta;
    }
}
