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
<<<<<<< HEAD
import javafx.scene.control.SeparatorMenuItem;
=======
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
>>>>>>> 98fbe641c5e4890de3a079cdb91497b5ce8b4a90
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
<<<<<<< HEAD
=======

    //public CollectionOfBooks model;
    private Button addButton;
    private Button removeButton;
    private Button sortButton;
    private Button searchButton;
>>>>>>> 98fbe641c5e4890de3a079cdb91497b5ce8b4a90
    
    //MenuBar
    private Menu menuFile;
    private Menu menuActions;
    private Menu menuAboutUs;
    private Menu menuHelp;
    private MenuItem newFile;
    private MenuItem openFile;
    private MenuItem saveFile;
    private MenuItem exitFile;
    private MenuItem addBooks;
    private MenuItem removeBooks;
    private MenuItem sortBooks;
    private MenuItem aboutTheDev;
    private MenuItem aboutTheProgram;
    private MenuItem helpInstructions;
    //SearchBar
    private ArrayList<RadioButton> searchByButtons;
    private RadioButton rbTitle;
    private RadioButton rbISBN;
    private RadioButton rbAuthor;
    //Actions
    private Button addButton;
    private Button removeButton;
    private Button sortButton;
    
<<<<<<< HEAD
    @Override
    public void start(Stage primaryStage) {

=======
    private TableView tableView;
    
    @Override
    public void start(Stage primaryStage) {

        // model= new CollectionOfBooks();

>>>>>>> 98fbe641c5e4890de3a079cdb91497b5ce8b4a90
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(20, 0, 20, 20));
        rootPane.setStyle(" -fx-background-color: linear-gradient(from 25% 40% to 100% 100%, #FF8C00,#D75388)");
       
        GridPane gridParentBoxPane = new GridPane();
        rootPane.setPadding(new Insets(20, 0, 20, 90));
        
        addButton = new Button("Add");
<<<<<<< HEAD
=======
        removeButton = new Button("Remove");
        sortButton = new Button("Sort");
        searchButton= new Button("Search");
        tableView= new TableView();
        
>>>>>>> 98fbe641c5e4890de3a079cdb91497b5ce8b4a90
        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton = new Button("Remove");
        removeButton.setMaxWidth(Double.MAX_VALUE);
        sortButton = new Button("Sort");
        sortButton.setMaxWidth(Double.MAX_VALUE);
        searchButton.setMaxWidth(Double.MAX_VALUE);
        
        rbTitle = new RadioButton();
        rbTitle.setText("Title");
        rbISBN  = new RadioButton();
        rbISBN.setText("ISBN");    
        rbAuthor = new RadioButton();
        rbAuthor.setText("Author");
        
<<<<<<< HEAD
        searchByButtons = new ArrayList<RadioButton>();
        searchByButtons.add(rbTitle); 
        searchByButtons.add(rbISBN);
        searchByButtons.add(rbAuthor);
        
        menuFile = new Menu("File");
        newFile = new MenuItem("New");
        openFile = new MenuItem("Open");
        saveFile = new MenuItem("Save");
        exitFile = new MenuItem("Exit");
        
        menuFile.getItems().addAll(newFile,openFile,saveFile,new SeparatorMenuItem(),exitFile);
        
        MenuBar menuBar = new MenuBar();  
        menuBar.getMenus().addAll(menuFile);
=======
        tableView.setEditable(true);
        
        TableColumn firstColumn= new TableColumn("Title");
        TableColumn thirdColumn= new TableColumn("Edition");
        TableColumn secondColumn= new TableColumn("ISBN");
        TableColumn fourthColumn= new TableColumn("Author");
        TableColumn fifthColumn= new TableColumn("Price");
        
        tableView.getColumns().addAll(firstColumn,thirdColumn,secondColumn, fourthColumn,fifthColumn);
        final VBox tableVBox= new VBox();
        tableVBox.setSpacing(5);
        tableVBox.setPadding(new Insets(10,10,10,10));
        tableVBox.getChildren().addAll(tableView);
>>>>>>> 98fbe641c5e4890de3a079cdb91497b5ce8b4a90
        
        VBox vbButtons= new VBox();  
        vbButtons.setSpacing(30);
        vbButtons.setPadding( new Insets(95,80,10,20));
        vbButtons.getChildren().addAll(addButton,removeButton, sortButton);
        
        HBox hbButtons= new HBox();  
        hbButtons.setSpacing(10);
        hbButtons.setPadding( new Insets(5,20,10,250));
        hbButtons.getChildren().addAll(rbTitle,rbISBN,rbAuthor);
        
        
        TextField searchBar = new TextField();
        searchBar.setText("´Enter text...");
        searchBar.setText("");
        
        HBox  searchHbButton= new HBox();
        searchHbButton.setSpacing(10);
        searchHbButton.setPadding( new Insets(10,20,10,250));
        searchHbButton.getChildren().addAll(searchBar, searchButton);
        
        gridParentBoxPane.add(menuBar, 0, 0);
        gridParentBoxPane.add(hbButtons, 0, 1);
        gridParentBoxPane.add(searchHbButton, 0, 2);
        
        primaryStage.setResizable(false);
        rootPane.setRight(vbButtons);
        rootPane.setTop(gridParentBoxPane);
        rootPane.setCenter(tableView);
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
