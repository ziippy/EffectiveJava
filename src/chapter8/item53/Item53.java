package chapter8.item53;

import java.math.BigInteger;
import java.util.*;


public class Item53 {

    // 간단한 가변인수 활용 예
    private static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // 인수가 1개 이상이어야 하는 가변인수 메서드 --- 잘못 구현한 예
    // 인수의 개수를 따져 보고 있고.. 코드도 지저분하다.
    private static int min(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    // 인수가 1개 이상이어야 할 때, 가변인수를 제대로 사용하는 방법
    private static int minGood(int firstArg, int... args) {
        int min = firstArg;
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        System.out.println(sum(1, 2, 3, 4, 5));
        /** 출력
         * 15
         */

        System.out.println(min(3, 2, 1, 4, 5));
        System.out.println(minGood(3, 2, 1, 4, 5));

    }
}

