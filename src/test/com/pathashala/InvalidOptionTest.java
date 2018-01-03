package com.pathashala;

import com.inputOutput.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.SELECT_A_VALID_OPTION;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InvalidOptionTest {
  private Output output;
  private InvalidOption invalidOption;

  @BeforeEach
  void setUp() {
    output = mock(Output.class);
    invalidOption = new InvalidOption(output);
  }

  @Test
  void expectCustomerToBeAskedToChooseAValidOption() {
    invalidOption.execute();
    verify(output).print(SELECT_A_VALID_OPTION);
  }
}