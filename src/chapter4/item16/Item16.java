package chapter4.item16;

// 퇴보한 클래스
class PointBad {
    public double x;
    public double y;
}

// 최소한 이렇게..
class PointGood {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

// 이 안에서만 쓸 클래스면 그냥 package-private 클래스로
class ThisClass {       // 이게 package-private 클래스이다.
    int a = 10;

    class InsideClass {
        int b = 10;
    }

    int getValue() {
        InsideClass ic = new InsideClass();
        return this.a + ic.b;
    }
}

public class Item16 {

    public static void main(String[] args) {
        ThisClass tc = new ThisClass();
        System.out.println(tc.getValue());
        /** 출력
         * 20
         */
    }
}
