package com.libraryMenuOperations;

import com.inputOutput.Output;

//Represents unallowed option input from the user
public class InvalidOption implements LibraryMenuOption {
  public static final String SELECT_A_VALID_OPTION = "Select a valid option!";

  private final Output output;

  public InvalidOption(Output output) {
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(SELECT_A_VALID_OPTION);
  }
}
