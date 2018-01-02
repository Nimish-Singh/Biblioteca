package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents a library management system
public class Biblioteca {
  public static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
  public static final String MENU = "\nPlease select one of the following choices\n" +
          "1.List Books\n" +
          "2.Exit\n";
  public static final String SELECT_A_VALID_OPTION = "Select a valid option!";
  public static final String BOOK_LIST_HEADER = String.format("%-40s%-40s%-40s\n", "Book", "Author", "Year published");

  private final Books books;
  private final Output output;
  private final Input input;

  Biblioteca(Books books, Output output, Input input) {
    this.books = books;
    this.output = output;
    this.input = input;
  }

  void run() {
    welcomeUser();
    menu();
  }

  private void menu() {
    int userChoice;
    do {
      showMenu();
      userChoice = Integer.parseInt(input.read());
      executeUserChoice(userChoice);
    } while (userChoice != 2);
  }

  private void welcomeUser() {
    output.print(WELCOME_MESSAGE);
  }

  private void listBooks() {
    output.print(BOOK_LIST_HEADER);
    output.print(books.stringRepresentationForTabularForm());
  }

  private void showMenu() {
    output.print(MENU);
  }

  private void executeUserChoice(int choice) {
    if (choice == 1) {
      listBooks();
      return;
    }
    if (choice == 2) {
      return;
    }
    output.print(SELECT_A_VALID_OPTION);
  }
}