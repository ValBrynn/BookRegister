/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.CollectionOfBooks;
import model.Model;


/**
 *
 * @author FarHad
 */
public final class Controller {
    
    private View view= new View();
    private Model model= new Model();
    
    public Controller(View view, Model model)
    {
        this.view=view;
        this.model=model;
    }
    
    public Controller(View view)
    {
        this.view=view;
    }
    
    public void handleAddBook()
    {
         view.addBook();
         view.updateTable();
    }
    public void handleRemoveBook()
    {
         view.removeBook();
    }
    
    public void handleSearchBar()
    {
      view.radioButtons();
    
    }

    public void handleLoadCollection(){
        view.setTableView();
    }
    
    public void handleExit(){
        view.exitFile();
    }
    public void aboutButtonHandle(){
        view.aboutInfo();
    }
    public void helpButtonHandle(){
       view.helpInfo();
    }
    
    public void clearEnterTextOnSearch(){
       view.clearSearchBar();
    }
    
    public void openFileChooser() throws IOException, ClassNotFoundException{
//       model.openFile(view.openFile());
       view.updateTable();
    }
    
    public void handleSaveFile() throws IOException, ClassNotFoundException {
//       model.saveFile(view.saveFile());
       view.updateTable();
    }
    
    public void handleCreateFile() throws IOException, ClassNotFoundException {
        //model.createFile(view.createFile());
        view.updateTable();
    }
    
}
