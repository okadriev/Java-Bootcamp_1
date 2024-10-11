package exercise09;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Data {
  private List<String> list, correctList;
  private String check;

  public Data(List<String> list_, String check_) {
    list = list_;
    check = check_;
    correctList = new ArrayList<>(list.size());
  }

  public static Data readData() throws Exception {
    Scanner scanner = new Scanner(System.in);

    int count = getConsoleInt(scanner);
    scanner.nextLine();
    if (count < 0) {
      scanner.close();
      throw new Exception("Input error. Size <= 0");
    }

    List<String> list = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      list.add(scanner.nextLine());
    }
    String check = scanner.next();

    scanner.close();
    return new Data(list, check);
  }

  public void calcData() {
    for (String str : list) {
      if (str.contains(check)) {
        correctList.add(str);
      }
    }
  }

  public void printData() {
    int n = correctList.size();
    for (int i = 0; i < n; i++) {
      System.out.print(correctList.get(i) + ((i < n - 1) ? ", " : "\n"));
    }
  }

  public static int getConsoleInt(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      System.out.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }

    return scanner.nextInt();
  }
}