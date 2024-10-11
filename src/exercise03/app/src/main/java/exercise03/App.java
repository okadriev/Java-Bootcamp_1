package exercise03;

public class App {
  public static void main(String[] args) {
    Fibo fibo = Fibo.readFibo();

    fibo.calcFibo();
    fibo.printFibo();
  }
}