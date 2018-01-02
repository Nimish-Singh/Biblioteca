package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class BibliotecaTest {
  private Books books;
  private Input input;
  private Output output;
  private Biblioteca biblioteca;

  @BeforeEach
  void setUp() {
    books = new Books();
    input = mock(Input.class);
    output = mock(Output.class);
    biblioteca = new Biblioteca(books, output, input);
  }

  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    when(input.read()).thenReturn("2");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
  }

  @Test
  void expectCustomerToSeeMenuAfterWelcomeMessage() {
    when(input.read()).thenReturn("2");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
    verify(output).print(MENU);
  }

  @Test
  void expectCustomerToSeeListOfBooksOnChoosingOption1() {
    when(input.read()).thenReturn("1").thenReturn("2");
    biblioteca.run();
    verify(output).print(BOOK_LIST_HEADER);
    verify(output).print(books.stringRepresentationForTabularForm());
  }

  @Test
  void expectCustomerToBeInformedOnSelectingAnInvalidChoice() {
    when(input.read()).thenReturn("5").thenReturn("2");
    biblioteca.run();
    verify(output).print(SELECT_A_VALID_OPTION);
  }
}