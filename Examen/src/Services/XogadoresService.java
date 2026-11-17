package Services;

import Connector.DBConnector;
import models.Xogadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XogadoresService {

    public static void createXogadores (Xogadores x){
        String sql = "INSERT INTO xogadores (nome, posicion, idade) VALUES (?, ?, ?)";

        try (Connection conn = DBConnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, x.getNome());
            ps.setString(2, x.getPosicion());
            ps.setInt(3, x.getIdade());

            ps.executeUpdate();

            System.out.println("Se han añadido correctamente los xogadores");
        } catch (Exception e) {
            System.out.println("Error al insertar Xogadores");
        }

    }
    public static List<Xogadores> obterXogadores () {
        String sql = "SELECT * FROM xogadores";
        List<Xogadores> xogadores = new ArrayList<>();

        try (Connection conn = DBConnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                xogadores.add(new Xogadores(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("posicion"),
                        rs.getInt("idade")
                        ));
            }

            rs.close();

            System.out.println("Se han leido correctamente los Xogadores");
        } catch (Exception e) {
            System.out.println("Error al leer los Xogadores");
        }
        return xogadores;
    }

    public static List<Xogadores> obterXogadoresPorNome (String ruta) {
        String sql = "SELECT * FROM xogadores WHERE nome = ?";
        List<Xogadores> lista = new ArrayList<>();

        File file = new File(ruta);

        if (file.exists()) {

            try (Connection conn = DBConnector.conexion();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                BufferedReader br =( FileReader());
                String line;
                while ((br)) {
                        br.read(line);
                }

            } catch (Exception e) {
                System.out.println("Erro lendo algo " + e.getMessage());
            }
        }
            return lista;
        }

    public static void deleteTabla () {
        String sql = "DELETE * FROM xogadores";

        try (Connection conn = DBConnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.executeUpdate();

            System.out.println("Eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al eliminar");
        }
    }

}
