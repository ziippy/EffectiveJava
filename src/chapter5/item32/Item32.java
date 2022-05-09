package chapter5.item32;

import java.util.*;


class Machine<T> {
    private final List<T> versions = new ArrayList<>();

    @SafeVarargs
    public final void safe(T... toAdd) {
        for (T version : toAdd) {
            versions.add(version);
        }
        System.out.println(versions);
    }
}

public class Item32 {

    public static void main(String[] args) {
        List<String> stringList1 = List.of("Hello");
        List<String> stringList2 = List.of("World");

        try {
            dangerous(stringList1, stringList2);
        } catch (Exception e) {
            System.err.println(e.toString());
            /**
             * java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
             */
        }

        // 다른 예시
        String string = "seed";
        try {
            String[] plants = broken(string); // ClassCastException
        } catch (Exception e) {
            System.err.println(e.toString());
            /**
             * java.lang.ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String; ([Ljava.lang.Object; and [Ljava.lang.String; are in module java.base of loader 'bootstrap')
             */
        }

        Machine<String> machine = new Machine<>();
        machine.safe(string);
        /** 출력
         * [seed]
         */
    }

    public static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;                   // 힙 오염 발생
        String s = stringLists[0].get(0);       // ClassCastException 발생
    }

    public static <T> T[] unsafe(T... elements) {
        return elements; // unsafe! don't ever return a parameterized varargs array
    }

    public static <T> T[] broken(T seed) {
        T[] plant = unsafe(seed, seed, seed); // broken! This will be an Object[] no matter what T is
        return plant;
    }
}
