package Homeless.monkey.com;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.area();
        circle.perimeter();

        Rectangle rect = new Rectangle(4,5);
        System.out.printf("Площадь прямоугольника: %f%n", rect.area());
        System.out.printf("Периметр прямоугольника: %f%n", rect.perimeter());

        Triangle triangle = new Triangle();
        triangle.area();
        triangle.perimeter();
    }
}