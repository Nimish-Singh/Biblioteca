package com.pathashala;

import java.util.List;

//Represents a collection of books
public class Books {
  private final List<Book> books;

  Books(List<Book> books) {
    this.books = books;
  }

  void show() {
    books.forEach(System.out::println);
  }
}