package com.inputOutput;

import com.core.Book;
import com.core.LibraryListable;
import com.core.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents the data being loaded into the library
public class DataLoader {
  private Connection connection;
  private Statement statement;
  private List<LibraryListable> items;

  public DataLoader(){
    connection = null;
    statement = null;
    items = new ArrayList<>();
  }

  public List<LibraryListable> dataFromDatabase(){
    try {
      connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pathashala", "nimishs", "");
      statement = connection.createStatement();
      items = readBookData();
      items.addAll(readMovieData());
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
    Collections.sort(books);
    return books;
  }

  private List<LibraryListable> createBookListFromData(ResultSet resultSet, List<LibraryListable> books) {
    try {
      while(resultSet.next()){
        books.add(new Book(resultSet.getString(1), resultSet.getString(2),  resultSet.getInt(3)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
    Collections.sort(movies);
    return movies;
  }

  private List<LibraryListable> createMovieListFromData(ResultSet resultSet, List<LibraryListable> movies) {
    try {
      while(resultSet.next()){
        movies.add(new Movie(resultSet.getString(1), resultSet.getString(2),  resultSet.getInt(3), resultSet.getString(4)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }
}
