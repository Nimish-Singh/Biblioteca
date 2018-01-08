package com.libraryMenuOperations;

import com.libraryItems.Book;
import com.core.Library;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ReturnItem.*;
import static org.mockito.Mockito.*;

class ReturnItemTest {
  private Input input;
  private Output output;
  private CheckoutItem checkoutItem;
  private ReturnItem returnItem;
  private Library library;

  @BeforeEach
  void setUp() {
    List<LibraryListable> items = new ArrayList<>();
    items.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    items.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    items.add(new Book("Outliers", "William Gladwell", 2010));
    items.add(new Movie("Toy Story", "John Lasseter", 1995, "8.3"));
    items.add(new Movie("X-Men", "Bryan Singer", 2000, "7.4"));
    items.add(new Movie("The Departed", "Martin Scorsese", 2006, "8.5"));
    library = new Library(items);
    input = mock(Input.class);
    output = mock(Output.class);
    checkoutItem = new CheckoutItem(library, output, input);
    returnItem = new ReturnItem(library, output, input);
  }

  @Test
  void expectCustomerToBeAbleToReturnBookBelongingToTheLibrary() {
    when(input.read()).thenReturn("Harry Potter").thenReturn("Harry Potter");
    checkoutItem.execute();
    returnItem.execute();
    verify(output).print(ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED);
    verify(output).print(SUCCESSFUL_ITEM_RETURN_MESSAGE);
  }

  @Test
  void expectCustomerNotToBeAbleToCheckoutUnavailableBook() {
    when(input.read()).thenReturn("Alice in Wonderland");
    returnItem.execute();
    verify(output).print(ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED);
    verify(output).print(NOT_A_VALID_ITEM_TO_RETURN_MESSAGE);
  }

  @Test
  void expectCustomerToBeAbleToReturnMovieBelongingToTheLibrary() {
    when(input.read()).thenReturn("X-Men").thenReturn("X-Men");
    checkoutItem.execute();
    returnItem.execute();
    verify(output).print(ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED);
    verify(output).print(SUCCESSFUL_ITEM_RETURN_MESSAGE);
  }

  @Test
  void expectCustomerNotToBeAbleToCheckoutUnavailableMovie() {
    when(input.read()).thenReturn("La La Land");
    returnItem.execute();
    verify(output).print(ENTER_NAME_OF_THE_ITEM_TO_BE_RETURNED);
    verify(output).print(NOT_A_VALID_ITEM_TO_RETURN_MESSAGE);
  }
}