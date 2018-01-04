package com.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Represents a place where books can be borrowed from
public class Library {
  private List<Book> availableBooks;
  private List<Book> checkedOutBooks;

  public Library(List<Book> availableBooks) {
    this.availableBooks = availableBooks;
    this.checkedOutBooks = new ArrayList<>();
  }

  public String stringRepresentationForTabularForm() {
    return availableBooks.stream().map(Book::tableRepresentationFormatting).collect(Collectors.joining("\n"));
  }

  public Optional<Book> checkOut(String bookName) {
    Optional<Book> checkedOutBook = availableBooks.stream().filter(book -> book.hasSameName(bookName)).findFirst();
    if (checkedOutBook.isPresent()) {
      availableBooks.remove(checkedOutBook.get());
      checkedOutBooks.add(checkedOutBook.get());
    }
    return checkedOutBook;
  }

  public Optional<String> returnBook(String bookName) {
    Optional<Book> returnedBook = checkedOutBooks.stream().filter(book -> book.hasSameName(bookName)).findFirst();
    if (returnedBook.isPresent()) {
      checkedOutBooks.remove(returnedBook.get());
      availableBooks.add(returnedBook.get());
      return Optional.empty();
    }
    return Optional.of(bookName);
  }
}