package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents the option for checking out a book from the library
public class CheckoutItem implements LibraryMenuOption {
  static final String ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT = "Enter name of item to be checked out";
  static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the item";
  static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "The item is not available";

  private final Library library;
  private final Output output;
  private final Input input;

  CheckoutItem(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT);
    String itemName = input.read();
    if (library.checkOut(itemName).isPresent()) {
      output.print(SUCCESSFUL_CHECKOUT_MESSAGE);
      return;
    }
    output.print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}