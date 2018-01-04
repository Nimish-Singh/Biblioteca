package com.inputOutput;

import com.core.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVFileReaderTest {
  @Test
  void expectBooksToBeReadFromFile() {
    List<Book> bookList = new ArrayList<>();
    bookList.add(new Book("Classical Mythology", "Mark P. O. Morford", 2002));
    bookList.add(new Book("Clara Callan", "Richard Bruce Wright", 2001));
    bookList.add(new Book("Decision in Normandy", "Carlo D'Este", 1991));
    Collections.sort(bookList);
    CSVFileReader csvFileReader = new CSVFileReader();
    assertEquals(bookList, csvFileReader.readBooksFromFile("/Users/nimishs/Assignments/Biblioteca/src/test/resources/books.csv"));
  }
}