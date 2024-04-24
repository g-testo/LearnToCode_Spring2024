package com.ps;

public class Book {
    private String isbn;
    private String title;

    public Book(){} // Book book = new Book();

    public Book(String isbn, String title){ // Book book = new Book("8-023-4323-848-9", "Harry Potter and the...);
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
