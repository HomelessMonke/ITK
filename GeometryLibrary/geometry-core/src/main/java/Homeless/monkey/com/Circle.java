package Homeless.monkey.com;

public class Circle implements Shape{
    @Override
    public double area() {
        System.out.println("Площадь круга");
        return 0;
    }

    @Override
    public double perimeter() {
        System.out.println("Периметр круга");
        return 0;
    }
}
