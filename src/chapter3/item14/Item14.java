package chapter3.item14;


import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Item14 {

    public static void main(String[] args) {
        // String 이 Comparable 을 구현한 덕분에 정렬이 된다.
        String[] sample = {"ee", "aa", "cc", "bb", "dd"};
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, sample);
        System.out.println(s);
        /** 출력
         * [aa, bb, cc, dd, ee]
         */
    }
}
