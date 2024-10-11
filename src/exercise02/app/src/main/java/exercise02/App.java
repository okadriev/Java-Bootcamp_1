package exercise02;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Clock clock = Clock.readClock(scanner);

    clock.calcTime();
    clock.printTime();
  }
}