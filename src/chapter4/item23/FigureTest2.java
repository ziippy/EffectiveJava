package chapter4.item23;


abstract class Figure2 {
    abstract double area();
}

class Circle extends Figure2 {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Figure2 {
    final double width;
    final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

public class FigureTest2 {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());

        Rectangle rectangle = new Rectangle(6, 7);
        System.out.println(rectangle.area());

        /** 출력
         * 78.53981633974483
         * 42.0
         */

        // 이게 훨씬 더 명확하다!!
    }
}
