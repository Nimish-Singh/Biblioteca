package com.pathashala;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    books.show();

    assertEquals("Harry Potter J.K.Rowling 2001\n", outContent.toString());
  }

  @Test
  void expectMultipleListedBooksToBeShown() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    Book anotherBook = new Book("Steve Jobs", "Walter Isaacson", 2007);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    bookList.add(anotherBook);
    Books books = new Books(bookList);

    books.show();

    assertEquals("Harry Potter J.K.Rowling 2001\nSteve Jobs Walter Isaacson 2007\n", outContent.toString());
  }
}