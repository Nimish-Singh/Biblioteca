package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ListBooks.BOOK_LIST_HEADER;
import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;
import static org.mockito.Mockito.*;

class ListBooksTest {
  private Library library;
  private Output output;
  private ListBooks listBooks;
  private Input input;

  @BeforeEach
  void setUp() {
    Book aBook = new Book("Harry Potter", "J.K.Rowling", 2001);
    Book anotherBook = new Book("Outliers", "William Gladwell", 2005);
    List<LibraryListable> bookList = new ArrayList<>();
    bookList.add(aBook);
    bookList.add(anotherBook);
    library = new Library(bookList);
    output = mock(Output.class);
    input = mock(Input.class);
    listBooks = new ListBooks(library, output, input);
  }

  @Test
  void expectListOfBooksToBeSentToOutput() {
    when(input.read()).thenReturn("N").thenReturn(QUIT_OPTION_NUMBER);
    listBooks.execute();
    verify(output).print(BOOK_LIST_HEADER);
    verify(output).print(String.format("%-170s%-50s%-40s\n%-170s%-50s%-40s\n", "Harry Potter", "J.K.Rowling", 2001, "Outliers", "William Gladwell", 2005));
  }
}