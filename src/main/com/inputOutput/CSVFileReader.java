package com.inputOutput;

import com.pathashala.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVFileReader {
  List<Book> books;

  public List<Book> readBooksFromFile() {
    File readFile = new File("/Users/nimishs/Assignments/Biblioteca/src/main/resources/books.csv");
    books = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(readFile));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] book = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        books.add(new Book(book[1], book[2], Integer.parseInt(book[3])));
      }
    } catch (IOException exception) {
      System.out.println("File reading failed");
    }
    Collections.sort(books);
    return books;
  }
}
