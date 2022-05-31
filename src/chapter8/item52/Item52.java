package chapter8.item52;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "집합";
    }

    public static String classify(List<?> l) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그 외";
    }

    public static String classifyUsingInstanceOf(Collection<?> c) {
        return c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
     }
}

class Wine {
    public String name() { return "와인"; }
}

class SparklingWine extends Wine {
    @Override
    public String name() { return "스파클링 와인"; }
}

class Champagne extends Wine {
    @Override
    public String name() { return "샴페이"; }
}

public class Item52 {

    public static void main(String[] args) {

        Collection<?>[] collections = {new HashSet<String>(), new ArrayList<BigInteger>(), new HashMap<String, String>().values() };

        for (Collection<?> c : collections) {
            System.out.println(CollectionClassifier.classify(c));
        }
        /** 출력
         * 그 외
         * 그 외
         * 그 외
         * ............... "집합", "리스트", "그 외" 를 차례로 출력하지 않는다. 왜?
         */

        // 어느 메서드를 호출할지가 컴파일타임에 정해지기 때문이다.
        // for 문 안의 c 는 Collection<?> 타입이기 때문이다.
        // 런타임에는 타입이 매번 달라지겠지만, 이는 호출할 메서드에는 영향을 주지 못한다.

        // 위 경우 instanceOf 를 이용하면 하나의 함수에서 가능하긴 하다.
        for (Collection<?> c : collections) {
            System.out.println(CollectionClassifier.classifyUsingInstanceOf(c));
        }
        /** 출력
         * 집합
         * 리스트
         * 그 외
         */

        // 반면 메서드 재정의는 다르다.
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
        /** 출력
         * 와인
         * 스파클링 와인
         * 샴페이
         */

    }
}

