package com.pathashala;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {
  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void cleanUpStreams() {
    System.setOut(null);
  }

  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    Books books = new Books(new ArrayList<Book>());
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.welcomeUser();
    assertEquals("Welcome to Biblioteca\n", outContent.toString());
  }

  @Test
  void expectCustomerToSeeListOfBooks() {
    Books books = mock(Books.class);
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.listBooks();
    verify(books).show();
  }
}