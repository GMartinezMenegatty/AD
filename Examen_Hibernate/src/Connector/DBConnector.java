
import java.sql.*;

public class DBConnector {

    public static Connection BDConnector() {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/probas";
            String usuario = "postgres";
            String password = "admin";

            conn = DriverManager.getConnection(url, usuario, password);

        } catch (Exception e){
            System.out.println("No se pudo conectar a la base de datos");
        }
        return conn;
    }
}

public static void main(String[] args) {

    Connection c = DBConnector.BDConnector();

    if (c != null) {
        System.out.println("Estoy conectado a PostgreSQL.");
    } else {
        System.out.println("No se pudo conectar.");
    }
}

