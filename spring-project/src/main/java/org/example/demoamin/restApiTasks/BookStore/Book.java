package org.example.demoamin.restApiTasks.BookStore;

public class Book {

  private Long id;
  private String title;
  private String author;
  private int price;
  private String ISBN;

  public Book(Long id, String title, String author, int price, String ISBN) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.price = price;
      this.ISBN = ISBN;
  }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
