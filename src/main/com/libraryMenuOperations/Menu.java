package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;

import java.util.HashMap;
import java.util.Map;

//Represents a mapping of different library options
public class Menu {
  public static final String LIST_BOOKS_OPTION_NUMBER = "1";
  public static final String LIST_MOVIES_OPTION_NUMBER = "2";
  public static final String CHECKOUT_BOOK_OPTION_NUMBER = "3";
  public static final String RETURN_BOOK_OPTION_NUMBER = "4";
  public static final String QUIT_OPTION_NUMBER = "0";
  private final Map<String, LibraryMenuOption> commands;
  private final LibraryMenuOption invalidOption;
  public final LibraryMenuOption quit;

  public Menu(Library library, Output output, Input input) {
    invalidOption = new InvalidOption(output);
    quit = new Quit(output);
    commands = new HashMap<>();
    commands.put(LIST_BOOKS_OPTION_NUMBER, new ListBooks(library, output, input));
    commands.put(LIST_MOVIES_OPTION_NUMBER, new ListMovies(library, output, input));
    commands.put(CHECKOUT_BOOK_OPTION_NUMBER, new CheckoutItem(library, output, input));
    commands.put(RETURN_BOOK_OPTION_NUMBER, new ReturnItem(library, output, input));
    commands.put(QUIT_OPTION_NUMBER, quit);
  }

  public LibraryMenuOption getOption(String userChoice) {
    return commands.getOrDefault(userChoice, invalidOption);
  }
}
