package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.libraryMenuOperations.ListMovies.MOVIE_LIST_HEADER;
import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;
import static org.mockito.Mockito.*;

class ListMoviesTest {
  private Library library;
  private Output output;
  private ListMovies listMovies;
  private Input input;

  @BeforeEach
  void setUp() {
    Movie aMovie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    List<LibraryListable> movieList = new ArrayList<>();
    movieList.add(aMovie);
    movieList.add(anotherMovie);
    library = new Library(movieList);
    output = mock(Output.class);
    input = mock(Input.class);
    listMovies = new ListMovies(library, output, input);
  }

  @Test
  void expectListOfMoviesToBeSentToOutput() {
    when(input.read()).thenReturn("N").thenReturn(QUIT_OPTION_NUMBER);
    listMovies.execute();
    verify(output).print(MOVIE_LIST_HEADER);
    verify(output).print(String.format("%-70s%-40s%-30s%-10s\n%-70s%-40s%-30s%-10s\n", "Se7en", "David Fincher", "1995", "8.6", "Toy Story", "John Lasseter", "1995", "8.3"));
  }

}