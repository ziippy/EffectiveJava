package chapter9.item58;

import java.util.Iterator;
import java.util.List;

public class Item58 {

    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5);

        // 전통적인 for 문
        for (int i = 0; i < intList.size(); i++) {
            int n = intList.get(i);
            // ...
        }

        // for-each 이용
        // 컬렉션이나 배열을 순회하는 권장 관용구
        for (int n : intList) {
            // ...
        }
    }
}

