package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class BibliotecaTest {
  private Library library;
  private Input input;
  private Output output;
  private Biblioteca biblioteca;

  @BeforeEach
  void setUp() {
    library = new Library();
    input = mock(Input.class);
    output = mock(Output.class);
    biblioteca = new Biblioteca(library, output, input);
  }

  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    when(input.read()).thenReturn("3");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
  }

  @Test
  void expectCustomerToSeeMenuAfterWelcomeMessage() {
    when(input.read()).thenReturn("3");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
    verify(output).print(MENU);
  }

  @Test
  void expectCustomerToSeeListOfBooksOnChoosingOption1() {
    when(input.read()).thenReturn("1").thenReturn("3");
    biblioteca.run();
    verify(output).print(BOOK_LIST_HEADER);
    verify(output).print(library.stringRepresentationForTabularForm());
  }

  @Test
  void expectCustomerToBeInformedOnChoosingAnInvalidOption() {
    when(input.read()).thenReturn("5").thenReturn("3");
    biblioteca.run();
    verify(output).print(SELECT_A_VALID_OPTION);
  }

  @Test
  void expectCustomerToBeAbleToCheckoutAvailableBookOnChoosingOption2() {
    when(input.read()).thenReturn("2").thenReturn("Harry Potter").thenReturn("3");
    biblioteca.run();
    verify(output).print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    verify(output).print(SUCCESSFUL_CHECKOUT_MESSAGE);
  }

  @Test
  void expectCustomerNotToBeAbleToCheckoutUnavailableBookOnChoosingOption2() {
    when(input.read()).thenReturn("2").thenReturn("Alice in Wonderland").thenReturn("3");
    biblioteca.run();
    verify(output).print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
    verify(output).print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
  }
}