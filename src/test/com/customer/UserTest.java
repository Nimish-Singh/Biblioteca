package com.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  @Test
  void expectCustomersWithSameDetailsToBeEqual() {
    User aUser = new User("A","a@a.com","123","userA","passworda");
    User anotherUser = new User("A","a@a.com","123","userA","passworda");
    assertEquals(aUser, anotherUser);
  }

  @Test
  void expectCustomersWithDifferentDetailsToBeUnequal() {
    User aUser = new User("A","a@a.com","123","userA","passworda");
    User anotherUser = new User("B","a@a.com","123","userA","passworda");
    assertNotEquals(aUser, anotherUser);
  }

  @Test
  void expectEqualCustomersToHaveEqualHashcodes() {
    User aUser = new User("A","a@a.com","123","userA","passworda");
    User anotherUser = new User("A","a@a.com","123","userA","passworda");
    assertEquals(aUser.hashCode(), anotherUser.hashCode());
  }

  @Test
  void expectUnequalCustomersToHaveUnequalHashcodes() {
    User aUser = new User("A","a@a.com","123","userA","passworda");
    User anotherUser = new User("B","a@a.com","123","userA","passworda");
    assertNotEquals(aUser.hashCode(), anotherUser.hashCode());
  }
}