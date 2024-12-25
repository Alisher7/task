package org.example;

import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
            }
        }
    }

    public void findBookByAuthor(String author) {
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                list.add(book);
            }
        }
        if (list.isEmpty()) {
            System.out.println("Книги автора " + author + " не найдены");
        } else {
            System.out.println("Книги автора " + author + " :");
            for (Book book : list) {
                System.out.println(book);
            }
        }
    }
}
