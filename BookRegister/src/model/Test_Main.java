package model;

/**
*
* @author FarHad Salehi and Tahir Sabe
*/
import java.util.ArrayList;
import java.util.Collections;

public class Test_Main {
	
	public static void main(String[] args) {
		
		Book bk5 = new Book("564541","Approch to Modern Programming",9,500);
		Book bk2 = new Book("742516","Approch to Modern Programming",14,700);
		Book bk1 = new Book("154878","Java, Guava & Mango",4,75);
		Book bk3 = new Book("784481","Math for Engineer",14,300);
		Book bk4 = new Book("162148","Zebras, zebras & more Zebra",0,250);
		
		ArrayList<Book> bkList = new ArrayList<>();  
		bkList.add(bk1);
		bkList.add(bk2);
		bkList.add(bk3);
		bkList.add(bk4);
		bkList.add(bk5);
//		System.out.println(bk1);
//		System.out.println(bk2);
//		System.out.println(bk3);
//		System.out.println(bk4);
//		System.out.println(bk5);
//		System.out.println(bkList);
		
		Author andersLindstrom = new Author("Anders Lindstr�m");
		Author armin = new Author("Armin");
		Author nicklas = new Author("Nicklas");
		Author notZebra = new Author("Not A Zebra");
		Author yared = new Author("Yared");
		Author farhad = new Author("Farhad");
		
		bk1.addAuthor(nicklas);
		bk2.addAuthor(andersLindstrom);
		bk3.addAuthor(yared);
		bk3.addAuthor(farhad);
		bk4.addAuthor(armin);
		bk5.addAuthor(notZebra);
		
		//System.out.println(bkList);
		bk1.removeAuthor(armin);
		bk1.removeAuthor(nicklas);
		//System.out.println(bkList);
		Collections.sort(bkList);
		//System.out.println(bkList);
		
		CollectionOfBooks collection = new CollectionOfBooks(bkList);
		//System.out.println(collection.toString());
//		System.out.println(collection.getBooksByAuthor(farhad));
//		System.out.println(collection.getBooksByAuthor("Anders Lindstr�m"));
//		System.out.println(collection.getBooksByISBN(bk4.getIsbn()));
//		System.out.println(collection.getBooksByTitle(bk4.getTitle()));
//		System.out.println(collection.toString());
		collection.removeBook(bk5);
		System.out.println(collection.toString());
	}

}
