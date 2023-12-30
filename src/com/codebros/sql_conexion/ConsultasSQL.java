/**
 *
 *  Clase encargada de realizar la consulta de las preguntas a la base y
 *  encapsularlas en una lista
 *
 *  @author CodeBros
 */
package com.codebros.sql_conexion;

import com.codebros.modelo.Pregunta;
import com.codebros.utilidades.TipoPregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;


public final class ConsultasSQL {


    public synchronized static ArrayList<Pregunta> getPreguntas(TipoPregunta tipo) throws SQLException {

        ArrayList<Pregunta> preguntas = new ArrayList<>();

        Connection connection = ConexionBD.getInstancia().conectar();
        PreparedStatement seleccionar = connection.prepareStatement("SELECT * FROM " + tipo);
        ResultSet consulta = seleccionar.executeQuery();

        while(consulta.next()){
            preguntas.add(new Pregunta(consulta.getString(2),consulta.getString(3),
                    consulta.getString(4),consulta.getString(5),
                    consulta.getString(6)));
        }

        ConexionBD.getInstancia().cerrarConexion();

        // mezcla las preguntas
        Collections.shuffle(preguntas);

        return preguntas;
    }
}
