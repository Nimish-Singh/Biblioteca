package com.inputOutput;

import com.core.Book;
import com.core.LibraryListable;
import com.core.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.inputOutput.CSVFileReader.BOOKS_FILE_IO_ERROR;
import static com.inputOutput.CSVFileReader.MOVIES_FILE_IO_ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CSVFileReaderTest {
  Output output = mock(Output.class);

  @Test
  void expectBooksToBeReadFromFile() {
    List<LibraryListable> bookList = new ArrayList<>();
    bookList.add(new Book("Classical Mythology", "Mark P. O. Morford", 2002));
    bookList.add(new Book("Clara Callan", "Richard Bruce Wright", 2001));
    bookList.add(new Book("Decision in Normandy", "Carlo D'Este", 1991));
    Collections.sort(bookList);
    List<LibraryListable> movieList = new ArrayList<>();
    movieList.add(new Movie("Toy Story", "John Lasseter", 1995, "8.3"));
    movieList.add(new Movie("Se7en", "David Fincher", 1995, "8.6"));
    Collections.sort(movieList);
    bookList.addAll(movieList);
    CSVFileReader csvFileReader = new CSVFileReader();
    assertEquals(bookList, csvFileReader.readFromFile("src/test/resources/books.csv", "src/test/resources/movies.csv", output));
  }

  @Test
  void expectMessageToBeShownIfBooksFileCanNotBeRead() {
    CSVFileReader csvFileReader = new CSVFileReader();
    csvFileReader.readFromFile("/test/resources/books.csv", "src/test/resources/movies.csv", output);
    verify(output).print(BOOKS_FILE_IO_ERROR);
  }

  @Test
  void expectMessageToBeShownIfMoviesFileCanNotBeRead() {
    CSVFileReader csvFileReader = new CSVFileReader();
    csvFileReader.readFromFile("src/test/resources/books.csv", "test/resources/movies.csv", output);
    verify(output).print(MOVIES_FILE_IO_ERROR);
  }
}