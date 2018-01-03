package com.pathashala;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.*;
import static org.mockito.Mockito.*;

class MenuTest {
  private Output output;
  private Input input;
  private Menu menu;

  @BeforeEach
  void setUp() {
    Library library = new Library();
    output = mock(Output.class);
    input = mock(Input.class);
    menu = new Menu(library, output, input);
  }

  @Test
  void expectListBooksOptionToBeExecutedOnChoosingOption1() {
    menu.execute(1);
    verify(output).print(BOOK_LIST_HEADER);
  }

  @Test
  void expectCheckoutBooksOptionToBeExecutedOnChoosingOption2() {
    menu.execute(2);
    verify(output).print(ENTER_NAME_OF_BOOK_TO_BE_CHECKED_OUT);
  }

  @Test
  void expectReturnBooksOptionToBeExecutedOnChoosingOption3() {
    when(input.read()).thenReturn("");
    menu.execute(3);
    verify(output).print(ENTER_NAME_OF_THE_BOOK_TO_BE_RETURNED);
  }

  @Test
  void expectQuitOptionToBeExecutedOnChoosingOption4() {
    menu.execute(4);
    verify(output).print(GOODBYE_MESSAGE);
  }

  @Test
  void expectInvalidOptionToBeExecutedOnChoosingAnyOtherOption() {
    menu.execute(7);
    verify(output).print(SELECT_A_VALID_OPTION);
  }
}