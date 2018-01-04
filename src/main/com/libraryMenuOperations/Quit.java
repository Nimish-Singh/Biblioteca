package com.libraryMenuOperations;

import com.inputOutput.Output;

//Represents the option of exiting the application
public class Quit implements LibraryMenuOption {
  public static final String GOODBYE_MESSAGE = "Goodbye! See you again!";

  private final Output output;

  public Quit(Output output) {
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(GOODBYE_MESSAGE);
  }
}
