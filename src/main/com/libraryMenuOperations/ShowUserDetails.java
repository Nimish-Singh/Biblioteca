package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Output;

//Represents the act of displaying user details
public class ShowUserDetails implements LibraryMenuOption {
  public static final String USER_DETAILS_HEADER = String.format("%-30s%-30s%-30s", "Name", "Email Address", "Phone Number");
  private Output output;
  private Library library;

  public ShowUserDetails(Library library, Output output) {
    this.library = library;
    this.output = output;
  }

  @Override
  public void execute() {
    output.print(USER_DETAILS_HEADER);
    output.print(library.showCurrentCustomerDetails());
  }
}
