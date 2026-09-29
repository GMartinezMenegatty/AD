package practica3;
import javax.xml.stream.*;
import java.io.*;

public class Parte3 {
    public static void main(String[] args) {

        try {
            // Crear la fábrica para escribir XML
            XMLOutputFactory autores = XMLOutputFactory.newInstance();

            // Crear el escritor XML
            XMLStreamWriter writer = autores.createXMLStreamWriter(new FileWriter("autores.xml"));

            // Declaración XML
            writer.writeStartDocument("1.0");
            // Elemento raíz
            writer.writeStartElement("autores");


            // Primer autor
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");

            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement();

            writer.writeEndElement();


            // Segundo autor
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();

            writer.writeEndElement();

            // Cerrar elemento autores
            writer.writeEndElement();

            // Finalizar documento
            writer.writeEndDocument();

            writer.close();

            System.out.println("Archivo autores.xml creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
