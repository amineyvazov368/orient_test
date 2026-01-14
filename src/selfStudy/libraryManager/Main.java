package selfStudy.libraryManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        BookRepository bookRepository = new BookRepository(books);
        BookService bookService = new BookService(bookRepository);
        bookService.add(new Book(1, "Tarix", "Mr.Tom", true));
        bookService.add(new Book(2, "Kimya", "Mr.Qom", false));
        bookService.add(new Book(3, "Az-dili", "Mr.Yom", true));
        bookService.add(new Book(4, "Riyaziyyat", "Mr.Tum", false));

//        System.out.println("Butun kitablar: ");
//        bookService.getAllBooks();
//        System.out.println("Movcud kitablar: ");
//        bookService.getBooks();
        bookService.borrowBook(2);
//        bookService.getBooks();
//        bookService.getAllBooks();
        bookService.returnBook(2);
        bookService.getAllBooks();

    }
}
