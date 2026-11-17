package Connector;

import java.sql.*;

public class DBConnector {
    public static Connection conexion() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/probas";
            String usuario = "postgres";
            String password = "admin";

            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión realizada correctamente.");

        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection c = conexion();

        if (c != null) {
            System.out.println("Estoy conectado a PostgreSQL.");
        } else {
            System.out.println("No se pudo conectar.");
        }
    }
}
