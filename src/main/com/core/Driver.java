package com.core;

import com.customer.User;
import com.customer.UserAuthentication;
import com.inputOutput.*;
import com.libraryMenuOperations.Menu;

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
    Library library = new Library(dataLoader.dataFromDatabase());
    library.changeActiveCustomer(activeUser);
    Menu menu = new Menu(library,Output.CONSOLE, Input.CONSOLE);
    Biblioteca biblioteca = new Biblioteca(menu, Output.CONSOLE, Input.CONSOLE);
    biblioteca.run();
  }
}