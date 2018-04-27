/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;

<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> 8b04c636b71e2a3933c20218642b31ca16fa62c8
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

import javafx.scene.shape.Rectangle;
<<<<<<< HEAD
import org.jdom.JDOMException;
=======
import javafx.scene.text.Text;

import proyectodosprogramacion.FXMLDocumentController.accion;
>>>>>>> 8b04c636b71e2a3933c20218642b31ca16fa62c8

/**
 *
 * @author daniela
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane2;
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

    ////ListaImagenes
    @FXML
    private AnchorPane listaImagenes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD

        try {
            FileArmacabeza fileArmacabeza = new FileArmacabeza();
            //ListaImagenes
            LinkedList<Image> imageList = fileArmacabeza.listImage("xml");
            for (int i = 0; i < imageList.size(); i++) {
                ImageView imageView = new ImageView(imageList.get(i).getUrl());
                listaImagenes.getChildren().add(imageView);

            }
        } catch (JDOMException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

=======
        // gridPane.setOnMouseClicked(new accion());
>>>>>>> 8b04c636b71e2a3933c20218642b31ca16fa62c8
    }

    @FXML
    private void accionBoton(ActionEvent event) {

        gridPane.getChildren().clear();

        int filas = Integer.parseInt(tfNumeroFilas.getText());
        int columnas = Integer.parseInt(tfNumeroColumnas.getText());
        //gridPane.resize(columnas, filas);

<<<<<<< HEAD
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {

=======
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Tile tile = new Tile();
                  gridPane.setAlignment(Pos.TOP_LEFT);
               gridPane.setValignment(tile, VPos.TOP);
               gridPane.add(tile, j, i);
>>>>>>> 8b04c636b71e2a3933c20218642b31ca16fa62c8
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

<<<<<<< HEAD
=======
        }

    }

    public class Tile extends StackPane {

        private Text text = new Text();

        public Tile() {
            Rectangle rect = new Rectangle(130, 135);
            rect.setFill(null);
            rect.setStroke(Color.BLACK);

//            gridPane.setAlignment(Pos.TOP_LEFT);
//            gridPane.setValignment(rect, VPos.TOP);
            getChildren().addAll(rect, text);
            setOnMouseClicked(event -> {
                  drawX();
            });
        }

        private void drawX() {
            text.setText("hola");
        }
    }

    public class accion implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
//            int filas = Integer.parseInt(tfNumeroFilas.getText());
//            int columnas = Integer.parseInt(tfNumeroColumnas.getText());

            ImageView imagen = new ImageView("/imagen/0b4b5b9f-8521-42d8-8a6b-7f64d371f42f.jpg");
            //  gridPane.add(imagen, 0, 0);

            Node source = (Node) event.getSource();
            Integer columna = gridPane.getColumnIndex(source);
            Integer fila = gridPane.getRowIndex(source);
            gridPane.add(imagen, columna, fila);
            System.out.println(fila);

//        //            
//// 
////         
//            gridPane.add(imagen, columna, fila);
//            int x = (int) event.getSceneX();
//            int y = (int) event.getSceneY();
//            gridPane.add(imagen, x, y);
            System.out.println("entra");

>>>>>>> 8b04c636b71e2a3933c20218642b31ca16fa62c8
        }

    }

}
