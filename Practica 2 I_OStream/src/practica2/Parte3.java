package practica2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Parte3 {

    public static void Escribir() {

        try {

            DataOutputStream salida = new DataOutputStream(new FileOutputStream("Practica 2 I_OStream/texto3.txt", true));
            String cadena = "o tempo está xélido";
            for (int i = 0; i < 3; i++) {

                System.out.println("Escribiendo la cadena: " + cadena);
                salida.writeUTF(cadena);
                System.out.println("Tamaño del fichero: " + salida.size() + " bytes");
                System.out.println("[...]");
            }
            salida.close();
            System.out.println("Tamaño final del fichero: " + new java.io.File("Practica 2 I_OStream/texto3.txt").length() + " bytes");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void Leer() {
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream("Practica 2 I_OStream/texto3.txt"));
            while (entrada.available() > 0) {
                System.out.println("Quedan: " + entrada.available() + " bytes por leer");
                String cadena = entrada.readUTF();
                System.out.println("Cadena: " + cadena);
                System.out.println("[...]");
            }
            System.out.println("Ya no queda nada por leer");
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        Escribir();
        System.out.println();
        Leer();
    }
}