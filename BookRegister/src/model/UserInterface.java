package model;

/**
 *
 * @author FarHad Salehi and Tahir Sabe
 */
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface implements Serializable {

    private Scanner scan = new Scanner(System.in);
    private CollectionOfBooks collectionOfBooks;
    private CollectionOfBooksHelpWithSerialization ser;
    private String fileName;

    /**
     *
     */
    public UserInterface() {
        scan = new Scanner(System.in);
        collectionOfBooks = new CollectionOfBooks();
        ser = new CollectionOfBooksHelpWithSerialization();
        fileName = " ";
    }

    /**
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void run() throws ClassNotFoundException, IOException {
        char choice = ' ';
        String answer;

        do {
            printMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0);

            switch (choice) {
                case 'A':
                    addBook();
                    break;
                case 'R':
                    removeBook();
                    break;

                case 'T':

                    System.out.println("Enter Title:  ");
                    getBooksByTitle(scan.nextLine());
                    break;
                case 'W':
                    System.out.println("Enter Author:  ");
                    getBooksByAuthor(scan.nextLine());
                    break;
                case 'I':
                    System.out.println("Enter ISBN:  ");
                    getBooksByISBN(scan.nextLine());
                    break;
                case 'Z':
                    System.out.println(getAllBooks());
                    break;
                case 'X':
                    System.out.println(this.getAllBooks());
                    ser.setTheBooks(collectionOfBooks.getTheBooks());
                    ser.serializeToFile(fileName);
                    System.out.println("Exiting..!");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } while (choice != 'X');
    }

    /**
     * Adds book to the list and the file
     */
    public void addBook() {
        String isbn, title, name;
        String answer = " ";
        int edition;
        double price;
        Author newAuthor;
        int add;

        System.out.println("input in this order: ISBN, title, edition, "
                + "\nprice & Author");

        isbn = scan.nextLine();
        title = scan.nextLine();
        edition = Integer.parseInt(scan.nextLine());
        price = Double.parseDouble(scan.nextLine());
        Book book = new Book(isbn, title, edition, price);

        do {
            add = 0;
            name = scan.nextLine();
            newAuthor = new Author(name);
            book.addAuthor(newAuthor);
            System.out.println("Would you like to add another Author answer \"y\" then");
            answer = scan.nextLine();
            if (answer.compareToIgnoreCase("y") == 0) {
                add = 1;
            }
        } while (add == 1);
        collectionOfBooks.addBook(book);

    }

    /**
     * Removes a book from the list and the file
     */
    public void removeBook() {

        int answer;
        String toRemove = " ";
        ArrayList<Book> removedBooks = new ArrayList<Book>();

        System.out.println("Do you want to search and remove by 1- Title 2- Author 3- ISBN ");
        answer = Integer.parseInt(scan.nextLine());

        System.out.println(answer);

        switch (answer) {

            case 1:
                System.out.println("Enter title: ");
                toRemove = scan.nextLine();
                removedBooks = collectionOfBooks.getBooksByTitle(toRemove);
                break;
            case 2:
                System.out.println("Enter Author(s):");
                toRemove = scan.nextLine();
                removedBooks = collectionOfBooks.getBooksByAuthor(toRemove);
                break;
            case 3:
                System.out.println("Enter ISBN: ");
                toRemove = scan.nextLine();
                removedBooks = collectionOfBooks.getBooksByISBN(toRemove);
                break;
            default:
                System.out.println("Unknown command");

        }
        for (Book b : removedBooks) {
            collectionOfBooks.removeBook(b);
        }

    }

    /**
     *
     * @param title
     */
    public void getBooksByTitle(String title) {

        System.out.println(collectionOfBooks.getBooksByTitle(title).toString());
    }

    /**
     *
     * @param author
     */
    public void getBooksByAuthor(String author) {
        System.out.println((collectionOfBooks.getBooksByAuthor(author).toString()));
    }

    /**
     *
     * @param isbn
     */
    public void getBooksByISBN(String isbn) {
        System.out.println(collectionOfBooks.getBooksByISBN(isbn).toString());
    }

    /**
     *
     * @return
     */
    public String getAllBooks() {
        return collectionOfBooks.toString();
    }

    /**
     * Prints Menu
     */
    public void printMenu() {
        System.out.println("---Menu---");
        System.out.println("A To Add a Book");
        System.out.println("R To Remove a Book");
        System.out.println("T To get Books by a given Title");
        System.out.println("W To get Books by a given Writer");
        System.out.println("I To get Books by a given ISBN");
        System.out.println("Z To get All Books");
        System.out.println("X Exit");
        System.out.println("----------");
    }

    /**
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void chooseFile() throws ClassNotFoundException, IOException {
        System.out.println("\nChoose a filename:");
        fileName = scan.nextLine();
        fileName += ".ser";
        System.out.println(fileName);
        ser.deSerializeFromFile(fileName);
        if (ser.getTheBooks() == null) {
            collectionOfBooks = new CollectionOfBooks();
        } else {
            collectionOfBooks = new CollectionOfBooks(ser.getTheBooks());
        }
    }

    /**
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        UserInterface menu = new UserInterface();
        menu.chooseFile();
        menu.run();
    }
}
