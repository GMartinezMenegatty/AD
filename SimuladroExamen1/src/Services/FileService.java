package Services;
import model.Videoxogo;

import javax.xml.stream.*;
import java.io.*;

public class FileService implements Serializable {

    //Escribe unha función que permita serializar nun
    // ficheiro o contido da táboa Videoxogo.

    public Videoxogo serializar(Videoxogo videoxogo) {
        try {
            FileOutputStream archivo = new FileOutputStream("Videoxogo_serializado");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(videoxogo);

            salida.close();
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return videoxogo;
    }

    // Escribe unha función que permita
    // deserializar as entradas do ficheiro creado anteriormente.

    public Videoxogo deserializar() {
        Videoxogo videoxogo = null;
        try {
            FileInputStream archivo = new FileInputStream("Videoxogo_deserializado");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            videoxogo = (Videoxogo) entrada.readObject();

            entrada.close();
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return videoxogo;
    }

    // Escribe unha función que permita exportar en XML as entradas
    // da táboa Videoxogo.

    public void exportarXML() {
        try {
            XMLOutputFactory XOF = XMLOutputFactory.newInstance();
            XMLStreamWriter XSW = XOF.createXMLStreamWriter(new FileWriter("Videoxogo.xml"));

            XSW.writeStartDocument();
            XSW.writeStartElement("Videoxogo");

            XSW.writeStartElement("Id");
            XSW.writeCharacters(String.valueOf(Videoxogo.getId()));
            XSW.writeEndElement();

            XSW.writeStartElement("Titulo");
            XSW.writeCharacters(Videoxogo.getTitulo());
            XSW.writeEndElement();

            XSW.writeStartElement("Plataforma");
            XSW.writeCharacters(Videoxogo.getPlataforma());
            XSW.writeEndElement();

            XSW.writeStartElement("AnoLanzamento");
            XSW.writeCharacters(String.valueOf(Videoxogo.getAnoLanzamento()));
            XSW.writeEndElement();

            XSW.writeStartElement("Descripcion");
            XSW.writeCharacters(Videoxogo.getDescripcion());
            XSW.writeEndElement();

            XSW.writeEndElement(); // Cierra el elemento Videoxogo
            XSW.writeEndDocument();

            XSW.close();
        } catch (Exception e) {
            System.out.println("Error al exportar a XML: " + e.getMessage());
        }
    }

    // Exporta as entradas da táboa Videoxogo nun ficheiro.

    public void exportarFichero(Videoxogo videoxogo) {
        try {
            FileOutputStream archivo = new FileOutputStream("Videoxogo.txt");
            PrintWriter pw = new PrintWriter(archivo);

            pw.println("Id: " + videoxogo.getId());
            pw.println("Titulo: " + videoxogo.getTitulo());
            pw.println("Plataforma: " + videoxogo.getPlataforma());
            pw.println("AnoLanzamento: " + videoxogo.getAnoLanzamento());
            pw.println("Descripcion: " + videoxogo.getDescripcion());

            pw.close();
            archivo.close();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }



}
