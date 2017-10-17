/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import java.awt.Graphics;

import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import model.Author;
import model.Book;
import model.CollectionOfBooks;
import model.Model;

/**
 *
 * @author FarHad
 */
public class View {

    private Model model;
    private TableView<Book> tableView;
    private Book book;
    private String fileName;
    ToggleGroup sortBy;

    //KeyButtons Main Actions
    private Button addButton;
    private Button removeButton;
    private Button refreshButton;
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
    private MenuItem aboutTheDev;
    private MenuItem helpInstructions;
    //SearchBar
    private TextField searchField;
    private RadioButton rbTitle;
    private RadioButton rbISBN;
    private RadioButton rbAuthor;
    private Stage stage;

    public View(Stage primaryStage) {
        model = new Model();
        tableView = new TableView<Book>();
        searchField = new TextField();
        this.stage = primaryStage;
        start(primaryStage);
    }

    public View() {
    }

    public void start(Stage primaryStage) {

        //Border Pane (top,bottom,left,right)
        BorderPane rootPane = new BorderPane();
        rootPane.setPadding(new Insets(0, 0, 0, 0));

        Image image = new Image("Image/bk.jpg");
        ImageView pic = new ImageView();
        pic.setFitWidth(800);
        pic.setFitHeight(500);
        pic.setImage(image);
        rootPane.getChildren().add((pic));

        //Grid Pane
        GridPane gridParentBoxPane = new GridPane();
        gridParentBoxPane.setPadding(new Insets(0, 0, 0, 0));

        addButton = new Button("Add");
        removeButton = new Button("Remove");
        refreshButton = new Button("Refresh");
        searchButton = new Button("Search");

        addButton.setMaxWidth(Double.MAX_VALUE);
        removeButton.setMaxWidth(Double.MAX_VALUE);
        refreshButton.setMaxWidth(Double.MAX_VALUE);
        searchButton.setMaxWidth(Double.MAX_VALUE);

        //Radio Buttons and Search
        searchField.setPromptText("Enter text...");
        sortBy = new ToggleGroup();
        rbTitle = new RadioButton();
        rbTitle.setText("Title");
        rbTitle.setTextFill(Color.ORANGE);
        rbTitle.setToggleGroup(sortBy);
        rbISBN = new RadioButton();
        rbISBN.setText("ISBN");
        rbISBN.setTextFill(Color.ORANGE);
        rbISBN.setToggleGroup(sortBy);
        rbAuthor = new RadioButton();
        rbAuthor.setText("Author");
        rbAuthor.setTextFill(Color.ORANGE);
        rbAuthor.setToggleGroup(sortBy);

        //Menu (File) 
        menuFile = new Menu("File");
        newFile = new MenuItem("New");
        openFile = new MenuItem("Open");
        saveFile = new MenuItem("Save");
        exitFile = new MenuItem("Exit");
        menuFile.getItems().addAll(newFile, openFile, saveFile, new SeparatorMenuItem(), exitFile);

        //Menu (Options)
        menuOptions = new Menu("Options");
        addBooks = new MenuItem("Add New Book");
        removeBooks = new MenuItem("Remove Book");
        menuOptions.getItems().addAll(addBooks, removeBooks);

        //Menu(About Us)
        menuAboutUs = new Menu("About");
        aboutTheDev = new MenuItem("About Book Register");
        menuAboutUs.getItems().add(aboutTheDev);

        //Menu (Help)
        menuHelp = new Menu("Help");
        helpInstructions = new MenuItem("How to use Book Register");
        menuHelp.getItems().addAll(helpInstructions);

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuOptions, menuAboutUs, menuHelp);

        //Table
        setTableView();

        //Boxes 
        VBox tableVBox = new VBox();
        tableVBox.setSpacing(5);
        tableVBox.setPadding(new Insets(10, 50, 20, 100));
        tableVBox.getChildren().addAll(tableView);

        VBox vbButtons = new VBox();
        vbButtons.setSpacing(30);
        vbButtons.setPadding(new Insets(107, 44, 16, 10));
        vbButtons.getChildren().addAll(addButton, removeButton, refreshButton);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10);
        hbButtons.setPadding(new Insets(10, 100, 5, 100));
        hbButtons.getChildren().addAll(rbTitle, rbISBN, rbAuthor);

        HBox searchHbButton = new HBox();
        searchHbButton.setSpacing(10);
        searchHbButton.setPadding(new Insets(10, 100, 10, 100));
        searchHbButton.getChildren().addAll(searchField, searchButton);

        HBox menuBarBox = new HBox();
        menuBarBox.setSpacing(10);
        menuBarBox.setPadding(new Insets(0, 0, 10, 0));
        menuBarBox.getChildren().addAll(menuBar);

        //Set-Up of Grid Pane with the Menu,RadioButtons,Search
        gridParentBoxPane.add(menuBarBox, 0, 0);
        gridParentBoxPane.add(hbButtons, 2, 2);
        gridParentBoxPane.add(searchHbButton, 2, 3);

        //Set-Up of Border Pane (rootPane)
        primaryStage.setResizable(false);
        rootPane.setRight(vbButtons);
        rootPane.setTop(gridParentBoxPane);
        rootPane.setCenter(tableVBox);

        Scene scene = new Scene(rootPane, 800, 500);
        primaryStage.setTitle("Book Register");
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

        EventHandler pressXHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("heloooooooooooooooo");

            }
        };
        EventHandler openHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    model.openFile(openFile());
                    controller.openFileChooser();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        EventHandler addBookHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleAddBook();
                updateTable();
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
                    model.saveFile(saveFile());
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
                    model.createFile(createFile());
                    controller.handleCreateFile();
                } catch (IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        EventHandler searchHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.handleSearchBar();
                controller.clearEnterTextOnSearch();
            }
        };

        EventHandler refreshHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                updateTable();
            }
        };

        exitFile.setOnAction(exitHandler);
        saveFile.setOnAction(saveHandler);
        searchField.setOnAction(searchHandler);
        openFile.setOnAction(openHandler);
        newFile.setOnAction(createFileHandler);

        addBooks.setOnAction(addBookHandler);
        addButton.setOnAction(addBookHandler);

        removeBooks.setOnAction(removeBookHandler);
        removeButton.setOnAction(removeBookHandler);

        refreshButton.setOnAction(refreshHandler);

        menuAboutUs.setOnAction(aboutHandler);
        helpInstructions.setOnAction(helpHandler);

        searchButton.setOnAction(searchHandler);

    }

    public void addBook() {

        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add New Book");
        dialog.setHeaderText("Multiple Authors must be\n separated with a : '-'");

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
        TextField author = new TextField();
        author.setPromptText("Author");

        gridPane.add(title, 1, 0);
        gridPane.add(edition, 1, 1);
        gridPane.add(isbn, 1, 2);
        gridPane.add(price, 1, 3);
        gridPane.add(author, 1, 4);

        gridPane.add(new Label("Title"), 0, 0);
        gridPane.add(new Label("Edition"), 0, 1);
        gridPane.add(new Label("ISBN"), 0, 2);
        gridPane.add(new Label("Price"), 0, 3);
        gridPane.add(new Label("Authors"), 0, 4);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the username field by default.
        Platform.runLater(() -> title.requestFocus());

//        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                try {
                    String[] authors;
                    if (author.getText().contains("-")) {
                        // Split
                        authors = author.getText().split("-");
                    } 
                    else {
                        authors = new String[1];
                        authors[0] = author.getText();
                    }
                    if (isbn.getText().isEmpty() ||  title.getText().isEmpty() || authors.length==0  )
                      throw new Exception(); 
                    model.addBook(isbn.getText(), title.getText(), Integer.parseInt(edition.getText()),
                            Double.parseDouble(price.getText()), authors);
                     
                } catch (Exception e) {
                    
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Check the entered data.");
                    alert.showAndWait();

                }
                updateTable();
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {        
        });
    }

    public void removeBook() {
        Book selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);
        updateTable();
    }

    public void setTableView() {

        TableColumn<Book, String> firstColumn = new TableColumn<>("Title");
        firstColumn.setMinWidth(100);
        TableColumn<Book, String> thirdColumn = new TableColumn<>("Edition");
        thirdColumn.setMinWidth(70);
        TableColumn<Book, String> secondColumn = new TableColumn<>("ISBN");
        secondColumn.setMinWidth(90);
        TableColumn<Book, String> fourthColumn = new TableColumn<>("Price");
        fourthColumn.setMinWidth(70);
        TableColumn<Book, String> fifthColumn = new TableColumn<>("Author");

        tableView.setEditable(true);
        tableView.getColumns().addAll(firstColumn, thirdColumn, secondColumn, fourthColumn, fifthColumn);

        tableView.setItems(FXCollections.observableList(model.getCollectionOfBooks()));
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        thirdColumn.setCellValueFactory(new PropertyValueFactory<>("edition"));
        fourthColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        fifthColumn.setCellValueFactory(new PropertyValueFactory<>("authors"));
    }

    public void radioButtons() {

        if (rbTitle.isSelected()) {
            ArrayList<Book> selectedBooks = model.getBookByTitle(searchField.getText());
            tableView.setItems(FXCollections.observableList(selectedBooks));
        } else if (rbISBN.isSelected()) {
            ArrayList<Book> selectedBooks = model.getBookByISBN(searchField.getText());
            tableView.setItems(FXCollections.observableList(selectedBooks));
        } else if (rbAuthor.isSelected()) {
            ArrayList<Book> selectedBooks = model.getBookByAuthor(searchField.getText());
            tableView.setItems(FXCollections.observableList(selectedBooks));
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Choose To Search By Title/ISBN/Author");
            alert.showAndWait();
        }

    }

    public void exitFile() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("");
        alert.setContentText(" Do want you to exit?");

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
        alert.setContentText("© 2017 FrostGrupp,Inc.\n All rights reserved\n Thank you for using this free Application. We hope you like it. \n Farhad Salehi and Tahir Sabe\n");
        alert.showAndWait();
    }

    public void helpInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Book Register is a simple but effective and smooth application for registering and sorting books.It is also possible to search books by the Title, ISBN and Author(s).You can also delete any book you want\n ");
        alert.showAndWait();
    }

    public void clearSearchBar() {
        searchField.clear();
    }

    public String openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            fileName = file.getName();
        }

        return fileName;
    }

    public String saveFile() {
        return fileName;

    }

    public String createFile() {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Create New File");

        // Set the button types.
        ButtonType saveButtonType = new ButtonType("Create", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 150, 10, 10));

        TextField fileNameField = new TextField();
        fileNameField.setPromptText("Enter fileName");

        gridPane.add(fileNameField, 1, 0);

        gridPane.add(new Label("File"), 0, 0);

        dialog.getDialogPane().setContent(gridPane);

        // Request focus on the username field by default.
        Platform.runLater(() -> fileNameField.requestFocus());

//        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                try {
                    fileName = fileNameField.getText();
                    fileName += ".ser";
                } catch (Exception e) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("U cant mess this up");
                    alert.showAndWait();

                }
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            //System.out.println("From=" + pair.getKey() + ", To=" + pair.getValue());
            //ArrayList <Book> arrayListBook= (ArrayList <Book>) tableView.getItems();

        });
        return fileName;
    }

    public void updateTable() {
        tableView.setItems(FXCollections.observableList(model.getCollectionOfBooks()));
    }

}
