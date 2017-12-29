package com.pathashala;

public class Driver {
  public static void main(String[] args){
    Books books = new Books();
    Biblioteca biblioteca = new Biblioteca(books);
    biblioteca.welcomeUser();
    biblioteca.listBooks();
  }
}