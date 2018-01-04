package com.libraryMenuOperations;

import com.inputOutput.Output;
import org.junit.jupiter.api.Test;

import static com.libraryMenuOperations.Quit.GOODBYE_MESSAGE;
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