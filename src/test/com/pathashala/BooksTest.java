package com.pathashala;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BooksTest {
  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void cleanUpStreams() {
    System.setOut(null);
  }

  @Test
  void expectAListedBookToBeShown() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    Books books = new Books(bookList);

    assertEquals(String.format("%-40s%-40s%-40s", "Harry Potter", "J.K.Rowling", "2001"), books.stringRepresentationForTabularForm());
  }

  @Test
  void expectMultipleListedBooksToBeShown() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    Book anotherBook = new Book("Steve Jobs", "Walter Isaacson", 2007);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    bookList.add(anotherBook);
    Books books = new Books(bookList);

    assertEquals(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s", "Harry Potter", "J.K.Rowling", "2001", "Steve Jobs", "Walter Isaacson", "2007"), books.stringRepresentationForTabularForm());
  }
}