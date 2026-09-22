package practica2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Parte2Buffered {

    public static void CopiarImagen() {
        try {
            BufferedInputStream entrada = new BufferedInputStream
                    (new FileInputStream("Practica 2 I_OStream/foto.jpg"));
            BufferedOutputStream salida = new BufferedOutputStream
                    (new FileOutputStream("Practica 2 I_OStream/foto2Buffered.jpg"));
            int imagen;
            while ((imagen = entrada.read()) != -1) {
                salida.write(imagen);
            }
            entrada.close();
            salida.close();
            System.out.println("Imagen con Buffered.");
        } catch(Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        CopiarImagen();
    }
}