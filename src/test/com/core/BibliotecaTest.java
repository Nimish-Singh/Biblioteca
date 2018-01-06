package com.core;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.core.Biblioteca.MENU;
import static com.core.Biblioteca.WELCOME_MESSAGE;
import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;
import static org.mockito.Mockito.*;

class BibliotecaTest {
  private Library library;
  private Input input;
  private Output output;
  private Biblioteca biblioteca;
  private Menu menu;

  @BeforeEach
  void setUp() {
    List<LibraryListable> books = new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    library = new Library(books);
    input = mock(Input.class);
    output = mock(Output.class);
    menu = new Menu(library, output, input);
    biblioteca = new Biblioteca(menu, output, input);
  }

  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    when(input.read()).thenReturn(QUIT_OPTION_NUMBER);
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
  }

  @Test
  void expectCustomerToSeeMenuAfterWelcomeMessage() {
    when(input.read()).thenReturn(QUIT_OPTION_NUMBER);
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
    verify(output).print(MENU);
  }
}