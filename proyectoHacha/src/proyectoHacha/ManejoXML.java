package proyectoHacha;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejoXML {
	
	public static void crearXML(int partes, long tamanyo, String directorio, String fichero, String extension) {
	    try {
	      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	      
	      String a = String.valueOf(partes);
	      String b = String.valueOf(tamanyo);
	      String c = String.valueOf(partes);
	      
	      
	      //Elemento raíz
	      Document doc = docBuilder.newDocument();
	      Element rootElement = doc.createElement("archivo");
	      doc.appendChild(rootElement);
	      
	      //Primer elemento
	      Element elemento1 = doc.createElement("partes");
	      rootElement.appendChild(elemento1);
	      elemento1.setTextContent(a);
	      
	      //Segundo elemento
	      Element elemento2 = doc.createElement("tamaño");
	      rootElement.appendChild(elemento2);
	      elemento2.setTextContent(b);
	      
	      //Tercer elemento
	      Element elemento3 = doc.createElement("directorio");
	      rootElement.appendChild(elemento3);
	      elemento3.setTextContent(directorio);
	      
	      //Cuarto Elemento
	      Element elemento4 = doc.createElement("nombre");
	      rootElement.appendChild(elemento4);
	      elemento4.setTextContent(fichero);
	      
	      //Quinto Elemento
	      Element elemento5 = doc.createElement("extension");
	      rootElement.appendChild(elemento5);
	      elemento5.setTextContent(extension);
	      
	      
	      //Se escribe el contenido del XML en un archivo
	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      DOMSource source = new DOMSource(doc);
	      StreamResult result = new StreamResult(new File( directorio+ "xmlParticion" + fichero + ".xml"));
	      transformer.transform(source, result);
	      
	    } catch (ParserConfigurationException pce) {
	      pce.printStackTrace();
	    } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	      }
	  }

	
	/*
	 JTextField textFieldPartes;
	 JTextField textFieldLongitud;
	 JTextField textFieldNombre;
	 JTextField textFieldRutaPartes;
	 
	 */
	
	
	public static void leerXML(String ruta, 
			JTextField textFieldPartes, 
			JTextField textFieldLongitud, 
			JTextField textFieldNombre,
			JTextField textFieldRutaPartes, 
			JTextField textFieldExtension) {
		
		try {
            File file = new File(ruta);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            
            NodeList nList =document.getElementsByTagName("archivo");
            
           for(int aux=0; aux< nList.getLength(); aux++){
        	   Node nNode = nList.item(aux);
        	   if(nNode.getNodeType()== Node.ELEMENT_NODE) {
        		   Element eElement = (Element) nNode;

                   String partes = eElement.getElementsByTagName("partes").item(0).getTextContent();
                   String tamanyo = eElement.getElementsByTagName("tamaño").item(0).getTextContent();
                   String directorio = eElement.getElementsByTagName("directorio").item(0).getTextContent();    
                   String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                   String extension = eElement.getElementsByTagName("extension").item(0).getTextContent();
                   
                   textFieldPartes.setText(partes);
                   textFieldLongitud.setText(tamanyo);
                   textFieldRutaPartes.setText(directorio);
                   textFieldNombre.setText(nombre);
                   textFieldExtension.setText(extension);
                   
        	   }
           }
            
        }catch(IOException e) {
            System.out.println(e);
        }catch(ParserConfigurationException e) {
        	System.out.println(e);
        }catch(SAXException e) {
        	System.out.println(e);
        }
		
		
	}
}
