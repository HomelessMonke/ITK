package Homeless.monkey.com;

public class Rectangle implements Shape{

    private final double aSide;
    private final double bSide;

    public Rectangle(double aSide, double bSide){
        this.aSide = aSide;
        this.bSide = bSide;
    }

    @Override
    public double area() {
        double result = aSide * bSide;
        return result;
    }

    @Override
    public double perimeter() {
        double result = (aSide + bSide) * 2;
        return result;
    }
}
