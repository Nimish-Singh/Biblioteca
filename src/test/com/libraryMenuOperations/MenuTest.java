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

import static com.libraryMenuOperations.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MenuTest {
  private Menu menu;

  @BeforeEach
  void setUp() {
    List<LibraryListable> books = new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    Library library = new Library(books);
    Output output = mock(Output.class);
    Input input = mock(Input.class);
    menu = new Menu(library, output, input);
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
  void expectShowUserDetailsOptionToBeReturnedOnChoosingShowUserDetailsOption() {
    assertEquals(ShowUserDetails.class, menu.getOption(SHOW_USER_DETAILS).getClass());
  }

  @Test
  void expectBorrowedItemsOptionToBeReturnedOnChoosingListBorrowedItemsOption() {
    assertEquals(ListBorrowedItems.class, menu.getOption(LIST_BORROWED_ITEMS_OPTION_NUMBER).getClass());
  }

  @Test
  void expectLogoutOptionToBeReturnedOnChoosingLogoutOption() {
    assertEquals(Logout.class, menu.getOption(LOGOUT).getClass());
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