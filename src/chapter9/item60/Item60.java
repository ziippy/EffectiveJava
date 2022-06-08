package chapter9.item60;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class Item60 {

    public static void main(String[] args) {

        // 1.03 달러 에서 42센트를 썼다고 하면? -> 이를 float 를 이용하면
        System.out.println(1.03 - 0.42);
        /** 출력
         * 0.6100000000000001
         * 안타깝게도 0.61 이 아니라.. 저런 수가 나온다.
         */

        // 1 달러에서 10센트짜리 사탕 9 개를 샀다고 하면?
        System.out.println(1.0 - 0.1 * 9);
        /** 출력
         * 0.09999999999999998
         * 어의 없다. 왜 저런 수가 나오지?
         */

        // 이건 float 와 double 타입의 한계이다.

        // 이런 금융 계산에는 BigDecimal, int 혹은 long 을 사용해야 한다.

        BigDecimal a = new BigDecimal("1.03");
        BigDecimal b = new BigDecimal("0.42");
        BigDecimal c = a.subtract(b);
        System.out.println(c);
        /** 출력
         * 0.61
         */

        BigDecimal a2 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("0.1");
        b2 = b2.multiply(new BigDecimal("9"));
        BigDecimal c2 = a2.subtract(b2);
        System.out.println(c2);
        /** 출력
         * 0.1
         */

        // 그러나, BigDecimal 은 쓰게 불편하고, 훨씬 느리다.
        // int 나 long 타입을 쓸 수 있지만, 이 경우 소수점을 직접 관리해야 한다.
    }
}

