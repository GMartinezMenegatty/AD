
import config.HibernateConfig;
import model.*;
import services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main1 {

    static PokedexService pokedexService = new PokedexService();
    static AdestradorService adestradorService = new AdestradorService();
    static PokemonService pokemonService = new PokemonService();

    public static void main(String[] args) {

        try {
            parte1(false);
            parte1(true);

            parte2(false);
            parte2(true);

            parte3(false);
            parte3(true);

        } finally {
            HibernateConfig.cerrar();
        }
    }

    // INSERTAR 10 ENTRADAS POKEDEX
    public static List<Pokedex> insertarPokedex(boolean query) {

        String[] nomes = {
                "Pikachu", "Charmander", "Bulbasaur",
                "Squirtle", "Eevee", "Snorlax",
                "Psyduck", "Meowth", "Vulpix",
                "Jigglypuff"
        };

        for (int i = 0; i < 10; i++) {

            Pokedex p = new Pokedex(
                    nomes[i],
                    (double) (i + 5),
                    "Tipo " + i
            );

            if (query) {
                pokedexService.crearPokedexQuery(p);
            } else {
                pokedexService.crearPokedex(p);
            }
        }

        return pokedexService.listarPokedex();
    }

    // INSERTAR DOS ENTRENADORES
    public static List<Adestrador> insertarAdestradores(
            boolean query) {

        Adestrador ash = new Adestrador(
                "Ash", LocalDate.of(2000, 1, 1));

        Adestrador misty = new Adestrador(
                "Misty", LocalDate.of(2001, 2, 2));

        if (query) {
            adestradorService.crearAdestradorQuery(ash);
            adestradorService.crearAdestradorQuery(misty);
        } else {
            adestradorService.crearAdestrador(ash);
            adestradorService.crearAdestrador(misty);
        }

        return adestradorService.listarAdestradores();
    }

    // INSERTAR 12 POKEMON
    public static List<Pokemon> insertarPokemons(
            boolean query,
            List<Pokedex> pokedex,
            List<Adestrador> adestradores) {

        for (int i = 0; i < 12; i++) {

            Pokemon p = new Pokemon(
                    "Pokemon " + (i + 1),
                    LocalDate.of(2020, 1, 1),
                    pokedex.get(i % 10),
                    adestradores.get(i / 6)
            );

            if (query) {
                pokemonService.crearPokemonQuery(p);
            } else {
                pokemonService.crearPokemon(p);
            }
        }

        return pokemonService.listarPokemons();
    }

    public static void listarPokedex() {

        for (Pokedex p : pokedexService.listarPokedex()) {
            System.out.println(p);
        }
    }

    public static void listarAdestradores() {

        for (Adestrador a :
                adestradorService.listarAdestradores()) {
            System.out.println(a);
        }
    }

    public static void listarPokemons() {

        for (Pokemon p : pokemonService.listarPokemons()) {
            System.out.println(p);
        }
    }

    // MODIFICAR DOS POKEDEX
    public static void modificarPokedex(
            boolean query, List<Pokedex> lista) {

        for (int i = 0; i < 2; i++) {

            Pokedex p = lista.get(i);
            p.setNome(p.getNome() + " Modificado");

            if (query) {
                pokedexService.modificarPokedexQuery(p);
            } else {
                pokedexService.modificarPokedex(p);
            }
        }
    }

    // MODIFICAR DOS ENTRENADORES
    public static void modificarAdestradores(
            boolean query, List<Adestrador> lista) {

        for (Adestrador a : lista) {

            a.setNome(a.getNome() + " Modificado");

            if (query) {
                adestradorService.modificarAdestradorQuery(a);
            } else {
                adestradorService.modificarAdestrador(a);
            }
        }
    }

    // MODIFICAR CUATRO POKEMON
    public static void modificarPokemons(
            boolean query, List<Pokemon> lista) {

        for (int i = 0; i < 4; i++) {

            Pokemon p = lista.get(i);
            p.setNome(p.getNome() + " Evolucionado");

            if (query) {
                pokemonService.modificarPokemonQuery(p);
            } else {
                pokemonService.modificarPokemon(p);
            }
        }
    }

    // ELIMINAR EN ORDEN CORRECTO
    public static void limpiar(boolean query) {

        if (query) {
            pokemonService.eliminarTodosPokemonsQuery();
            adestradorService.eliminarTodosAdestradoresQuery();
            pokedexService.eliminarTodosPokedexQuery();

        } else {
            pokemonService.eliminarTodosPokemons();
            adestradorService.eliminarTodosAdestradores();
            pokedexService.eliminarTodosPokedex();
        }
    }

    // PARTE 1
    public static void parte1(boolean query) {

        System.out.println("\n=== PARTE 1 ===");
        System.out.println(query ? "CON QUERIES" : "CON OBJETOS");

        limpiar(query);

        List<Pokedex> lista = insertarPokedex(query);

        System.out.println("LISTANDO POKEDEX");
        listarPokedex();

        System.out.println("MODIFICANDO 2 ENTRADAS");
        modificarPokedex(query, lista);

        System.out.println("LISTANDO MODIFICACIONES");
        listarPokedex();

        System.out.println("ELIMINANDO DATOS");
        limpiar(query);
    }

    // PARTE 2
    public static void parte2(boolean query) {

        System.out.println("\n=== PARTE 2 ===");
        System.out.println(query ? "CON QUERIES" : "CON OBJETOS");

        limpiar(query);

        List<Pokedex> pokedex = insertarPokedex(query);
        List<Adestrador> entrenadores =
                insertarAdestradores(query);

        System.out.println("LISTANDO POKEDEX");
        listarPokedex();

        System.out.println("LISTANDO ENTRENADORES");
        listarAdestradores();

        modificarAdestradores(query, entrenadores);
        modificarPokedex(query, pokedex);

        System.out.println("LISTANDO MODIFICACIONES");
        listarPokedex();
        listarAdestradores();

        String modo = query ? "queries" : "objetos";

        FileService.toXMLPokedex(
                pokedexService.listarPokedex(),
                "parte2_pokedex_" + modo + ".xml"
        );

        FileService.toXML(
                adestradorService.listarAdestradores(),
                "parte2_adestradores_" + modo + ".xml"
        );

        limpiar(query);
    }

    // PARTE 3
    public static void parte3(boolean query) {

        System.out.println("\n=== PARTE 3 ===");
        System.out.println(query ? "CON QUERIES" : "CON OBJETOS");

        limpiar(query);

        List<Pokedex> pokedex = insertarPokedex(query);
        List<Adestrador> adestradores =
                insertarAdestradores(query);

        List<Pokemon> pokemons = insertarPokemons(
                query, pokedex, adestradores
        );

        System.out.println("DATOS INICIALES");
        listarPokedex();
        listarAdestradores();
        listarPokemons();

        String modo = query ? "queries" : "objetos";

        String archivoDat = "pokedex_" + modo + ".dat";
        String archivoXml = "adestradores_" + modo + ".xml";

        // GUARDAR LOS DATOS ANTES DE MODIFICAR
        FileService.serializar(
                new ArrayList<>(pokedex.subList(0, 2)),
                archivoDat
        );

        FileService.toXML(
                adestradores,
                archivoXml
        );

        modificarPokedex(query, pokedex);
        modificarAdestradores(query, adestradores);
        modificarPokemons(query, pokemons);

        System.out.println("DATOS MODIFICADOS");
        listarPokedex();
        listarAdestradores();
        listarPokemons();

        // RECUPERAR POKEDEX SERIALIZADA
        List<Pokedex> originales =
                FileService.deserializar(archivoDat);

        for (Pokedex original : originales) {

            Pokedex actual =
                    pokedexService.lerPokedex(original.getId());

            if (actual != null) {

                actual.setNome(original.getNome());
                actual.setPeso(original.getPeso());
                actual.setMisc(original.getMisc());

                if (query) {
                    pokedexService.modificarPokedexQuery(actual);
                } else {
                    pokedexService.modificarPokedex(actual);
                }
            }
        }

        // RECUPERAR ENTRENADORES DESDE XML
        List<Adestrador> originalesXML =
                FileService.fromXML(archivoXml);

        for (Adestrador original : originalesXML) {

            Adestrador actual =
                    adestradorService.lerAdestrador(original.getId());

            if (actual != null) {

                actual.setNome(original.getNome());
                actual.setNacemento(original.getNacemento());

                if (query) {
                    adestradorService.modificarAdestradorQuery(actual);
                } else {
                    adestradorService.modificarAdestrador(actual);
                }
            }
        }

        System.out.println("DATOS RESTAURADOS");
        listarPokedex();
        listarAdestradores();
        listarPokemons();

        limpiar(query);
    }
}
