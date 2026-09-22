package practica2;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Parte2 {

    public static void CopiarImagen() {
        try {
            FileInputStream entrada = new FileInputStream("Practica 2 I_OStream/foto.jpg");
            FileOutputStream salida = new FileOutputStream("Practica 2 I_OStream/foto2.jpg");
            int imagen;
            while ((imagen = entrada.read()) != -1) {
                salida.write(imagen);
            }
            entrada.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void EngadirImagen() {
        try {
            FileInputStream entrada = new FileInputStream("Practica 2 I_OStream/foto.jpg");
            FileOutputStream salida = new FileOutputStream("Practica 2 I_OStream/foto2.jpg", true);
            int imagen;
            while ((imagen = entrada.read()) != -1) {
                salida.write(imagen);
            }
            entrada.close();
            salida.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        System.out.println("Copiando...");
        CopiarImagen();
        System.out.println("Copia correcta.");
        System.out.println("Añadiendo imagen...");
        EngadirImagen();
        System.out.println("Imagen añadida.");
    }
}