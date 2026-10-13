package Services;

import Connector.DBConnector;
import model.InventarioTenda;
import model.Videoxogo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InventarioService {

    public void crear(InventarioTenda inventarioTenda) {
        String sql = "INSERT INTO InventarioTenda (Id, IdVideoxogo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.DBConnector();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(2, inventarioTenda.getIdVideoxogo());
            ps.setDouble(3, inventarioTenda.getPrezoMayorista());
            ps.setDouble(4, inventarioTenda.getPrezoVenta());
            ps.setDouble(5, inventarioTenda.getPorcentaxeOferta());

            ps.executeUpdate();
            System.out.println("Videoxogo insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }


}
