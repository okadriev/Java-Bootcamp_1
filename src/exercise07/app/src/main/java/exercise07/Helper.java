package exercise07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Helper implements AutoCloseable {
  Scanner scanner;

  public Helper() {
    scanner = new Scanner(System.in);
  }

  public Helper(String string) throws FileNotFoundException {
    String currentDir = System.getProperty("user.dir");

    if (!currentDir.contains("src")) {
      string = "src/exercise07/app/src/main/resources/" + string;
    } else {
      string = "app/src/main/resources/" + string;
    }
    try {
      scanner = new Scanner(new File(string));
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("Input error. File isn't exist");
    }
  }

  public int getFileInt() {
    while (!scanner.hasNextInt() && scanner.hasNext()) {
      scanner.next();
    }

    if (!scanner.hasNext()) {
      throw new NoSuchElementException("Input error. Insufficient number of elements");
    }

    return scanner.nextInt();
  }

  public double getFileDouble() {
    while (!scanner.hasNextDouble() && scanner.hasNext()) {
      scanner.next();
    }

    if (!scanner.hasNext()) {
      throw new NoSuchElementException("Input error. Insufficient number of elements");
    }

    return scanner.nextDouble();
  }

  public double getConsoleDouble() {
    while (!scanner.hasNextDouble()) {
      System.out.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }

    return scanner.nextDouble();
  }

  public int getConsoleInt() {
    while (!scanner.hasNextInt()) {
      System.out.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }

    return scanner.nextInt();
  }

  public String getConsoleText() {
    return scanner.nextLine();
  }

  public void close() {
    scanner.close();
  }
}