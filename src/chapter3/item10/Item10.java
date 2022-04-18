package chapter3.item10;

import java.util.ArrayList;
import java.util.List;

class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    // 대칭성 위배 코드
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
}

class BodyInfo {
    private final int age, weight, tall;

    public BodyInfo(int age, int weight, int tall) {
        this.age = age;
        this.weight = weight;
        this.tall = tall;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BodyInfo)) {
            return false;
        }
        BodyInfo tmp = (BodyInfo) o;
        return this.age == tmp.age && this.weight == tmp.weight && this.tall == tmp.tall;
    }
}

public class Item10 {

    public static void main(String[] args) {
        // 반사성 테스트
        CaseInsensitiveString cis0 = new CaseInsensitiveString("Hello");
        System.out.println(cis0.equals(cis0));
        /** 출력
         * true
         */

        // 대칭성 위배 테스트
        CaseInsensitiveString cis = new CaseInsensitiveString("Hello");
        String s = "Hello";

        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));  // true 가 나와야 하지만 false 가 나온다.
        /** 출력
         * true
         * false
         */

        List<CaseInsensitiveString> cisList = new ArrayList<>();
        cisList.add(cis);
        System.out.println(cisList.contains(s));    // true 가 나와야 하지만 false 가 나온다.
        /** 출력
         * false
         */

        // BodyInfo 테스트
        BodyInfo bi = new BodyInfo(10, 100, 180);
        BodyInfo bi2 = new BodyInfo(10, 100, 180);
        BodyInfo bi3 = new BodyInfo(10, 100, 180);
        System.out.println(bi.equals(bi));
        System.out.println(bi.equals(bi2));
        System.out.println(bi.equals(bi3));
        System.out.println(bi2.equals(bi3));
        /** 출력
         * true
         * true
         * true
         * true
         */
    }
}
