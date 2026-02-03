package org.example.demoamin.restApiTasks.BookStore;


import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();
    private Long idCounter = 1L;


    @PostMapping("/bulk")
    public void addBooks(@RequestBody List<Book> books) {
        this.books.addAll(books);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        book.setId(idCounter++);
        books.add(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam(required = false) String author) {
        List<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                res.add(book);
            }
        }
        return res;
    }

    @GetMapping("/price")
    public List<Book> getBooksFilterByPrice(
            @RequestParam(required = false) int min,
            @RequestParam(required = false) int max) {
        List<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice() >= min && book.getPrice() <= max) {
                res.add(book);
            }
        }
        return res;
    }

    @PutMapping("/{id}")
    public void updateBookById(@PathVariable Long id, @RequestBody Book book) {
        Book bookToUpdate = getBookById(id);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPrice(book.getPrice());
        bookToUpdate.setISBN(book.getISBN());
        books.add(bookToUpdate);

    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));

    }
}
