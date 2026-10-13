package Services;
import Connector.DBConnector;
import model.Videoxogo;

import java.sql.*;

public class VideoxogoService {

    // Insertar na táboa Videoxogo.
    public void crear(Videoxogo videoxogo) {
        String sql = "INSERT INTO Videoxogo (Id, Titulo, Plataforma, AnoLanzamento, Descripcion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

             ps.setString(2, videoxogo.getTitulo());
             ps.setString(3, videoxogo.getPlataforma());
             ps.setInt(4, videoxogo.getAnoLanzamento());
             ps.setString(5, videoxogo.getDescripcion());

            ps.executeUpdate();
            System.out.println("Videoxogo insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}
