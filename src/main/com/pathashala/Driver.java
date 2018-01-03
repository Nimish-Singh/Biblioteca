package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents the starting point to run the application
public class Driver {

  public static void main(String[] args) {
    Library library = new Library();
    Biblioteca biblioteca = new Biblioteca(library, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}