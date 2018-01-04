package com.libraryMenuOperations;

import com.inputOutput.Output;
import com.pathashala.Library;

//Represents the option for listing all the available books in the library
public class ListBooks implements LibraryMenuOption {
  public static final String BOOK_LIST_HEADER = String.format("%-170s%-50s%-40s\n", "Book", "Author", "Year published");

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
