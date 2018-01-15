package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Output;

//Represents the option for listing all the borrowed items from the library
public class ListBorrowedItems implements LibraryMenuOption {
  static final String ITEMS_BORROWED_FROM_THE_LIBRARY_HEADER = "Items borrowed from the library:\n";
  private Output output;
  private Library library;

  ListBorrowedItems(Library library, Output output) {
    this.library = library;
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(ITEMS_BORROWED_FROM_THE_LIBRARY_HEADER);
    output.print(library.listBorrowedItems());
  }
}