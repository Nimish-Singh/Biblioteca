package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
  @Test
  void expectAListedBookToBeShown() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    Library library = new Library(bookList);

    assertEquals(String.format("%-40s%-40s%-40s", "Harry Potter", "J.K.Rowling", "2001"), library.stringRepresentationForTabularForm());
  }

  @Test
  void expectMultipleListedBooksToBeShown() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    Book anotherBook = new Book("Steve Jobs", "Walter Isaacson", 2007);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    bookList.add(anotherBook);
    Library library = new Library(bookList);

    assertEquals(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40s", "Harry Potter", "J.K.Rowling", "2001", "Steve Jobs", "Walter Isaacson", "2007"), library.stringRepresentationForTabularForm());
  }

  @Test
  void expectBookToBeCheckedOutIfItIsAvailable() {
    Library library = new Library();
    assertTrue(library.checkOut("Harry Potter").isPresent());
    assertFalse(library.checkOut("Harry Potter").isPresent());
  }

  @Test
  void expectBookNotToBeCheckedOutIfItIsUnavailable() {
    Library library = new Library();
    assertFalse(library.checkOut("Alice in wonderland").isPresent());
  }

  @Test
  void expectBookToBeReturnedIfItBelongsToTheLibrary() {
    Library library = new Library();
    library.checkOut("Harry Potter");
    assertFalse(library.returnBook("Harry Potter").isPresent());
  }

  @Test
  void expectBookNotToBeReturnedIfItDoesNotBelongToTheLibrary() {
    Library library = new Library();
    assertTrue(library.returnBook("Alice in wonderland").isPresent());
  }
}