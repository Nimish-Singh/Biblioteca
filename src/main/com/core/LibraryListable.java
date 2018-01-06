package com.core;

//Understands any item that can be borrowed from a library
public interface LibraryListable extends Comparable<LibraryListable> {
  boolean hasSameName(String name);

  String tableRepresentationFormatting();

  int compareTo(LibraryListable other);
}
