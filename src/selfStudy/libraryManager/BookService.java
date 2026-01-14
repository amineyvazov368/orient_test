package selfStudy.libraryManager;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getAllBooks() {
        for (Book book : bookRepository.bookLists) {
            System.out.println(book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.isAvailable());
        }
    }

    public void add(Book book) {
        bookRepository.addBook(book);
        System.out.println("Kitab elave edildi");
    }

    public void borrowBook(int id) {
        Book book1 = bookRepository.getBookById(id);
        if (book1 == null) {
            System.out.println("Bu id li kitab yoxdur");
        } else {
            if (book1.isAvailable() == false) {
                System.out.println("Kitab artiq verilib");
            } else {
                book1.setAvailable(false);
                System.out.println("Kitab istifadeciye verildii");
            }
        }
    }

    public void returnBook(int id) {
        Book book1 = bookRepository.getBookById(id);
        if (book1 == null) {
            System.out.println("Bu id li kitab yoxdur");
        } else {
            if (book1.isAvailable() == true) {
                System.out.println("Bu kitab bizdedi");
            } else {
                book1.setAvailable(true);
                System.out.println("Istifadeci kitabi geri qaytardi");
            }
        }
    }

    public void getBooks() {
        for (Book book : bookRepository.getBooksLists()) {
            if (book.isAvailable() == true) {
                System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor());
            }
        }
    }
}
