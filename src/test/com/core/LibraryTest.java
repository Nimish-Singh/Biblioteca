package com.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.libraryMenuOperations.ListBooks.PAGE_LIMIT;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
  private Library library;
  private List<LibraryListable> items = new ArrayList<>();

  @BeforeEach
  void setUp() {
    items.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    items.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    items.add(new Book("Outliers", "William Gladwell", 2010));
    items.add(new Movie("Se7en", "David Fincher", 1995, "8.6"));
    items.add(new Movie("Toy Story", "John Lasseter", 1995, "8.3"));
    library = new Library(items);
  }

  @Test
  void expectItemToBeCheckedOutIfItIsAvailable() {
    assertTrue(library.checkOut("Harry Potter").isPresent());
    assertFalse(library.checkOut("Harry Potter").isPresent());
  }

  @Test
  void expectItemNotToBeCheckedOutIfItIsUnavailable() {
    assertFalse(library.checkOut("Alice in wonderland").isPresent());
  }

  @Test
  void expectItemToBeReturnedIfItBelongsToTheLibrary() {
    library.checkOut("Harry Potter");
    assertFalse(library.returnItem("Harry Potter").isPresent());
  }

  @Test
  void expectItemNotToBeReturnedIfItDoesNotBelongToTheLibrary() {
    assertTrue(library.returnItem("Alice in wonderland").isPresent());
  }

  @Test
  void expectBooksToBePaginated() {
    List<LibraryListable> books = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "J.K.Rowling", 2001),
            new Book("Steve Jobs", "Walter Isaacson", 2007),
            new Book("Outliers", "William Gladwell", 2010)));
    Map<Integer, List<LibraryListable>> paginatedBooks = new HashMap<>();
    paginatedBooks.put(0, books);
    assertEquals(paginatedBooks, library.paginateBooks(PAGE_LIMIT));
  }

  @Test
  void expectmMoviesToBePaginated() {
    List<LibraryListable> movies = new ArrayList<>(Arrays.asList(new Movie("Se7en", "David Fincher", 1995, "8.6"),
            new Movie("Toy Story", "John Lasseter", 1995, "8.3")));
    Map<Integer, List<LibraryListable>> paginatedMovies = new HashMap<>();
    paginatedMovies.put(0, movies);
    assertEquals(paginatedMovies, library.paginateMovies(PAGE_LIMIT));
  }
}