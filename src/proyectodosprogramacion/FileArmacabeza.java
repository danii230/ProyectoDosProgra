/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdom.JDOMException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class FileArmacabeza {

    public Object objetAReturnByNumber(String tipo, int imageNumber) {
        try {
            switch (tipo) {
                case "xml":
                    FileManagerXml fileManagerXml
                            = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");

                    return fileManagerXml.getImageByNumber(imageNumber);
            }

        } catch (JDOMException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public LinkedList<Images> listImage(String tipo) {

        try {
            switch (tipo) {
                case "xml":
                    FileManagerXml fileManagerXml
                            = FileManagerXml.openDocument("src\\proyectodosprogramacion\\Imagenes.xml");
                    return fileManagerXml.getAllImage();

            }

        } catch (JDOMException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public void saveFileJson(int row, int column, ArrayList imaArrayList, String path) {

        FileManagerJson fileManagerJson = new FileManagerJson(path);
        try {
            fileManagerJson.insertMatrixInFile(row, column, imaArrayList);

        } catch (IOException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Images> listImagesJson(String path) throws JDOMException, IOException {

        try {
            FileManagerJson fileManagerJson = new FileManagerJson(path);
            return fileManagerJson.getAllImages();

        } catch (ParseException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Object getAllAtributesJson(String path) throws JDOMException, IOException {

        try {
            FileManagerJson fileManagerJson = new FileManagerJson(path);
            return fileManagerJson.getAllAtributes();

        } catch (ParseException ex) {
            Logger.getLogger(FileArmacabeza.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void delete(String path) {

        FileManagerJson fileManagerJson = new FileManagerJson(path);
        fileManagerJson.deleteJson(path);
    }

    public void ExportIntoJpg(GridPane gridCountainer) {
        JFileChooser fileChooser = new JFileChooser(new File("c:\\"));
        fileChooser.setDialogTitle("Save Image");

        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Imagen(*.jpg)", "jpg");//filtra archivos de tipo jpg
        fileChooser.setFileFilter(filtroExtension);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile() + ".jpg");//crea el archivo file con la extencion jpg

            try {
                WritableImage writableImage
                        = new WritableImage((int) gridCountainer.getWidth(), (int) gridCountainer.getHeight());
                gridCountainer.snapshot(null, writableImage);

                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                    System.out.println("image saved: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    System.out.print("problemas");
                }

            } catch (Exception E) {

            }
        }
    }

    public void ExportIntoPng(GridPane gridCountainer) {
        JFileChooser fileChooser = new JFileChooser(new File("c:\\"));
        fileChooser.setDialogTitle("Save Image");

        FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Imagen(*.png)", "png");//filtra archivos de tipo jpg
        fileChooser.setFileFilter(filtroExtension);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile() + ".png");//crea el archivo file con la extencion jpg

            try {
                WritableImage writableImage
                        = new WritableImage((int) gridCountainer.getWidth(), (int) gridCountainer.getHeight());
                gridCountainer.snapshot(null, writableImage);

                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                    System.out.println("image saved: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    System.out.print("Problemas con el archivo");
                }

            } catch (Exception E) {

            }
        }
    }

}
