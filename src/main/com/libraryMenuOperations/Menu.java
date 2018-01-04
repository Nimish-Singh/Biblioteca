package com.libraryMenuOperations;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.pathashala.Library;

import java.util.HashMap;
import java.util.Map;

//Represents a mapping of different library options
public class Menu {
  private final Map<Integer, LibraryMenuOption> commands;
  private final LibraryMenuOption invalidOption;

  public Menu(Library library, Output output, Input input) {
    invalidOption = new InvalidOption(output);
    commands = new HashMap<>();
    commands.put(1,new ListBooks(library, output));
    commands.put(2,new CheckoutBook(library, output, input));
    commands.put(3,new ReturnBook(library, output, input));
    commands.put(4,new Quit(output));
  }

  public void execute(Integer option){
    commands.getOrDefault(option, invalidOption).execute();
  }
}
