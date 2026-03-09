package Homeless.monkey.com;

public class ShapesIdentificator {

    public boolean isCircle(Shape shape){
        return shape instanceof Circle;
    }

    public boolean isRectangle(Shape shape){
        return shape instanceof Rectangle;
    }
}
