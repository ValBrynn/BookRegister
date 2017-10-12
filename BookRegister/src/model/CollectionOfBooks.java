package model;

/**
 *
 * @author FarHad Salehi and Tahir Sabe
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CollectionOfBooks implements Serializable {

    private ArrayList<Book> books;

    public CollectionOfBooks() {
        books = new ArrayList<Book>();
    }

    /**
     * Initializes collectionofbooks with an arraylist type of Book
     *
     * @param books
     */
    public CollectionOfBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public int getNrOfBooks() {
        return books.size();
    }

    /**
     * Add a book to book list
     *
     * @param addedBook
     */
    public void addBook(Book addedBook) {
        books.add(addedBook);
    }

    /**
     * Remove a book from a book list
     *
     * @param removedBook
     */
    public void removeBook(Book removedBook) {
        books.remove(removedBook);
    }

    /**
     * Search and get a book by title
     *
     * @param title
     * @return
     */
    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> refOfBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                refOfBooks.add(b);
            }
        }
        return refOfBooks;
    }

    /**
     * Search and get a book by the author . Param is type of String
     *
     * @param author
     * @return
     */
    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> refOfBooks = new ArrayList<>();
        ArrayList<Author> authorlist = new ArrayList<>();
        for (Book b : books) {
            authorlist = b.getAuthors();
            for (Author a : authorlist) {
                if (a.getName().equals(author)) {
                    refOfBooks.add(b);
                }
            }
        }
        return refOfBooks;
    }

    /**
     * Search and get a book by the author . Param is type of Author
     *
     * @param author
     * @return
     */
    public ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> refOfBooks = new ArrayList<>();
        ArrayList<Author> authorlist = new ArrayList<>();
        for (Book b : books) {
            authorlist = b.getAuthors();
            if (authorlist.contains(author)) {
                refOfBooks.add(b);
            }
        }
        return refOfBooks;
    }

    /**
     * Search and get a book by ISBN
     *
     * @param isbn
     * @return
     */
    public ArrayList<Book> getBooksByISBN(String isbn) {
        ArrayList<Book> refOfBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                refOfBooks.add(b);
            }
        }
        return refOfBooks;
    }

    /**
     * Get all the books
     *
     * @return
     */
    public ArrayList<Book> getTheBooks() {
        return books;
    }

    @Override
    public String toString() {
        String info = " " + books;
        return info;
    }

}
