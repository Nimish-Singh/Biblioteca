package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.LibraryListable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/*
class LogoutTest {
  @Test
  void expectLoginPromptToBeShownWhenPresentCustomerLogsOut() {
    Output output = mock(Output.class);
    Input input = mock(Input.class);
    LibraryListable item = mock(LibraryListable.class);
    Library library = new Library(Arrays.asList(item));
    Logout logout = new Logout(library);
    when(input.read()).thenReturn("111-1111").thenReturn("password1");
    logout.execute();
    verify(output).print("Enter library number:");
  }
}*/