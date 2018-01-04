package com.pathashala;

import com.inputOutput.Output;
import com.libraryMenuOperations.Quit;
import org.junit.jupiter.api.Test;

import static com.pathashala.Biblioteca.GOODBYE_MESSAGE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitTest {
  @Test
  void expectUserToSeeGoodByeMessageOnQuittingApplication() {
    Output output = mock(Output.class);
    Quit quit = new Quit(output);
    quit.execute();
    verify(output).print(GOODBYE_MESSAGE);
  }
}