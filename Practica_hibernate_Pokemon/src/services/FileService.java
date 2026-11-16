
package services;

import model.Pokedex;
import model.Adestrador;

import javax.xml.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    // SERIALIZAR POKEDEX
    public static void serializar(
            List<Pokedex> datos, String archivo) {

        try (ObjectOutputStream salida =
                     new ObjectOutputStream(
                             new FileOutputStream(archivo))) {

            salida.writeObject(new ArrayList<>(datos));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // DESERIALIZAR POKEDEX
    @SuppressWarnings("unchecked")
    public static List<Pokedex> deserializar(String archivo) {

        try (ObjectInputStream entrada =
                     new ObjectInputStream(
                             new FileInputStream(archivo))) {

            return (List<Pokedex>) entrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // EXPORTAR ADESTRADORES A XML
    public static void toXML(
            List<Adestrador> datos, String archivo) {

        try (OutputStream salida =
                     new FileOutputStream(archivo)) {

            XMLStreamWriter xml =
                    XMLOutputFactory.newInstance()
                            .createXMLStreamWriter(
                                    salida, "UTF-8");

            xml.writeStartDocument("UTF-8", "1.0");
            xml.writeStartElement("adestradores");

            for (Adestrador a : datos) {

                xml.writeStartElement("adestrador");
                xml.writeAttribute(
                        "id", a.getId().toString());

                xml.writeStartElement("nome");
                xml.writeCharacters(a.getNome());
                xml.writeEndElement();

                xml.writeStartElement("nacemento");
                xml.writeCharacters(
                        a.getNacemento() == null
                                ? ""
                                : a.getNacemento().toString()
                );
                xml.writeEndElement();

                xml.writeEndElement();
            }

            xml.writeEndElement();
            xml.writeEndDocument();
            xml.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // IMPORTAR ADESTRADORES DESDE XML
    public static List<Adestrador> fromXML(String archivo) {

        List<Adestrador> lista = new ArrayList<>();

        try (InputStream entrada =
                     new FileInputStream(archivo)) {

            XMLStreamReader xml =
                    XMLInputFactory.newInstance()
                            .createXMLStreamReader(
                                    entrada, "UTF-8");

            Long id = null;
            String nome = null;
            LocalDate fecha = null;

            while (xml.hasNext()) {

                int evento = xml.next();

                if (evento == XMLStreamConstants.START_ELEMENT) {

                    switch (xml.getLocalName()) {

                        case "adestrador":
                            id = Long.valueOf(
                                    xml.getAttributeValue(null, "id")
                            );
                            break;

                        case "nome":
                            nome = xml.getElementText();
                            break;

                        case "nacemento":
                            String texto = xml.getElementText();

                            fecha = texto.isEmpty()
                                    ? null
                                    : LocalDate.parse(texto);
                            break;
                    }

                } else if (
                        evento == XMLStreamConstants.END_ELEMENT
                                && xml.getLocalName().equals("adestrador")) {

                    Adestrador a = new Adestrador(nome, fecha);
                    a.setId(id);

                    lista.add(a);

                    id = null;
                    nome = null;
                    fecha = null;
                }
            }

            xml.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // EXPORTAR POKEDEX A XML
    public static void toXMLPokedex(
            List<Pokedex> datos, String archivo) {

        try (OutputStream salida =
                     new FileOutputStream(archivo)) {

            XMLStreamWriter xml =
                    XMLOutputFactory.newInstance()
                            .createXMLStreamWriter(
                                    salida, "UTF-8");

            xml.writeStartDocument("UTF-8", "1.0");
            xml.writeStartElement("pokedex");

            for (Pokedex p : datos) {

                xml.writeStartElement("entrada");
                xml.writeAttribute(
                        "id", p.getId().toString());

                xml.writeStartElement("nome");
                xml.writeCharacters(p.getNome());
                xml.writeEndElement();

                xml.writeStartElement("peso");
                xml.writeCharacters(
                        p.getPeso() == null
                                ? ""
                                : p.getPeso().toString()
                );
                xml.writeEndElement();

                xml.writeStartElement("misc");
                xml.writeCharacters(
                        p.getMisc() == null
                                ? ""
                                : p.getMisc()
                );
                xml.writeEndElement();

                xml.writeEndElement();
            }

            xml.writeEndElement();
            xml.writeEndDocument();
            xml.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
