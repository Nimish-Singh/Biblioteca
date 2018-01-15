package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.libraryMenuOperations.CheckoutItem.*;
import static org.mockito.Mockito.*;

class CheckoutItemTest {
  private Input input;
  private Output output;
  private CheckoutItem checkoutItem;

  @BeforeEach
  void setUp() {
    List<LibraryListable> books = new ArrayList<>(Collections.singletonList(new Book("Harry Potter", "J.K.Rowling", 2001)));
    List<LibraryListable> movies = new ArrayList<>(Collections.singletonList(new Movie("Toy Story", "John Lasseter", 1995, "8.3")));
    books.addAll(movies);
    Library library = new Library(books);
    input = mock(Input.class);
    output = mock(Output.class);
    checkoutItem = new CheckoutItem(library, output, input);
  }

  @Test
  void expectAvailableBookToBeCheckedOut() {
    when(input.read()).thenReturn("Harry Potter");
    checkoutItem.execute();
    verify(output).print(ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT);
    verify(output).print(SUCCESSFUL_CHECKOUT_MESSAGE);
  }

  @Test
  void expectUnavailableBookNotToBeCheckedOut() {
    when(input.read()).thenReturn("Alice in Wonderland");
    checkoutItem.execute();
    verify(output).print(ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT);
    verify(output).print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }

  @Test
  void expectAvailableMovieToBeCheckedOut() {
    when(input.read()).thenReturn("Toy Story");
    checkoutItem.execute();
    verify(output).print(ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT);
    verify(output).print(SUCCESSFUL_CHECKOUT_MESSAGE);
  }

  @Test
  void expectUnavailableMovieNotToBeCheckedOut() {
    when(input.read()).thenReturn("X-Men");
    checkoutItem.execute();
    verify(output).print(ENTER_NAME_OF_ITEM_TO_BE_CHECKED_OUT);
    verify(output).print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}