/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CollectionOfBooks;

/**
 *
 * @author FarHad
 */
public class View extends Application {

    //public CollectionOfBooks model;
    private Button addButton;
    private Button removeButton;
    private Button sortButton;
    
    private ArrayList<RadioButton> searchButtons;
    private RadioButton rbTitle;
    private RadioButton rbISBN;
    private RadioButton rbAuthor;
    
    
    @Override
    public void start(Stage primaryStage) {

        // model= new CollectionOfBooks();

        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(20, 0, 20, 20));
        rootPane.setStyle(" -fx-background-color: linear-gradient(from 25% 40% to 100% 100%, #FF8C00,#D75388)");
       
        GridPane gridParentBoxPane = new GridPane();
        rootPane.setPadding(new Insets(20, 0, 20, 90));
        
        addButton = new Button("Add");
        removeButton = new Button("Remove");
        sortButton = new Button("Sort");

        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton.setMaxWidth(Double.MAX_VALUE);
        sortButton.setMaxWidth(Double.MAX_VALUE);
        
        rbTitle = new RadioButton();
        rbISBN  = new RadioButton();
        rbAuthor  = new RadioButton();
        
        rbTitle.setText("Title");
        rbISBN.setText("ISBN");
        rbAuthor.setText("Author");
        
        VBox vbButtons= new VBox();  
        vbButtons.setSpacing(30);
        vbButtons.setPadding( new Insets(95,80,10,20));
        vbButtons.getChildren().addAll(addButton,removeButton, sortButton);
        
        HBox hbButtons= new HBox();  
        hbButtons.setSpacing(10);
        hbButtons.setPadding( new Insets(5,20,10,250));
        hbButtons.getChildren().addAll(rbTitle,rbISBN,rbAuthor);
        
        
        TextField searchBar = new TextField();
        searchBar.setText("");
        
        HBox  searchHbButton= new HBox();
        searchHbButton.setSpacing(10);
        searchHbButton.setPadding( new Insets(10,20,10,250));
        searchHbButton.getChildren().add(searchBar);
        
        gridParentBoxPane.add(hbButtons, 0, 0);
        gridParentBoxPane.add(searchHbButton, 0, 1);
        
        primaryStage.setResizable(false);
        rootPane.setRight(vbButtons);
        rootPane.setTop(gridParentBoxPane);
        Scene scene = new Scene(rootPane, 800, 500);
        
        primaryStage.setTitle("Tahirs Book Register");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /*private final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private void showAlert(String message) {
        alert.setHeaderText("");
        alert.setTitle("Alert!");
        alert.setContentText(message);
        alert.show();
    }*/
    public static void main(String[] args) {
        launch(args);
    }

}
