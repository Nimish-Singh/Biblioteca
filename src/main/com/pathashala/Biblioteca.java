package com.pathashala;

//Represents a library management system
public class Biblioteca {
  public static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
  public static final String MENU = "\nPlease select one of the following choices\n" +
          "1.List Books\n" +
          "2.Exit\n";
  public static final String SELECT_A_VALID_OPTION = "Select a valid option!";
  public static final String BOOK_LIST_HEADER = String.format("%-40s%-40s%-40s\n", "Book", "Author", "Year published");

  private final Books books;

  Biblioteca(Books books) {
    this.books = books;
  }

  String welcomeUser() {
    return WELCOME_MESSAGE;
  }

  private String listBooks() {
    return BOOK_LIST_HEADER + books.show();
  }

  String showMenu() {
    return MENU;
  }

  String executeUserChoice(int choice) {
    if (choice == 1) {
      return listBooks();
    }
    if (choice == 2) {
      exitMenu();
    }
    return invalidOptionSelected();
  }

  private void exitMenu() {
    System.exit(0);
  }

  private String invalidOptionSelected() {
    return SELECT_A_VALID_OPTION;
  }
}