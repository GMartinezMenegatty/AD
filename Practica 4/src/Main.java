import Services.AnimeService;
import model.Anime;
import java.sql.Date;

/**
 * Clase principal que ejecuta el programa y realiza operaciones CRUD en la base de datos de animes.
 */

public class Main {
    public static void main(String[] args) {

        AnimeService animeService = new AnimeService();

        System.out.println("Crear: ");

        Anime anime = new Anime("Naruto",
                "Un ninja joven con un gran sueño",
                Date.valueOf("2002-10-03"),
                9);

        animeService.crear(anime);
        System.out.println("-------");

        System.out.println("Leer todos: ");
        animeService.leer();
        System.out.println("-------");

        System.out.println("Actualizar: ");

        Anime animeActualizado = new Anime("One Piece",
                "Piratas",
                Date.valueOf("1999-10-20"),
                9);

        animeService.update("Naruto", animeActualizado);
        System.out.println("-------");

        System.out.println("Buscar por nombre: ");

        animeService.buscarPorNombre("One Piece");
        System.out.println("-------");

        System.out.println("Eliminar: ");
        animeService.delete("One Piece");
        System.out.println("-------");
    }
}
