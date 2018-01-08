package com.core;

import com.inputOutput.DataLoader;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.Menu;
import com.user.User;
import com.user.UserAuthentication;

import java.sql.SQLException;

//Represents the starting point to run the application
public class Driver {
  public static void main(String[] args) {
    User activeUser = null;
    try {
      activeUser = UserAuthentication.userAuthentication.loginUser();
    } catch (SQLException e) {
      Output.CONSOLE.print("The user database can't be connected");
    }
    DataLoader dataLoader = new DataLoader();
    Library library = new Library(dataLoader.dataFromDatabase("pathashala"));
    library.changeActiveUser(activeUser);
    Menu menu = new Menu(library, Output.CONSOLE, Input.CONSOLE);
    Biblioteca biblioteca = new Biblioteca(menu, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}