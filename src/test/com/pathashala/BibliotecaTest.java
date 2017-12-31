package com.pathashala;

import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.MENU;
import static com.pathashala.Biblioteca.SELECT_A_VALID_OPTION;
import static com.pathashala.Biblioteca.WELCOME_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {
  @Test
  void expectCustomerToSeeWelcomeMessageOnStartingApplication() {
    Books books = new Books();
    Biblioteca biblioteca = new Biblioteca(books);
    assertEquals(WELCOME_MESSAGE, biblioteca.welcomeUser());
  }

  @Test
  void expectCustomerToSeeMenu() {
    Books books = new Books();
    Biblioteca biblioteca = new Biblioteca(books);
    assertEquals(MENU, biblioteca.showMenu());
  }

  @Test
  void expectCustomerToSeeListOfBooksOnChoosingOption1() {
    Books books = mock(Books.class);
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.executeUserChoice(1);
    verify(books).show();
  }

  @Test
  void expectCustomerToBeNotifiedOnSelectingAnInvalidChoice() {
    Books books = mock(Books.class);
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.executeUserChoice(4);
    assertEquals(SELECT_A_VALID_OPTION, biblioteca.executeUserChoice(4));
  }
}