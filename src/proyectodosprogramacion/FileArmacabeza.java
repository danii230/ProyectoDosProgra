/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.jdom.JDOMException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class FileArmacabeza {

    public Object objetAReturnByNumber(String tipo, int imageNumber) throws JDOMException, IOException {
        switch (tipo) {
            case "xml":
                FileManagerXml fileManagerXml
                        = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");

                return fileManagerXml.getImageByNumber(imageNumber);
        }
        return null;
    }

    public LinkedList<Images> listImage(String tipo) throws JDOMException, IOException {

        switch (tipo) {
            case "xml":
                FileManagerXml fileManagerXml
                        = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");
                return fileManagerXml.getAllImage();

        }
        return null;
    }
}
