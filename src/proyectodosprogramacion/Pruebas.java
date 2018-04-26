/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.JDOMException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileArmacabeza fileArmacabeza = new FileArmacabeza();
            LinkedList<Image> imageList = fileArmacabeza.listImage("xml");
            System.out.println("\n \n****Lector xml generar lista****\n\n");
            for (int i = 0; i < imageList.size(); i++) {
                System.out.println(imageList.get(i).toString());
            }

            System.out.println("\n\n****Lector xml buscar uno****\n\n");
            System.out.println(fileArmacabeza.objetoAReturnPorName("xml", "001-wine").toString());

        } catch (JDOMException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
