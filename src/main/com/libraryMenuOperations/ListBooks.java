package com.libraryMenuOperations;

import com.inputOutput.Output;
import com.pathashala.Library;

import static com.pathashala.Biblioteca.BOOK_LIST_HEADER;

//Represents the option for listing all the available books in the library
public class ListBooks implements LibraryMenuOption {
  private final Library library;
  private final Output output;

  public ListBooks(Library library, Output output) {
    this.library = library;
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(BOOK_LIST_HEADER);
    output.print(library.stringRepresentationForTabularForm());
  }
}
