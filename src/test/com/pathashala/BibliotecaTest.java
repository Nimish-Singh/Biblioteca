package com.pathashala;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaTest {
  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    Books books = new Books(new ArrayList<Book>());
    Biblioteca biblioteca = new Biblioteca(books);
    assertEquals("Welcome to Biblioteca", biblioteca.welcomeUser());
  }

  @Test
  void expectCustomerToSeeListOfBooks() {
    Books books = mock(Books.class);
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.listBooks();
    verify(books).show();
  }
}