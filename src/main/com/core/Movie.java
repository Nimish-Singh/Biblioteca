package com.core;

public class Movie implements LibraryListable {
  private final String title;
  private final String director;
  private final int year;
  private final String rating;

  public Movie(String title, String director, int year, String rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;
  }

  @Override
  public boolean hasSameName(String movieName) {
    return this.title.equalsIgnoreCase(movieName);
  }

  @Override
  public String tableRepresentationFormatting() {
    return String.format("%-70s%-40s%-30s%-10s", title, director, year, rating);
  }

  @Override
  public int compareTo(LibraryListable other) {
    Movie otherMovie = (Movie) other;
    return this.title.compareToIgnoreCase(otherMovie.title);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    Movie otherMovie = (Movie) other;
    if (year != otherMovie.year) {
      return false;
    }
    if (title != null ? !title.equals(otherMovie.title) : otherMovie.title != null) {
      return false;
    }
    if (director != null ? !director.equals(otherMovie.director) : otherMovie.director != null) {
      return false;
    }
    return rating != null ? rating.equals(otherMovie.rating) : otherMovie.rating == null;
  }

  @Override
  public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (director != null ? director.hashCode() : 0);
    result = 31 * result + year;
    result = 31 * result + (rating != null ? rating.hashCode() : 0);
    return result;
  }
}
