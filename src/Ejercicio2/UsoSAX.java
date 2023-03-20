package Ejercicio2;
//Crea un programa que tome los datos del archivo empleados
// y nos muestre la cuantía total
// de pagar a todos los empleados (SAX).


import Ejercicio1.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;

public class UsoSAX  {

    public static void main(String[] args) {


        SAXParserFactory spf = SAXParserFactory.newInstance();

        try{
            SAXParser sp = spf.newSAXParser();
            sp.parse("Empleados.xml",new Escuchador());

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
