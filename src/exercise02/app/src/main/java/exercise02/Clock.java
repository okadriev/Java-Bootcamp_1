package exercise02;

import java.util.Scanner;

public class Clock {
  private int h, m, s, time;

  public Clock(int time_) {
    h = 0;
    m = 0;
    s = 0;
    time = time_;
  }

  public void calcTime() {
    h = time / 3600 % 24;
    m = (time / 60) % 60;
    s = time % 60;
  }

  public static Clock readClock(Scanner scanner) {
    int time = getValidNumber(scanner);

    return new Clock(time);
  }

  private static int getValidNumber(Scanner scanner) {
    while (true) {
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        System.out.println("Couldn't parse a number. Please, try again");
        scanner.next();
      }
    }
  }

  public void printTime() {
    if (time < 0) {
      System.out.println("Incorrect time");
    } else {
      System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }
  }
}