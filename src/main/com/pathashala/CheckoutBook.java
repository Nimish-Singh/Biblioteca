package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

import static com.pathashala.Biblioteca.ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT;
import static com.pathashala.Biblioteca.SUCCESSFUL_CHECKOUT_MESSAGE;
import static com.pathashala.Biblioteca.UNSUCCESSFUL_CHECKOUT_MESSAGE;

//Represents the option for checking out a book from the library
public class CheckoutBook implements LibraryMenuOption {
  private final Library library;
  private final Output output;
  private final Input input;

  CheckoutBook(Library library, Output output, Input input) {
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
