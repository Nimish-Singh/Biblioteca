package com.pathashala;

import com.inputOutput.Output;

import static com.pathashala.Biblioteca.SELECT_A_VALID_OPTION;

//Represents unallowed option input from the user
public class InvalidOption implements LibraryMenuOption {
  private final Output output;

  InvalidOption(Output output) {
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(SELECT_A_VALID_OPTION);
  }
}
