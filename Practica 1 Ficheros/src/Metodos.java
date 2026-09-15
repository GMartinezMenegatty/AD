import java.util.*;


public class Metodos {

    public String eDirectorio(String cadea) {
        File directorio = new File(cadea);
        if (directorio.isDirectory()) {
            return "é un directorio";
        }
        else {
            return "non é un directorio";
        }
    }

}
    public String eFicheiro(String cadea) {
    File fichero = new File(cadea);
    if (fichero.isFile()) {
        return "é un ficheiro";
    }
    else {
        return "non é un ficheiro";
    }
}

    public boolean creaDirectorio(String ruta) {
        File fichero = new File(ruta);
        if (fichero.exists()) {
            return true;
        }
        else {
            return fichero.mkdir();
        }
}


//ejercicio 5
public boolean modoAcceso(String dirName, String fileName) {
    File ficheiro = new File(dirName, fileName);

    if (ficheiro.canWrite()) {
        System.out.println("escritura si");
    } else {
        System.out.println("escritura no");
    }

    if (ficheiro.canRead()) {
        System.out.println("lectura si");
    } else {
        System.out.println("lectura no");
    }
    return false;
}

//ejercicio 6
public static void calculaLonxitude(String dirName, String fileName) {
    File fichero = new File(dirName, fileName);

    if (fichero.isFile()) {
        System.out.println("Lonxitude: " + fichero.length() + " bytes");
    } else {
        System.out.println("O ficheiro non existe.");
    }
}


void main() {
}


