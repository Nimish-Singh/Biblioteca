package com.inputOutput;

import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
//Represents a comma separated file reader
public class CSVFileReader {
  public static final String BOOKS_FILE_IO_ERROR = "The specified books' file could not be read";
  public static final String MOVIES_FILE_IO_ERROR = "The specified movies' file could not be read";
  public static final String REGEX_FOR_PARSING = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
  List<LibraryListable> books;
  List<LibraryListable> movies;

  public List<LibraryListable> readFromFile(String booksPath, String moviesPath, Output output) {
    List<LibraryListable> books = readBooksFromFile(booksPath, output);
    Collections.sort(books);
    List<LibraryListable> movies = readMoviesFromFile(moviesPath, output);
    Collections.sort(movies);
    books.addAll(movies);
    return books;
  }

  private List<LibraryListable> readBooksFromFile(String path, Output output) {
    File readFile = new File(path);
    books = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(readFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] book = line.split(REGEX_FOR_PARSING);
        books.add(new Book(book[1], book[2], Integer.parseInt(book[3])));
      }
    } catch (IOException exception) {
      output.print(BOOKS_FILE_IO_ERROR);
    }
    Collections.sort(books);
    return books;
  }

  private List<LibraryListable> readMoviesFromFile(String moviesPath, Output output) {
    File readFile = new File(moviesPath);
    movies = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(readFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] movie = line.split(REGEX_FOR_PARSING);
        movies.add(new Movie(movie[0], movie[1], Integer.parseInt(movie[2]), movie[3]));
      }
    } catch (IOException exception) {
      output.print(MOVIES_FILE_IO_ERROR);
    }
    Collections.sort(movies);
    return movies;
  }
}*/
