package chapter9.item64;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Son {

}

public class Item64 {

    public static void main(String[] args) {

        // 좋은 예
        Set<Son> sonSet = new LinkedHashSet<>();

        // 나쁜 예
        LinkedHashSet<Son> sonSet2 = new LinkedHashSet<>();


        // 좋은 예 - sonSet 은 HashSet 으로 변경 가능하다.
        sonSet = new HashSet<>();

        // 나쁜 예 - sonSet2 는 HashSet 으로 변경 불가하다. 아래 코드는 컴파일 안됨.
        //sonSet2 = new HashSet<>();
    }
}

