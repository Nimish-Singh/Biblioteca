package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

import static com.pathashala.Biblioteca.ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED;
import static com.pathashala.Biblioteca.NOT_A_VALID_BOOK_TO_RETURN_MESSAGE;
import static com.pathashala.Biblioteca.SUCCESSFUL_BOOK_RETURN_MESSAGE;

//Represents the option for returning a book to the library
public class ReturnBook implements LibraryMenuOption {
  private final Library library;
  private final Output output;
  private final Input input;

  ReturnBook(Library library, Output output, Input input) {
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
