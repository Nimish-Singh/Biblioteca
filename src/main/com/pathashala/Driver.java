package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;

//Represents the starting point to run the application
public class Driver {

  public static void main(String[] args) {
    Books books = new Books();
    Biblioteca biblioteca = new Biblioteca(books, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}