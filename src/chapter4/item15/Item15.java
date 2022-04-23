package chapter4.item15;


import java.util.*;

class A {
    private int memberOfA;              // private 접근 범위

    A(int value) {
        this.memberOfA = value;
    }

    public int getMemberOfA() {
        return this.memberOfA;
    }
}

class B {
    int memberOfB;      // package-private 접근 범위

    B(int value) {
        this.memberOfB = value;
    }
}

class C {
    private final A a;
    private final B b;

    public C(int first, int second) {
        a = new A(first);
        b = new B(second);
    }

    public int compute() {
        return a.getMemberOfA() + b.memberOfB;
    }
}

// 불변 리스트
class D {
    private static final Integer[] PRIVATE_VALUES = {3, 2, 1};

    // private static final 에 대한 public 불변 리스트 생성 (Collections.unmodifiableList 이용)
    public static final List<Integer> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // private static final 에 대한 public 불변 리스트 생성 (List.of 이용)
    public static final List<Integer> VALUES2 = List.of(PRIVATE_VALUES);
}

public class Item15 {

    public static void main(String[] args) {
        C c = new C(10, 20);
        System.out.println(c.compute());
        /** 출력
         * 30
         */

        System.out.println(D.VALUES);
        System.out.println(D.VALUES2);
        try {
            D.VALUES.add(3);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        /** 출력
         * [3, 2, 1]
         * [3, 2, 1]
         * java.lang.UnsupportedOperationException
         */
    }
}
