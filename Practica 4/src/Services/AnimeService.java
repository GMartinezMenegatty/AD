package Services;
import Connector.DBConnector;
import model.Anime;

import java.sql.*;

/**
 * Programa que realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos PostgreSQL para la entidad Anime.
 * Utiliza la clase DBConnector para establecer la conexión con la base de datos y la clase Anime para representar los objetos de anime.
 */

public class AnimeService {

    /**
     * Método que inserta un nuevo anime en la base de datos.
     * @param anime
     */

    public void crear(Anime anime) {

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


    /**
     * Método que lee todos los animes de la base de datos y los imprime en consola.
     */

    public void leer() {

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

    /**
     * Método que busca un anime por su nombre.
     * @param nome
     */

    public void buscarPorNombre(String nome) {

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

    /**
     * Método que actualiza un anime existente en la base de datos.
     * @param nomeAnterior
     * @param animeNuevo
     */

    public void update(String nomeAnterior, Anime animeNuevo) {

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

    /**
     * Método que elimina un anime por su nombre.
     * @param nome
     */

    public void delete(String nome) {

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
