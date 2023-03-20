package Ejercicio1;//En el archivo Empleados.xml hay una serie de empleados. El objetivo es disponer
// de esa información en un programa java para poder trabajar con objetos en lugar de un archivo.
// Una vez importado de una manera correcta, se mostrará la información de todos los empleados.


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {

        ArrayList<Empleado> lista = leeEmpleados();

        for (Empleado e : lista){
            System.out.println(e);
        }

    }

    public static ArrayList<Empleado>leeEmpleados(){

        ArrayList<Empleado> leidos = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse("Empleados.xml");

            NodeList empleados = documento.getElementsByTagName("empleado");
            System.out.println("Hay " + empleados.getLength() + " empleados.");

            for (int i = 0; i < empleados.getLength(); i++){

                Node empleado = empleados.item(i);
                NodeList hijos = empleado.getChildNodes();

                String strId = hijos.item(1).getFirstChild().getNodeValue();
                String apellido = hijos.item(3).getFirstChild().getNodeValue();
                String strDep = hijos.item(5).getFirstChild().getNodeValue();
                String strSalario = hijos.item(7).getFirstChild().getNodeValue();

                int id = Integer.parseInt(strId);
                int dep = Integer.parseInt(strDep);
                double salario = Double.parseDouble(strSalario);

                leidos.add(new Empleado(id,apellido,dep,salario));

            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return leidos;

    }


}
