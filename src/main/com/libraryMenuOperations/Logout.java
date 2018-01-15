package com.libraryMenuOperations;

import com.core.Library;
import com.user.UserAuthentication;

import java.sql.SQLException;

//Represents the act of ending the current user's session
public class Logout implements LibraryMenuOption {
  private final Library library;


  Logout(Library library) {
    this.library = library;
  }

  @Override
  public void execute() {
    try {
      library.changeActiveUser(UserAuthentication.userAuthentication.loginUser());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}