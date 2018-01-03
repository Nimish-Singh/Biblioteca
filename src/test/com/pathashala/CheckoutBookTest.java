package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class CheckoutBookTest {
  private Input input;
  private Output output;
  private CheckoutBook checkoutBook;

  @BeforeEach
  void setUp() {
    Library library = new Library();
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