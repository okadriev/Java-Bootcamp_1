package exercise03;

import java.util.Scanner;

public class Fibo {
  private int input, number;

  public Fibo(int input_) {
    input = input_;
    number = 0;
  }

  public void calcFibo() {
    if (input > 0 && input <= 44)
      number = calcFibo(input);
  }

  private int calcFibo(int n) {
    return (n <= 1) ? n : calcFibo(n - 1) + calcFibo(n - 2);
  }

  public static Fibo readFibo() {
    int num = getValidNumber();

    return new Fibo(num);
  }

  private static int getValidNumber() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      if (scanner.hasNextInt()) {
        int x = scanner.nextInt();
        scanner.close();
        return x;
      } else {
        System.out.println("Couldn't parse a number. Please, try again");
        scanner.next();
      }
    }
  }

  public void printFibo() {
    if (input > 44) {
      System.out.println("Too large n");
    } else if (input < 1) {
      System.out.println("n less than 1");
    } else {
      System.out.println(number);
    }
  }
}