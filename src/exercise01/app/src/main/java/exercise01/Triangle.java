package exercise01;

import java.util.Scanner;

public class Triangle {
  private Point a, b, c;

  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double getPerimeter() {
    return a.distance(b) + b.distance(c) + c.distance(a);
  }

  public static Triangle readTriangle(Scanner scanner) {
    Point a = Point.readPoint(scanner);
    Point b = Point.readPoint(scanner);
    Point c = Point.readPoint(scanner);

    return new Triangle(a, b, c);
  }

  public boolean check() {
    double ab = a.distance(b);
    double bc = b.distance(c);
    double ca = c.distance(a);
    boolean check = ab + bc > ca && ab + ca > bc && bc + ca > ab;

    if (!check) {
      System.out.println("It isn't triangle");
    }

    return check;
  }
}