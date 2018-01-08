package com.user;

import com.inputOutput.Input;
import com.inputOutput.Output;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserAuthenticationTest {
  @Test
  void expectUserToBeLoggedInOnGivingCorrectCredentials() throws SQLException {
    Output output = mock(Output.class);
    Input input = mock(Input.class);
    UserAuthentication userAuthentication = new UserAuthentication(output, input);
    when(input.read()).thenReturn("111-1111").thenReturn("password1");
    assertEquals(User.class, userAuthentication.loginUser().getClass());
  }
}