package com.inputOutput;

import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataLoaderTest {
  @Test
  void expectBooksAndMoviesToBeReadFromDatabase() {
    DataLoader dataLoader = new DataLoader();
    List<LibraryListable> items = new ArrayList<>();
    items.add(new Book("Harry Potter", "J.K.Rowling", 2000));
    items.add(new Movie("Batman", "Christopher Nolan", 2000, "8.5"));
    assertEquals(items, dataLoader.dataFromDatabase("test"));
  }
}