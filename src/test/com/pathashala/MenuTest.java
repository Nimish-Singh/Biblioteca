package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.Menu.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuTest {
  private Output output;
  private Input input;
  private Menu menu;
  private Library library;

  @BeforeEach
  void setUp() {
    List<Book> books= new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    library = new Library(books);
    output = mock(Output.class);
    input = mock(Input.class);
    menu = new Menu(library, output, input);
  }

  @Test
  void expectListBooksOptionToBeExecutedOnChoosingOption1() {
    assertEquals(ListBooks.class, menu.getOption(LIST_BOOKS_OPTION_NUMBER).getClass());
  }

  @Test
  void expectCheckoutBooksOptionToBeExecutedOnChoosingOption2() {
    assertEquals(CheckoutBook.class, menu.getOption(CHECKOUT_BOOK_OPTION_NUMBER).getClass());
  }

  @Test
  void expectReturnBooksOptionToBeExecutedOnChoosingOption3() {
    assertEquals(ReturnBook.class, menu.getOption(RETURN_BOOK_OPTION_NUMBER).getClass());
  }

  @Test
  void expectQuitOptionToBeExecutedOnChoosingOption4() {
    assertEquals(Quit.class, menu.getOption(QUIT_OPTION_NUMBER).getClass());
  }

  @Test
  void expectInvalidOptionToBeExecutedOnChoosingAnyOtherOption() {
    assertEquals(InvalidOption.class, menu.getOption("G").getClass());
  }
}