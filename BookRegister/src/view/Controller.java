/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.CollectionOfBooks;


/**
 *
 * @author FarHad
 */
public final class Controller {
    
    private View view= new View();
    private CollectionOfBooks model= new CollectionOfBooks();
    
    public Controller(View view, CollectionOfBooks model)
    {
        this.view=view;
        this.model=model;
    }
    
    public Controller(View view)
    {
        this.view=view;
        this.model=model;
    }
    
    public void handleExit(){
        view.exitFile();
    }
    
    
}
