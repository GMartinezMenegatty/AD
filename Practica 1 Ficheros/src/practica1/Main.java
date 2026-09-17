package practica1;

public class Main {

    public static void main(String[] args) {

        String ruta = "/home/dam26/AD";

        String ruta2 = ruta + "/arquivosdir";
        String subdir = ruta2 + "/subdir";

        String fileName1 = "Products1.txt";
        String fileName2 = "Products2.txt";

        // ejercicio 1
        Metodos.creaDirectorio("/arquivosdir");

        // ejercicio 2

        Metodos.creaFicheiro(ruta2, fileName1);
        System.out.println(Metodos.eFicheiro(ruta + "/" + fileName1));

        // ejercicio 3
        Metodos.creaDirectorio(subdir);
        Metodos.creaFicheiro(subdir, fileName2);

        System.out.println(Metodos.eDirectorio(subdir));
        System.out.println(Metodos.eFicheiro(subdir + "/" + fileName2));

        // ejercicio 4
        Metodos.mContido(ruta2);

        // ejercicio 5
        Metodos.modoAcceso(ruta2, fileName1);
        Metodos.calculaLonxitude(ruta2, fileName1);

        // ejercicio 6

        Metodos.mLectura(ruta2, fileName1);
        Metodos.modoAcceso(ruta2, fileName1);

        // ejercicio 7

        Metodos.mEscritura(ruta2, fileName1);
        Metodos.modoAcceso(ruta2, fileName1);

        // ejercicio 8
        Metodos.borraFicheiro(ruta2, fileName1);
        System.out.println(Metodos.eFicheiro(ruta + "/" + fileName1));

        // ejercicio 9
        Metodos.borraFicheiro(subdir, fileName2);
        Metodos.borraDirectorio(subdir);
        Metodos.borraDirectorio(ruta2);
    }
}