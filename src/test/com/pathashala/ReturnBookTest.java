package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class ReturnBookTest {
  private Input input;
  private Output output;
  private CheckoutBook checkoutBook;
  private ReturnBook returnBook;

  @BeforeEach
  void setUp() {
    Library library = new Library();
    input = mock(Input.class);
    output = mock(Output.class);
    checkoutBook = new CheckoutBook(library, output, input);
    returnBook = new ReturnBook(library, output, input);
  }

  @Test
  void expectCustomerToBeAbleToReturnBookBelongingToTheLibraryOnChoosingOption3() {
    when(input.read()).thenReturn("Harry Potter").thenReturn("Harry Potter");
    checkoutBook.execute();
    returnBook.execute();
    verify(output).print(ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED);
    verify(output).print(SUCCESSFUL_BOOK_RETURN_MESSAGE);
  }

  @Test
  void expectCustomerNotToBeAbleToCheckoutUnavailableBookOnChoosidsfngOption2() {
    when(input.read()).thenReturn("Alice in Wonderland");
    returnBook.execute();
    verify(output).print(ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED);
    verify(output).print(NOT_A_VALID_BOOK_TO_RETURN_MESSAGE);
  }
}