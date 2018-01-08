package com.inputOutput;

//Understands how to render data to an output device
public interface Output {
  Output CONSOLE = System.out::println;

  void print(String message);
}
