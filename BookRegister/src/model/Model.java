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
        collectionOfBooks = new CollectionOfBooks();
    }
    
    public void saveFile(String filename) throws IOException, ClassNotFoundException{
        ser.setTheBooks(collectionOfBooks.getTheBooks());
        ser.serializeToFile(filename);      
    }
    
    public void openFile(String filename) throws IOException, ClassNotFoundException{
        ser.deSerializeFromFile(filename);
        collectionOfBooks = new CollectionOfBooks(ser.getTheBooks());
    }
    
//    public void addBook(String isbn, String title, int edition, double price) {
//        Book addedBook = new Book(isbn,title,edition,price);
//        collectionOfBooks.addBook(addedBook);
//    }
    
    public void addBook(String isbn, String title, int edition, double price,
            ArrayList <String> authors) {
        Book addedBook = new Book(isbn,title,edition,price);
        for(String s :authors){
            addedBook.addAuthor(new Author(s));
        }
        collectionOfBooks.addBook(addedBook);
    }
    
//    private void addAuthors(ArrayList <String> authors, Book b){
//        for(String newAuthor: authors){
//            b.addAuthor(new Author(newAuthor));
//        }
//    }
    
    public void removeBook(Book b){
        collectionOfBooks.removeBook(b);
    }
    
    public void sortBy(){
    }
    
    public ArrayList<Book> getBookByTitle(String title){
        return collectionOfBooks.getBooksByTitle(title); 
    }
    
    public ArrayList<Book> getBookByISBN(String ISBN){
      
         return collectionOfBooks.getBooksByISBN(ISBN);
    }
    
    public ArrayList<Book> getBookByAuthor(String Author){
      
         return collectionOfBooks.getBooksByAuthor(Author);
    }

    
    public ArrayList<Book> getCollectionOfBooks(){
        return collectionOfBooks.getTheBooks();
    }
}
