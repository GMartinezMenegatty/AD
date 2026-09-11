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

void main() {
}


