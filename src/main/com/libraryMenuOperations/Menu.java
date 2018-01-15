package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;

import java.util.HashMap;
import java.util.Map;

//Represents a mapping of different library options
public class Menu {
  static final String LIST_BOOKS_OPTION_NUMBER = "1";
  static final String LIST_MOVIES_OPTION_NUMBER = "2";
  static final String CHECKOUT_ITEM_OPTION_NUMBER = "3";
  static final String RETURN_ITEM_OPTION_NUMBER = "4";
  static final String SHOW_USER_DETAILS = "5";
  static final String LIST_BORROWED_ITEMS_OPTION_NUMBER = "6";
  static final String LOGOUT = "7";
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
    commands.put(CHECKOUT_ITEM_OPTION_NUMBER, new CheckoutItem(library, output, input));
    commands.put(RETURN_ITEM_OPTION_NUMBER, new ReturnItem(library, output, input));
    commands.put(SHOW_USER_DETAILS, new ShowUserDetails(library, output));
    commands.put(LIST_BORROWED_ITEMS_OPTION_NUMBER, new ListBorrowedItems(library, output));
    commands.put(LOGOUT, new Logout(library));
    commands.put(QUIT_OPTION_NUMBER, quit);
  }

  public LibraryMenuOption getOption(String userChoice) {
    return commands.getOrDefault(userChoice, invalidOption);
  }
}