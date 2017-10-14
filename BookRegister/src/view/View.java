/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;

import javafx.scene.control.SeparatorMenuItem;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.Book;
import model.CollectionOfBooks;
import model.Model;

/**
 *
 * @author FarHad
 */
public class View {

    private Model model= new Model();;
    private Button addButton;
    private Button removeButton;
    private Button sortButton;
    private Button searchButton;
    private Book book;

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
    TextField searchBar = new TextField();
    //Actions
    
    ObservableList<Book> obsListBook= FXCollections.observableArrayList(model.getCollectionOfBooks());
    private Stage stage; 

    private TableView<Book> tableView;

    public View(Stage primaryStage) {
        this.stage = primaryStage;
        start(primaryStage);
    }

    public View() {
    }

    public void start(Stage primaryStage) {

        
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(0, 0, 0, 0));
        rootPane.setStyle(" -fx-background-color: linear-gradient(from 25% 40% to 100% 100%, #FF8C00,#D75388)");

        GridPane gridParentBoxPane = new GridPane();
        gridParentBoxPane.setPadding(new Insets(0, 0, 0, 0));

        addButton = new Button("Add");
        removeButton = new Button("Remove");
        sortButton = new Button("Sort");
        searchButton = new Button("Search");
        tableView = new TableView<Book>();

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
        rbISBN = new RadioButton();
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
        menuFile.getItems().addAll(newFile, openFile, saveFile, new SeparatorMenuItem(), exitFile);

        menuOptions = new Menu("Options");
        addBooks = new MenuItem("Add New Book");
        removeBooks = new MenuItem("Remove Book");

        menuOptions.getItems().addAll(addBooks, removeBooks);

        menuAboutUs = new Menu("About");
        aboutTheDev = new MenuItem("Publishers");
        menuAboutUs.getItems().add(aboutTheDev);

        menuHelp = new Menu("Help");
        helpInstructions = new MenuItem("How to seach a book ?");
        menuHelp.getItems().addAll(helpInstructions);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuOptions, menuAboutUs, menuHelp);

        tableView.setEditable(true);

        TableColumn<Book, String> firstColumn = new TableColumn<>("Title");
        TableColumn<Book, String> thirdColumn = new TableColumn<>("Edition");
        TableColumn<Book, String> secondColumn = new TableColumn<>("ISBN");
        TableColumn<Book, String> fourthColumn = new TableColumn<>("Price");
        //TableColumn <Book,String> fifthColumn = new TableColumn("Author");

        model.addBook("575", "FarhadESur", 0, 0);

        //tableView.setItems(FXCollections.observableList(model.getCollectionOfBooks()));
        
        tableView.setItems(obsListBook);
        tableView.getColumns().addAll(firstColumn, thirdColumn, secondColumn, fourthColumn);
//        
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("Edition"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        final VBox tableVBox = new VBox();
        tableVBox.setSpacing(5);
        tableVBox.setPadding(new Insets(20, 10, 10, 10));
        tableVBox.getChildren().addAll(tableView);

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(95, 80, 10, 20));
        vbButtons.getChildren().addAll(addButton, removeButton, sortButton);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);
        hbButtons.setPadding(new Insets(5, 20, 10, 250));
        hbButtons.getChildren().addAll(rbTitle, rbISBN, rbAuthor);

        searchBar.setPromptText("Enter text...");

        HBox searchHbButton = new HBox();
        searchHbButton.setSpacing(10);
        searchHbButton.setPadding(new Insets(10, 20, 10, 250));
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

    public void initController(Controller controller) {
        this.initHandlers(controller);
    }

    private void initHandlers(Controller controller) {
        EventHandler exitHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleExit();
            }
        };

        EventHandler searchBarHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.clearEnterTextOnSearch();
            }
        };

        EventHandler openHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    controller.openFileChooser();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        EventHandler newHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //controller.clearEnterTextOnSearch();
            }
        };

        EventHandler addBookHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleAddBook();
            }
        };

        EventHandler removeBookHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleRemoveBook();
            }
        };

        EventHandler aboutHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.aboutButtonHandle();
            }
        };

        EventHandler helpHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.helpButtonHandle();
            }
        };
        
        EventHandler saveHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    controller.handleSaveFile();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        EventHandler createFileHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    controller.handleCreateFile();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        exitFile.setOnAction(exitHandler);
        saveFile.setOnAction(saveHandler);
        searchBar.setOnAction(searchBarHandler);
        openFile.setOnAction(openHandler);
        newFile.setOnAction(createFileHandler);

        addBooks.setOnAction(addBookHandler);
        addButton.setOnAction(addBookHandler);

        removeBooks.setOnAction(removeBookHandler);
        removeButton.setOnAction(removeBookHandler);

        menuAboutUs.setOnAction(aboutHandler);
        helpInstructions.setOnAction(helpHandler);

    }

    public void addBook() {

        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add New Book");

        // Set the button types.
        ButtonType saveButtonType = new ButtonType("Save", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");
        TextField edition = new TextField();
        edition.setPromptText("Edition");
        TextField isbn = new TextField();
        isbn.setPromptText("ISBN");
        TextField price = new TextField();
        price.setPromptText("Price");
//        TextField author = new TextField();
//        author.setPromptText("Author");

        gridPane.add(title, 1, 0);
        gridPane.add(edition, 1, 1);
        gridPane.add(isbn, 1, 2);
        gridPane.add(price, 1, 3);
//        gridPane.add(author, 1, 4);

        gridPane.add(new Label("Title"), 0, 0);
        gridPane.add(new Label("Edition"), 0, 1);
        gridPane.add(new Label("ISBN"), 0, 2);
        gridPane.add(new Label("Price"), 0, 3);
//        gridPane.add(new Label("Author"), 0, 4);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the username field by default.
        Platform.runLater(() -> title.requestFocus());

//        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                model.addBook(isbn.getText(),title.getText(),Integer.parseInt(edition.getText()), Double.parseDouble(price.getText()));
                tableView.getItems().add(book);
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            //System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
            ArrayList <Book> arrayListBook= (ArrayList <Book>) tableView.getItems();
            
        });
    }

    public void removeBook() {

        //ap.getChildren().remove(ap.lookup(removeButton));
        //tableView.getItems().remove(tableView.lookup(removeButton));
//        removeButton.setOnAction(e -> {
            
            
            Book selectedItem = tableView.getSelectionModel().getSelectedItem();

            tableView.getItems().remove(selectedItem);
            tableView.getSelectionModel().clearSelection();
            

//        });

    }

    public void setTableView() {

//        for (int i=0; i>5; i++)
//            tableView.getColumns().set(i, model.getCollectionOfBooks());
    }

    public void exitFile() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("");
        alert.setContentText(" Do want you exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            return;
        }
    }

    public void aboutInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("We are your BOSS boi getuppp!!");

        alert.showAndWait();

    }

    public void helpInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(" Dont add book ! Smoke grEEN !!");

        alert.showAndWait();
    }

    public void clearSearchBar() {
        searchBar.clear();
    }
    
    public String openFile() {
        String fileName = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        fileName = file.getName();
                    }
                 
        return fileName;
        }
    
    public String saveFile() {
        String fileName = "";
        fileName = "Fil1.ser";
        return fileName;
        
        }
    
    public String createFile() {
        String fileName = "";
        fileName = "Fil1.ser";
        return fileName;
        
        }
    
    public void updateTable(){
        tableView.setItems(obsListBook);
    }
        
}
