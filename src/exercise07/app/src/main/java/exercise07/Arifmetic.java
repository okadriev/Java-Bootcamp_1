package exercise07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Arifmetic {
  private int count;
  private double numbers[], min, max;

  public Arifmetic(int count_, double numbers_[]) {
    count = count_;
    numbers = numbers_;
    min = numbers[0];
    max = numbers[0];
  }

  public static Arifmetic readArifmetic() throws Exception {
    Helper help = new Helper();
    String fileName = help.getConsoleText();
    help.close();

    try (Helper helper = new Helper(fileName)) {
      int count = helper.getFileInt();

      double numbers[] = (count > 0) ? new double[count] : new double[1];
      for (int i = 0; i < count; i++) {
        numbers[i] = helper.getFileDouble();
      }
      helper.close();

      return new Arifmetic(count, numbers);

    } catch (Exception e) {
      throw e;
    } 
  }

  public void calcArifmetic() {

    for (double num : numbers) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }
  }

  public void printArifmetic() {
    if (count <= 0) {
      System.out.println("Input error. Size <= 0");
    } else {
      try (PrintWriter writer = new PrintWriter("result.txt")) {
        System.out.println("Saving min and max values in file");
        writer.printf("%.1f %.1f", min, max);
      } catch (IOException e) {
        System.out.println("Ошибка записи в файл: " + e.getMessage());
      }
    }
  }
}
