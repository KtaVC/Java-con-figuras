package proyectojava;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class LeeArchivo {

    public static void leer(){

        try {

            File xmlArchivo = new File("XML/file.xml"); //El archivo que tengo en carpeta
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlArchivo); //xmlArchivo es el "objeto archivo"

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); //datos

            NodeList nList = doc.getElementsByTagName("Actividad"); //Lista 1 Actividad
            NodeList nList2 = doc.getElementsByTagName("Relacion"); //Lista 2 Relacion


            

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Actividad id = " + eElement.getAttribute("id") + "  "  +("Duracion = " + eElement.getAttribute("duracion")));

                }
            }
            System.out.println("\n");
            
            for (int temp = 0; temp < nList2.getLength(); temp++) {

                Node nNode2 = nList2.item(temp);


                if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode2;

                    System.out.println("Relacion actividad = " + eElement.getAttribute("actividad")+ "  "  + ("Sucesor = " + eElement.getAttribute("sucesor") ));
 
                }
            }
            
            
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                int n;
                



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    
                    eElement.getAttributeNS("id", "duracion");
                   
                }
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}



   