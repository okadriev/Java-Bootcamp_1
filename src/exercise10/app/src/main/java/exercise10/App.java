package exercise10;

import java.util.Locale;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    try {
      Data data = Data.readData();
      data.calcData();
      data.printData();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}