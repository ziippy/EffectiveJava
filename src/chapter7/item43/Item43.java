package chapter7.item43;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Item43 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        String key = "key";

        // Map 에 추가된 merge 함수에 람다를 써서 하는 코드. key 가 없으면 1, 있으면 기존 매핑 값을 증가시킨다.
        map.merge(key, 1, (count, incr) -> count + incr);
        System.out.println(map);
        map.merge(key, 1, (count, incr) -> count + incr);
        System.out.println(map);
        /** 출력
         * {key=1}
         * {key=2}
         */

        // 먼가 거추장 스러운 부분이 여전히 남아 있다.

        // 메서드 참조를 이용하면 똑같은 결과를 보기 좋게 얻을 수 있다.
        map.merge(key, 1, Integer::sum);
        System.out.println(map);
        /** 출력
         * {key=3}
         */
    }
}

