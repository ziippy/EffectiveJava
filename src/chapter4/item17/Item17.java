package chapter4.item17;

import java.util.concurrent.CompletionException;

// 불변 복소수 클래스
class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Complex)) return false;
        Complex c = (Complex) o;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) * Double.hashCode(im);
    }

    @Override
    public String toString() {
        return String.format("Complex: re(%f), im(%f)", re, im);
    }
}

class ComplexCannotInherit {
    private final double re;
    private final double im;

    private ComplexCannotInherit(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexCannotInherit valueOf(double re, double im) {
        return new ComplexCannotInherit(re, im);
    }

    @Override public String toString() { return String.format("ComplexCannotInherit - re(%f), im(%f)", re, im); }
}

public class Item17 {

    public static void main(String[] args) {
        Complex c = new Complex(11.1, 22.2);
        Complex c2 = new Complex(4.9, 2.8);
        System.out.println(c);
        System.out.println(c.plus(c2)); // c 가 변하지 않는다.
        System.out.println(c);
        /** 출력
         * Complex: re(11.100000), im(22.200000)
         * Complex: re(16.000000), im(25.000000)
         * Complex: re(11.100000), im(22.200000)
         */
        /** 설명
         * 이처럼 피연산자에 함수를 적용해 그 결과를 반환하지만, 피연산자 자체는 그대로인 프로그래밍 패턴을 "함수형 프로그래밍" 이라고 한다.
         */

        // ComplexCannotInherit cc = new ComplexCannotInherit(10.0, 12.0);         // 이렇게는 사용 못한다.
        ComplexCannotInherit cc = ComplexCannotInherit.valueOf(10.0, 12.0);
        System.out.println(cc);
        /** 출력
         * ComplexCannotInherit - re(10.000000), im(12.000000)
         */
    }
}
