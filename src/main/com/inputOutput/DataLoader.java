package com.inputOutput;

import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents the data being loaded into the library
public class DataLoader {
  public static final String DATABASE_CONNECTION_ERROR = "Could not connect to the specified database";
  private static final String MOVIE_DATABASE_CONNECTION_ERROR = "Could not connect to the movie table";
  private static final String BOOK_DATABASE_CONNECTION_ERROR = "Could not connect to the book table";
  private static final String DATABASE_PATH = "jdbc:postgresql://127.0.0.1:5432/";
  public static final String DBMS_USERNAME = "nimishs";
  public static final String DBMS_PASSWORD = "";

  private Connection connection;
  private Statement statement;
  private List<LibraryListable> items;

  public DataLoader() {
    connection = null;
    statement = null;
    items = new ArrayList<>();
  }

  public List<LibraryListable> dataFromDatabase(String databaseName) {
    try {
      connection = DriverManager.getConnection(DATABASE_PATH + databaseName, DBMS_USERNAME, DBMS_PASSWORD);
      statement = connection.createStatement();
      items = readBookData();
      items.addAll(readMovieData());
      statement.close();
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(DATABASE_CONNECTION_ERROR);
    }
    return items;
  }

  private List<LibraryListable> readBookData() {
    ResultSet resultSet;
    List<LibraryListable> books = new ArrayList<>();
    try {
      resultSet = statement.executeQuery("select * from book;");
      books = createBookListFromData(resultSet, books);
      resultSet.close();
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(BOOK_DATABASE_CONNECTION_ERROR);
    }
    Collections.sort(books);
    return books;
  }

  private List<LibraryListable> createBookListFromData(ResultSet resultSet, List<LibraryListable> books) {
    try {
      while (resultSet.next()) {
        books.add(new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
      }
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(BOOK_DATABASE_CONNECTION_ERROR);
    }
    return books;
  }

  private List<LibraryListable> readMovieData() {
    ResultSet resultSet;
    List<LibraryListable> movies = new ArrayList<>();
    try {
      resultSet = statement.executeQuery("select * from movie;");
      movies = createMovieListFromData(resultSet, movies);
      resultSet.close();
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(MOVIE_DATABASE_CONNECTION_ERROR);
    }
    Collections.sort(movies);
    return movies;
  }

  private List<LibraryListable> createMovieListFromData(ResultSet resultSet, List<LibraryListable> movies) {
    try {
      while (resultSet.next()) {
        movies.add(new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
      }
    } catch (SQLException sqlException) {
      Output.CONSOLE.print(MOVIE_DATABASE_CONNECTION_ERROR);
    }
    return movies;
  }
}
