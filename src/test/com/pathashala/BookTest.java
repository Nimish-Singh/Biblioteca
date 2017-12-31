package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
  @Test
  void expectABookDetailsToBePrintedCorrectly() {
    Book book = new Book("Harry Potter", "J.K.Rowling", 2001);
    assertEquals(String.format("%-40s%-40s%-40s", "Harry Potter", "J.K.Rowling", "2001"), book.toString());
  }

  @Test
  void expectAnotherBooksDetailsToBePrintedCorrectly() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    assertEquals(String.format("%-40s%-40s%-40s", "Outliers", "William Gladwell", "2010"), book.toString());
  }
}