package Services;

import Connector.DBConnector;
import model.InventarioTenda;
import model.Videoxogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {

    public static void crear(InventarioTenda inventarioTenda) {
        String sql = "INSERT INTO InventarioTenda (IdVideoxogo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, inventarioTenda.getIdVideoxogo());
            ps.setDouble(2, inventarioTenda.getPrezoMayorista());
            ps.setDouble(3, inventarioTenda.getPrezoVenta());
            ps.setInt(4, inventarioTenda.getPorcentaxeOferta());

            ps.executeUpdate();
            System.out.println("Videoxogo insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public static List<InventarioTenda> leerInventarioTenda() {
        String sql = "SELECT * FROM InventarioTenda";
        List<InventarioTenda> inventarioTenda = new ArrayList<>();

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement read = conn.prepareStatement(sql);
             ResultSet rs = read.executeQuery();
        ){
            while (rs.next()) {
                inventarioTenda.add(new InventarioTenda(
                        rs.getInt("Id"),
                        rs.getInt("IdVideoxogo"),
                        rs.getDouble("PrezoMayorista"),
                        rs.getDouble("PrezoVenta"),
                        rs.getInt("PorcentaxeOferta")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
        return inventarioTenda;
    }



}
