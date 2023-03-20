package Ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Escuchador extends DefaultHandler {

    int salarioTotal = 0;
    String texto;
    // String qnameActual;
    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        texto = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equals("salario")){


            salarioTotal+= Double.parseDouble(texto);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("El salario total es :  " + salarioTotal);
    }
}
