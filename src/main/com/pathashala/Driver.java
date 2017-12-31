package com.pathashala;

import java.util.Scanner;

public class Driver {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Books books = new Books();
    Biblioteca biblioteca = new Biblioteca(books);
    welcomeUser(biblioteca);
    displayUserMenu(biblioteca);
  }

  private static void displayUserMenu(Biblioteca biblioteca) {
    do {
      System.out.println(biblioteca.showMenu());
      int userChoice = sc.nextInt();
      System.out.println(biblioteca.executeUserChoice(userChoice));
    } while (true);
  }

  private static void welcomeUser(Biblioteca biblioteca) {
    System.out.println(biblioteca.welcomeUser());
  }
}