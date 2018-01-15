package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents the option for returning a book to the library
public class ReturnItem implements LibraryMenuOption {
  static final String ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED = "Enter name of the item to be returned";
  static final String SUCCESSFUL_ITEM_RETURN_MESSAGE = "Thank you for returning the item.";
  static final String NOT_A_VALID_ITEM_TO_RETURN_MESSAGE = "That is not a valid item to return";

  private final Library library;
  private final Output output;
  private final Input input;

  ReturnItem(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED);
    String itemName = input.read();
    if (!library.returnItem(itemName).isPresent()) {
      output.print(SUCCESSFUL_ITEM_RETURN_MESSAGE);
      return;
    }
    output.print(NOT_A_VALID_ITEM_TO_RETURN_MESSAGE);
  }
}