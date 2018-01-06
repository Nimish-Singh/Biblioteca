package com.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toMap;

//Represents a place where books and movies can be borrowed from
public class Library {
  private List<LibraryListable> availableItems;
  private List<LibraryListable> checkedOutItems;

  public Library(List<LibraryListable> items) {
    this.availableItems = items;
    this.checkedOutItems = new ArrayList<>();
  }

  public Optional<LibraryListable> checkOut(String itemName) {
    Optional<LibraryListable> checkedOutItem = availableItems.stream().filter(item -> item.hasSameName(itemName)).findFirst();
    if (checkedOutItem.isPresent()) {
      availableItems.remove(checkedOutItem.get());
      checkedOutItems.add(checkedOutItem.get());
    }
    return checkedOutItem;
  }

  public Optional<String> returnItem(String itemName) {
    Optional<LibraryListable> returnedItem = checkedOutItems.stream().filter(item -> item.hasSameName(itemName)).findFirst();
    if (returnedItem.isPresent()) {
      checkedOutItems.remove(returnedItem.get());
      availableItems.add(returnedItem.get());
      return Optional.empty();
    }
    return Optional.of(itemName);
  }

  public Map<Integer, List<LibraryListable>> paginateBooks(int pageSize) {
    List<LibraryListable> books = new ArrayList<>(availableItems);
    books.addAll(checkedOutItems);
    List<LibraryListable> printingBooks = books.stream().filter(book -> book.getClass().equals(Book.class)).collect(Collectors.toList());

    return IntStream.iterate(0, i -> i + pageSize)
            .limit((printingBooks.size() + pageSize - 1) / pageSize)
            .boxed()
            .collect(toMap(i -> i / pageSize, i -> printingBooks.subList(i, min(i + pageSize, printingBooks.size()))));
  }

  public Map<Integer, List<LibraryListable>> paginateMovies(int pageSize) {
    List<LibraryListable> movies = new ArrayList<>(availableItems);
    movies.addAll(checkedOutItems);
    List<LibraryListable> printingMovies = movies.stream().filter(movie -> movie.getClass().equals(Movie.class)).collect(Collectors.toList());

    return IntStream.iterate(0, i -> i + pageSize)
            .limit((printingMovies.size() + pageSize - 1) / pageSize)
            .boxed()
            .collect(toMap(i -> i / pageSize, i -> printingMovies.subList(i, min(i + pageSize, printingMovies.size()))));
  }
}