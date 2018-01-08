package com.libraryMenuOperations;

import com.libraryItems.Book;
import com.core.Library;
import com.libraryItems.LibraryListable;
import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MenuTest {
  private Output output;
  private Input input;
  private Menu menu;
  private Library library;

  @BeforeEach
  void setUp() {
    List<LibraryListable> books = new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    //library = new Library(books);
    output = mock(Output.class);
    input = mock(Input.class);
    //menu = new Menu(library, output, input);
  }

  @Test
  void expectListBooksOptionToBeReturnedOnChoosingListBooksOption() {
    assertEquals(ListBooks.class, menu.getOption(LIST_BOOKS_OPTION_NUMBER).getClass());
  }

  @Test
  void expectListMoviesOptionToBeReturnedOnChoosingListMoviesOption() {
    assertEquals(ListMovies.class, menu.getOption(LIST_MOVIES_OPTION_NUMBER).getClass());
  }

  @Test
  void expectCheckoutBooksOptionToBeReturnedOnChoosingCheckoutItemOption() {
    assertEquals(CheckoutItem.class, menu.getOption(CHECKOUT_ITEM_OPTION_NUMBER).getClass());
  }

  @Test
  void expectReturnBooksOptionToBeReturnedOnChoosingReturnItemOption() {
    assertEquals(ReturnItem.class, menu.getOption(RETURN_ITEM_OPTION_NUMBER).getClass());
  }

  @Test
  void expectQuitOptionToBeReturnedOnChoosingQuitOption() {
    assertEquals(Quit.class, menu.getOption(QUIT_OPTION_NUMBER).getClass());
  }

  @Test
  void expectInvalidOptionToBeReturnedOnChoosingAnyOtherOption() {
    assertEquals(InvalidOption.class, menu.getOption("G").getClass());
  }
}