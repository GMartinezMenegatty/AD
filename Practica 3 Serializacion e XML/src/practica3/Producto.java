package practica3;
import java.io.*;

public class Producto implements Serializable{
    String nombre;
    int num1;
    double num2;

    public Producto(String nombre, int num1, double num2) {
        this.nombre = nombre;
        this.num1 = num1;
        this.num2 = num2;
    }

    public static void main(String[] args) {
        Producto p1 = new Producto("Abc", 12, 34);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Practica 3 Serializacion e XML/producto.ser"))) {
            oos.writeObject(p1); // Usamos writeObject aquí
            System.out.println("Objeto guardado correctamente: " + p1);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Practica 3 Serializacion e XML/producto.ser"))) {
            Producto pRecuperada = (Producto) ois.readObject();
            System.out.println("Objeto leído del archivo: " + pRecuperada);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
