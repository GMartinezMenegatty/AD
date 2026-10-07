package Connector;
import java.sql.*;

public class DBConnector {

    public static Connection DBConnector() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://10.0.9.29:5432/probas";
            String usuario = "postgres";
            String password = "admin";
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Error na conexión: "+ e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {

        DBConnector c = new DBConnector();
//
//        if (c.DBConnector() != null) {
//            System.out.println("Conexion correcta");
//        } else {
//            System.out.println("No se pudo conectar");
//        }
    }
}
