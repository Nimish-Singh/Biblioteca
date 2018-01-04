package com.pathashala;

//Represents a collection of pages glued together
public class Book {
  private final String name;
  private final String author;
  private final int yearPublished;

  Book(String name, String author, int yearPublished) {
    this.name = name;
    this.author = author;
    this.yearPublished = yearPublished;
  }

  boolean hasSameName(String name){
    return this.name.equalsIgnoreCase(name);
  }

  public String tableRepresentationFormatting() {
    return String.format("%-40s%-40s%-40s", name, author, yearPublished);
  }
}
