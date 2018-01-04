package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class BibliotecaTest {
  private Library library;
  private Input input;
  private Output output;
  private Biblioteca biblioteca;

  @BeforeEach
  void setUp() {
    List<Book> books= new ArrayList<>();
    books.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    books.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    books.add(new Book("Outliers", "William Gladwell", 2010));
    library = new Library(books);
    input = mock(Input.class);
    output = mock(Output.class);
    biblioteca = new Biblioteca(library, output, input);
  }

  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    when(input.read()).thenReturn("4");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
  }

  @Test
  void expectCustomerToSeeMenuAfterWelcomeMessage() {
    when(input.read()).thenReturn("4");
    biblioteca.run();
    verify(output).print(WELCOME_MESSAGE);
    verify(output).print(MENU);
  }
}