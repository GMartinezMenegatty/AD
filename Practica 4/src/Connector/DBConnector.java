package Connector;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class DBConnector {
    public static Connection conexion() throws SQLException {
        String url = "jdbc:postgresql://10.0.9.29:5432/probas";
        String usuario = "postgres";
        String contrasinal = "admin";
        Connection conn;
        conn = DriverManager.getConnection(url,usuario, contrasinal);

        return conn;
    }

}
