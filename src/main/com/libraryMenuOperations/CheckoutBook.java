package com.libraryMenuOperations;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.pathashala.Library;

//Represents the option for checking out a book from the library
public class CheckoutBook implements LibraryMenuOption {
  public static final String ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT = "Enter name of book to be checked out";
  public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
  public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "The book is not available";

  private final Library library;
  private final Output output;
  private final Input input;

  public CheckoutBook(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    String bookName = input.read();
    if (library.checkOut(bookName).isPresent()) {
      output.print(SUCCESSFUL_CHECKOUT_MESSAGE);
      return;
    }
    output.print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}
