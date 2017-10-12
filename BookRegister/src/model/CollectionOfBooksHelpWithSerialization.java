package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Hints on how to implement serialization and deserialization in class
 * CollectionOfBooks.
 */
public class CollectionOfBooksHelpWithSerialization implements Serializable {

    private ArrayList<Book> theBooks = new ArrayList<Book>();

    // ...
    /**
     * Call this method before the application exits, to store the books, in
     * serialized form, on file the specified file.
     */
    public void serializeToFile(String filename) throws IOException {

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(filename));
            out.writeObject(theBooks);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Call this method at startup of the application, to deserialize the books
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public void deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {

        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(
                    new FileInputStream(filename));
            // readObject returns a reference of type Object, hence the down-cast
            theBooks = (ArrayList<Book>) in.readObject();
        } catch (Exception IOExeption) {
            System.out.println("File not found!");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Get all the books in hte list
     *
     * @return
     */
    public ArrayList<Book> getTheBooks() {
        return theBooks;
    }

    /**
     * Initializes the array list with the books
     *
     * @param books
     */
    public void setTheBooks(ArrayList<Book> books) {
        theBooks = books;
    }

}
