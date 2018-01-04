package com.libraryMenuOperations;

import com.core.Book;
import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.libraryMenuOperations.CheckoutBook.*;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
  private Input input;
  private Output output;
  private CheckoutBook checkoutBook;
  private List<Book> books;
  private Library library;

  @BeforeEach
  void setUp() {
    books = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "J.K.Rowling", 2001)));
    library = new Library(books);
    input = mock(Input.class);
    output = mock(Output.class);
    checkoutBook = new CheckoutBook(library, output, input);
  }

  @Test
  void expectAvailableBookToBeCheckedOut() {
    when(input.read()).thenReturn("Harry Potter");
    checkoutBook.execute();
    verify(output).print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    verify(output).print(SUCCESSFUL_CHECKOUT_MESSAGE);
  }

  @Test
  void expectUnavailableBookNotToBeCheckedOut() {
    when(input.read()).thenReturn("Alice in Wonderland");
    checkoutBook.execute();
    verify(output).print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    verify(output).print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}