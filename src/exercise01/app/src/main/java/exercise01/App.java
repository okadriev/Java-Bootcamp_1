package exercise01;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Triangle triangle = Triangle.readTriangle(scanner);

    if (triangle.check()) {
      System.out.printf("%.3f\n", triangle.getPerimeter());
    } 
  }
}