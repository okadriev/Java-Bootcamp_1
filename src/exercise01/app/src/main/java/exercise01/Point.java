package exercise01;

import java.util.Scanner;

public class Point {
  private double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point other) {
    return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
  }

  public static Point readPoint(Scanner scanner) {
    double x = getValidNumber(scanner);
    double y = getValidNumber(scanner);

    return new Point(x, y);
  }

  private static double getValidNumber(Scanner scanner) {
    while (true) {
      if (scanner.hasNextDouble()) {
        return scanner.nextDouble();
      } else {
        System.out.println("Couldn't parse a number. Please, try again");
        scanner.next();
      }
    }
  }
}