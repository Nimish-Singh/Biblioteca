package com.core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toMap;

//Represents a place where books can be borrowed from
public class Library {
  private List<Book> availableBooks;
  private List<Book> checkedOutBooks;

  public Library(List<Book> availableBooks) {
    this.availableBooks = availableBooks;
    this.checkedOutBooks = new ArrayList<>();
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

  public String stringRepresentationForTabularForm() {
    return availableBooks.stream().map(Book::tableRepresentationFormatting).collect(Collectors.joining("\n"));
  }

  public Map<Integer, List<Book>> paginateBooks(int pageSize) {
    List<Book> books = new ArrayList<>(availableBooks);
    books.addAll(checkedOutBooks);
    Collections.sort(books);

    return IntStream.iterate(0, i -> i + pageSize)
            .limit((books.size() + pageSize - 1) / pageSize)
            .boxed()
            .collect(toMap(i -> i / pageSize, i -> books.subList(i, min(i + pageSize, books.size()))));
  }
}