package com.pathashala;

//Represents a library management system
public class Biblioteca {
  private final Books books;

  Biblioteca(Books books) {
    this.books = books;
  }

  String welcomeUser() {
    return "Welcome to Biblioteca";
  }

  void listBooks() {
    books.show();
  }
}