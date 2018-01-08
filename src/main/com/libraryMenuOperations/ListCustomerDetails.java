package com.libraryMenuOperations;

import com.core.Library;
import com.inputOutput.Output;

public class ListCustomerDetails implements LibraryMenuOption{
  public static final String CUSTOMER_DETAILS_HEADER = String.format("%-30s%-30s%-30s", "Name", "Email Address", "Phone Number");
  private Output output;
  private Library library;

  public ListCustomerDetails(Library library, Output output) {
    this.library = library;
    this.output=output;
  }

  @Override
  public void execute() {
    output.print(CUSTOMER_DETAILS_HEADER);
    output.print(library.showCurrentCustomerDetails());
  }
}
