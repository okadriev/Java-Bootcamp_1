package exercise07;

public class App {
  public static void main(String[] args) {
    try {
      Arifmetic arifmetic = Arifmetic.readArifmetic();

      arifmetic.calcArifmetic();
      arifmetic.printArifmetic();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}