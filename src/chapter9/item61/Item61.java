package chapter9.item61;

import java.math.BigDecimal;
import java.util.Comparator;

public class Item61 {

    public static void main(String[] args) {

        // 잘못 구현된 비교자
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        System.out.println(naturalOrder.compare(1, 2));
        System.out.println(naturalOrder.compare(1, 1));
        System.out.println(naturalOrder.compare(2, 1));
        /** 출력
         * -1
         * 0
         * 1
         */

        // 잘 동작하는 것 같지만, Integer 를 이용해보면 -> 결함을 확인 가능하다.
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
        /** 출력
         * 1
         * 값이 같으므로 0 을 출력해야 할 것 같지만, 1을 출력한다.
         */

        // 이유는?
        // 박싱된 기본 타입에 == 연산자를 이용하여 값을 비교하면 오류가 발생한다.

        // 수정한 구현자
        Comparator<Integer> naturalOrder2 = (iBoxed, jBoxed) -> {
            int i = iBoxed;
            int j = jBoxed;
            return (i < j) ? -1 : (i == j ? 0 : 1);
        };

        System.out.println(naturalOrder2.compare(new Integer(42), new Integer(42)));
        /** 출력
         * 0
         */
    }
}

