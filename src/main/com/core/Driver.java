package com.core;

import com.inputOutput.DataLoader;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.Menu;
import com.user.User;
import com.user.UserAuthentication;

import java.sql.SQLException;

import static com.inputOutput.DataLoader.DATABASE_CONNECTION_ERROR;

//Represents the starting point to run the application
public class Driver {

  private static final String DATABASE_NAME = "pathashala";

  public static void main(String[] args) {
    User activeUser = null;
    try {
      activeUser = UserAuthentication.userAuthentication.loginUser();
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(DATABASE_CONNECTION_ERROR);
    }
    DataLoader dataLoader = new DataLoader();
    Library library = new Library(dataLoader.dataFromDatabase(DATABASE_NAME));
    library.changeActiveUser(activeUser);
    Menu menu = new Menu(library, Output.CONSOLE, Input.CONSOLE);
    Biblioteca biblioteca = new Biblioteca(menu, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}