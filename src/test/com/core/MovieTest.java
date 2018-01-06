package com.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
  @Test
  void expectAMovieDetailsToBePrintedCorrectly() {
    Movie movie = new Movie("X-Men", "Bryan Singer", 2000, "7.4");
    assertEquals(String.format("%-70s%-40s%-30s%-10s", "X-Men", "Bryan Singer", "2000", "7.4"), movie.tableRepresentationFormatting());
  }

  @Test
  void expectAnotherMovieDetailsToBePrintedCorrectly() {
    Movie movie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    assertEquals(String.format("%-70s%-40s%-30s%-10s", "Toy Story", "John Lasseter", "1995", "8.3"), movie.tableRepresentationFormatting());
  }

  @Test
  void expectMovieWithAGivenNameToBeFound() {
    Movie movie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    assertTrue(movie.hasSameName("toy story"));
  }

  @Test
  void expectMovieWithAWrongNameNotToBeFound() {
    Movie movie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    assertFalse(movie.hasSameName("X-Men"));
  }

  @Test
  void expectMovieWithNameInInitialPlaceInLexicographicalOrderToBeConsideredHigher() {
    Movie aMovie = new Movie("X-Men", "Bryan Singer", 2000, "7.4");
    Movie anotherMovie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    assertTrue(aMovie.compareTo(anotherMovie) > 0);
  }

  @Test
  void expectMovieWithNameInLatterPlaceInLexicographicalOrderToBeConsideredLower() {
    Movie aMovie = new Movie("Toy Story", "John Lasseter", 1995, "8.3");
    Movie anotherMovie = new Movie("X-Men", "Bryan Singer", 2000, "7.4");
    assertTrue(aMovie.compareTo(anotherMovie) < 0);
  }

  @Test
  void expectMoviesWithNamesInEqualPlaceInLexicographicalOrderToBeConsideredEqual() {
    Movie aMovie = new Movie("X-Men", "Bryan Singer", 2000, "7.4");
    Movie anotherMovie = new Movie("X-Men", "Bryan Singer", 2000, "7.4");
    assertTrue(anotherMovie.compareTo(aMovie) == 0);
  }

  @Test
  void expectMoviesWithSameDetailsToBeEqual() {
    Movie movie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    assertEquals(movie, anotherMovie);
  }

  @Test
  void expectMoviesWithDifferentDetailsToBeUnequal() {
    Movie movie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Toy Story", "David Fincher", 1995, "8.6");
    assertNotEquals(movie, anotherMovie);
  }

  @Test
  void expectEqualMoviesToHaveEqualHashcodes() {
    Movie movie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    assertEquals(movie.hashCode(), anotherMovie.hashCode());
  }

  @Test
  void expectUnequalMoviesToHaveUnequalHashcodes() {
    Movie movie = new Movie("Se7en", "David Fincher", 1995, "8.6");
    Movie anotherMovie = new Movie("Toy Story", "David Fincher", 1995, "8.6");
    assertNotEquals(movie.hashCode(), anotherMovie.hashCode());
  }
}