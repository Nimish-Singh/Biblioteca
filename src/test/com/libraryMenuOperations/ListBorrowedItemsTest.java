package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import com.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ListBorrowedItems.ITEMS_BORROWED_FROM_THE_LIBRARY_HEADER;
import static com.libraryMenuOperations.Menu.LIST_BORROWED_ITEMS_OPTION_NUMBER;
import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;
import static org.mockito.Mockito.*;

class ListBorrowedItemsTest {
  private Output output;
  private ListBorrowedItems listBorrowedItems;
  private Input input;

  @BeforeEach
  void setUp() {
    Movie aMovie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    List<LibraryListable> movieList = new ArrayList<>();
    movieList.add(aMovie);
    movieList.add(anotherMovie);
    Library library = new Library(movieList);
    library.changeActiveUser(User.librarian);
    output = mock(Output.class);
    input = mock(Input.class);
    listBorrowedItems = new ListBorrowedItems(library, output);
  }

  @Test
  void expectListOfMoviesToBeSentToOutput() {
    when(input.read()).thenReturn(LIST_BORROWED_ITEMS_OPTION_NUMBER).thenReturn(QUIT_OPTION_NUMBER);
    listBorrowedItems.execute();
    verify(output).print(ITEMS_BORROWED_FROM_THE_LIBRARY_HEADER);
  }
}