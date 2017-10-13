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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

import javafx.scene.control.SeparatorMenuItem;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

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
public class View {

    //public CollectionOfBooks model;
    private Button addButton;
    private Button removeButton;
    private Button sortButton;
    private Button searchButton;

    
    //MenuBar
    private Menu menuFile;
    private Menu menuOptions;
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
    private RadioButton rbTitle;
    private RadioButton rbISBN;
    private RadioButton rbAuthor;
    //Actions
 
    private TableView tableView;
 
    public View(Stage primaryStage){
        start(primaryStage);
    }
    
    public View(){
    }
            
    
    public void start(Stage primaryStage) {

        // model= new CollectionOfBooks();
        
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(0, 0, 0, 0));
        rootPane.setStyle(" -fx-background-color: linear-gradient(from 25% 40% to 100% 100%, #FF8C00,#D75388)");
       
        GridPane gridParentBoxPane = new GridPane();
        gridParentBoxPane.setPadding(new Insets(0, 0, 0, 0));
        
        addButton = new Button("Add");
        removeButton = new Button("Remove");
        sortButton = new Button("Sort");
        searchButton= new Button("Search");
        tableView= new TableView();
        

        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton = new Button("Remove");
        removeButton.setMaxWidth(Double.MAX_VALUE);
        sortButton = new Button("Sort");
        sortButton.setMaxWidth(Double.MAX_VALUE);
        searchButton.setMaxWidth(Double.MAX_VALUE);
        
        ToggleGroup sortBy = new ToggleGroup();
        
        rbTitle = new RadioButton();
        rbTitle.setText("Title");
        rbTitle.setToggleGroup(sortBy);
        rbISBN  = new RadioButton();
        rbISBN.setText("ISBN");    
        rbISBN.setToggleGroup(sortBy);
        rbAuthor = new RadioButton();
        rbAuthor.setText("Author");
        rbAuthor.setToggleGroup(sortBy);
        
        menuFile = new Menu("File");
        newFile = new MenuItem("New");
        openFile = new MenuItem("Open");
        saveFile = new MenuItem("Save");
        exitFile = new MenuItem("Exit");
        menuFile.getItems().addAll(newFile,openFile,saveFile,new SeparatorMenuItem(),exitFile);
        
        menuOptions= new Menu("Options");
        addBooks= new MenuItem("Add New Book");
        removeBooks= new MenuItem("Remove Book");
        
        menuOptions.getItems().addAll(addBooks,removeBooks);
        
        menuAboutUs= new Menu ("About");
        aboutTheDev= new MenuItem("THE Real Gukoooooo");
        menuAboutUs.getItems().add(aboutTheDev);
        
        menuHelp=  new Menu("Help");
        helpInstructions= new MenuItem("Hhahahah U dumb as Gokuuu");
        menuHelp.getItems().addAll(helpInstructions);
        
        MenuBar menuBar = new MenuBar();  
        menuBar.getMenus().addAll( menuFile,menuOptions,menuAboutUs, menuHelp);

        tableView.setEditable(true);
        
        TableColumn firstColumn= new TableColumn("Title");
        TableColumn thirdColumn= new TableColumn("Edition");
        TableColumn secondColumn= new TableColumn("ISBN");
        TableColumn fourthColumn= new TableColumn("Price");
        TableColumn fifthColumn= new TableColumn("Author");
        
        tableView.getColumns().addAll(firstColumn,thirdColumn,secondColumn, fourthColumn,fifthColumn);
        final VBox tableVBox= new VBox();
        tableVBox.setSpacing(5);
        tableVBox.setPadding(new Insets(20,10,10,10));
        tableVBox.getChildren().addAll(tableView);

        
        VBox vbButtons= new VBox();  
        vbButtons.setSpacing(30);
        vbButtons.setPadding( new Insets(95,80,10,20));
        vbButtons.getChildren().addAll(addButton,removeButton, sortButton);
        
        HBox hbButtons= new HBox();  
        hbButtons.setSpacing(10);
        hbButtons.setPadding( new Insets(5,20,10,250));
        hbButtons.getChildren().addAll(rbTitle,rbISBN,rbAuthor);
        
        
        TextField searchBar = new TextField();
        //searchBar.setText("´Enter text...");
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
    
    
    public void initController(Controller controller){
        this.initHandlers(controller);
    }
    
/*    private void initHandlers(Controller controller){
        exitFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.handleExit();
            }    
        });
    }
*/
    private void initHandlers(Controller controller){
        EventHandler exitHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleExit();
          }
        };
        
        exitFile.setOnAction(exitHandler);
        saveFile.setOnAction(exitHandler);
    }

 
    
    public void exitFile(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("yeah booooi");
        alert.setHeaderText("This is information for Farhad");
        alert.setContentText("Press OK if Farhad is stupid"
                + "\nPress Cancel if u know he is  ");
        alert.showAndWait();      
    }
}
