package practica3;
import java.io.*;

public class ProductoTransient implements Serializable {
    String nombre;
    transient int num1;
    double num2;

    public ProductoTransient(String nombre, int num1, double num2) {
        this.nombre = nombre;
        this.num1 = num1;
        this.num2 = num2;
    }

    public ProductoTransient() {
    }

    @Override
    public String toString() {
        return "ProductoTransient{" + "nome='" + nombre + '\'' + ", num1=" + num1 + ", num2=" + num2 + '}';
    }
    public static void main(String[] args) {

        // Crear un objeto con num1 = 25
        ProductoTransient producto1 = new ProductoTransient("Abc", 24, 1410);

        // Guardar el objeto
        try {

            FileOutputStream archivo = new FileOutputStream("serialTransient");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);

            salida.writeObject(producto1);

            salida.close();
            archivo.close();

            System.out.println("Producto guardado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }


        // Crear un objeto vacío
        ProductoTransient producto2 = new ProductoTransient();

        // Leer el objeto
        try {
            FileInputStream archivo = new FileInputStream("serialTransient");
            ObjectInputStream entrada = new ObjectInputStream(archivo);

            producto2 = (ProductoTransient) entrada.readObject();

            entrada.close();
            archivo.close();

            System.out.println("Producto cargado correctamente.");
            System.out.println(producto2);

        } catch (Exception e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
