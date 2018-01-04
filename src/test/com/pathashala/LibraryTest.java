package com.pathashala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
  private Library library;

  @BeforeEach
  void setUp() {
    List <Book> books= new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    library = new Library(books);
  }

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
    assertTrue(library.checkOut("Harry Potter").isPresent());
    assertFalse(library.checkOut("Harry Potter").isPresent());
  }

  @Test
  void expectBookNotToBeCheckedOutIfItIsUnavailable() {
    assertFalse(library.checkOut("Alice in wonderland").isPresent());
  }

  @Test
  void expectBookToBeReturnedIfItBelongsToTheLibrary() {
    library.checkOut("Harry Potter");
    assertFalse(library.returnBook("Harry Potter").isPresent());
  }

  @Test
  void expectBookNotToBeReturnedIfItDoesNotBelongToTheLibrary() {
    assertTrue(library.returnBook("Alice in wonderland").isPresent());
  }
}