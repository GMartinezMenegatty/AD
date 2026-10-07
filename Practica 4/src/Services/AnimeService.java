package Services;
import Connector.DBConnector;
import model.Anime;

import java.sql.*;

public class AnimeService {

    // INSERTAR
    public void insertar(Anime anime) {

        String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, anime.getNome());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getData());
            ps.setInt(4, anime.getPuntuacion());

            ps.executeUpdate();

            System.out.println("Anime insertado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al insertar: " + e.getMessage());
        }
    }


    // LEER TODOS
    public void listarTodos() {

        String sql = "SELECT * FROM anime";

        try (Connection conn = DBConnector.DBConnector();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Anime anime = new Anime(
                        rs.getString("nome"), rs.getString("descripcion"),
                        rs.getDate("data"), rs.getInt("puntuacion")
                );

                System.out.println(anime);
            }

        } catch (Exception e) {

            System.out.println("Error al leer: " + e.getMessage());
        }
    }


    // BUSCAR POR NOMBRE
    public void buscarPorNome(String nome) {

        String sql = "SELECT * FROM anime WHERE nome = ?";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Anime anime = new Anime(rs.getString("nome"), rs.getString("descripcion"),
                        rs.getDate("data"),rs.getInt("puntuacion"));

                System.out.println(anime);
            }

        } catch (Exception e) {

            System.out.println("Error al buscar: " + e.getMessage());
        }
    }


    // ACTUALIZAR
    public void actualizar(String nomeAnterior, Anime animeNuevo) {

        String sql = "UPDATE anime SET nome = ?, descripcion = ?, " + "data = ?, puntuacion = ? WHERE nome = ?";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animeNuevo.getNome());
            ps.setString(2, animeNuevo.getDescripcion());
            ps.setDate(3, animeNuevo.getData());
            ps.setInt(4, animeNuevo.getPuntuacion());
            ps.setString(5, nomeAnterior);

            ps.executeUpdate();

            System.out.println("Anime actualizado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }


    // ELIMINAR
    public void eliminar(String nome) {

        String sql = "DELETE FROM anime WHERE nome = ?";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);

            ps.executeUpdate();

            System.out.println("Anime eliminado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
