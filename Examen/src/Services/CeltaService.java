package Services;

import Connector.DBConnector;
import models.Celta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CeltaService {

    public static void createXogadores (Celta x){
        String sql = "INSERT INTO celta (nome, soldo) VALUES (?, ?, ?)";

        try (Connection conn = DBConnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, x.getNome());
            ps.setInt(2, x.getSoldo());

            ps.executeUpdate();

            System.out.println("Se han añadido correctamente los celta");
        } catch (Exception e) {
            System.out.println("Error al insertar celta");
        }

    }
    public static List<Celta> obterCelta () {
        String sql = "SELECT * FROM celta";
        List<Celta> celta = new ArrayList<>();

        try (Connection conn = DBConnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                celta.add(new Celta(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("soldo")
                ));
            }
            rs.close();

            System.out.println("Se han leido correctamente los Celta");
        } catch (Exception e) {
            System.out.println("Error al leer los Celta");
        }
        return celta;
    }

    public static void deleteTabla () {
        String sql = "DELETE * FROM celta";

        try (Connection conn = DBConnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.executeUpdate();

            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar");
        }
    }
}
