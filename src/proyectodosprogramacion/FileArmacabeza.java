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

    public Object objetoAReturnPorName(String tipo, String name) throws JDOMException, IOException {
        switch (tipo) {
            case "xml":
                FileManagerXml fileManagerXml
                        = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");

                return fileManagerXml.getImageByName(name);
        }
        return null;
    }

    public LinkedList<Image> listImage(String tipo) throws JDOMException, IOException {

        switch (tipo) {
            case "xml":
                FileManagerXml fileManagerXml
                        = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");
                return fileManagerXml.getAllImage();

        }
        return null;
    }
}
