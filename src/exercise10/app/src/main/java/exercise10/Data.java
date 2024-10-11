package exercise10;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Data {
  private List<User> data;
  private String namesList;

  public Data(List<User> list_) {
    data = list_;
    namesList = "";
  }

  public static Data readData() throws Exception {
    try (Scanner scanner = new Scanner(System.in)) {
      int count = Data.getConsoleInt(scanner);
      if (count < 0) {
        throw new Exception("Input error, count < 0");
      }

      List<User> list = new ArrayList<>(count);
      for (int i = 0; i < count; i++) {
        String name = scanner.next();
        int age = Data.getConsoleInt(scanner);

        if (age <= 0) {
          System.out.println("Incorrect input. Age <= 0");
          i--;
        } else {
          list.add(new User(name, age));
        }
      }

      return new Data(list);
    }
  }

  public void calcData() {
    namesList = data.stream()
        .filter(user -> user.age >= 18)
        .map(user -> user.name)
        .collect(Collectors.joining(", "));
  }

  public void printData() {
    if (!namesList.isEmpty()) {
      System.out.println(namesList);
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