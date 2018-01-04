package com.core;

//Represents a collection of pages held together
public class Book implements Comparable<Book> {
  private final String name;
  private final String author;
  private final int yearPublished;

  public Book(String name, String author, int yearPublished) {
    this.name = name;
    this.author = author;
    this.yearPublished = yearPublished;
  }

  boolean hasSameName(String name) {
    return this.name.equalsIgnoreCase(name);
  }

  public String tableRepresentationFormatting() {
    return String.format("%-170s%-50s%-40s", name, author, yearPublished);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Book otherBook = (Book) other;
    if (yearPublished != otherBook.yearPublished) {
      return false;
    }
    if (name != null ? !name.equals(otherBook.name) : otherBook.name != null) {
      return false;
    }
    return author != null ? author.equals(otherBook.author) : otherBook.author == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (author != null ? author.hashCode() : 0);
    result = 31 * result + yearPublished;
    return result;
  }

  @Override
  public int compareTo(Book other) {
    return this.name.compareToIgnoreCase(other.name);
  }
}
