import Services.*;
import model.*;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        System.out.println("Serializar: ");
        fileService.serializar(Videoxogo.builder()
                .id
                .titulo
                .plataforma
                .anoLanzamento
                .descripcion
                .build());
        System.out.println("-------");

        System.out.println("Deserializar: ");
        fileService.deserializar();
        System.out.println("-------");

        System.out.println("Exportar XML: ");
        fileService.exportarXML();
        System.out.println("-------");

        System.out.println("Crear: ");
        VideoxogoService videoxogoService = new VideoxogoService();
        Videoxogo videoxogo = new Videoxogo(Serial,
                "The Legend of Zelda: Ocarina of Time",
                "Nintendo 64",
                1998, "Descrición: Clásico xogo de aventura e acción 3D en Hyrule.");
        videoxogoService.crear(videoxogo);
        System.out.println("-------");

    }
}
