package practica2;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Parte1 {

    public static void Copiar() {
        try {
            FileInputStream entrada = new FileInputStream("Practica 2 I_OStream/texto1.txt");
            FileOutputStream salida = new FileOutputStream("Practica 2 I_OStream/texto2.txt");
            int texto;
            while ((texto = entrada.read()) != -1) {
                salida.write(texto);
            }
            entrada.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void Engadir() {
        try {
            FileInputStream entrada = new FileInputStream("Practica 2 I_OStream/texto1.txt");
            FileOutputStream salida = new FileOutputStream("Practica 2 I_OStream/texto2.txt", true);
            int texto;
            while ((texto = entrada.read()) != -1) {
                salida.write(texto);
            }
            entrada.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Copiando...");
        Copiar();
        System.out.println("Copia correcta.");
        System.out.println("Añadiendo texto...");
        Engadir();
        System.out.println("Texto añadido.");
    }
}