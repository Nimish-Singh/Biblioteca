package com.inputOutput;

//Understands how to render data to an output device
public interface Output {
  Output CONSOLE = (message) -> System.out.println(message);

  void print(String message);
}
