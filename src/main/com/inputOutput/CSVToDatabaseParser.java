package com.inputOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.inputOutput.CSVFileReader.REGEX_FOR_PARSING;

public class CSVToDatabaseParser {
  private File bookFile;
  private File movieFile;
  private Connection connection = null;
  private Statement statement = null;

  public void readDataFromFile(String booksPath, String moviesPath) {
    bookFile = new File(booksPath);
    movieFile = new File(moviesPath);

    try {
      connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pathashala", "nimishs", "");
      statement = connection.createStatement();
      readBookFile();
      readMovieFile();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void readBookFile() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(bookFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] bookDetails = line.split(REGEX_FOR_PARSING);
        String insertIntoBookTable = "insert into book values ('" + bookDetails[1] + "', '" + bookDetails[2] + "', " + Integer.parseInt(bookDetails[3]) + ");";
        statement.executeUpdate(insertIntoBookTable);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readMovieFile() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(movieFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] movieDetails = line.split(REGEX_FOR_PARSING);
        String insertIntoMovieTable = "insert into movie values ('" + movieDetails[0] + "', '" + movieDetails[1] + "', " + Integer.parseInt(movieDetails[2]) + ", '" + "'" + ");";
        statement.executeUpdate(insertIntoMovieTable);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
