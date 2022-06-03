package chapter8.item55;


import java.util.*;

public class Item55 {

    // 컬렉션에서 최대값을 구한다. - 단 컬렉션이 비었다면 예외를 던진다.
    private static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("빈 컬렉션");
        }

        E result = null;
        // ...
        return result;
    }

    // 컬렉션에서 최대값을 구한다. - 최대값을 구해 Optional<E> 로 반환한다.
    private static <E extends Comparable<E>> Optional<E> maxUsingOptional(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        // ...
        return Optional.of(result);
    }

    public static void main(String[] args) {



    }
}

