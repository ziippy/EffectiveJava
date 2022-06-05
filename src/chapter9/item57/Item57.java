package chapter9.item57;

import java.util.Iterator;
import java.util.List;

public class Item57 {

    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5);

        // 컬렉션이나 배열을 순회하는 권장 관용구
        for (int n : intList) {
            // ...
        }

        // 버그 가능성에 유념해야 하는, 전통적인 반복문..
        Iterator<Integer> i = intList.iterator();
        while (i.hasNext()) {
            System.out.println(i);
            i.next();
        }

        Iterator<Integer> i2 = intList.iterator();
        while (i2.hasNext()) {
            System.out.println(i2);
            i.next();           // 이렇게 i2 인데 i 로 쓰면서.. 복사 붙여넣기 실수로.. 버그가 발생하기도 한다.
        }
        /** 출력
         * Exception in thread "main" java.util.NoSuchElementException
         * 	at java.base/java.util.ImmutableCollections$ListItr.next(ImmutableCollections.java:375)
         * 	at chapter9.item57.Item57.main(Item57.java:27)
         */
    }
}

