package com.inputOutput;

import java.util.Scanner;

//Understands how to take data from an input device
public interface Input {
  Input CONSOLE = () -> new Scanner(System.in).nextLine();

  String read();
}
