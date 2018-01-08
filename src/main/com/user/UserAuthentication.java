package com.user;

import com.inputOutput.Input;
import com.inputOutput.Output;

import java.sql.*;
import java.util.Optional;

import static com.inputOutput.DataLoader.DBMS_PASSWORD;
import static com.inputOutput.DataLoader.DBMS_USERNAME;

//Represents the process of logging in a user into the library
public class UserAuthentication {
  private static final String LOGIN_PROMPT_ASKING_FOR_LIBRARY_NUMBER = "Enter library number to login:";
  private static final String LOGIN_PROMPT_ASKING_FOR_PASSWORD = "Enter password:";
  private static final String USERNAME_AND_PASSWORD_MISMATCH_MESSAGE = "The username and password don't match";
  private static final String DATABASE_PATH = "jdbc:postgresql://127.0.0.1:5432/pathashala";
  private Output output;
  private Input input;

  public static final UserAuthentication userAuthentication = new UserAuthentication(Output.CONSOLE, Input.CONSOLE);

  UserAuthentication(Output output, Input input) {
    this.output = output;
    this.input = input;
  }

  public User loginUser() throws SQLException {
    Optional<User> activeCustomer;
    do {
      output.print(LOGIN_PROMPT_ASKING_FOR_LIBRARY_NUMBER);
      String libraryNumber = input.read();
      output.print(LOGIN_PROMPT_ASKING_FOR_PASSWORD);
      String password = input.read();
      activeCustomer = checkCustomerInDatabase(libraryNumber, password);
      if (activeCustomer.isPresent()) {
        return activeCustomer.get();
      }
      output.print(USERNAME_AND_PASSWORD_MISMATCH_MESSAGE);
    } while (true);
  }

  private Optional<User> checkCustomerInDatabase(String libraryNumber, String password) throws SQLException {
    Connection connection = DriverManager.getConnection(DATABASE_PATH, DBMS_USERNAME, DBMS_PASSWORD);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from users where librarynumber='" + libraryNumber + "' and password='" + password + "';");
    if (resultSet.next()) {
      return Optional.of(new User(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
    }
    return Optional.empty();
  }
}
