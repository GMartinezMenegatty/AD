import model.Autor;
import model.Comic;
import model.Protagonista;

import services.ProtagonistaService;
import services.AutorService;
import services.ComicService;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        AutorService autor = new AutorService();
        ProtagonistaService protagonista = new ProtagonistaService();
        ComicService comics = new ComicService();

        //Actualizar

        System.out.println("-----Actualizar Autores-----");

        Autor novoAutor = new Autor("Stan", "Lee", "Estadounidense");
        autor.actualizarAutor(novoAutor);

        Autor novoAutor2 = new Autor("Alan", "Moore", "Britanica");
        autor.actualizarAutor(novoAutor2);

        Autor novoAutor3 = new Autor("Frank", "Miller", "Estadounidense");
        autor.actualizarAutor(novoAutor3);

        Autor novoAutor4 = new Autor("Herge", "Remi", "Belga");
        autor.actualizarAutor(novoAutor4);

        System.out.println("-----Actualizar Protagonistas-----");

        Protagonista novoProtagonista = new Protagonista("Spider-Man", "superforza e axilidade");
        protagonista.actualizarProtagonista(novoProtagonista);

        Protagonista novoProtagonista2 = new Protagonista("Batman", "diñeiro");
        protagonista.actualizarProtagonista(novoProtagonista2);

        Protagonista novoProtagonista3 = new Protagonista("Superman", "superforza e batSubvencion");
        protagonista.actualizarProtagonista(novoProtagonista3);

        Protagonista novoProtagonista4 = new Protagonista("Wonder Woman", "superforza e batSubvencion");
        protagonista.actualizarProtagonista(novoProtagonista4);

        Protagonista novoProtagonista5 = new Protagonista("Tintín", "intelixencia e capacidade de investigación");
        protagonista.actualizarProtagonista(novoProtagonista5);

        Protagonista novoProtagonista6 = new Protagonista("Daredevil", "case tódo-los sentidos sobrehumanos");
        protagonista.actualizarProtagonista(novoProtagonista6);

        System.out.println("-----Actualizar Comics-----");

        Comic comic = new Comic ("The Amazing Spider-Man", 1963, novoAutor,  novoProtagonista);
        comics.crearComic(comic);

        Comic comic2 = new Comic ("Batman: The Killing Joke", 1988, novoAutor2,  novoProtagonista2);
        comics.crearComic(comic2);

        Comic comic3 = new Comic ("Superman: The Man of Steel", 1986, novoAutor3,  novoProtagonista3);
        comics.crearComic(comic3);

        Comic comic4 = new Comic ("Wonder Woman: Gods and Mortals", 1987, novoAutor2,  novoProtagonista4);
        comics.crearComic(comic4);

        Comic comic5 = new Comic ("The Adventures of Tintin", 1929, novoAutor4,  novoProtagonista5);
        comics.crearComic(comic5);

        //Listar

        System.out.println("-----Listar Autores-----");

        System.out.println(novoAutor);
        System.out.println(novoAutor2);
        System.out.println(novoAutor3);
        System.out.println(novoAutor4);

        System.out.println("-----Listar Comics-----");

        List<Comic> comicsList = comics.listarComics();

        if (comicsList != null) {
            for (Comic c : comicsList) {
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getTitulo());
                System.out.println("Ano: " + c.getAno());
                System.out.println("Autor: " + c.getAutor());
                System.out.println("Protagonista: " + c.getProtagonista());
                System.out.println("--------------------");
            }
        }

        System.out.println("-----Listar Protagonistas-----");

        System.out.println(novoProtagonista);
        System.out.println(novoProtagonista2);
        System.out.println(novoProtagonista3);
        System.out.println(novoProtagonista4);
        System.out.println(novoProtagonista5);
        System.out.println(novoProtagonista6);

        //ELiminar

        System.out.println("-----Eliminar Autores-----");

        autor.eliminarAutor(novoAutor);
        autor.eliminarAutor(novoAutor2);
        autor.eliminarAutor(novoAutor3);
        autor.eliminarAutor(novoAutor4);

        System.out.println("-----Eliminar Protagonistas-----");

        protagonista.eliminarProtagonista(novoProtagonista);
        protagonista.eliminarProtagonista(novoProtagonista2);
        protagonista.eliminarProtagonista(novoProtagonista3);
        protagonista.eliminarProtagonista(novoProtagonista4);
        protagonista.eliminarProtagonista(novoProtagonista5);
        protagonista.eliminarProtagonista(novoProtagonista6);

        System.out.println("-----Eliminar Comics-----");

        comics.eliminarComic(comic);
        comics.eliminarComic(comic2);
        comics.eliminarComic(comic3);
        comics.eliminarComic(comic4);
        comics.eliminarComic(comic5);

        //Listar otra vez

        System.out.println("-----Listar Autores x2-----");

        System.out.println(novoAutor);
        System.out.println(novoAutor2);
        System.out.println(novoAutor3);
        System.out.println(novoAutor4);

        System.out.println("-----Listar Comics x2-----");

        List<Comic> comicList = comics.listarComics();

        if (comicList != null) {
            for (Comic c : comicList) {
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getTitulo());
                System.out.println("Ano: " + c.getAno());
                System.out.println("Autor: " + c.getAutor());
                System.out.println("Protagonista: " + c.getProtagonista());
                System.out.println("--------------------");
            }
        }

        System.out.println("-----Listar Protagonistas x2-----");

        System.out.println(novoProtagonista);
        System.out.println(novoProtagonista2);
        System.out.println(novoProtagonista3);
        System.out.println(novoProtagonista4);
        System.out.println(novoProtagonista5);
        System.out.println(novoProtagonista6);


    }
}