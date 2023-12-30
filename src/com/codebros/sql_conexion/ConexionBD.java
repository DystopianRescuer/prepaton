/**
 *
 *  Esta clase se encarga de realizar la conexión a la base de datos,
 *  usa patrón singleton para evitar multiples instancias.
 *
 *  @author CodeBros
 */
package com.codebros.sql_conexion;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;


public class ConexionBD {

    // Datos de acceso por defecto
    private static String URL = "jdbc:mysql://sql5.freemysqlhosting.net/sql5471995";
    private static String USER = "sql5471995";
    private static String PASSWORD = "nqMb1L8Hu3";
    private static Connection conexion;
    private static ConexionBD instancia;

    private ConexionBD() {

        Properties config = new Properties();
        InputStream archivo;

        // Carga el archivo de propiedades para verificar si el usuario desea conectarse a la DB de forma local
        try {
            archivo = new FileInputStream("resources\\sql\\bd.config");
            config.load(archivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, """
                    No se ha encontrado el archivo de configuración de la base de datos el programa cargará con la
                    base de datos online, sin embargo, probablemente hiciste una instalación incorrecta, te recomendamos
                    cerrar el programa y leer el manual de usuario antes de volverlo a intentar.""");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Boolean.parseBoolean(config.getProperty("bd-offline"))){
            URL = "jdbc:mysql://" + config.getProperty("servidor-db");
            USER = Objects.equals(config.getProperty("usuario-db"), "null") ? "" : config.getProperty("usuario-db");
            PASSWORD = Objects.equals(config.getProperty("clave-db"), "null") ? "" : config.getProperty("clave-db");
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection conectar() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conexion;
    }

    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (Exception e) {
            conexion.close();
        }
    }
}
