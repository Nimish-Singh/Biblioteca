package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Input;
import com.inputOutput.Output;
import com.libraryItems.LibraryListable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.libraryMenuOperations.Menu.QUIT_OPTION_NUMBER;

//Represents the option for listing all the available books in the library
public class ListBooks implements LibraryMenuOption {
  static final String BOOK_LIST_HEADER = String.format("%-170s%-50s%-40s\n", "Book", "Author", "Year published");
  public static final Integer PAGE_LIMIT = 20;
  static final String PAGINATION_CONTINUATION_PROMPT_MESSAGE = "Press any key to continue. Press 0 to get back to main menu";

  private final Library library;
  private final Output output;
  private final Input input;

  ListBooks(Library library, Output output, Input input) {
    this.library = library;
    this.output = output;
    this.input = input;
  }

  @Override
  public void execute() {
    output.print(BOOK_LIST_HEADER);
    Map<Integer, List<LibraryListable>> paginatedBooks = library.paginateBooks(PAGE_LIMIT);
    Iterator<Map.Entry<Integer, List<LibraryListable>>> iterator = paginatedBooks.entrySet().iterator();
    do {
      Map.Entry<Integer, List<LibraryListable>> booksPerPage = iterator.next();
      output.print(formatListBooks(booksPerPage.getValue()));
      output.print(PAGINATION_CONTINUATION_PROMPT_MESSAGE);
    } while (!input.read().equalsIgnoreCase(QUIT_OPTION_NUMBER) && iterator.hasNext());
  }

  private String formatListBooks(List<LibraryListable> books) {
    StringBuilder output = new StringBuilder();
    for (LibraryListable book : books) {
      output.append(book.tableRepresentationFormatting()).append('\n');
    }
    return output.toString();
  }
}