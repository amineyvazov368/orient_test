package selfStudy.libraryManager;

import java.util.List;

public class BookRepository {
     List<Book> bookLists;

    public BookRepository(List<Book> bookLists) {
        this.bookLists = bookLists;
    }

    public void addBook(Book book) {
        bookLists.add(book);
    }

    public List<Book> getBooksLists() {
        return bookLists;
    }

    public Book getBookById(int id) {
        for (Book book : bookLists) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void deleteBookById(int id) {
        Book book = getBookById(id);
        bookLists.remove(book);
    }

}
