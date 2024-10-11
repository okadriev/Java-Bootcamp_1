package exercise10;

public class App {
  public static void main(String[] args) {
    try {
      Data data = Data.readData();
      data.calcData();
      data.printData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}