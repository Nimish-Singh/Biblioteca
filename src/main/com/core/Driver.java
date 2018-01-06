package com.core;

import com.inputOutput.CSVFileReader;
import com.inputOutput.DataLoader;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.Menu;

//Represents the starting point to run the application
public class Driver {
  public static void main(String[] args) {
    DataLoader dataLoader = new DataLoader();
    Library library = new Library(dataLoader.dataFromDatabase());
    Menu menu = new Menu(library, Output.CONSOLE, Input.CONSOLE);
    Biblioteca biblioteca = new Biblioteca(menu, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}