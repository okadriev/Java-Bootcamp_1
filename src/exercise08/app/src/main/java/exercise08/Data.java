package exercise08;

import java.util.Scanner;

public class Data {
  private boolean sorted;
  private int last;

  public Data(boolean ok, int last_) {
    sorted = ok;
    last = last_;
  }

  public static Data readData() throws Exception {
    Scanner scanner = new Scanner(System.in);
    boolean sorted = true;
    int count = 0;

    if (scanner.hasNextInt()) {
      int last = scanner.nextInt();
      while (scanner.hasNextInt()) {
        count++;
        int next = scanner.nextInt();
        if (last > next) {
          sorted = false;
          break;
        }
        last = next;
      }

    } else {
      scanner.close();
      throw new Exception("Input error");
    }

    scanner.close();
    return new Data(sorted, count);
  }

  public void printData() {
    if (sorted) {
      System.out.println("The sequence is ordered in ascending order");
    } else {
      System.out.printf("The sequence is not ordered from the ordinal number of the number %d\n", last);
    }
  }
}