package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Path ficheroXMLAtletas = Path.of(".","src","main","resources","FicheroXMLAtletas.xml");

        AtletaFemenina atl1 = new AtletaFemenina("Maricarmen", List.of("100M","50M"),65,"España");
        AtletaFemenina atl2 = new AtletaFemenina("Juana", List.of("Waterpolo","Natacion"),20,"Francia");

        List<AtletaFemenina> atletas = List.of(atl1, atl2);

        ListaAtletas listaAtletas = new ListaAtletas(atletas);


        System.out.println("\n**** Escritura de lista de objetos XML ****");
        System.out.println(escribirListaObjetosXML(listaAtletas));
        System.out.println("\n**** Escritura de lista de objetos XML a fichero ****");
        escribirListaObjetosXml(listaAtletas, ficheroXMLAtletas);
        System.out.println("\n**** Lectura de array de objetos XML desde fichero ****");
        leerArrayObjetosXml(ficheroXMLAtletas).forEach(System.out::println);
    }

    public static String escribirListaObjetosXML(ListaAtletas atletas){
        try {

            XmlMapper xmlMapper = new XmlMapper();

            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(atletas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void escribirListaObjetosXml(ListaAtletas atletas, Path ficheroXMLAtletas) {

        try {
            Files.deleteIfExists(ficheroXMLAtletas);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ficheroXMLAtletas.toFile(), atletas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static List<AtletaFemenina> leerArrayObjetosXml(Path ficheroXMLAtletas) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ficheroXMLAtletas.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}