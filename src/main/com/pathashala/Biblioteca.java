package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents a library management system
public class Biblioteca {
  static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
  static final String MENU = "\nPlease select one of the following choices\n" +
          "1.List Books\n" +
          "2.CheckoutBook Book\n" +
          "3.Return Book\n" +
          "4.Exit";
  static final String SELECT_A_VALID_OPTION = "Select a valid option!";
  static final String BOOK_LIST_HEADER = String.format("%-40s%-40s%-40s\n", "Book", "Author", "Year published");
  static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "The book is not available";
  static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
  static final String ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT = "Enter name of book to be checked out";
  static final String NOT_A_VALID_BOOK_TO_RETURN_MESSAGE = "That is not a valid book to return";
  static final String SUCCESSFUL_BOOK_RETURN_MESSAGE = "Thank you for returning the book.";
  static final String ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED = "Enter name of the book to be returned";
  static final String GOODBYE_MESSAGE = "Goodbye! See you again!";

  private final Menu menu;
  private final Output output;
  private final Input input;

  Biblioteca(Library library, Output output, Input input) {
    this.output = output;
    this.input = input;
    menu = new Menu(library, output, input);
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
    } while (userChoice != 4);
  }

  private void welcomeUser() {
    output.print(WELCOME_MESSAGE);
  }

  private void showMenu() {
    output.print(MENU);
  }

  private void executeUserChoice(int choice) {
    menu.execute(choice);
  }
}