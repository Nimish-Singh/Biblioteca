package com.pathashala;

import com.inputOutput.Output;

import static com.pathashala.Biblioteca.GOODBYE_MESSAGE;

//Represents the option of exiting the application
public class Quit implements LibraryMenuOption {
  private final Output output;

  public Quit(Output output) {
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(GOODBYE_MESSAGE);
  }
}
