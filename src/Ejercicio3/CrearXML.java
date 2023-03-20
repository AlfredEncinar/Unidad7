package Ejercicio3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class CrearXML {

    public static void main(String[] args) {
        ArrayList<Biblioteca> biblio = new ArrayList<>();

        biblio.add(new Biblioteca(3,"cars",2005));
        biblio.add(new Biblioteca(4,"Geronimo Stilton",1997));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.newDocument();
            Node root = documento.createElement("biblio");
            documento.appendChild(root);

            for (Biblioteca b : biblio){

                Node biblioteca = documento.createElement("biblioteca");
                Node codigo = documento.createElement("codigo");
                Node titulo = documento.createElement("titulo");
                Node annoPublicacion = documento.createElement("annoPublicacion");

                System.out.println("codigo");

                root.appendChild(biblioteca);

                biblioteca.appendChild(codigo);
                codigo.appendChild(documento.createTextNode(String.valueOf(b.getCodigo())));
                biblioteca.appendChild(titulo);
                titulo.appendChild(documento.createTextNode(b.getTitulo()));
                biblioteca.appendChild(annoPublicacion);
                annoPublicacion.appendChild(documento.createTextNode(String.valueOf(b.getAnnoPublicacion())));

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();

                transformer.setOutputProperty(OutputKeys.INDENT ,"yes");

                transformer.transform(new DOMSource(documento),new StreamResult("biblioteca.xml"));

            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }

}
