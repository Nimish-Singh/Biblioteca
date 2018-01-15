package com.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserTest {
  @Test
  void expectCustomersWithSameDetailsToBeEqual() {
    User aUser = new User("A", "a@a.com", "123", "userA", "passworda");
    User anotherUser = new User("A", "a@a.com", "123", "userA", "passworda");
    assertEquals(aUser, anotherUser);
  }

  @Test
  void expectCustomersWithDifferentDetailsToBeUnequal() {
    User aUser = new User("A", "a@a.com", "123", "userA", "passworda");
    User anotherUser = new User("B", "a@a.com", "123", "userA", "passworda");
    assertNotEquals(aUser, anotherUser);
  }

  @Test
  void expectEqualCustomersToHaveEqualHashcodes() {
    User aUser = new User("A", "a@a.com", "123", "userA", "passworda");
    User anotherUser = new User("A", "a@a.com", "123", "userA", "passworda");
    assertEquals(aUser.hashCode(), anotherUser.hashCode());
  }

  @Test
  void expectUnequalCustomersToHaveUnequalHashcodes() {
    User aUser = new User("A", "a@a.com", "123", "userA", "passworda");
    User anotherUser = new User("B", "a@a.com", "123", "userA", "passworda");
    assertNotEquals(aUser.hashCode(), anotherUser.hashCode());
  }

  @Test
  void expectUserDetailsToBePrintedCorrectly() {
    User user = new User("User1", "user1@abc.com", "1234", "111-1111", "password1");
    assertEquals(String.format("%-30s%-30s%-30s", "User1", "user1@abc.com", "1234"), user.tableRepresentationFormatting());
  }

  @Test
  void expectUserLibraryNumberToBePrintedCorrectly() {
    User user = new User("User1", "user1@abc.com", "1234", "111-1111", "password1");
    assertEquals(String.format("%-20s", "111-1111"), user.rowRepresentationOfUserLibraryNumber());
  }
}