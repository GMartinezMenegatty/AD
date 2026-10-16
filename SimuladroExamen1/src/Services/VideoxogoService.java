package Services;

import Connector.DBConnector;
import model.Videoxogo;

import java.sql.*;
import java.util.*;

public class VideoxogoService {

    // Insertar na táboa Videoxogo.
    public static void crear(Videoxogo videoxogo) {
        String sql = "INSERT INTO Videoxogo (Titulo, Plataforma, AnoLanzamento, Descripcion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(1, videoxogo.getTitulo());
             ps.setString(2, videoxogo.getPlataforma());
             ps.setInt(3, videoxogo.getAnoLanzamento());
             ps.setString(4, videoxogo.getDescripcion());

            ps.executeUpdate();
            System.out.println("Videoxogo insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    public static List<Videoxogo> read() {
        String sql = "SELECT * FROM Videoxogo";
        List<Videoxogo> listaVideoxogo = new ArrayList<>();

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement leer = conn.prepareStatement(sql);
             ResultSet rs = leer.executeQuery();
             ){
            while (rs.next()) {
                listaVideoxogo.add(new Videoxogo(
                        rs.getInt("Id"),
                        rs.getString("Titulo"),
                        rs.getString("Plataforma"),
                        rs.getInt("AnoLanzamento"),
                        rs.getString("Descripcion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
        return listaVideoxogo;
    }
}
