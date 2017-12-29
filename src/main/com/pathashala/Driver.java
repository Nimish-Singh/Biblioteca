package com.pathashala;

import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args){
    Book book = new Book("bookName","author",123);
    List<Book> bookList = new ArrayList<>();
    bookList.add(book);
    Biblioteca biblioteca = new Biblioteca(new Books(bookList));
    System.out.println(biblioteca.welcomeUser());
    biblioteca.listBooks();
  }
}
