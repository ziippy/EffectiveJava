package chapter5.item27;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Item27 {

    public static void main(String[] args) {
        Set<String> sss = new HashSet();    // 이렇게 작성해도 컴파일은 되나, 자바 7부터 지원하는 다이아몬드 연산자를 이용하자. new HashSet<>();
        sss.add("string");

        Iterator<String> iterator = sss.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /** 출력
         * string
         */
    }
}
