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
        metodos.creaDirectorio(ruta);
        System.out.println(metodos.eDirectorio(ruta));

        // ejercicio 2

        System.out.println();

        metodos.creaFicheiro(ruta, fileName1);

        System.out.println(metodos.eFicheiro(ruta + "/" + fileName1));

        // ejercicio 3
        metodos.creaDirectorio(subdir);
        metodos.creaFicheiro(subdir, fileName2);

        System.out.println(metodos.eDirectorio(subdir));
        System.out.println(metodos.eFicheiro(subdir + "/" + fileName2));

        // ejercicio 4
        metodos.mContido(ruta);

        // ejercicio 5
        metodos.modoAcceso(ruta, fileName1);
        metodos.calculaLonxitude(ruta, fileName1);

        // ejercicio 6

        metodos.mLectura(ruta, fileName1);
        metodos.modoAcceso(ruta, fileName1);

        // ejercicio 7

        metodos.mEscritura(ruta, fileName1);
        metodos.modoAcceso(ruta, fileName1);

        // ejercicio 8
        metodos.borraFicheiro(ruta, fileName1);
        System.out.println(metodos.eFicheiro(ruta + "/" + fileName1));

        // ejercicio 9
        metodos.borraFicheiro(subdir, fileName2);
        metodos.borraDirectorio(subdir);
        metodos.borraDirectorio(ruta);
    }
}