package com.pathashala;

import com.inputOutput.Output;
import com.libraryMenuOperations.ListBooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ListBooks.BOOK_LIST_HEADER;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksTest {
  private Library library;
  private Output output;
  private ListBooks listBooks;

  @BeforeEach
  void setUp() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    Book anotherBook = new Book("Outliers", "William Gladwell", 2005);
    List<Book> bookList = new ArrayList<>();
    bookList.add(aBook);
    bookList.add(anotherBook);
    library = new Library(bookList);
    output = mock(Output.class);
    listBooks = new ListBooks(library, output);
  }

  @Test
  void expectListOfBooksToBeSentToOutput() {
    listBooks.execute();
    verify(output).print(BOOK_LIST_HEADER);
    verify(output).print(library.stringRepresentationForTabularForm());
  }
}