/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class FileManagerXml {

    private Document document;
    private Element root;
    private String documentPath;

    public FileManagerXml() {

    }

    public FileManagerXml(String documentPath) throws JDOMException, IOException {
        this.documentPath = documentPath;
        File usuarioExist = new File(documentPath);
        if (usuarioExist.exists()) {
            SAXBuilder saxBuilder = new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            // se monta el documento en la mamora del sistema operativo
            this.document = saxBuilder.build(this.documentPath);
            this.root = document.getRootElement();
        } else {
            // se crea la estructura del archivo
            this.root = new Element("images");
            this.document = new Document(root);
            XMLOutputter xMLOutputter = new XMLOutputter();
            xMLOutputter.output(this.document, new PrintWriter(this.documentPath));//pone el archivo en salida a traves del print Writer
            //este cuerpo del constructor puede ser un metodo aparte
        }
    }

    public static FileManagerXml openDocument(String rutaDocumento)
            throws JDOMException, IOException {
        return new FileManagerXml(rutaDocumento);
    }

    public Images getImageByNumber(int imageNumber) {
        Images image = new Images();
        List<Element> children = root.getChildren("image");//ya que todas las editoriales se llaman asi , su base

        for (int i = 0; i < children.size(); i++) {
            Element currentElement = children.get(i);
            if (Integer.parseInt(currentElement.getChildText("imageNumber")) == imageNumber) {
                image.setName(currentElement.getChildText("name"));
                image.setImageNumber(Integer.parseInt(currentElement.getChildText("imageNumber")));
                image.setHeight(Integer.parseInt(currentElement.getChildText("height")));
                image.setWidth(Integer.parseInt(currentElement.getChildText("width")));
                image.setUrl(currentElement.getChildText("url"));

            }

        }
        return image;
    }

    public LinkedList<Images> getAllImage() {
        List<Element> children = root.getChildren("image");//ya que todas las editoriales se llaman asi , su base
        LinkedList<Images> imageList = new LinkedList<>();
        for (int i = 0; i < children.size(); i++) {
            Images image = new Images();
            //obtengo la author actual del archivo
            Element currentElement = children.get(i);
            image.setName(currentElement.getChildText("name"));
            image.setImageNumber(Integer.parseInt(currentElement.getChildText("imageNumber")));
            image.setHeight(Integer.parseInt(currentElement.getChildText("height")));
            image.setWidth(Integer.parseInt(currentElement.getChildText("width")));
            image.setUrl(currentElement.getChildText("url"));

            imageList.add(image);
        }
        return imageList;
    }

}
