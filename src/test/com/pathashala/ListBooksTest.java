package com.pathashala;

import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.BOOK_LIST_HEADER;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksTest {
  private Library library;
  private Output output;
  private ListBooks listBooks;

  @BeforeEach
  void setUp() {
    library = new Library();
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