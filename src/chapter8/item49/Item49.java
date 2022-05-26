package chapter8.item49;

import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Stream;

public class Item49 {

    public static void main(String[] args) throws IOException {
        BigInteger b = null;
        try {
            mod(b);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        /** 출력
         * java.lang.NullPointerException: Cannot invoke "java.math.BigInteger.signum()" because "m" is null
         * 그런데, 아래 mod 함수에서는 어디에서도 NullPointerException 관련 설명이 없다.
         * mod2 함수처럼 상단에 설명을 추가해야 한다.
         */

        try {
            mod2(b);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        /** 출력
         * java.lang.NullPointerException: 계수(m)는 null 이면 안됩니다.
         */
    }

    private static BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }

        return BigInteger.ZERO;
    }

    /**
     * @param m 계수 (양수여야 한다.)
     * @return ...
     * @throws ArithmeticException m 이 0보다 작거나 같으면 발생한다.
     * @throws NullPointerException m 이 null 인 경우 발생한다.
     */
    private static BigInteger mod2(BigInteger m) {
        if (m == null) {
            throw new NullPointerException("계수(m)는 null 이면 안됩니다.");
        }
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }

        return BigInteger.ZERO;
    }
}

