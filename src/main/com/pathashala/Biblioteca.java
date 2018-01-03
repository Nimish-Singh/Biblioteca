package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents a library management system
public class Biblioteca {
  static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
  static final String MENU = "\nPlease select one of the following choices\n" +
          "1.List Books\n" +
          "2.Checkout Book\n" +
          "3.Return Book\n"+
          "4.Exit";
  static final String SELECT_A_VALID_OPTION = "Select a valid option!";
  static final String BOOK_LIST_HEADER = String.format("%-40s%-40s%-40s\n", "Book", "Author", "Year published");
  static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "The book is not available";
  static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
  static final String ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT = "Enter name of book to be checked out";
  static final String NOT_A_VALID_BOOK_TO_RETURN_MESSAGE = "That is not a valid book to return";
  static final String SUCCESSFUL_BOOK_RETURN_MESSAGE = "Thank you for returning the book.";
  static final String ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED = "Enter name of the book to be returned";

  private final Library library;
  private final Output output;
  private final Input input;

  Biblioteca(Library library, Output output, Input input) {
    this.library = library;
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
    } while (userChoice != 4);
  }

  private void welcomeUser() {
    output.print(WELCOME_MESSAGE);
  }

  private void listBooks() {
    output.print(BOOK_LIST_HEADER);
    output.print(library.stringRepresentationForTabularForm());
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
      checkout();
      return;
    }
    if(choice==3){
      returnBook();
      return;
    }
    if (choice == 4) {
      return;
    }
    output.print(SELECT_A_VALID_OPTION);
  }

  private void returnBook() {
    output.print(ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED);
    String bookName = input.read();
    if (!library.returnBook(bookName).isPresent()) {
      output.print(SUCCESSFUL_BOOK_RETURN_MESSAGE);
      return;
    }
    output.print(NOT_A_VALID_BOOK_TO_RETURN_MESSAGE);
  }

  private void checkout() {
    output.print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    String bookName = input.read();
    if (library.checkOut(bookName).isPresent()) {
      output.print(SUCCESSFUL_CHECKOUT_MESSAGE);
      return;
    }
    output.print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}