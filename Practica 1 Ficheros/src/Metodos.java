import java.io.File;

public class Metodos {
    //    ejercicio 1
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
//    ejercicio 2
    public String eFicheiro(String cadea) {
    File fichero = new File(cadea);
    if (fichero.isFile()) {
        return "é un ficheiro";
    }
    else {
        return "non é un ficheiro";
    }
}

//  ejercicio 3
    public boolean creaDirectorio(String ruta) {
    File fichero = new File(ruta);
    if (fichero.exists()) {
        return true;
    }
    else {
        return fichero.mkdir();
    }
}

//  ejercicio 4
    public boolean creaFicheiro(String dirName, String fileName) {
    File directorio = new File(dirName);
    File ficheiro = new File(dirName, fileName);

    if (!directorio.exists() || !directorio.isDirectory()) {
        return false;
    }
    if (ficheiro.exists()) {
        return true;
    }
    try {
        return ficheiro.createNewFile();
    } catch (Exception e) {
        return false;
    }
}

//  ejercicio 5
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

//  ejercicio 6
    public static void calculaLonxitude(String dirName, String fileName) {
    File fichero = new File(dirName, fileName);

    if (fichero.isFile()) {
        System.out.println("Lonxitude: " + fichero.length() + " bytes");
    } else {
        System.out.println("O ficheiro non existe.");
    }
}

//  ejercicio 7
    public void mLectura(String dirName, String fileName) {
    File ficheiro = new File(dirName, fileName);
    if (ficheiro.exists()) {
        ficheiro.setReadOnly();
    }
}

//  ejercicio 8
    public void mEscritura(String dirName, String fileName) {
    File ficheiro = new File(dirName, fileName);
    if (ficheiro.exists()) {
        ficheiro.setWritable(true);
    }
}

//  ejercicio 9
    public void borraFicheiro(String dirName, String fileName) {
    File ficheiro = new File(dirName, fileName);

    if (ficheiro.exists()) {
        ficheiro.delete();
    } else {
        System.out.println("fichero inexistente");
    }
}

//  ejercicio 10
    public void borraDirectorio(String dirName) {
    File directorio = new File(dirName);

    if (directorio.exists() && directorio.isDirectory()) {
        directorio.delete();
    } else {
        System.out.println("ruta inexistente ou con descencencia");
    }
}

//  ejercicio 11
    public void mContido(String dirName) {
    File directorio = new File(dirName);

    if (directorio.exists() && directorio.isDirectory()) {
        File[] contido = directorio.listFiles();
        for (File elemento : contido) {
            System.out.println(elemento.getName());
        }
    } else {
        System.out.println("ruta inexistente");
    }
}
//  ejercicio 12
    public void recur(File directorio) {
    if (directorio.exists() && directorio.isDirectory()) {
        File[] elementos = directorio.listFiles();
        for (File elemento : elementos) {
            System.out.println(elemento.getAbsolutePath());
            if (elemento.isDirectory()) {
                recur(elemento);
            }
        }
    }
}


void main() {
}

public static void prueba() {
    System.out.println("Hola");
}


