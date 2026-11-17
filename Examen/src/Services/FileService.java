package Services;

import models.Celta;
import models.Xogadores;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static void Serial(List<Celta> tablaCelta, String ruta) {
        File file = new File(ruta);

        try(FileOutputStream FoS = new FileOutputStream(file);
            ObjectOutputStream OoS = new ObjectOutputStream(FoS)) {

            OoS.writeObject(tablaCelta);

            System.out.println("Fichero serializado correctamente");

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Celta> deserial(String ruta) {
        File file = new File(ruta);
        List<Celta> celta = new ArrayList<>();

        try(FileInputStream FiS = new FileInputStream(file);
            ObjectInputStream OiS = new ObjectInputStream(FiS)) {

            OiS.read();
            celta.getFirst();

            System.out.println("Fichero deserializado correctamente");

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return celta;
    }

    // Faltaron las etiquetas adecuadas

//    public static void XML(List<Celta> celta, String ruta){
//        XMLOutputFactory XOF = XMLOutputFactory.newInstance();
//
//        try(
//            XMLStreamWriter XSW = XOF.createXMLStreamWriter(new FileWriter(fileName));
//            XSW.writeStartDocument("UTF-8", 1.0)
//            ){
//            XSW.writeCharacters(" ");
//
//            XSW.writeCharacters(" ");
//            XSW.writeStartElement();
//            XSW.writeAttribute();
//            XSW.writeEndElement();
//            XSW.writeCharacters("\n");
//
//            XSW.writeStartElement();
//            XSW.writeAttribute();
//            XSW.writeEndElement();
//
//
//
//            XSW.writeEndDocument();
//
//            XSW.flush();
//            XSW.close();
//        }
//
//    }
}




















