/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Images;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Michelle
 */
public class List {

    ArrayList<Images> imagenesArrayList = new ArrayList<>();

    public void ReadXml() throws Exception {

        try {
            File fXmlFile = new File("src/Images.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            NodeList imageNodeList = document.getElementsByTagName("image");

            for (int temp = 0; temp < imageNodeList.getLength(); temp++) {

                Node auxNode = imageNodeList.item(temp);
                if (auxNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) auxNode;
                    String url = getTagValue("URL", element);
                    String name = getTagValue("name", element);
                    Images images = new Images(url, name);
                    imagenesArrayList.add(images);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nodeList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nodeValue = (Node) nodeList.item(0);

        return nodeValue.getNodeValue();
    }

    public VBox printImages() throws Exception {
        ReadXml();
        Images tempImagenes = null;
        String url;
        VBox vbox = new VBox();
        for (int i = 0; i < imagenesArrayList.size(); i++) {
            tempImagenes = imagenesArrayList.get(i);
            url = tempImagenes.getURL();
            Image image = new Image(url);
            ImageView imageView = new ImageView(image);

            imageView.setFitHeight(100);
            imageView.setFitWidth(100);

            vbox.getChildren().addAll(imageView);

        }
        return vbox;

    }

}
