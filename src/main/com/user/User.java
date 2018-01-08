package com.user;

//Represents a person who can borrow items from a library
public class User {
  private final String name;
  private final String emailAddress;
  private final String phoneNumber;
  private final String libraryNumber;
  private final String password;

  public User(String name, String emailAddress, String phoneNumber, String libraryNumber, String password) {
    this.name = name;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;
    this.libraryNumber = libraryNumber;
    this.password = password;
  }

  public String tableRepresentationFormatting() {
    return String.format("%-30s%-30s%-30s", name, emailAddress, phoneNumber);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (getClass() != other.getClass()) {
      return false;
    }
    User otherUser = (User) other;
    if (name != null ? !name.equals(otherUser.name) : otherUser.name != null) {
      return false;
    }
    if (emailAddress != null ? !emailAddress.equals(otherUser.emailAddress) : otherUser.emailAddress != null) {
      return false;
    }
    if (phoneNumber != null ? !phoneNumber.equals(otherUser.phoneNumber) : otherUser.phoneNumber != null) {
      return false;
    }
    if (libraryNumber != null ? !libraryNumber.equals(otherUser.libraryNumber) : otherUser.libraryNumber != null) {
      return false;
    }
    return password != null ? password.equals(otherUser.password) : otherUser.password == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    result = 31 * result + (libraryNumber != null ? libraryNumber.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }
}
