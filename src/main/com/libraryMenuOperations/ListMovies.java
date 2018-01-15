package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.LibraryListable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.libraryMenuOperations.ListBooks.PAGE_LIMIT;
import static com.libraryMenuOperations.ListBooks.PAGINATION_CONTINUATION_PROMPT_MESSAGE;
import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;

//Represents the option for listing all the available books in the library
public class ListMovies implements LibraryMenuOption {
  static final String MOVIE_LIST_HEADER = String.format("%-70s%-40s%-30s%-10s\n", "Movie", "Director", "Year", "Rating");

  private final Library library;
  private final Output output;
  private final Input input;

  ListMovies(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(MOVIE_LIST_HEADER);
    Map<Integer, List<LibraryListable>> paginatedMovies = library.paginateMovies(PAGE_LIMIT);
    Iterator<Map.Entry<Integer, List<LibraryListable>>> iterator = paginatedMovies.entrySet().iterator();
    do {
      Map.Entry<Integer, List<LibraryListable>> moviesPerPage = iterator.next();
      output.print(formatListBooks(moviesPerPage.getValue()));
      output.print(PAGINATION_CONTINUATION_PROMPT_MESSAGE);
    } while (!input.read().equalsIgnoreCase(QUIT_OPTION_NUMBER) && iterator.hasNext());
  }

  private String formatListBooks(List<LibraryListable> movies) {
    StringBuilder output = new StringBuilder();
    for (LibraryListable movie : movies) {
      output.append(movie.tableRepresentationFormatting()).append('\n');
    }
    return output.toString();
  }
}