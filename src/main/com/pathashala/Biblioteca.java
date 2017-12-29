package com.pathashala;

//Represents a library management system
public class Biblioteca {
  public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca";
  private final Books books;

  Biblioteca(Books books) {
    this.books = books;
  }

  void welcomeUser() {
    showMessage(WELCOME_TO_BIBLIOTECA);
  }

  void listBooks() {
    books.show();
  }

  private void showMessage(String message){
    System.out.println(message);
  }
}