import java.io.File;

public class Main {

    public static void main(String[] args) {

        Metodos metodos = new Metodos();

        String ruta = "C:/Users/gabri/Documents/DAM2/AD/Practica 1 Ficheros/arquivosdir";
        System.out.println(metodos.eDirectorio(ruta));

        String subdir = ruta + "/subdir";

        String fileName1 = "Products1.txt";
        String fileName2 = "Products2.txt";

        // ejercicio 1

        System.out.println("1) CREAR DIRECTORIO");

        metodos.creaDirectorio(ruta);
        System.out.println(metodos.eDirectorio(ruta));

        // ejercicio 2

        System.out.println();
        System.out.println("2) CREAR Products1.txt");

        metodos.creaFicheiro(ruta, fileName1);

        System.out.println(
                metodos.eFicheiro(ruta + "/" + fileName1)
        );

        // ejercicio 3

        System.out.println();
        System.out.println("3) CREAR subdir Y Products2.txt");

        metodos.creaDirectorio(subdir);
        metodos.creaFicheiro(subdir, fileName2);

        System.out.println(
                metodos.eDirectorio(subdir)
        );
        System.out.println(
                metodos.eFicheiro(subdir + "/" + fileName2)
        );

        // ejercicio 4

        System.out.println();
        System.out.println("4) CONTENIDO DE archivosdir");
        metodos.mContido(ruta);

        // ejercicio 5

        System.out.println();
        System.out.println("5) INFORMACIÓN DE Products1.txt");

        metodos.modoAcceso(ruta, fileName1);
        metodos.calculaLonxitude(ruta, fileName1);

        // ejercicio 6

        System.out.println();
        System.out.println("6) SOLO LECTURA");

        metodos.mLectura(ruta, fileName1);
        metodos.modoAcceso(ruta, fileName1);

        // ejercicio 7

        System.out.println();
        System.out.println("7) PERMITIR ESCRITURA");

        metodos.mEscritura(ruta, fileName1);
        metodos.modoAcceso(ruta, fileName1);

        // ejercicio 8

        System.out.println();
        System.out.println("8) BORRAR Products1.txt");

        metodos.borraFicheiro(ruta, fileName1);
        System.out.println(
                metodos.eFicheiro(ruta + "/" + fileName1)
        );

        // ejercicio 9

        System.out.println();
        System.out.println("9) BORRAR RESTO");

        metodos.borraFicheiro(subdir, fileName2);
        metodos.borraDirectorio(subdir);
        metodos.borraDirectorio(ruta);

        System.out.println("Proceso terminado.");

    }
}