package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.LibraryMenuOption;
import com.libraryMenuOperations.Menu;

//Represents a library management system
public class Biblioteca {
  static final String WELCOME_MESSAGE = "Welcome to Biblioteca";
  static final String MENU = "\nPlease select one of the following choices\n" +
          "1.List Books\n" +
          "2.CheckoutBook Book\n" +
          "3.Return Book\n" +
          "4.Quit";
  public static final String ASK_KEY_INPUT_TO_CONTINUE = "\nPress any key to continue";

  private final Menu menu;
  private final Output output;
  private final Input input;

  Biblioteca(Menu menu, Output output, Input input) {
    this.output = output;
    this.input = input;
    this.menu = menu;
  }

  void run() {
    welcomeUser();
    menu();
  }

  private void welcomeUser() {
    output.print(WELCOME_MESSAGE);
  }

  private void menu() {
    String userChoice;
    LibraryMenuOption userOption;
    do {
      showMenu();
      userChoice = input.read();
      userOption = menu.getOption(userChoice.toUpperCase());
      userOption.execute();
      output.print(ASK_KEY_INPUT_TO_CONTINUE);
      input.read();
    } while (userOption != menu.quit);
  }

  private void showMenu() {
    output.print(MENU);
  }
}