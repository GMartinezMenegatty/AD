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

    public Producto() {
    }

    @Override
    public String toString() {
        return "Producto{" + "nome='" + nombre + '\'' + ", num1=" + num1 +
                ", num2=" + num2 + '}';
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("Ordenador", 10, 799.99);

        // Guardar el objeto en el fichero serial
        try {

            FileOutputStream archivo = new FileOutputStream("serial");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);

            salida.writeObject(producto1);

            salida.close();
            archivo.close();

            System.out.println("Producto guardado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }


        // Crear un objeto vacío
        Producto producto2 = new Producto();

        // Cargar los datos desde el fichero
        try {

            FileInputStream archivo = new FileInputStream("serial");
            ObjectInputStream entrada = new ObjectInputStream(archivo);

            producto2 = (Producto) entrada.readObject();

            entrada.close();
            archivo.close();

            System.out.println("Producto cargado correctamente.");

            System.out.println(producto2);

        } catch (Exception e) {

            System.out.println("Error al cargar: " + e.getMessage());

        }
    }
}
