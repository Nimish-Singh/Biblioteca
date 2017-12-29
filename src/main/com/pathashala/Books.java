package com.pathashala;

import java.util.ArrayList;
import java.util.List;

//Represents a collection of books
public class Books {
  private final List<Book> books;

  Books() {
    List<Book> list = new ArrayList<>();
    list.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    list.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    list.add(new Book("Outliers", "William Gladwell", 2010));
    this.books = list;
  }

  Books(List<Book> books) {
    this.books = books;
  }

  void show() {
    books.forEach(System.out::println);
  }
}