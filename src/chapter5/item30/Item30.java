package chapter5.item30;

import java.util.HashSet;
import java.util.Set;


public class Item30 {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Hello");

        Set<String> s2 = new HashSet<>();
        s2.add("World");

        System.out.println(union(s1, s2));
        /** 출력
         * [Hello, World]
         */
        System.out.println(genericUnion(s1, s2));
        /** 출력
         * [Hello, World]
         */
    }

    // 로 타입 사용 - 수용 불가
    // 컴파일은 되나 unchecked 경고가 발생한다. 이를 없애고 메서드를 타입 안전하게 만들어야 한다.
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // 제네릭 메서드
    public static <E> Set<E> genericUnion(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}
