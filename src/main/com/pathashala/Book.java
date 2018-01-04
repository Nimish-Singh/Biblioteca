package com.pathashala;

//Represents a collection of pages glued together
public class Book implements Comparable<Book>{
  private final String name;
  private final String author;
  private final int yearPublished;

  public Book(String name, String author, int yearPublished) {
    this.name = name;
    this.author = author;
    this.yearPublished = yearPublished;
  }

  boolean hasSameName(String name){
    return this.name.equalsIgnoreCase(name);
  }

  String tableRepresentationFormatting() {
    return String.format("%-170s%-50s%-40s", name, author, yearPublished);
  }

  @Override
  public int compareTo(Book other) {
    return this.name.compareToIgnoreCase(other.name);
  }
}
