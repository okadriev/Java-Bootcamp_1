package exercise08;

public class App {
  public static void main(String[] args) {
    try {
      Data data = Data.readData();
      data.printData();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}