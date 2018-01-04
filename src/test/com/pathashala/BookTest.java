package com.pathashala;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
  @Test
  void expectABookDetailsToBePrintedCorrectly() {
    Book book = new Book("Harry Potter", "J.K.Rowling", 2001);
    assertEquals(String.format("%-170s%-50s%-40s", "Harry Potter", "J.K.Rowling", "2001"), book.tableRepresentationFormatting());
  }

  @Test
  void expectAnotherBooksDetailsToBePrintedCorrectly() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    assertEquals(String.format("%-170s%-50s%-40s", "Outliers", "William Gladwell", "2010"), book.tableRepresentationFormatting());
  }

  @Test
  void expectBookWithAGivenNameToBeFound() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    assertTrue(book.hasSameName("outliers"));
  }

  @Test
  void expectBookWithAWrongNameNotToBeFound() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    assertFalse(book.hasSameName("outli"));
  }

  @Test
  void expectBookWithNameInInitialPlaceInLexicographicalOrderToBeConsideredHigher() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    Book anotherBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    assertTrue(book.compareTo(anotherBook) > 0);
  }

  @Test
  void expectBookWithNameInLatterPlaceInLexicographicalOrderToBeConsideredLower() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    Book anotherBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    assertTrue(anotherBook.compareTo(book) < 0);
  }

  @Test
  void expectBooksWithNamesInEqualPlaceInLexicographicalOrderToBeConsideredEqual() {
    Book book = new Book("Outliers", "William Gladwell", 2010);
    Book anotherBook = new Book("outliers", "William Gladwell", 2010);
    assertTrue(anotherBook.compareTo(book) == 0);
  }
}