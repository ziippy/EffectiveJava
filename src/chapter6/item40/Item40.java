package chapter6.item40;

import java.util.HashSet;
import java.util.Set;

// 영어 알파벳 2개로 구성된 문자열을 표현하는 클래스 - 버그가 존재한다! 찾아봐라~
class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }
    public boolean equals(Bigram b) {   // 그냥 이렇게 구현하면 -> 이건 overriding 이 아니라 overloading 이다. (다중 정의)
        return b.first == first && b.second == second;
    }
    public int hashCode() {
        return 31 * first * second;
    }
}

// 재정의 한 함수에 대해서는 @Override 를 붙여서 잘 동작하는 클래스
class BigramGood {
    private final char first;
    private final char second;

    public BigramGood(char first, char second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public boolean equals(Object o) {
        BigramGood b = (BigramGood) o;
        return b.first == first && b.second == second;
    }
    public int hashCode() {
        return 31 * first * second;
    }
}


public class Item40 {

    public static void main(String[] args) throws Exception {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
        /** 출력
         * 260
         * Set 은 중복을 허용하지 않으므로 26 이 출력되리라고 예상했지만, 260이 출력된다.
         */

        Set<BigramGood> s2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s2.add(new BigramGood(ch, ch));
            }
        }
        System.out.println(s2.size());
        /** 출력
         * 26
         * 정상 출력이다.
         */
    }
}
