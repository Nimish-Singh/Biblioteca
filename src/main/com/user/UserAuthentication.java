package com.user;

import com.inputOutput.Input;
import com.inputOutput.Output;

import java.sql.*;
import java.util.Optional;

//Represents the process of logging in a user into the library
public class UserAuthentication {
  private static final String LOGIN_MENU = "\nPlease select one of the following choices\n" +
          "1.Login\n" +
          "0.Quit\n";
  private Output output;
  private Input input;

  public static final UserAuthentication userAuthentication = new UserAuthentication(Output.CONSOLE, Input.CONSOLE);

  public UserAuthentication(Output output, Input input) {
    this.output = output;
    this.input = input;
  }

  public User loginUser() throws SQLException {
    Optional<User> activeCustomer;
    do {
      output.print("Enter library number to login:");
      String libraryNumber = input.read();
      output.print("Enter password:");
      String password = input.read();
      activeCustomer = checkCustomerInDatabase(libraryNumber, password);
      if (activeCustomer.isPresent()) {
        return activeCustomer.get();
      }
      output.print("The username and password don't match");
    } while (!activeCustomer.isPresent());
    return activeCustomer.get();
  }

  private Optional<User> checkCustomerInDatabase(String libraryNumber, String password) throws SQLException {
    Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pathashala", "nimishs", "");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from users where librarynumber='" + libraryNumber + "' and password='" + password + "';");
    if (resultSet.next()) {
      return Optional.of(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
    }
    return Optional.empty();
  }
}
