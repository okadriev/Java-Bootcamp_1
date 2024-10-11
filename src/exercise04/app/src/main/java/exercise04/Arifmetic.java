package exercise04;

import java.util.Scanner;

public class Arifmetic {
  private int count, numbers[];
  private double calc;

  public Arifmetic(int count_, int numbers_[]) {
    calc = 0;
    count = count_;
    numbers = numbers_;
  }

  public static Arifmetic readArifmetic() {
    Scanner scanner = new Scanner(System.in);
    int count = getValidInt(scanner);

    int numbers[] = (count > 0) ? new int[count] : new int[0];
    for (int i = 0; i < count; i++) {
      numbers[i] = getValidInt(scanner);
    }

    scanner.close();
    return new Arifmetic(count, numbers);
  }

  private static int getValidInt(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      System.out.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }

    return scanner.nextInt();
  }

  public void calcArifmetic() {
    int sumNeg = 0;
    int countNeg = 0;
    for (int num : numbers) {
      if (num < 0) {
        sumNeg += num;
        countNeg++;
      }
    }

    if (countNeg > 0) {
      calc = sumNeg / countNeg;
    }
  }

  public void printArifmetic() {
    if (count <= 0) {
      System.out.println("Input error. Size <= 0");
    } else if (calc == 0) {
      System.out.println("There are no negative elements");
    } else {
      System.out.printf("%.3f\n", calc);
    }
  }
}
