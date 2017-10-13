/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class Model {
    
    private CollectionOfBooks collectionOfBooks;
    private CollectionOfBooksHelpWithSerialization ser;
    
    public Model(){
        collectionOfBooks = new CollectionOfBooks();
        ser = new CollectionOfBooksHelpWithSerialization();
    }
    
    public void createFile(String filename) throws IOException{
        ser.serializeToFile(filename);
    }
    
    public void saveFile(String filename) throws IOException, ClassNotFoundException{
        ser.deSerializeFromFile(filename);
    }
    
    public void addBook(String isbn, String title, int edition, double price,
            ArrayList <String> authors) {
        Book addedBook = new Book(isbn,title,edition,price);
        addAuthors(authors, addedBook);
        collectionOfBooks.addBook(addedBook);
    }
    
    private void addAuthors(ArrayList <String> authors, Book b){
        for(String newAuthor: authors){
            b.addAuthor(new Author(newAuthor));
        }
    }
    
    public void removeBook(){
    }
    
    public void sortBy(){
    }
    
}
