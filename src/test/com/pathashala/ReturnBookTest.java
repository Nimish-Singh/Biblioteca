package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryMenuOperations.CheckoutBook;
import com.libraryMenuOperations.ReturnBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ReturnBook.*;
import static org.mockito.Mockito.*;

class ReturnBookTest {
  private Input input;
  private Output output;
  private CheckoutBook checkoutBook;
  private ReturnBook returnBook;
  private Library library;

  @BeforeEach
  void setUp() {
    List<Book> books= new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    library = new Library(books);
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