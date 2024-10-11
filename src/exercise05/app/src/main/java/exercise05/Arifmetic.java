package exercise05;

import java.util.Scanner;

public class Arifmetic {
  private int count, numbers[], countCorrectNum, correctNumbers[];

  public Arifmetic(int count_, int numbers_[]) {
    count = count_;
    numbers = numbers_;
    countCorrectNum = 0;
    correctNumbers = (count > 0) ? new int[count] : new int[0];
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
    for (int num : numbers) {
      if (checkNumber(num)) {
        correctNumbers[countCorrectNum] = num;
        countCorrectNum++;
      }
    }
  }

  private boolean checkNumber(int num) {
    int lastDigit = num % 10;
    int firstDigit = num;
    while (num > 0) {
      firstDigit = num;
      num /= 10;
    }

    return firstDigit == lastDigit;
  }

  public void printArifmetic() {
    if (count <= 0) {
      System.out.println("Input error. Size <= 0");
    } else if (countCorrectNum == 0) {
      System.out.println("There are no such elements");
    } else {
      for (int i = 0; i < countCorrectNum; i++) {
        System.out.printf("%d ", correctNumbers[i]);
      }
      System.out.println();
    }
  }
}
