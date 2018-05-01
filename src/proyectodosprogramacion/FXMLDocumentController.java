/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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


import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    private GridPane gpn_list;
    @FXML
    private GridPane gridPane;
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

    private static Images selectedImage;
  
  

    @FXML
    private void accionBoton(ActionEvent event) {

        gridPane.getChildren().clear();

        int filas = Integer.parseInt(tfNumeroFilas.getText());
        int columnas = Integer.parseInt(tfNumeroColumnas.getText());
        //gridPane.resize(columnas, filas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Tile tile = new Tile();
                gridPane.setAlignment(Pos.TOP_LEFT);
                gridPane.setValignment(tile, VPos.TOP);
                gridPane.add(tile, j, i);
                // ImageView imagenes = new ImageView();
//               gridPane.addColumn(j, imagenes);
//               gridPane.addRow(i, imagenes);
//                System.out.println("entra");
//            Rectangle rect = new Rectangle(130, 135);
//                rect.setFill(null);
//                rect.setStroke(Color.BLACK);
//
//                gridPane.setAlignment(Pos.TOP_LEFT);
//                gridPane.setValignment(rect, VPos.TOP);
//                gridPane.add(rect, j, i);

//                gridPane.getColumnConstraints().add(new ColumnConstraints(400));
            }

        }

    }

    public class Tile extends StackPane {

//        private Image img = new Image();
        
       
        ImageView imagen = new ImageView();

        public Tile() {
            Rectangle rect = new Rectangle(130, 135);
            rect.setFill(null);
            rect.setStroke(Color.BLACK);

//            gridPane.setAlignment(Pos.TOP_LEFT);
//            gridPane.setValignment(rect, VPos.TOP);
            getChildren().addAll(rect, imagen);
            setOnMouseClicked(event -> {
                drawHi();
            });
        }

        private void drawHi() {
            Image im = new Image(selectedImage.getUrl(), 80, 80, true, true);
            imagen.setImage(im);
        }
    }

    private void loadImages() {
        try {
            FileArmacabeza fileArmacabeza = new FileArmacabeza();
            LinkedList<Images> listImages = fileArmacabeza.listImage("xml");

            for (int i = 0; i < 36; i++) {
//                System.out.println(listImages.get(i).getUrl());
                Images images = listImages.get(i);
                Image image = new Image(images.getUrl(), 80, 80, true, true);

                ImageView imageView = new ImageView(image);
                int numberImage = i + 1;
                imageView.setId(numberImage + "");
                System.out.println(imageView.getId());
                imageView.setOnMouseClicked((event) -> {

                    Node source = (Node) event.getSource();

                    System.out.println(source.getId() + "hi");

                    try {
                        Images imagesTemp = (Images) fileArmacabeza.objetAReturnByNumber("xml", Integer.parseInt(source.getId()));
                        System.out.println(imagesTemp);
                        selectedImage.setName(imagesTemp.getName());
                        selectedImage.setImageNumber(imagesTemp.getImageNumber());
                        selectedImage.setHeight(imagesTemp.getHeight());
                        selectedImage.setWidth(imagesTemp.getWidth());
                        selectedImage.setUrl(imagesTemp.getUrl());

                        System.out.println("Imagen seleccionada: --->>>" + selectedImage.toString());

                    } catch (JDOMException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });

                gpn_list.add(imageView, 0, i);

            }

            scrollPane.setContent(gpn_list);
        } catch (JDOMException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectedImage = new Images("002-vegetables", 2, 30, 30, "Icon/002-vegetables.png");
        loadImages();
    }

}
