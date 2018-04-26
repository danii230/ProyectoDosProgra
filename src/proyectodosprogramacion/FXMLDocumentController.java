/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodosprogramacion;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import org.w3c.dom.Text;


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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void accionBoton(ActionEvent event) {

        gridPane.getChildren().clear();
        
        
        int filas = Integer.parseInt(tfNumeroFilas.getText());
        int columnas = Integer.parseInt(tfNumeroColumnas.getText());
         //gridPane.resize(columnas, filas);
 
 
     
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {

           // ImageView imagenes = new ImageView();
//               gridPane.addColumn(j, imagenes);
//               gridPane.addRow(i, imagenes);
//                System.out.println("entra");
                Rectangle rect = new Rectangle(100, 100);
                rect.setFill(null);
                rect.setStroke(Color.BLACK);
                gridPane.add(rect, j, i);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setValignment(rect, VPos.TOP);
                rect.onMouseClickedProperty();
                
               
//                gridPane.getColumnConstraints().add(new ColumnConstraints(400));

            }
            
            
        }

    }
    

}
