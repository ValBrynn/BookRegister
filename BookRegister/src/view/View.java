/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.CollectionOfBooks;


/**
 *
 * @author FarHad
 */
public class View extends Application{
    
     //public CollectionOfBooks model;
     private Button addButton;
     private Button removeButton;
     private Button sortButton;
     
     @Override
     public void start(Stage primaryStage){
     
    // model= new CollectionOfBooks();
     
     GridPane rootPane= new GridPane();
     rootPane.setAlignment(Pos.CENTER);
     rootPane.setPadding(new Insets(20,20, 20,20));
     rootPane.setVgap(10);
     rootPane.setHgap(10);
     
//     addButton.setMaxWidth(Double.MAX_VALUE);
//     removeButton.setMaxWidth(Double.MAX_VALUE);
//     sortButton.setMaxWidth(Double.MAX_VALUE);

      addButton= new Button("Add");
      removeButton= new Button("Remove");
      sortButton= new Button("Sort");
      
     rootPane.add(addButton, 0, 1);
     rootPane.add(removeButton, 1, 2);
     rootPane.add(sortButton,2, 3);
     
     

     
     
     Scene scene= new Scene(rootPane, 800, 500);
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
