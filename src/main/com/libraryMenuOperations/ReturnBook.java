package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents the option for returning a book to the library
public class ReturnBook implements LibraryMenuOption {
  public static final String ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED = "Enter name of the book to be returned";
  public static final String SUCCESSFUL_BOOK_RETURN_MESSAGE = "Thank you for returning the book.";
  public static final String NOT_A_VALID_BOOK_TO_RETURN_MESSAGE = "That is not a valid book to return";

  private final Library library;
  private final Output output;
  private final Input input;

  public ReturnBook(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED);
    String bookName = input.read();
    if (!library.returnBook(bookName).isPresent()) {
      output.print(SUCCESSFUL_BOOK_RETURN_MESSAGE);
      return;
    }
    output.print(NOT_A_VALID_BOOK_TO_RETURN_MESSAGE);
  }
}
