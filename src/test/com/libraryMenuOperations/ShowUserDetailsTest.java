package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Output;
import com.libraryItems.Book;
import com.user.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.libraryMenuOperations.ShowUserDetails.USER_DETAILS_HEADER;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ShowUserDetailsTest {
  @Test
  void expectListOfBooksToBeSentToOutput() {
    Output output = mock(Output.class);
    Library library = new Library(Arrays.asList(new Book("Harry Potter", "J.K.Rowling", 2000)));
    User aUser = new User("User1", "user1@user1.com", "1234", "111-1111", "password1");
    library.changeActiveUser(aUser);
    ShowUserDetails showUserDetails = new ShowUserDetails(library, output);
    showUserDetails.execute();
    verify(output).print(USER_DETAILS_HEADER);
    verify(output).print(String.format("%-30s%-30s%-30s", "User1", "user1@user1.com", "1234"));
  }
}