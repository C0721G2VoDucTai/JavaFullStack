package _00_fix_bug;

class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }
}

interface Resizeable  {
    double resize(double percent);
}

class Circle extends Shape implements Resizeable {
    private double radius = 2.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public double resize(double percent) {
        double area = getArea() + (getArea() * percent);
        return area;
    }
}

interface Colorable {
    void howToColor();
}

class Square extends Circle implements Colorable {
    private double size = 5.0 ;

    public Square() {
    }

    public Square(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getArea (){
        return this.size*this.size;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSize()
                + " with area is "
                + getArea();
    }


    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}

public class MainTest {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[2];
        shapes[0] = new Square();
        shapes[1] = new Circle();

        for ( Shape shape: shapes) {
            if( shape instanceof Colorable){
                Colorable colorable = (Square) shape;
                colorable.howToColor();
            }else if(shape instanceof Circle) {
                System.out.println("Cricle Area :" + ((Circle) shape).getArea());
            }
        }
    }
}
