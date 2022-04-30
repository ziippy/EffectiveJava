package chapter4.item23;

class Figure {
    enum Shape { RECTANGLE, CIRCLE}

    final Shape shape;

    // RECTANGLE 일 때만 사용되는 것들
    double width;
    double height;

    // CIRCLE 일 때만 사용되는 것들
    double radius;

    Figure(double width, double height) {
        this.shape = Shape.RECTANGLE;
        this.width = width;
        this.height = height;
    }

    Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    double area() {
        switch(shape) {
            case RECTANGLE -> { return width * height; }
            case CIRCLE -> { return Math.PI * (radius * radius); }
            default -> { throw new AssertionError(shape); }
        }
    }
}

public class FigureTest {

    public static void main(String[] args) {
        Figure circle = new Figure(5);
        System.out.println(circle.area());

        Figure rectangle = new Figure(6, 7);
        System.out.println(rectangle.area());

        /** 출력
         * 78.53981633974483
         * 42.0
         */
    }
}
