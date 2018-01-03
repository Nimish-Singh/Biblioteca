package com.pathashala;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Represents a place where books can be borrowed from
public class Library {
  private List<Book> availableBooks;
  private List<Book> checkedOutBooks;

  Library() {
    List<Book> list = new ArrayList<>();
    list.add(new Book("Harry Potter", "J.K.Rowling", 2001));
    list.add(new Book("Steve Jobs", "Walter Isaacson", 2007));
    list.add(new Book("Outliers", "William Gladwell", 2010));
    this.availableBooks = list;
    this.checkedOutBooks = new ArrayList<>();
  }

  Library(List<Book> availableBooks) {
    this.availableBooks = availableBooks;
  }

  String stringRepresentationForTabularForm() {
    return availableBooks.stream().map(Object::toString).collect(Collectors.joining("\n"));
  }

  Optional<Book> checkOut(String bookName) {
    Optional<Book> checkedOutBook = availableBooks.stream().filter(book -> book.hasSameName(bookName)).findFirst();
    if (checkedOutBook.isPresent()) {
      availableBooks.remove(checkedOutBook.get());
      checkedOutBooks.add(checkedOutBook.get());
    }
    return checkedOutBook;
  }

  Optional<String> returnBook(String bookName) {
    Optional<Book> returnedBook = checkedOutBooks.stream().filter(book -> book.hasSameName(bookName)).findFirst();
    if (returnedBook.isPresent()) {
      checkedOutBooks.remove(returnedBook.get());
      availableBooks.add(returnedBook.get());
      return Optional.empty();
    }
    return Optional.of(bookName);
  }
}