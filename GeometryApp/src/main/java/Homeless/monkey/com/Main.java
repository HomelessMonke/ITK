package Homeless.monkey.com;

public class Main {
    public static void main(String[] args) {
        ShapesIdentificator shapesIdentificator = new ShapesIdentificator();
        ThreeDimensionalUtils.puk();

        Circle circle = new Circle();
        circle.area();
        circle.perimeter();
        var isCircle = shapesIdentificator.isCircle(circle);
        System.out.printf("isCircle: %s%n", isCircle);

        Rectangle rect = new Rectangle(4,5);
        System.out.printf("Площадь прямоугольника: %f%n", rect.area());
        System.out.printf("Периметр прямоугольника: %f%n", rect.perimeter());
        var isRectangle = shapesIdentificator.isRectangle(rect);
        System.out.printf("isRectangle: %s%n", isRectangle);

        Triangle triangle = new Triangle();
        triangle.area();
        triangle.perimeter();
    }
}