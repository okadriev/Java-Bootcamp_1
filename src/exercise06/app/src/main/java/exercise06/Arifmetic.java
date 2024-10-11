package exercise06;

import java.util.Scanner;

public class Arifmetic {
  private int count;
  private double numbers[];

  public Arifmetic(int count_, double numbers_[]) {
    count = count_;
    numbers = numbers_;
  }

  public static Arifmetic readArifmetic() {
    Scanner scanner = new Scanner(System.in);
    int count = getValidInt(scanner);

    double numbers[] = (count > 0) ? new double[count] : new double[0];
    for (int i = 0; i < count; i++) {
      numbers[i] = getValidDouble(scanner);
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

  private static double getValidDouble(Scanner scanner) {
    while (!scanner.hasNextDouble()) {
      System.out.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }

    return scanner.nextDouble();
  }

  public void calcArifmetic() {
    for (int i = 0; i < numbers.length; i++) {
      int minIndex = i;
      for (int j = i; j < numbers.length; j++) {
        if (numbers[j] < numbers[minIndex]) {
          minIndex = j;
        }
      }
      swap(i, minIndex);
    }
  }

  private void swap(int a, int b) {
    double temp = numbers[a];
    numbers[a] = numbers[b];
    numbers[b] = temp;
  }

  public void printArifmetic() {
    if (count <= 0) {
      System.out.println("Input error. Size <= 0");
    } else {
      for (double num : numbers) {
        System.out.printf("%.1f ", num);
      }
      System.out.println();
    }
  }
}
