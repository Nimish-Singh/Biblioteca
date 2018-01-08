package com.libraryMenuOperations;

import com.core.Library;
import com.customer.UserAuthentication;

import java.sql.SQLException;

public class Logout implements LibraryMenuOption {
  private final Library library;

  public Logout(Library library) {
    this.library = library;
  }

  @Override
  public void execute() {
    try {
      library.changeActiveCustomer(UserAuthentication.userAuthentication.loginUser());
    } catch (SQLException e) {
      System.out.println("Could not connect to the database");
    }
  }
}
