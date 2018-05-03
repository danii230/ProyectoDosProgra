/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.xml.transform.Source;
import jdk.nashorn.internal.objects.NativeRegExp;
import org.jdom.JDOMException;


/**
 *
 * @author daniela
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ScrollPane paneMatriz;
    @FXML
    private GridPane gpn_list;

    @FXML
    private Label labelIngreseColumnas;
    @FXML
    private TextField tfNumeroColumnas;
    @FXML
    private Label labelIngreseFilas;
    @FXML
    private TextField tfNumeroFilas;
    @FXML
    private Button bAccion;
    GridPane gridPane;
    FileArmacabeza fileArmacabeza;
    private static Images selectedImage;
    ArrayList<Images> matrixImages;
    int row;
    int column;
    String pathOpen;

    @FXML
    private void accionBoton(ActionEvent event) {

        gridPane.getChildren().clear();

        row = Integer.parseInt(tfNumeroFilas.getText());
        column = Integer.parseInt(tfNumeroColumnas.getText());
        //gridPane.resize(columnas, filas);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Tile tile = new Tile();
                tile.setId(i + "x" + j);

                gridPane.setAlignment(Pos.TOP_LEFT);
                gridPane.setValignment(tile, VPos.TOP);
                gridPane.add(tile, i, j);

            }

            paneMatriz.setContent(gridPane);

        }
    }

    public class Tile extends StackPane {

        ImageView imagen = new ImageView();

        public Tile() {
            Rectangle rect = new Rectangle(140, 140);

            rect.setFill(null);

            rect.setStroke(Color.BLACK);

            getChildren().addAll(rect, imagen);

            setOnMouseClicked(event -> {
                Node source = (Node) event.getSource();

                Image im = new Image(selectedImage.getUrl(), selectedImage.getWidth(), selectedImage.getHeight(), true, true);
                imagen.setImage(im);
//                System.out.println(source.getId() + "esto-->>" + selectedImage.getImageNumber());
                matrixImages(source.getId(), selectedImage.getImageNumber());

            });
        }

    }

    @FXML
    private void accionLimpiar(ActionEvent event) throws JDOMException, IOException {

        gridPane.getChildren().clear();
        selectedImage = (Images) fileArmacabeza.objetAReturnByNumber("xml", 0);
        tfNumeroColumnas.setText("");
        tfNumeroFilas.setText("");

    }

    @FXML
    private void accionEnlarge(ActionEvent event) throws JDOMException, IOException {
        row = Integer.parseInt(tfNumeroFilas.getText());
        column = Integer.parseInt(tfNumeroColumnas.getText());
        uploadImages();

    }

    @FXML
    public void exportImagejpg() {

        fileArmacabeza.ExportIntoJpg(gridPane);
    }

    @FXML
    public void exportImagepng() {

        fileArmacabeza.ExportIntoPng(gridPane);
    }

    public void Exit(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    private void accionSave(ActionEvent event) throws JDOMException, IOException {
        if (pathOpen == null) {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showSaveDialog(null);

            String path;
            path = selectedFile.getAbsolutePath();
//        System.out.println(path);

            fileArmacabeza.saveFileJson(column, row, matrixImages, path);
        } else {
            fileArmacabeza.delete(pathOpen);
            fileArmacabeza.saveFileJson(column, row, matrixImages, pathOpen);

        }
    }

    @FXML
    private void accionOpen(ActionEvent event) throws ParseException, JDOMException, IOException {

        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            String path;
            path = selectedFile.getAbsolutePath();

            matrixImages = fileArmacabeza.listImagesJson(path);
//            for (int i = 0; i < matrixImages.size(); i++) {
//                System.out.println(matrixImages.get(i).toString());
//            }
            String attributes = (String) fileArmacabeza.getAllAtributesJson(path);
            pathOpen = path;
            column = Integer.parseInt(attributes.substring(0, 1));
            row = Integer.parseInt(attributes.substring(2, 3));

//            System.out.println("---->>>" + row + "----" + column);
            uploadImages();

        } else {
            System.out.println("file is not valid");
        }

    }

    private void loadImages() throws JDOMException, IOException {

        LinkedList<Images> listImages = fileArmacabeza.listImage("xml");

        for (int i = 1; i < 36; i++) {
//               
            Images images = listImages.get(i);
            Image image = new Image(images.getUrl(), images.getWidth(), images.getHeight(), true, true);

            ImageView imageView = new ImageView(image);
            int numberImage = i;
            imageView.setId(numberImage + "");
            System.out.println(imageView.getId());
            imageView.setOnMouseClicked((event) -> {

                Node source = (Node) event.getSource();

//                System.out.println("Id de imagen:" + source.getId());
                Images imagesTemp = (Images) fileArmacabeza.objetAReturnByNumber("xml", Integer.parseInt(source.getId()));
                System.out.println(imagesTemp);
                selectedImage.setName(imagesTemp.getName());
                selectedImage.setImageNumber(imagesTemp.getImageNumber());
                selectedImage.setHeight(imagesTemp.getHeight());
                selectedImage.setWidth(imagesTemp.getWidth());
                selectedImage.setUrl(imagesTemp.getUrl());

//                System.out.println("Imagen seleccionada: --->>>" + selectedImage.toString());
            });

            gpn_list.add(imageView, 0, i);

        }

        scrollPane.setContent(gpn_list);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            gridPane = new GridPane();
            fileArmacabeza = new FileArmacabeza();
            selectedImage = (Images) fileArmacabeza.objetAReturnByNumber("xml", 0);
            matrixImages = new ArrayList<>();
            pathOpen = null;

            loadImages();
        } catch (JDOMException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void matrixImages(String posicion, int numberImages) {

        int column = Integer.parseInt(posicion.substring(0, 1));
        int row = Integer.parseInt(posicion.substring(2, 3));

        Images imagesTemp = (Images) fileArmacabeza.objetAReturnByNumber("xml", numberImages);
        imagesTemp.setColumnPosition(column);
        imagesTemp.setRowPosition(row);

        if (this.matrixImages.size() == 0) {
            this.matrixImages.add(imagesTemp);
        }
        if (positionObject(imagesTemp) == -1 && this.matrixImages.size() != 0) {

            this.matrixImages.add(imagesTemp);

        }
        if (positionObject(imagesTemp) != -1 && this.matrixImages.size() != 0) {

            this.matrixImages.set(positionObject(imagesTemp), imagesTemp);

        }
//           

    }

    public int positionObject(Images images) {
        int position = -1;
        for (int i = 0; i < matrixImages.size(); i++) {
            Images images1 = (Images) matrixImages.get(i);
            if (images1.getColumnPosition() == images.getColumnPosition() && images1.getRowPosition() == images.getRowPosition()) {
                return i;
            }
        }

        return position;
    }

    public void uploadImages() {
        System.out.println("entra");
        gridPane.getChildren().clear();

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < this.matrixImages.size(); k++) {
                    if (matrixImages.get(k).getColumnPosition() == j && matrixImages.get(k).getRowPosition() == i) {
                        selectedImage = matrixImages.get(k);

                        TileLoad tileLoad = new TileLoad();
                        tileLoad.setId(i + "x" + j);

                        gridPane.setAlignment(Pos.TOP_LEFT);
                        gridPane.setValignment(tileLoad, VPos.TOP);
                        gridPane.add(tileLoad, i, j);

                    } else {

                        Tile tile = new Tile();
                        tile.setId(i + "x" + j);
                        System.out.println(tile.getId());

                        gridPane.setAlignment(Pos.TOP_LEFT);
                        gridPane.setValignment(tile, VPos.TOP);
                        gridPane.add(tile, i, j);
                    }
                }
            }

            paneMatriz.setContent(gridPane);
        }

    }

    public class TileLoad extends StackPane {

        ImageView imagen = new ImageView();

        public TileLoad() {
            Rectangle rect = new Rectangle(140, 140);

            rect.setFill(null);

            rect.setStroke(Color.BLACK);
            Image imTemp = new Image(selectedImage.getUrl(), selectedImage.getWidth(), selectedImage.getHeight(), true, true);
            imagen.setImage(imTemp);

            getChildren().addAll(rect, imagen);
            setOnMouseClicked(event -> {
                Node source = (Node) event.getSource();

                Image im = new Image(selectedImage.getUrl(), selectedImage.getWidth(), selectedImage.getHeight(), true, true);

                imagen.setImage(im);
//                System.out.println(source.getId() + "esto-->>" + selectedImage.getImageNumber());
                matrixImages(source.getId(), selectedImage.getImageNumber());

            });
        }

    }

}
