package com.core;

import com.libraryItems.Book;
import com.libraryItems.LibraryListable;
import com.libraryItems.Movie;
import com.user.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toMap;

//Represents a place where books and movies can be borrowed from
public class Library {
  static final String UNAUTHORISED_TO_VIEW_ALL_DETAILS_MESSAGE = "You are not authorised to view these details";
  static final String BORROWER_AND_ITEM_SEPARATOR = "-> ";
  static final String ITEM_SEPARATOR = ", ";
  static final String LINE_DELIMITER = "\n";
  private List<LibraryListable> availableItems;
  private List<LibraryListable> checkedOutItems;
  private User activeUser;
  private Map<User, Set<LibraryListable>> customerCheckedoutItemsMapping;

  public Library(List<LibraryListable> items) {
    this.availableItems = items;
    this.checkedOutItems = new ArrayList<>();
    this.customerCheckedoutItemsMapping = new HashMap<>();
  }

  public void changeActiveUser(User user) {
    this.activeUser = user;
  }

  public Optional<LibraryListable> checkOut(String itemName) {
    Optional<LibraryListable> checkedOutItem = availableItems.stream().filter(item -> item.hasSameName(itemName)).findFirst();
    if (checkedOutItem.isPresent()) {
      Set<LibraryListable> customerItems = customerCheckedoutItemsMapping.getOrDefault(activeUser, new HashSet<>());
      customerItems.add(checkedOutItem.get());
      customerCheckedoutItemsMapping.put(activeUser, customerItems);
      availableItems.remove(checkedOutItem.get());
      checkedOutItems.add(checkedOutItem.get());
    }
    return checkedOutItem;
  }

  public Optional<String> returnItem(String itemName) {
    Set<LibraryListable> customerItems = customerCheckedoutItemsMapping.getOrDefault(activeUser, new HashSet<>());
    if (customerItems.isEmpty()) {
      return Optional.of(itemName);
    }
    Optional<LibraryListable> returnedItem = checkedOutItems.stream().filter(item -> item.hasSameName(itemName)).findFirst();
    if (returnedItem.isPresent()) {
      checkedOutItems.remove(returnedItem.get());
      availableItems.add(returnedItem.get());
      return Optional.empty();
    }
    return Optional.of(itemName);
  }

  public String showCurrentCustomerDetails() {
    return activeUser.tableRepresentationFormatting();
  }

  public String listBorrowedItems() {
    if (!this.activeUser.equals(User.librarian)) {
      return UNAUTHORISED_TO_VIEW_ALL_DETAILS_MESSAGE;
    }
    StringBuilder borrowedItems = new StringBuilder();
    for (User borrower : customerCheckedoutItemsMapping.keySet()) {
      borrowedItems.append(borrower.rowRepresentationOfUserLibraryNumber()).append(BORROWER_AND_ITEM_SEPARATOR);
      customerCheckedoutItemsMapping.get(borrower).forEach(item -> borrowedItems.append(item.rowRepresentationOfItemName()).append(ITEM_SEPARATOR));
      borrowedItems.append(LINE_DELIMITER);
    }
    return borrowedItems.toString();
  }

  public Map<Integer, List<LibraryListable>> paginateBooks(int pageSize) {
    List<LibraryListable> items = new ArrayList<>(availableItems);
    items.addAll(checkedOutItems);
    List<LibraryListable> printingBooks = items.stream().filter(item -> item.getClass().equals(Book.class)).collect(Collectors.toList());

    return IntStream.iterate(0, i -> i + pageSize)
            .limit((printingBooks.size() + pageSize - 1) / pageSize)
            .boxed()
            .collect(toMap(i -> i / pageSize, i -> printingBooks.subList(i, min(i + pageSize, printingBooks.size()))));
  }

  public Map<Integer, List<LibraryListable>> paginateMovies(int pageSize) {
    List<LibraryListable> items = new ArrayList<>(availableItems);
    items.addAll(checkedOutItems);
    List<LibraryListable> printingMovies = items.stream().filter(item -> item.getClass().equals(Movie.class)).collect(Collectors.toList());

    return IntStream.iterate(0, i -> i + pageSize)
            .limit((printingMovies.size() + pageSize - 1) / pageSize)
            .boxed()
            .collect(toMap(i -> i / pageSize, i -> printingMovies.subList(i, min(i + pageSize, printingMovies.size()))));
  }
}