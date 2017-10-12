package model;


/**
 *
* @author FarHad Salehi and Tahir Sabe
 */

import java.io.Serializable;

public class Author implements Serializable{

    private String name;
    
    public Author() {
       name= "";
    }
    
    /**
    * Initializes a new Author with name
    * @param name 
    */
    
    public Author( String name ) {
       this.name=name;
    }
    
    /*
      Method returns the author
    */
    public String getName() {
       return name;
    }
     
     /**
    * Initializes an Author with name
    * @param name 
    */
    
    public void setNewName(String name) {
        this.name=name;
    }
    
    @Override
    public String toString() {
       return name;
    }
}
